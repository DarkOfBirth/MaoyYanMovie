package lanou.maoyanmovie.mine.login;

import android.content.Intent;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.LogInListener;
import lanou.maoyanmovie.base.MyApplication;
import lanou.maoyanmovie.bean.MyUser;

/**
 * Created by 麦建东 on 16/12/9.
 */

public class LoginModel implements LoginContract.Model {
    private LoginContract.Presenter mPresenter;

    //进行耗时操作
    @Override
    public void login(String userName, String password) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //查询用户是否存在
                BmobQuery<MyUser> query = new BmobQuery<>();
                query.addWhereEqualTo("username", userName);
                query.findObjects(new FindListener<MyUser>() {
                    @Override
                    public void done(List<MyUser> list, BmobException e) {
                        if (e == null) {//查询用户成功
                            //使用手机号码＋密码登录
                            BmobUser.loginByAccount(userName, password, new LogInListener<MyUser>() {
                                @Override
                                public void done(MyUser myUser, BmobException e) {
                                    if (myUser != null) {
                                        mPresenter.loginSuccess();
                                        MyUser user = BmobUser.getCurrentUser(MyUser.class);
                                        Intent intent = new Intent("sendInfo");
                                        intent.putExtra("objectId", user.getObjectId());
                                        MyApplication.getmContext().sendBroadcast(intent);
                                    } else {
                                        Exception exception = new Exception("用户名/密码错误");
                                        mPresenter.loginError(exception);
                                    }
                                }
                            });
                        } else {//查询用户失败
                            Exception exception = new Exception("查询用户失败");
                            mPresenter.loginError(exception);
                        }
                    }
                });
            }
        }).start();

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

}
