package lanou.maoyanmovie.mine.login;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.UpdateListener;
import lanou.maoyanmovie.MainActivity;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.MyUser;
import lanou.maoyanmovie.mine.MineFragment;
import lanou.maoyanmovie.tools.LoginTool;

/**
 * Created by 麦建东 on 16/11/23.
 * 手机号码＋短信验证码 登录
 */
public class TeleNumFragment extends BaseFragment implements View.OnClickListener {

    private EditText mPhoneEt;
    private EditText mCodeEt;
    private Button mCodeBtn;
    private Button mLoginBtn;
    private String mPhoneNum;
    //点击"获取验证码"按钮后的数字，代表时间
    private int i = 30;
    private String mCode;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine_login_tele;
    }

    @Override
    protected void initView() {
        mPhoneEt = bindView(R.id.fragment_mine_login_tele_phone_et);
        mCodeEt = bindView(R.id.fragment_mine_login_tele_code_et);
        mCodeBtn = bindView(R.id.fragment_mine_login_tele_code_btn);
        mLoginBtn = bindView(R.id.fragment_mine_login_tele_btn);
    }

    @Override
    protected void initData() {
        mPhoneNum = mPhoneEt.getText().toString();
        mCode = mCodeEt.getText().toString();

        //BMob初始化
        Bmob.initialize(mContext, LoginTool.APP_ID);
    }

    @Override
    protected void initClick() {
        mCodeBtn.setOnClickListener(this);
        mLoginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_mine_login_tele_code_btn:
                //查询用户
                queryUser();
                break;
            case R.id.fragment_mine_login_tele_btn:
                //验证短信验证码，成功的话就登录
                verifyCode();
                break;
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                mCodeBtn.setText("重新发送" + i + "s");
            }
            if (msg.what == 2) {
                mCodeBtn.setText("获取验证码");
                mCodeBtn.setClickable(true);
            }
        }
    };

    //查询用户是否存在
    private void queryUser() {
        BmobQuery<MyUser> query = new BmobQuery<>();
        query.addWhereEqualTo("username", mPhoneNum);
        query.findObjects(new FindListener<MyUser>() {
            @Override
            public void done(List<MyUser> list, BmobException e) {
                if (e == null) {//查询用户成功
                    //发送短信验证码
                    sendCode();
                } else {//查询用户失败
                    Toast.makeText(mContext, "该号码未被注册", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //请求登录的短信码
    private void sendCode() {
        BmobSMS.requestSMSCode(mPhoneNum, "maoYan", new QueryListener<Integer>() {
            @Override
            public void done(Integer integer, BmobException e) {
                if (e == null) {
                    //验证码发送成功
                    mCodeBtn.setClickable(false);
                    mCodeBtn.setText("重新发送(" + i + ")");
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (; i > 0; i--) {
                                handler.sendEmptyMessage(1);
                                if (i <= 0) {
                                    break;
                                }
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            handler.sendEmptyMessage(2);
                        }
                    }).start();
                }
            }
        });
    }

    //验证短信验证码是否验证成功
    private void verifyCode() {
        BmobSMS.verifySmsCode(mPhoneNum, mCode, new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    //短信验证码已验证成功
                    login();
                } else {
                    //验证失败
                    Toast.makeText(mContext, "验证码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //调用loginBySMSCode方法进行手机号码登录
    private void login() {
        BmobUser.loginBySMSCode(mPhoneNum, mCode, new LogInListener<MyUser>() {
            @Override
            public void done(MyUser myUser, BmobException e) {
                if (myUser != null) {
                    //切换到"我的"界面
                    MainActivity activity = (MainActivity) getActivity();
                    MineFragment mineFragment = new MineFragment();
                    String objectId = myUser.getObjectId();
                    Bundle bundle = new Bundle();
                    bundle.putString("objectId", objectId);
                    mineFragment.setArguments(bundle);
                    activity.jumpFragment(mineFragment);
                }
            }
        });
    }

}
