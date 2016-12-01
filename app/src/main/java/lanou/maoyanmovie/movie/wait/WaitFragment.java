package lanou.maoyanmovie.movie.wait;

import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.MovieWaitBean;
import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;

/**
 * Created by 麦建东 on 16/11/21.
 * 电影页的待映界面
 */
public class WaitFragment extends BaseFragment{

    private WaitAdapter mWaitAdapter;
    private ViewPager mWaitVp;
    private RelativeLayout mWaitRl;
    private DisplayMetrics mOutMetrics;

    @Override
    protected int getLayout() {
        return R.layout.fragment_movie_wait;
    }

    @Override
    protected void initView() {
        mWaitRl = bindView(R.id.fragment_movie_wait_rl);
        mWaitVp = bindView(R.id.fragment_movie_wait_vp);
    }

    @Override
    protected void initData() {
        mWaitAdapter = new WaitAdapter();
        mOutMetrics = new DisplayMetrics();

        HttpUtil.getMovieWait(new ResponseCallBack<MovieWaitBean>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onResponse(MovieWaitBean movieWaitBean) {
                mWaitRl.setClipChildren(false);
                mWaitVp.setClipChildren(false);

                getActivity().getWindow().getWindowManager().getDefaultDisplay().getMetrics(mOutMetrics);
                int screenWidth = mOutMetrics.widthPixels;
                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) mWaitVp.getLayoutParams();
                lp.leftMargin = screenWidth / 4;
                lp.rightMargin = screenWidth / 4;
                mWaitVp.setLayoutParams(lp);

                mWaitAdapter.setMovieWaitBean(movieWaitBean);
                mWaitVp.setAdapter(mWaitAdapter);
                mWaitVp.setPageTransformer(true, new PicTransFormer());
                mWaitVp.setOffscreenPageLimit(3);
                mWaitVp.setPageMargin(100);
                mWaitRl.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        return mWaitVp.dispatchTouchEvent(event);
                    }
                });
            }
        });
    }

    @Override
    protected void initClick() {

    }
}