package lanou.maoyanmovie.find;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.StoreHeaderBean;
import lanou.maoyanmovie.bean.StoreLikeBean;
import lanou.maoyanmovie.bean.StoreMonthDiscountBean;
import lanou.maoyanmovie.bean.StoreTopBean;
import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;
import lanou.maoyanmovie.tools.MainLoadingDialogFragment;

/**
 * Created by wangYe on 16/11/24.
 */
public class StoreFragment extends BaseFragment {

    private PullLoadMoreRecyclerView mStoreRv;
    private StoreRvAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private int count = 1;
    private RotateAnimation ra;
    private ImageView storeLoadingImg;
    private ImageView storeLoadingBefore;
    private TextView mHeaderTv;
    private ImageView mBackImg;

    @Override
    protected int getLayout() {
        return R.layout.fragment_store;
    }

    @Override
    protected void initView() {
        mHeaderTv = bindView(R.id.find_header_store_header);
        mBackImg = bindView(R.id.find_header_store_back);


        mStoreRv = bindView(R.id.find_header_store_body_rv);
        mAdapter = new StoreRvAdapter();
        mRecyclerView = mStoreRv.getRecyclerView();
        GridLayoutManager manager = new GridLayoutManager(mContext, 2);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);

        storeLoadingImg = bindView(R.id.store_loading_img);
        storeLoadingBefore = bindView(R.id.store_loading_before);

        //开启动画
        MainLoadingDialogFragment fragment = new MainLoadingDialogFragment();
        fragment.show(getActivity().getFragmentManager(), "dialog_fragment");
    }

    @Override
    protected void initData() {
        initInternetRequest();
        //页面的上拉加载下拉刷新
        mStoreRv.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                initInternetRequest();
                mStoreRv.setPullLoadMoreCompleted();
            }

            @Override
            public void onLoadMore() {
                count++;
                HttpUtil.getFindStoreTop(new ResponseCallBack<StoreTopBean>() {
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(mContext, "网络出现了问题", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(StoreTopBean storeTopBean) {
                        //网络请求成功时, 结束动画
                        Log.d("zzz", "数据请求成功");
                        Intent intent = new Intent("Hello");
                        intent.putExtra("text","终止动画");
                        mContext.sendBroadcast(intent);
                        mAdapter.setStoreTopBeen(storeTopBean);
                    }
                });
                HttpUtil.getFindStoreMonthDiscount(new ResponseCallBack<StoreMonthDiscountBean>() {
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(mContext, "网络出现了问题", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(StoreMonthDiscountBean storeMonthDiscountBean) {
                        mAdapter.setStoreMonthDiscountBean(storeMonthDiscountBean);

                    }
                });
                HttpUtil.getStoreLike(10 * count, 10, new ResponseCallBack<StoreLikeBean>() {
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(mContext, "网络出现了问题", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(StoreLikeBean storeLikeBean) {

                        mAdapter.addStoreLikeBean(storeLikeBean);
                    }
                });
                mStoreRv.setPullLoadMoreCompleted();
            }
        });

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.d("StoreFragment", "getScrolled():" + getScrolled());
                if (getScrolled() <= 570) {
                    mHeaderTv.getBackground().setAlpha((int) (getScrolled() * 255 / 570.0f));
                    mHeaderTv.setTextColor(Color.argb((int) (getScrolled() * 255 / 570.0f), 255, 255, 255));
                    Log.d("StoreFragment123", "(int) (getScrolled() * 255 / 570.0f):" + (int) (getScrolled() * 255 / 570.0f));
                }
            }
        });

    }

    @Override
    protected void initClick() {
        mBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

    private void initInternetRequest() {
        HttpUtil.getStoreHeader(new ResponseCallBack<StoreHeaderBean>() {
            @Override
            public void onError(Exception e) {
                Toast.makeText(mContext, "网络出现问题", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(StoreHeaderBean storeHeaderBean) {
                Log.d("zzz", "数据请求成功");
                Intent intent = new Intent("Hello");
                intent.putExtra("text","终止动画");
                mContext.sendBroadcast(intent);
                mAdapter.setStoreHeaderBean(storeHeaderBean);
            }
        });
        HttpUtil.getFindStoreTop(new ResponseCallBack<StoreTopBean>() {
            @Override
            public void onError(Exception e) {
                Toast.makeText(mContext, "网络出现了问题", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(StoreTopBean storeTopBean) {

                mAdapter.setStoreTopBeen(storeTopBean);

            }
        });
        HttpUtil.getFindStoreMonthDiscount(new ResponseCallBack<StoreMonthDiscountBean>() {
            @Override
            public void onError(Exception e) {
                Toast.makeText(mContext, "网络出现了问题", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(StoreMonthDiscountBean storeMonthDiscountBean) {
                mAdapter.setStoreMonthDiscountBean(storeMonthDiscountBean);

            }
        });
        HttpUtil.getStoreLike(0, 20, new ResponseCallBack<StoreLikeBean>() {
            @Override
            public void onError(Exception e) {
                Toast.makeText(mContext, "网络出现了问题", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(StoreLikeBean storeLikeBean) {
                mAdapter.setStoreLikeBean(storeLikeBean);

            }
        });

    }

    //第一个item的距离
    private int getScrolled() {
        LinearLayoutManager layoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        View firstItem = mRecyclerView.getChildAt(0);
        int firstPosition = layoutManager.findFirstVisibleItemPosition();
        int itemHeight = firstItem.getHeight();
        Log.d("MainActivity222", "itemHeight:" + itemHeight);
        if (itemHeight != 570){
            itemHeight = 570;
        }
        Log.d("MainActivity333", "itemHeight:" + itemHeight);
        int firstBottom = layoutManager.getDecoratedBottom(firstItem);
        return (firstPosition + 1) * itemHeight - firstBottom;
    }
}
