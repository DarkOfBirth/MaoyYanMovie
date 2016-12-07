package lanou.maoyanmovie.find;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.StoreLikeBean;
import lanou.maoyanmovie.bean.StoreMonthDiscountBean;
import lanou.maoyanmovie.bean.StoreTopBean;
import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;

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

    @Override
    protected int getLayout() {
        return R.layout.fragment_store;
    }

    @Override
    protected void initView() {
        mStoreRv = bindView(R.id.find_header_store_body_rv);
        mAdapter = new StoreRvAdapter();
        mRecyclerView = mStoreRv.getRecyclerView();
        GridLayoutManager manager = new GridLayoutManager(mContext, 2);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);



        storeLoadingImg = bindView(R.id.store_loading_img);
        storeLoadingBefore = bindView(R.id.store_loading_before);

    }

    @Override
    protected void initData() {
        //开启动画
        startAnim();

        initInternetRequest();
        //页面的上拉加载下拉刷新
        mStoreRv.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                startAnim();
                initInternetRequest();
                mStoreRv.setPullLoadMoreCompleted();
            }

            @Override
            public void onLoadMore() {
                startAnim();
                count++;
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
                HttpUtil.getStoreLike( 10 * count, 10, new ResponseCallBack<StoreLikeBean>() {
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(mContext, "网络出现了问题", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(StoreLikeBean storeLikeBean) {
                        storeLoadingImg.clearAnimation();
                        storeLoadingImg.setVisibility(View.GONE);
                        storeLoadingBefore.setVisibility(View.GONE);
                        mAdapter.addStoreLikeBean(storeLikeBean);
                    }
                });
                mStoreRv.setPullLoadMoreCompleted();
            }
        });
    }

    @Override
    protected void initClick() {

    }

    private void initInternetRequest() {
        HttpUtil.getFindStoreTop(new ResponseCallBack<StoreTopBean>() {
            @Override
            public void onError(Exception e) {
                Toast.makeText(mContext, "网络出现了问题", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(StoreTopBean storeTopBean) {
                storeLoadingImg.clearAnimation();
                storeLoadingImg.setVisibility(View.GONE);
                storeLoadingBefore.setVisibility(View.GONE);
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

    public void startAnim(){

        storeLoadingImg.setVisibility(View.VISIBLE);
        storeLoadingBefore.setVisibility(View.VISIBLE);

        ra = new RotateAnimation(0, 7200, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setInterpolator(new Interpolator(){
            @Override
            public float getInterpolation(float input) {
                return input;
            }
        });
        ra.setInterpolator(new Interpolator() {
            @Override
            public float getInterpolation(float input) {
                return input;
            }
        });
        //设置播放时间
        ra.setDuration(10000);
        //设置重复次数
        ra.setRepeatCount(30);
        //动画重复播放的模式
        ra.setRepeatMode(Animation.RESTART);
        //动画播放完毕后，组件停留在动画结束的位置上
        ra.setFillAfter(true);
        storeLoadingImg.startAnimation(ra);
    }
}
