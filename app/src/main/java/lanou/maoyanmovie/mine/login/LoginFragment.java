package lanou.maoyanmovie.mine.login;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

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
import lanou.maoyanmovie.tools.CircleImageView;
import lanou.maoyanmovie.tools.LoginTool;

/**
 * Created by 麦建东 on 16/11/23.
 * "登录"界面
 */
public class LoginFragment extends BaseFragment implements View.OnClickListener {

    private TextView mRegisterTv;
    private RegisterFragment mRegisterFragment;
    private MainActivity mActivity;
    private EditText mPhoneEt;
    private EditText mPasswordEt;
    private Button mLoginBtn;
    private CircleImageView mLoginHeadIv;
    private String mPhoneNum;
    private String mPassword;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine_login;
    }

    @Override
    protected void initView() {
        mRegisterTv = bindView(R.id.register_tv);
        mPhoneEt = bindView(R.id.fragment_mine_login_phone_et);
        mPasswordEt = bindView(R.id.fragment_mine_login_password_et);
        mLoginBtn = bindView(R.id.fragment_mine_login_btn);
        mLoginHeadIv = bindView(R.id.fragment_mine_login_head_iv);
    }

    @Override
    protected void initData() {
        //Bmob初始化
        Bmob.initialize(mContext, LoginTool.APP_ID);
        //判断账号的输入状态，当满足条件时，显示相应的头像
        mPhoneEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                mLoginHeadIv.setImageResource(R.mipmap.main_mine_head);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLoginHeadIv.setImageResource(R.mipmap.main_mine_head);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 11) {
                    //查询用户是否存在
                    BmobQuery<MyUser> query = new BmobQuery<>();
                    query.addWhereEqualTo("username", s);
                    query.findObjects(new FindListener<MyUser>() {
                        @Override
                        public void done(List<MyUser> list, BmobException e) {
                            if (e == null) {
                                for (MyUser myUser : list) {
                                    String icon = myUser.getIcon();
                                    Picasso.with(mContext).load(icon).fit().into(mLoginHeadIv);
                                }
                            } else {
                                mLoginHeadIv.setImageResource(R.mipmap.main_mine_head);
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    protected void initClick() {
        //界面右上角－－注册
        mRegisterTv.setOnClickListener(this);
        mLoginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mPhoneNum = mPhoneEt.getText().toString();
        mPassword = mPasswordEt.getText().toString();
        switch (v.getId()) {
            case R.id.register_tv:
                mActivity = (MainActivity) mContext;
                mRegisterFragment = new RegisterFragment();
                mActivity.jumpFragment(mRegisterFragment);
                break;
            case R.id.fragment_mine_login_btn:
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
                                        MyUser user = BmobUser.getCurrentUser(MyUser.class);
                                        Intent intent = new Intent("sendInfo");
                                        intent.putExtra("objectId", user.getObjectId());
                                        mContext.sendBroadcast(intent);
                                        getActivity().onBackPressed();
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
                break;
        }
    }
}
