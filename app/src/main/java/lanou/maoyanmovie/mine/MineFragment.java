package lanou.maoyanmovie.mine;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import lanou.maoyanmovie.MainActivity;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.collect.CollectFragment;

/**
 * Created by dllo on 16/11/21.
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout mMainMineSettingRl;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private SettingFragment mSettingFragment;
    private RelativeLayout mMainMineCollectRl;
    private CollectFragment mCollectFragment;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        mMainMineSettingRl = bindView(R.id.main_mine_setting_rl);
        mMainMineCollectRl = bindView(R.id.main_mine_collect_rl);
    }

    @Override
    protected void initData() {
        //初始化fragment

        manager = getFragmentManager();
    }

    @Override
    protected void initClick() {
        mMainMineSettingRl.setOnClickListener(this);
        mMainMineCollectRl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_mine_setting_rl:
                mSettingFragment = new SettingFragment();
                MainActivity activity = (MainActivity) getActivity();
                activity.jumpFragment(mSettingFragment);
                break;
            case R.id.main_mine_collect_rl:
                Log.d("MineFragment", "点击了");
                mCollectFragment = new CollectFragment();
                MainActivity activity1 = (MainActivity) getActivity();
                activity1.jumpFragment(mCollectFragment);
                break;
        }
    }
}
