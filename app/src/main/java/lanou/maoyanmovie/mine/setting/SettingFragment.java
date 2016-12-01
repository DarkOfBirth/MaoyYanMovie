package lanou.maoyanmovie.mine.setting;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import lanou.maoyanmovie.MainActivity;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.gobang.GobangFragment;

/**
 * Created by 麦建东 on 16/11/22.
 */
public class SettingFragment extends BaseFragment implements View.OnClickListener, View.OnLongClickListener {

    private ImageButton mSettingReturnIb;
    private LinearLayout wuziqi;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine_setting;
    }

    @Override
    protected void initView() {
        mSettingReturnIb = bindView(R.id.fragment_mine_setting_return_ib);
        wuziqi = bindView(R.id.fragment_mine_setting_wuziqi_ll);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initClick() {
        mSettingReturnIb.setOnClickListener(this);
        wuziqi.setOnLongClickListener(this);
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

    /**
     * Called when a view has been clicked and held.
     *
     * @param v The view that was clicked and held.
     * @return true if the callback consumed the long click, false otherwise.
     */
    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()){
            case R.id.fragment_mine_setting_wuziqi_ll:
                GobangFragment gobangFragment = new GobangFragment();
                MainActivity activity = (MainActivity) getActivity();
                activity.jumpFragment(gobangFragment);
                break;
        }
        return true;
    }
}
