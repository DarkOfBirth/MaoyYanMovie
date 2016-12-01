package lanou.maoyanmovie.movie;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.movie.find.FindPageFragment;
import lanou.maoyanmovie.movie.hot.HotFragment;
import lanou.maoyanmovie.movie.wait.WaitFragment;

/**
 * Created by dllo on 16/11/21.
 */

public class MovieFragment extends BaseFragment{

    private TabLayout movieTab;
    private ViewPager movieVp;
    private MovieVpAdapter mAdapter;
    private ArrayList<Fragment> mFragments;

    @Override
    protected int getLayout() {
        return R.layout.fragment_movie;
    }

    @Override
    protected void initView() {
        movieTab = bindView(R.id.tab_movie_fragment);
        movieVp = bindView(R.id.vp_movie_fragment);
    }

    @Override
    protected void initData() {
        mAdapter = new MovieVpAdapter(getChildFragmentManager());
        mFragments = new ArrayList<>();
        HotFragment hotFragment = new HotFragment();
        WaitFragment waitFragment = new WaitFragment();
        FindPageFragment findPageFragment = new FindPageFragment();
        mFragments.add(hotFragment);
        mFragments.add(waitFragment);
        mFragments.add(findPageFragment);
        mAdapter.setFragments(mFragments);
        movieVp.setAdapter(mAdapter);
        movieTab.setupWithViewPager(movieVp);
        movieTab.setTabTextColors(0xff373737, 0xffffffff);
        movieTab.setSelectedTabIndicatorColor(0xffc0352f);
    }

    @Override
    protected void initClick() {

    }
}
