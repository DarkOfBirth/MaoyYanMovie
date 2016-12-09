package lanou.maoyanmovie.mine.login;

/**
 * Created by 麦建东 on 16/12/9.
 */

public interface LoginContract {
    interface View {
        //提示登录信息为空
        void showEmptyMsg();
        //登录成功
        void loginSuccess();
        //登录失败
        void loginError(String msg);
        //将Presenter层加到View层里
        void setPresenter(Presenter presenter);
    }

    interface Presenter {
        /**
         * 接收从View层传来的登录信息
         * @param userName 用户名
         * @param password 密码
         */
        void login(String userName, String password);
        //检查登录信息是否为空
        boolean checkIsEmpty(String userName, String password);
        //登录成功
        void loginSuccess();
        /**
         * 登录失败
         * @param exception 登录失败的错误信息
         */
        void loginError(Exception exception);
    }

    interface Model {
        /**
         * 进行耗时操作：登录
         * @param userName 用户名
         * @param password 密码
         */
        void login(String userName, String password);
        //将Presenter层加到Model层里
        void setPresenter(Presenter presenter);
    }
}
