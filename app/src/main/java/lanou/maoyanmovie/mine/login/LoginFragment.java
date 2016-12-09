package lanou.maoyanmovie.mine.login;

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
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
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
public class LoginFragment extends BaseFragment implements View.OnClickListener, LoginContract.View {

    private TextView mRegisterTv;
    private RegisterFragment mRegisterFragment;
    private MainActivity mActivity;
    private EditText mPhoneEt;
    private EditText mPasswordEt;
    private Button mLoginBtn;
    private CircleImageView mLoginHeadIv;
    private String mPhoneNum;
    private String mPassword;
    private LoginContract.Presenter mPresenter;

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
        //监听账号输入框的状态
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
                //判断手机号码符合11位，在Bmob上查询用户信息
                if (s.length() == 11) {
                    //查询用户是否存在
                    BmobQuery<MyUser> query = new BmobQuery<>();
                    query.addWhereEqualTo("username", s);
                    query.findObjects(new FindListener<MyUser>() {
                        @Override
                        public void done(List<MyUser> list, BmobException e) {
                            //查找用户成功，显示头像
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
                //将值传到Presenter
                mPresenter.login(mPhoneNum, mPassword);
                break;
        }
    }

    @Override
    public void showEmptyMsg() {
        Toast.makeText(mContext, "手机号码/密码为空", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        getActivity().onBackPressed();
        Toast.makeText(mContext, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
