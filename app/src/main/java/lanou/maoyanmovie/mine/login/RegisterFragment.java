package lanou.maoyanmovie.mine.login;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.smssdk.SMSSDK;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.tools.LoginTool;

/**
 * Created by 麦建东 on 16/11/29.
 * "注册"界面的输入手机号码
 */
public class RegisterFragment extends BaseFragment implements View.OnClickListener {

    private EditText mPhoneEt;
    private Button mSendCodeBtn;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine_login_register;
    }

    @Override
    protected void initView() {
        mPhoneEt = bindView(R.id.phone_et);
        mSendCodeBtn = bindView(R.id.send_code_btn);
    }

    @Override
    protected void initData() {
        //Mob初始化
        SMSSDK.initSDK(mContext, LoginTool.APP_KEY, LoginTool.APP_SECRETE);
    }

    @Override
    protected void initClick() {
        mSendCodeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String mPhoneNum = mPhoneEt.getText().toString();
        if (LoginTool.judgePhoneNum(mPhoneNum)) {
            SMSSDK.getVerificationCode("86", mPhoneNum);
            CodeFragment codeFragment = new CodeFragment();
            Bundle bundle = new Bundle();
            bundle.putString("phoneNum", mPhoneNum);
            codeFragment.setArguments(bundle);
            FragmentManager manager = getChildFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.register_fl, codeFragment);
            transaction.commit();
        } else {
            Toast.makeText(mContext, "发送失败", Toast.LENGTH_SHORT).show();
        }
    }

}
