package lanou.maoyanmovie.movie.hot;

import android.os.Bundle;
import android.util.Log;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import lanou.maoyanmovie.MainActivity;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.MovieHotBannerBean;
import lanou.maoyanmovie.bean.MovieHotListBean;
import lanou.maoyanmovie.event.CityMessage;
import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;
import lanou.maoyanmovie.tools.DividerItemDecoration;

/**
 * Created by dllo on 16/11/21.
 */
public class HotFragment extends BaseFragment implements OnMovieIdClickListener {

    private PullLoadMoreRecyclerView mHotRv;
    private MovieHotListAdapter mMovieHotListAdapter;
    private int offset = 0;
    private String mCityId;

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initView() {
        mHotRv = bindView(R.id.fragment_movie_hot_rv);
        mCityId = "65";
    }

    @Override
    protected void initData() {
        mMovieHotListAdapter = new MovieHotListAdapter();
        mHotRv.setAdapter(mMovieHotListAdapter);
        mHotRv.setLinearLayout();
        mHotRv.addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));

        //轮播图
        HttpUtil.getMovieHotBanner(new ResponseCallBack<MovieHotBannerBean>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onResponse(MovieHotBannerBean movieHotBannerBean) {
                mMovieHotListAdapter.setHotBannerBean(movieHotBannerBean);
            }
        });
        Log.d("HotFragment", "开始请求数据");


        //初始列表
        HttpUtil.getMovieHotList(mCityId,offset, new ResponseCallBack<MovieHotListBean>() {
            @Override
            public void onError(Exception e) {
                Log.d("HotFragment", "请求失败");
            }
            @Override
            public void onResponse(MovieHotListBean movieHotListBean) {
                mMovieHotListAdapter.setOnMovieIdClickListener(HotFragment.this);
                mMovieHotListAdapter.setMovieHotListBean(movieHotListBean);
                Log.d("HotFragment", "请求成功");
            }
        });

        //recyclerView的下拉刷新和上拉加载
        mHotRv.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            //刷新
            @Override
            public void onRefresh() {
                offset = 0;
                HttpUtil.getMovieHotList(mCityId,offset, new ResponseCallBack<MovieHotListBean>() {
                    @Override
                    public void onError(Exception e) {

                    }
                    @Override
                    public void onResponse(MovieHotListBean movieHotListBean) {
                        mMovieHotListAdapter.setOnMovieIdClickListener(HotFragment.this);
                        mMovieHotListAdapter.setMovieHotListBean(movieHotListBean);
                    }
                });
                mHotRv.setPullLoadMoreCompleted();
            }
            //加载
            @Override
            public void onLoadMore() {
                offset++;
                HttpUtil.getMovieHotList(mCityId,offset * 12, new ResponseCallBack<MovieHotListBean>() {
                    @Override
                    public void onError(Exception e) {

                    }
                    @Override
                    public void onResponse(MovieHotListBean movieHotListBean) {
                        mMovieHotListAdapter.setOnMovieIdClickListener(HotFragment.this);
                        mMovieHotListAdapter.addMovieHotListBean(movieHotListBean);
                    }
                });
                mHotRv.setPullLoadMoreCompleted();
            }
        });
    }

    @Override
    protected void initClick() {

    }

    // 接收值
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(CityMessage event) {

        mCityId = event.getCityId();
        HttpUtil.getMovieHotList(mCityId,0, new ResponseCallBack<MovieHotListBean>() {
            @Override
            public void onError(Exception e) {

            }
            @Override
            public void onResponse(MovieHotListBean movieHotListBean) {
                mMovieHotListAdapter.setOnMovieIdClickListener(HotFragment.this);
                mMovieHotListAdapter.setMovieHotListBean(movieHotListBean);
            }
        });
       };

    //获得列表详情页所需的movieId
    @Override
    public void getId(int movieId) {
        HotListDetailFragment hotListDetailFragment = new HotListDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("movieId", movieId);
        hotListDetailFragment.setArguments(bundle);
        //用占位替换Fragment
        MainActivity activity = (MainActivity) getActivity();
        activity.jumpFragment(hotListDetailFragment);
        Log.d("HotFragment", "movieId:" + movieId);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}