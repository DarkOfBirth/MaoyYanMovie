package lanou.maoyanmovie.find;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import lanou.maoyanmovie.MainActivity;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.FindTodayBean;
import lanou.maoyanmovie.bean.FindTopBean;
import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;
import lanou.maoyanmovie.tools.DividerItemDecoration;

/**
 * Created by wangYe on 16/11/21.
 */

public class FindFragment extends BaseFragment implements OnFindClickListener {

    private PullLoadMoreRecyclerView findRv;
    private FindRvAdapter mAdapter;
    private int count = 0;
    private ImageView loadingImg;
    private ImageView loadingBefore;
    private RotateAnimation ra;


    @Override
    protected int getLayout() {
        return R.layout.fragment_find;
    }


    @Override
    protected void initView() {

        loadingImg = bindView(R.id.loading_img);
        loadingBefore = bindView(R.id.loading_before);

        findRv = bindView(R.id.find_rv);
        mAdapter = new FindRvAdapter(mContext);

        findRv.setAdapter(mAdapter);
        findRv.setLinearLayout();
        findRv.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));
    }

    @Override
    protected void initData() {
        //开启动画
        startAnim();
        //首次进入网络请求
        initNetWorkRequest();
        //上拉加载, 下拉刷新
        upAndDownToRefresh();

        mAdapter.setOnFindClickListener(this);
    }

    //上拉加载, 下拉刷新
    private void upAndDownToRefresh() {

        findRv.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                startAnim();
                Log.d("FindFragment", "下拉刷新");
                initNetWorkRequest();
                findRv.setPullLoadMoreCompleted();
            }

            @Override
            public void onLoadMore() {
                startAnim();
                count++;
                HttpUtil.getFindToday(count * 10, 10, new ResponseCallBack<FindTodayBean>() {
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(mContext, "网络出现问题了!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(FindTodayBean findTodayBean) {
                        mAdapter.addFindTodayBean(findTodayBean);
                        loadingImg.clearAnimation();
                        loadingImg.setVisibility(View.GONE);
                        loadingBefore.setVisibility(View.GONE);
                    }

                });
                findRv.setPullLoadMoreCompleted();
            }
        });
    }

    @Override
    protected void initClick() {

    }

    private void initNetWorkRequest() {

        HttpUtil.getFindToday(0, 10, new ResponseCallBack<FindTodayBean>() {
            @Override
            public void onError(Exception e) {
                Toast.makeText(mContext, "网络出现问题了!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(FindTodayBean findTodayBean) {

                mAdapter.setFindTodayBean(findTodayBean);
                loadingImg.clearAnimation();
                loadingImg.setVisibility(View.GONE);
                loadingBefore.setVisibility(View.GONE);
            }
        });
        HttpUtil.getFindTop(new ResponseCallBack<FindTopBean>() {
            @Override
            public void onError(Exception e) {
                Toast.makeText(mContext, "网络出现问题了!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(FindTopBean findTopBean) {
                mAdapter.setFindTopBean(findTopBean);

            }
        });
    }

    @Override
    public void findClick(int targetID, int feedType, String nickName, String urlImg, String title) {
        Log.d("FindFragment", "feedType:" + feedType);
        DescriptionFragment fragment = new DescriptionFragment();
        MainActivity activity = (MainActivity) getActivity();
        Bundle bundle = new Bundle();
        bundle.putInt("targetID", targetID);
        bundle.putInt("feedType", feedType);
        bundle.putString("nickName", nickName);
        bundle.putString("urlImg", urlImg);
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        activity.jumpFragment(fragment);
    }

    @Override
    public void findTopClick(String name) {
        if (name.equals("周边商城")) {
            StoreFragment fragment = new StoreFragment();
            MainActivity activity = (MainActivity) getActivity();
            activity.jumpFragment(fragment);
        } else {
            DescriptionFragment fragment = new DescriptionFragment();
            MainActivity activity = (MainActivity) getActivity();
            Bundle bundle = new Bundle();
            bundle.putString("Title", name);
            fragment.setArguments(bundle);
            activity.jumpFragment(fragment);
        }

    }

    public void startAnim(){

        loadingImg.setVisibility(View.VISIBLE);
        loadingBefore.setVisibility(View.VISIBLE);

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
        loadingImg.startAnimation(ra);
    }

}
