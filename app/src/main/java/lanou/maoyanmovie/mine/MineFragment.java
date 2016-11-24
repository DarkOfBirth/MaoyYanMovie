package lanou.maoyanmovie.mine;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;

import lanou.maoyanmovie.MainActivity;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;

/**
 * Created by dllo on 16/11/21.
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout mMainMineSettingRl;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private SettingFragment mSettingFragment;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        mMainMineSettingRl = bindView(R.id.main_mine_setting_rl);
    }

    @Override
    protected void initData() {
        //初始化fragment

        manager = getFragmentManager();
    }

    @Override
    protected void initClick() {
        mMainMineSettingRl.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_mine_setting_rl:
                mSettingFragment = new SettingFragment();
                MainActivity activity = (MainActivity) getActivity();
                activity.jumpFragment(mSettingFragment);
                break;
        }
    }
}
