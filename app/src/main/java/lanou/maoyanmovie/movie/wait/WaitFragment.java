package lanou.maoyanmovie.movie.wait;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import lanou.maoyanmovie.MainActivity;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.MovieWaitBean;
import lanou.maoyanmovie.bean.MovieWaitWishBean;
import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;
import lanou.maoyanmovie.movie.hot.HotListDetailFragment;

/**
 * Created by 麦建东 on 16/11/21.
 * 电影页的待映界面
 */
public class WaitFragment extends BaseFragment implements OnMovieWaitWishClickListener {

    private WaitAdapter mWaitAdapter;
    private ViewPager mWaitVp;
    private LinearLayout mWaitLl;
    private DisplayMetrics mOutMetrics;
    private RecyclerView mWishRv;
    private WishAdapter mWishAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_movie_wait;
    }

    @Override
    protected void initView() {
        mWaitLl = bindView(R.id.fragment_movie_wait_ll);
        mWaitVp = bindView(R.id.fragment_movie_wait_vp);
        mWishRv = bindView(R.id.fragment_movie_wait_wish_rv);
    }

    @Override
    protected void initData() {
        mWaitAdapter = new WaitAdapter();
        mOutMetrics = new DisplayMetrics();
        mWishAdapter = new WishAdapter();

        //预告片推荐
        HttpUtil.getMovieWait(new ResponseCallBack<MovieWaitBean>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onResponse(MovieWaitBean movieWaitBean) {
                mWaitLl.setClipChildren(false);
                mWaitVp.setClipChildren(false);

                getActivity().getWindowManager().getDefaultDisplay().getMetrics(mOutMetrics);
                int screenWidth = mOutMetrics.widthPixels;
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mWaitVp.getLayoutParams();
                lp.leftMargin = screenWidth / 4;
                lp.rightMargin = screenWidth / 4;
                mWaitVp.setLayoutParams(lp);

                mWaitAdapter.setMovieWaitBean(movieWaitBean);
                mWaitVp.setAdapter(mWaitAdapter);
                mWaitVp.setPageTransformer(true, new PicTransFormer());
                mWaitVp.setOffscreenPageLimit(3);
                mWaitVp.setPageMargin(100);
                mWaitLl.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return mWaitVp.dispatchTouchEvent(event);

                    }
                });
            }
        });
        //近期最受期待
        HttpUtil.getMovieWaitWish(new ResponseCallBack<MovieWaitWishBean>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onResponse(MovieWaitWishBean movieWaitWishBean) {
                mWishAdapter.setBean(movieWaitWishBean);
                mWishAdapter.setWishClickListener(WaitFragment.this);
                mWishRv.setAdapter(mWishAdapter);
                mWishRv.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager
                        .HORIZONTAL, false));
            }
        });
    }

    @Override
    protected void initClick() {

    }

    //点击跳转到 待映->近期最受期待 详情界面
    @Override
    public void onItemClick(int movieId) {
        HotListDetailFragment hotListDetailFragment = new HotListDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("movieId", movieId);
        hotListDetailFragment.setArguments(bundle);
        //用占位替换Fragment
        MainActivity activity = (MainActivity) mContext;
        activity.jumpFragment(hotListDetailFragment);
    }
}