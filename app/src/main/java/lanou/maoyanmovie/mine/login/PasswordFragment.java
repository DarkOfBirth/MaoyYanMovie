package lanou.maoyanmovie.mine.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.MyUser;
import lanou.maoyanmovie.tools.LoginTool;

/**
 * Created by 麦建东 on 16/11/29.
 * "注册"界面的密码设置
 */
public class PasswordFragment extends BaseFragment implements View.OnClickListener {

    private Button mPasswordBtn;
    private EditText mPwdEt;
    private EditText mPwdAgainEt;
    private String mPhoneNum;
    private String mPwd;
    private String mPwdAgain;
    private TextView mPhoneTv;
    private TextView mCodeTv;
    private TextView mPasswordTv;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine_login_register_password;
    }

    @Override
    protected void initView() {
        mPwdEt = bindView(R.id.password_et);
        mPwdAgainEt = bindView(R.id.password_again_et);
        mPasswordBtn = bindView(R.id.password_btn);
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_mine_login_register,
                null);
        mPhoneTv = (TextView) view.findViewById(R.id.fragment_mine_register_phone_tv);
        mCodeTv = (TextView) view.findViewById(R.id.fragment_mine_register_code_tv);
        mPasswordTv = (TextView) view.findViewById(R.id.fragment_mine_register_password_tv);
    }

    @Override
    protected void initData() {
        //BMob初始化
        Bmob.initialize(mContext, LoginTool.APP_ID);
    }

    @Override
    protected void initClick() {
        mPasswordBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mPhoneTv.setTextColor(0xff757575);
        mCodeTv.setTextColor(0xff757575);
        mPasswordTv.setTextColor(0xfff27f78);
        //接收从CodeFragment传来的数据
        Bundle arguments = getArguments();
        mPhoneNum = arguments.getString("phoneNum");
        //获取输入框的内容
        mPwd = mPwdEt.getText().toString();
        mPwdAgain = mPwdAgainEt.getText().toString();
        //当输入框不为空时
        if (!mPwd.equals(null) && !mPwd.equals("")) {
            if (!mPwd.equals(mPwdAgain)) {
                Toast.makeText(mContext, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
                mPwdEt.setText("");
                mPwdAgainEt.setText("");
            } else {
                MyUser myUser = new MyUser();
                myUser.setUsername(mPhoneNum);
                myUser.setPassword(mPwd);
                //随机获取一张图片
                Random random = new Random();
                int num = random.nextInt(7);
                myUser.setIcon(LoginTool.icon[num]);
                myUser.signUp(new SaveListener<MyUser>() {
                    @Override
                    public void done(MyUser myUser, BmobException e) {
                        if (e == null) {
                            Toast.makeText(mContext, "注册成功", Toast.LENGTH_SHORT).show();
                            //注册成功，切换到"我的"界面
                            MyUser user = BmobUser.getCurrentUser(MyUser.class);
                            Intent intent = new Intent("sendInfo");
                            intent.putExtra("objectId", user.getObjectId());
                            mContext.sendBroadcast(intent);
                            getActivity().onBackPressed();
                        }
                    }
                });
            }
        }

    }

}
