package lanou.maoyanmovie;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import lanou.maoyanmovie.base.BaseActivity;
import lanou.maoyanmovie.cinema.CinemaFragment;
import lanou.maoyanmovie.find.FindFragment;
import lanou.maoyanmovie.movie.MovieFragment;
import lanou.maoyanmovie.mine.MineFragment;

public class MainActivity extends BaseActivity {

    private RadioButton mainMovieRb;
    private RadioButton mainCinemaRb;
    private RadioButton mainFindRb;
    private RadioButton mainMyRb;
    private RadioGroup mainRg;
    private RadioButton last;
    private CinemaFragment cinemaFragment;
    private FindFragment findFragment;
    private MovieFragment movieFragment;
    private MineFragment mineFragment;
    private FragmentManager manager;
    private FrameLayout activityFrame;
    private FrameLayout mainFrame;
    private FragmentTransaction transaction;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        mainMovieRb = bindView(R.id.main_movie_rb);
        mainCinemaRb = bindView(R.id.main_cinema_rb);
        mainFindRb = bindView(R.id.main_find_rb);
        mainMyRb = bindView(R.id.main_my_rb);
        mainRg = bindView(R.id.main_rg);
        activityFrame = bindView(R.id.activity_frame);
        mainFrame = bindView(R.id.main_frame);

        //初始化fragment
        cinemaFragment = new CinemaFragment();
        findFragment = new FindFragment();
        movieFragment = new MovieFragment();
        mineFragment = new MineFragment();
        manager = getSupportFragmentManager();
    }

    @Override
    protected void initData() {
        //初始进入时, 显示的是电影界面
        initLast(mainMovieRb);
        mainMovieRb.setSelected(true);
        transaction = manager.beginTransaction();
        transaction.replace(R.id.main_frame, movieFragment);
        transaction.commit();

    }



    @Override
    protected void initClick() {
        mainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                transaction = manager.beginTransaction();
                switch (checkedId) {
                    case R.id.main_movie_rb:
                        initLast(mainMovieRb);
                        mainMovieRb.setSelected(true);
                        transaction.replace(R.id.main_frame, new MovieFragment());
                        break;
                    case R.id.main_cinema_rb:
                        initLast(mainCinemaRb);
                        mainCinemaRb.setSelected(true);
                        transaction.replace(R.id.main_frame, new CinemaFragment());
                        break;
                    case R.id.main_find_rb:
                        initLast(mainFindRb);
                        mainFindRb.setSelected(true);
                        transaction.replace(R.id.main_frame, new FindFragment());
                        break;
                    case R.id.main_my_rb:
                        initLast(mainMyRb);
                        mainMyRb.setSelected(true);
                        transaction.replace(R.id.main_frame, mineFragment);
                        break;
                }
                transaction.commit();
            }
        });
    }

    //当点击其他的时候, 字体颜色还原本色
    private void initLast(RadioButton radioButton) {
        if (last != null) {
            last.setSelected(false);
            last = radioButton;
        } else {
            last = radioButton;
        }

    }

    /**
     * 跳转fragment 的通用方法
     *
     * @param t
     * @param <T>
     */
    public <T extends Fragment> void jumpFragment(T t) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.activity_frame, t);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}