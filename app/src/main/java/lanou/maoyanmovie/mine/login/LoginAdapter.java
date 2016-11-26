package lanou.maoyanmovie.mine.login;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 麦建东 on 16/11/23.
 */
public class LoginAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragmentArrayList;
    private String[] titles = {"账号密码登录", "手机号快捷登录"};

    public LoginAdapter(FragmentManager fm) {
        super(fm);
        mFragmentArrayList = new ArrayList<>();
    }

    public void setFragmentArrayList(ArrayList<Fragment> fragmentArrayList) {
        mFragmentArrayList = fragmentArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentArrayList == null ? 0 : mFragmentArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
