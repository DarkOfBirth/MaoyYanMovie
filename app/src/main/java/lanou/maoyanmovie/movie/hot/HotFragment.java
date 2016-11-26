package lanou.maoyanmovie.movie.hot;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.MovieHotBannerBean;
import lanou.maoyanmovie.bean.MovieHotListBean;
import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;
import lanou.maoyanmovie.tools.DividerItemDecoration;

/**
 * Created by dllo on 16/11/21.
 */
public class HotFragment extends BaseFragment {

    private PullLoadMoreRecyclerView mHotRv;
    private MovieHotListAdapter mMovieHotListAdapter;
    private ArrayList<Integer> mMovieId;
    private int movieIdNum = 24;

    @Override
    protected int getLayout() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initView() {
        mHotRv = bindView(R.id.fragment_movie_hot_rv);
    }

    @Override
    protected void initData() {
        mMovieHotListAdapter = new MovieHotListAdapter(getActivity());
        // 轮播图
        HttpUtil.getMovieHotBanner(new ResponseCallBack<MovieHotBannerBean>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onResponse(MovieHotBannerBean movieHotBannerBean) {
                mMovieHotListAdapter.setHotBannerBean(movieHotBannerBean);
            }
        });
        // 初始列表
        getMovieHotListUrl();
        //recyclerView的下拉刷新和上拉加载
        mHotRv.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                getMovieHotListUrl();
                mHotRv.setPullLoadMoreCompleted();
            }

            @Override
            public void onLoadMore() {
                mMovieId = mMovieHotListAdapter.getMovieId();
                HttpUtil.getMovieHotListBehind(movieIdNum, mMovieId, new ResponseCallBack<MovieHotListBean>() {
                    @Override
                    public void onError(Exception e) {

                    }

                    @Override
                    public void onResponse(MovieHotListBean movieHotListBean) {
                        mMovieHotListAdapter.setMovieHotListBean(movieHotListBean);
                        mHotRv.setAdapter(mMovieHotListAdapter);
                        mHotRv.setLinearLayout();
                        mHotRv.addItemDecoration(new DividerItemDecoration(getActivity(),
                                DividerItemDecoration.VERTICAL_LIST));
                        if (movieIdNum + 12 > mMovieId.size()) {
                            movieIdNum = mMovieId.size() - 12;
                        } else {
                            movieIdNum += 12;
                        }
                    }
                });
                mHotRv.setPullLoadMoreCompleted();
            }
        });
    }

    @Override
    protected void initClick() {

    }

    private void getMovieHotListUrl() {
        HttpUtil.getMovieHotListFront(new ResponseCallBack<MovieHotListBean>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onResponse(MovieHotListBean movieHotListBean) {
                mMovieHotListAdapter.setMovieHotListBean(movieHotListBean);
                mHotRv.setAdapter(mMovieHotListAdapter);
                mHotRv.setLinearLayout();
                mHotRv.addItemDecoration(new DividerItemDecoration(getActivity(),
                        DividerItemDecoration.VERTICAL_LIST));
            }
        });
    }

}