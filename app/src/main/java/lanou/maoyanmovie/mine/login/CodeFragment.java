package lanou.maoyanmovie.mine.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.tools.LoginTool;

/**
 * Created by 麦建东 on 16/11/29.
 * "注册"界面的验证码验证
 */
public class CodeFragment extends BaseFragment implements View.OnClickListener {

    private EditText mCodeEt;
    private Button mCodeCheckBtn;
    private String mPhoneNum;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine_login_register_code;
    }

    @Override
    protected void initView() {
        mCodeEt = bindView(R.id.code_et);
        mCodeCheckBtn = bindView(R.id.code_check_btn);
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        mPhoneNum = arguments.getString("phoneNum");
        //Mob初始化
        SMSSDK.initSDK(mContext, LoginTool.APP_KEY, LoginTool.APP_SECRETE);

        EventHandler eventHandler = new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {
                Message message = new Message();
                message.arg1 = event;
                message.arg2 = result;
                message.obj = data;
                handler.sendMessage(message);
            }
        };

        //注册回调监听接口
        SMSSDK.registerEventHandler(eventHandler);
    }

    @Override
    protected void initClick() {
        mCodeCheckBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //将收到的验证码和手机号提交再次核对
        SMSSDK.submitVerificationCode("86", mPhoneNum, mCodeEt.getText().toString());
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int event = msg.arg1;
            int result = msg.arg2;
            if (result == SMSSDK.RESULT_COMPLETE) {
                //回调完成
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                    //提交验证码成功
                    Toast.makeText(mContext, "提交验证码成功", Toast.LENGTH_SHORT).show();
                    PasswordFragment passwordFragment = new PasswordFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("phoneNum", mPhoneNum);
                    passwordFragment.setArguments(bundle);
                    FragmentManager manager = getChildFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.register_fl, passwordFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    //发广播通知文字变色
                    Intent intent = new Intent("colorChanged");
                    intent.putExtra("color", true);
                    mContext.sendBroadcast(intent);
                } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                    //获取验证码成功
                    Toast.makeText(mContext, "正在获取验证码", Toast.LENGTH_SHORT).show();
                } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                    //返回支持发送验证码的国家列表
                }
            }
        }
    };

    @Override
    public void onDestroy() {
        SMSSDK.unregisterAllEventHandler();
        super.onDestroy();
    }
}
