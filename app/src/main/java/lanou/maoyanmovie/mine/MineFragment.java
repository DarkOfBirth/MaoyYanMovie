package lanou.maoyanmovie.mine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import lanou.maoyanmovie.MainActivity;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.MyUser;
import lanou.maoyanmovie.collect.CollectFragment;
import lanou.maoyanmovie.mine.login.LoginFragment;
import lanou.maoyanmovie.mine.setting.SettingFragment;
import lanou.maoyanmovie.tools.CircleImageView;
import lanou.maoyanmovie.tools.LoginTool;


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
    private CircleImageView mIconIv;
    private Button mQuitBtn;
    private LoginSuccessBroadcastReceiver mReceiver;

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
        mQuitBtn = bindView(R.id.fragment_mine_quit_btn);
    }

    @Override
    protected void initData() {
        mReceiver = new LoginSuccessBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("sendInfo");
        mContext.registerReceiver(mReceiver, filter);
        //BMob初始化
        Bmob.initialize(mContext, LoginTool.APP_ID);
        MyUser myUser = BmobUser.getCurrentUser(MyUser.class);
        if (myUser != null) {
            //允许用户使用应用
            mUserTv.setText(myUser.getUsername());
            Picasso.with(mContext).load(myUser.getIcon()).fit().into(mIconIv);
            mQuitBtn.setVisibility(View.VISIBLE);
            mLoginLl.setClickable(false);
        } else {
            //缓存用户对象为空时，可打开用户注册界面
            mUserTv.setText("登录");
            mIconIv.setImageResource(R.mipmap.main_mine_head);
            mQuitBtn.setVisibility(View.GONE);
            mLoginLl.setClickable(true);
        }
    }

    @Override
    protected void initClick() {
        mMainMineSettingRl.setOnClickListener(this);
        mMainMineCollectRl.setOnClickListener(this);
        mLoginLl.setOnClickListener(this);
        mQuitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mActivity = (MainActivity) mContext;
        switch (v.getId()) {
            //设置
            case R.id.main_mine_setting_rl:
                mSettingFragment = new SettingFragment();
                mActivity.jumpFragment(mSettingFragment);
                break;
            //登录
            case R.id.fragment_mine_login_ll:
                mLoginFragment = new LoginFragment();
                mActivity.jumpFragment(mLoginFragment);
                break;
            //退出登录
            case R.id.fragment_mine_quit_btn:
                BmobUser.logOut();//清除缓存用户对象
                mUserTv.setText("登录");
                mIconIv.setImageResource(R.mipmap.main_mine_head);
                mQuitBtn.setVisibility(View.GONE);
                mLoginLl.setClickable(true);
                break;
            case R.id.main_mine_collect_rl:
                mCollectFragment = new CollectFragment();
                MainActivity activity1 = (MainActivity) getActivity();
                activity1.jumpFragment(mCollectFragment);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mContext.unregisterReceiver(mReceiver);
    }

    class LoginSuccessBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String objectId = intent.getStringExtra("objectId");
            if (objectId != null) {
                mLoginLl.setClickable(false);
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
                mQuitBtn.setVisibility(View.VISIBLE);
            }

        }
    }

}
