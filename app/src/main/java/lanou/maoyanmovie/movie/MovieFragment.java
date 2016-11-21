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
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HotFragment());
        fragments.add(new WaitFragment());
        fragments.add(new FindPageFragment());

        MovieVpAdapter adapter = new MovieVpAdapter(getChildFragmentManager());
        movieVp.setAdapter(adapter);
        adapter.setFragments(fragments);
        movieTab.setupWithViewPager(movieVp);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void initClick() {

    }
}
