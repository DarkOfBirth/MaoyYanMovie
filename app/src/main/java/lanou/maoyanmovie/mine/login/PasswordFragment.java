package lanou.maoyanmovie.mine.login;

import android.view.View;
import android.widget.Button;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;

/**
 * Created by 麦建东 on 16/11/29.
 */
public class PasswordFragment extends BaseFragment {

    private Button mPasswordBtn;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine_login_register_password;
    }

    @Override
    protected void initView() {
        mPasswordBtn = bindView(R.id.password_btn);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initClick() {
        mPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
