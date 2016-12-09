package lanou.maoyanmovie.mine.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.smssdk.SMSSDK;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.MyUser;
import lanou.maoyanmovie.tools.LoginTool;

/**
 * Created by 麦建东 on 16/11/29.
 * "注册"界面的输入手机号码
 */
public class RegisterFragment extends BaseFragment implements View.OnClickListener {

    private EditText mPhoneEt;
    private Button mSendCodeBtn;
    private TextView mPhoneTv;
    private TextView mCodeTv;
    private TextView mPasswordTv;
    private Boolean color = false;
    private ColorNotifyBroadcastReceiver mReceiver;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine_login_register;
    }

    @Override
    protected void initView() {
        mPhoneEt = bindView(R.id.phone_et);
        mSendCodeBtn = bindView(R.id.send_code_btn);
        mPhoneTv = bindView(R.id.fragment_mine_register_phone_tv);
        mCodeTv = bindView(R.id.fragment_mine_register_code_tv);
        mPasswordTv = bindView(R.id.fragment_mine_register_password_tv);
    }

    @Override
    protected void initData() {
        //使"输入手机号"字变色，表示为当前状态
        mPhoneTv.setTextColor(0xfff27f78);
        mCodeTv.setTextColor(0xff757575);
        mPasswordTv.setTextColor(0xff757575);
        //BMob初始化
        Bmob.initialize(mContext, LoginTool.APP_ID);
        //Mob初始化
        SMSSDK.initSDK(mContext, LoginTool.APP_KEY, LoginTool.APP_SECRETE);

        mReceiver = new ColorNotifyBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("colorChanged");
        mContext.registerReceiver(mReceiver, filter);
    }

    @Override
    protected void initClick() {
        mSendCodeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String mPhoneNum = mPhoneEt.getText().toString();
        if (LoginTool.judgePhoneNum(mPhoneNum)) {
            BmobQuery<MyUser> query = new BmobQuery<>();
            query.addWhereEqualTo("username", mPhoneNum);
            query.findObjects(new FindListener<MyUser>() {
                @Override
                public void done(List<MyUser> list, BmobException e) {
                    if (e == null) {
                        SMSSDK.getVerificationCode("86", mPhoneNum);
                        CodeFragment codeFragment = new CodeFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("phoneNum", mPhoneNum);
                        codeFragment.setArguments(bundle);
                        FragmentManager manager = getChildFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.register_fl, codeFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                        //使"输入验证码"字变色，表示为当前状态
                        mPhoneTv.setTextColor(0xff757575);
                        mCodeTv.setTextColor(0xfff27f78);
                        mPasswordTv.setTextColor(0xff757575);
                    } else {
                        Toast.makeText(mContext, "该手机号已注册过", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Toast.makeText(mContext, "发送失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mContext.unregisterReceiver(mReceiver);
    }

    class ColorNotifyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            color = intent.getBooleanExtra("color", false);
            if (color) {
                mPhoneTv.setTextColor(0xff757575);
                mCodeTv.setTextColor(0xff757575);
                mPasswordTv.setTextColor(0xfff27f78);
            }
        }
    }

}
