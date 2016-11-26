package lanou.maoyanmovie.mine.login;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;

/**
 * Created by 麦建东 on 16/11/23.
 */

public class LoginFragment extends BaseFragment {

    private TabLayout mLoginTl;
    private ViewPager mLoginVp;
    private LoginAdapter mLoginAdapter;
    private ArrayList<Fragment> mFragmentArrayList;
    private AccountFragment mAccountFragment;
    private TeleNumFragment mTeleNumFragment;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine_login;
    }

    @Override
    protected void initView() {
        mLoginTl = bindView(R.id.fragment_mine_login_tl);
        mLoginVp = bindView(R.id.fragment_mine_login_vp);
    }

    @Override
    protected void initData() {
        mLoginTl.setTabTextColors(0xff535353, 0xffeb382f);
        mLoginTl.setSelectedTabIndicatorColor(0xfff27f78);
        mLoginAdapter = new LoginAdapter(getChildFragmentManager());
        mFragmentArrayList = new ArrayList<>();
        mAccountFragment = new AccountFragment();
        mTeleNumFragment = new TeleNumFragment();
        mFragmentArrayList.add(mAccountFragment);
        mFragmentArrayList.add(mTeleNumFragment);
        mLoginAdapter.setFragmentArrayList(mFragmentArrayList);
        mLoginVp.setAdapter(mLoginAdapter);
        mLoginTl.setupWithViewPager(mLoginVp);
    }

    @Override
    protected void initClick() {

    }
}
