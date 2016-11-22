package lanou.maoyanmovie.mine;

import android.view.View;
import android.widget.ImageButton;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;

/**
 * Created by 麦建东 on 16/11/22.
 */
public class SettingFragment extends BaseFragment implements View.OnClickListener {

    private ImageButton mSettingReturnIb;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine_setting;
    }

    @Override
    protected void initView() {
        mSettingReturnIb = bindView(R.id.fragment_mine_setting_return_ib);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initClick() {
        mSettingReturnIb.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_mine_setting_return_ib:
                getFragmentManager().popBackStack();
                break;
        }
    }
}
