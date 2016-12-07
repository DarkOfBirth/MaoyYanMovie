package lanou.maoyanmovie.mine;

import lanou.maoyanmovie.base.BaseFragment;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import lanou.maoyanmovie.MainActivity;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.collect.CollectFragment;
import lanou.maoyanmovie.mine.login.LoginFragment;
import lanou.maoyanmovie.mine.setting.SettingFragment;


/**
 * Created by dllo on 16/11/21.
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout mMainMineSettingRl;
    private SettingFragment mSettingFragment;
    private RelativeLayout mMainMineCollectRl;
    private CollectFragment mCollectFragment;
    private LoginFragment mLoginFragment;
    private LinearLayout mLoginLl;
    private MainActivity mActivity;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        mMainMineSettingRl = bindView(R.id.main_mine_setting_rl);
        mMainMineCollectRl = bindView(R.id.main_mine_collect_rl);
        mLoginLl = bindView(R.id.fragment_mine_login_ll);
    }

    @Override
    protected void initData() {
        mActivity = (MainActivity) getActivity();
    }

    @Override
    protected void initClick() {
        mMainMineSettingRl.setOnClickListener(this);
        mMainMineCollectRl.setOnClickListener(this);
        mLoginLl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_mine_setting_rl:
                mSettingFragment = new SettingFragment();
                mActivity.jumpFragment(mSettingFragment);
                break;
            case R.id.fragment_mine_login_ll:
                mLoginFragment = new LoginFragment();
                mActivity.jumpFragment(mLoginFragment);
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
