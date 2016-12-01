package lanou.maoyanmovie.mine.login;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;

/**
 * Created by 麦建东 on 16/11/29.
 */
public class CodeFragment extends BaseFragment {

    private Button mCodeCheckBtn;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine_login_register_code;
    }

    @Override
    protected void initView() {
        mCodeCheckBtn = bindView(R.id.code_check_btn);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initClick() {
        mCodeCheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PasswordFragment passwordFragment = new PasswordFragment();
                FragmentManager manager = getChildFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.register_fl, passwordFragment);
                transaction.commit();
            }
        });
    }
}
