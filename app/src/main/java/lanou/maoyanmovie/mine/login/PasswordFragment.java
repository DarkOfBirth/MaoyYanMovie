package lanou.maoyanmovie.mine.login;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import lanou.maoyanmovie.MainActivity;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.MyUser;
import lanou.maoyanmovie.mine.MineFragment;
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

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine_login_register_password;
    }

    @Override
    protected void initView() {
        mPwdEt = bindView(R.id.password_et);
        mPwdAgainEt = bindView(R.id.password_again_et);
        mPasswordBtn = bindView(R.id.password_btn);
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
        //接收从CodeFragment传来的数据
        Bundle arguments = getArguments();
        mPhoneNum = arguments.getString("phoneNum");
        Log.d("PasswordFragment", mPhoneNum);
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
                myUser.setIcon(LoginTool.icon);
                myUser.save(new SaveListener<MyUser>() {
                    @Override
                 public void done(MyUser user, BmobException e) {
                        if (e == null) {
                            Toast.makeText(mContext, "注册成功", Toast.LENGTH_SHORT).show();
                            //注册成功，切换到"我的"界面
                            MainActivity activity = (MainActivity) getActivity();
                            MineFragment mineFragment = new MineFragment();
                            Bundle bundle = new Bundle();
                            bundle.putString("objectId", user.getObjectId());
                            mineFragment.setArguments(bundle);
                            activity.jumpFragment(mineFragment);
                        } else {
                            Toast.makeText(mContext, "注册失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

    }

}
