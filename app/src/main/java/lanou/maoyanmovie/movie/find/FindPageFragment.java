package lanou.maoyanmovie.movie.find;

import android.widget.Toast;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.MovieFindCenterBean;
import lanou.maoyanmovie.bean.MovieFindTypeOtherBean;
import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;

/**
 * Created by dllo on 16/11/21.
 */
public class FindPageFragment extends BaseFragment{

    private PullLoadMoreRecyclerView mFindRv;
    private MovieFindAdapter mAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_find_page;
    }

    @Override
    protected void initView() {
        mFindRv = bindView(R.id.movie_find_rv);
        mAdapter = new MovieFindAdapter();
        mFindRv.setAdapter(mAdapter);
        mFindRv.setLinearLayout();
        mFindRv.setPullRefreshEnable(false);
        mFindRv.setPushRefreshEnable(false);
    }

    @Override
    protected void initData() {
        HttpUtil.getMovieFindTypeAndOther(new ResponseCallBack<MovieFindTypeOtherBean>() {
            @Override
            public void onError(Exception e) {
                Toast.makeText(mContext, "网络出现故障", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(MovieFindTypeOtherBean movieFindTypeOtherBean) {
                mAdapter.setMovieFindTypeOtherBean(movieFindTypeOtherBean);
            }
        });
        HttpUtil.getMovieFindCenter(new ResponseCallBack<MovieFindCenterBean>() {
            @Override
            public void onError(Exception e) {
                Toast.makeText(mContext, "网络出现故障", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(MovieFindCenterBean movieFindCenterBean) {
                mAdapter.setMovieFindCenterBean(movieFindCenterBean);
            }
        });
    }

    @Override
    protected void initClick() {

    }
}