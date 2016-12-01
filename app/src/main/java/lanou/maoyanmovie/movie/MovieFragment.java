package lanou.maoyanmovie.movie;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import lanou.maoyanmovie.MainActivity;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.city.CityFragment;
import lanou.maoyanmovie.movie.find.FindPageFragment;
import lanou.maoyanmovie.movie.hot.HotFragment;
import lanou.maoyanmovie.movie.wait.WaitFragment;

/**
 * Created by dllo on 16/11/21.
 */

public class MovieFragment extends BaseFragment implements View.OnClickListener {

    private TabLayout movieTab;
    private ViewPager movieVp;
    private MovieVpAdapter mAdapter;
    private ArrayList<Fragment> mFragments;
    private TextView mLocation;

    @Override
    protected int getLayout() {
        return R.layout.fragment_movie;
    }

    @Override
    protected void initView() {
        movieTab = bindView(R.id.tab_movie_fragment);
        movieVp = bindView(R.id.vp_movie_fragment);
        mLocation = bindView(R.id.location_movie_fragment);

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
        mLocation.setOnClickListener(this);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.location_movie_fragment:
                MainActivity activity = (MainActivity) getActivity();
                CityFragment cityFragment = new CityFragment();
                activity.jumpFragment(cityFragment);
                break;
        }
    }
}
