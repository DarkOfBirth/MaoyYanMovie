package lanou.maoyanmovie.mine.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.LogInListener;
import lanou.maoyanmovie.MainActivity;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.MyUser;
import lanou.maoyanmovie.mine.MineFragment;
import lanou.maoyanmovie.tools.LoginTool;

/**
 * Created by 麦建东 on 16/11/23.
 * 手机号码＋密码 登录
 */
public class AccountFragment extends BaseFragment implements View.OnClickListener {

    private EditText mPhoneEt;
    private EditText mPwdEt;
    private Button mLoginBtn;
    private String mPhoneNum;
    private String mPassword;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine_login_account;
    }

    @Override
    protected void initView() {
        mPhoneEt = bindView(R.id.fragment_mine_login_account_phone_et);
        mPwdEt = bindView(R.id.fragment_mine_login_account_password_et);
        mLoginBtn = bindView(R.id.fragment_mine_login_account_btn);
    }

    @Override
    protected void initData() {
        //Bmob初始化
        Bmob.initialize(mContext, LoginTool.APP_ID);
    }

    @Override
    protected void initClick() {
        mLoginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mPhoneNum = mPhoneEt.getText().toString();
        mPassword = mPwdEt.getText().toString();
        //查询用户是否存在
        BmobQuery<MyUser> query = new BmobQuery<>();
        query.addWhereEqualTo("username", mPhoneNum);
        query.findObjects(new FindListener<MyUser>() {
            @Override
            public void done(List<MyUser> list, BmobException e) {
                if (e == null) {//查询用户成功
                    //使用手机号码＋密码登录
                    BmobUser.loginByAccount(mPhoneNum, mPassword, new LogInListener<MyUser>() {
                        @Override
                        public void done(MyUser myUser, BmobException e) {
                            if (myUser != null) {
                                Toast.makeText(mContext, "登录成功", Toast.LENGTH_SHORT).show();

                                MainActivity activity = (MainActivity) mContext;
                                MineFragment mineFragment = new MineFragment();
                                String objectId = myUser.getObjectId();
                                Bundle bundle = new Bundle();
                                bundle.putString("objectId", objectId);
                                mineFragment.setArguments(bundle);
                                activity.jumpFragment(mineFragment);
                            } else {
                                Toast.makeText(mContext, "密码错误", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {//查询用户失败
                    Toast.makeText(mContext, "该号码未被注册", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
