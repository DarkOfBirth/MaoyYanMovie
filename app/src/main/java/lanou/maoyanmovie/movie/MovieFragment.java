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
import lanou.maoyanmovie.weather.WeatherFragment;

/**
 * Created by dllo on 16/11/21.
 */

public class MovieFragment extends BaseFragment implements View.OnClickListener {

    private TabLayout movieTab;
    private ViewPager movieVp;
    private MovieVpAdapter mAdapter;
    private ArrayList<Fragment> mFragments;
    private TextView mLocation;
    private TextView weather;
    private MainActivity mActivity;


    @Override
    protected int getLayout() {
        return R.layout.fragment_movie;
    }

    @Override
    protected void initView() {
        movieTab = bindView(R.id.tab_movie_fragment);
        movieVp = bindView(R.id.vp_movie_fragment);
        mLocation = bindView(R.id.location_movie_fragment);
        weather = bindView(R.id.weather_iv);

    }

    @Override
    protected void initData() {

        mActivity = (MainActivity) getActivity();
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HotFragment());
        fragments.add(new WaitFragment());
        fragments.add(new FindPageFragment());

        MovieVpAdapter adapter = new MovieVpAdapter(getChildFragmentManager());
        movieVp.setAdapter(adapter);
        adapter.setFragments(fragments);

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
        weather.setOnClickListener(this);
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



                CityFragment cityFragment = new CityFragment();
                mActivity.jumpFragment(cityFragment);
                break;
            case R.id.weather_iv:
                WeatherFragment weatherFragment = new WeatherFragment();
                mActivity.jumpFragment(weatherFragment);
                break;
        }
    }
}
