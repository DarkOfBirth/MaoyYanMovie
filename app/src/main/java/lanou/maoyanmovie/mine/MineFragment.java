package lanou.maoyanmovie.mine;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import lanou.maoyanmovie.MainActivity;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.MyUser;
import lanou.maoyanmovie.collect.CollectFragment;
import lanou.maoyanmovie.mine.login.LoginFragment;
import lanou.maoyanmovie.mine.setting.SettingFragment;


/**
 * Created by dllo on 16/11/21.
 * "我的"界面
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout mMainMineSettingRl;
    private TextView mUserTv;
    private SettingFragment mSettingFragment;
    private RelativeLayout mMainMineCollectRl;
    private CollectFragment mCollectFragment;
    private LoginFragment mLoginFragment;
    private LinearLayout mLoginLl;
    private MainActivity mActivity;
    private ImageView mIconIv;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        mMainMineSettingRl = bindView(R.id.main_mine_setting_rl);
        mUserTv = bindView(R.id.main_mine_username);
        mMainMineCollectRl = bindView(R.id.main_mine_collect_rl);
        mLoginLl = bindView(R.id.fragment_mine_login_ll);
        mIconIv = bindView(R.id.fragment_mine_login_icon);
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String objectId = arguments.getString("objectId");
            BmobQuery<MyUser> bmobQuery = new BmobQuery<>();
            bmobQuery.getObject(objectId, new QueryListener<MyUser>() {
                @Override
                public void done(MyUser user, BmobException e) {
                    if (e == null) {
                        mUserTv.setText(user.getUsername());
                        Picasso.with(mContext).load(user.getIcon()).fit().into(mIconIv);
                    } else {
                        Toast.makeText(mContext, "失败", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    protected void initClick() {
        mMainMineSettingRl.setOnClickListener(this);
        mMainMineCollectRl.setOnClickListener(this);
        mLoginLl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mActivity = (MainActivity) mContext;
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
