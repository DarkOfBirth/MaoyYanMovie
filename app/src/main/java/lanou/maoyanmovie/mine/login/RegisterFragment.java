package lanou.maoyanmovie.mine.login;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;

/**
 * Created by 麦建东 on 16/11/29.
 */
public class RegisterFragment extends BaseFragment {

    private Button mSendCodeBtn;
    private FrameLayout mRegisterFl;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine_login_register;
    }

    @Override
    protected void initView() {
        mRegisterFl = bindView(R.id.register_fl);
        mSendCodeBtn = bindView(R.id.send_code_btn);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initClick() {
        mSendCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CodeFragment codeFragment = new CodeFragment();
                FragmentManager manager = getChildFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.register_fl, codeFragment);
                transaction.commit();

//                RegisterFragment registerFragment = new RegisterFragment();
//                registerFragment.replaceFragment(codeFragment);
            }
        });
    }

//    /**
//     * 跳转fragment 的通用方法
//     *
//     * @param t
//     * @param <T>
//     */
//    public <T extends Fragment> void replaceFragment(T t) {
//        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//        transaction.replace(R.id.register_fl, t);
//        transaction.commit();
//    }
}
