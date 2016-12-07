package lanou.maoyanmovie.mine.login;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        //BMob初始化
        Bmob.initialize(mContext, LoginTool.APP_ID);
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
            BmobQuery<MyUser> query = new BmobQuery<>();
            query.addWhereEqualTo("username", mPhoneNum);
            Log.d("LoginFragment", "s:" + mPhoneNum);
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
                    } else {
                        Toast.makeText(mContext, "该手机号已注册过", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Toast.makeText(mContext, "发送失败", Toast.LENGTH_SHORT).show();
        }
    }

}
