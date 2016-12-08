package lanou.maoyanmovie.gobang;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;

/**
 * If there is no bug, then it is created by WangYiMing 16/11/22.
 * otherwise, it is created by Wang Ye.
 */

public class GobangFragment extends BaseFragment{

    private GobangPanel mGobangPanel;

    @Override
    protected int getLayout() {
        return R.layout.fragment_gobang;
    }

    @Override
    protected void initView() {
        mGobangPanel = bindView(R.id.wuziqi_panel);
    }

    @Override
    protected void initData() {
        mGobangPanel.setOnGameOVerListener(new OnGameOVerListener() {
            @Override
            public void gameOver(boolean isWhiteWinner) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("结果");
                String msg = isWhiteWinner ? "白棋获胜" : "黑棋获胜";
                builder.setMessage(msg + "是否再来一局?");
                builder.setPositiveButton("再来一局", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mGobangPanel.restart();
                    }
                });
                builder.setNegativeButton("不想玩了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().onBackPressed();
                    }
                });
                builder.setCancelable(false);
                builder.show();
            }
        });
    }

    @Override
    protected void initClick() {

    }
}
