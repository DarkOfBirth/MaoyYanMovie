package lanou.maoyanmovie.movie;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import lanou.maoyanmovie.MainActivity;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.base.MyApplication;
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
    private TextView weather;
    private MainActivity mActivity;
    private CityFragment mCityFragment;


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
        mCityFragment = new CityFragment();
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

        mCityFragment.setOnSelectCity(new CityFragment.OnSelectCity() {
            @Override
            public void selectCityName(String name, String cityId) {
                Log.d("MovieFragment", name);
                mLocation.setText(name);
             // 将当前的cityId存入文件中
                SharedPreferences sharedPreferences = MyApplication.getmContext().getSharedPreferences("cityId", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("cityId",cityId);
                editor.commit();
            }
        });
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



                mActivity.jumpFragment(mCityFragment);
                break;
            case R.id.weather_iv:
//                WeatherFragment weatherFragment = new WeatherFragment();
//                Bundle bundle = new Bundle();
//                bundle.putString("city", mLocation.getText().toString());
//                weatherFragment.setArguments(bundle);
//                mActivity.jumpFragment(weatherFragment);
                break;
        }
    }
}
