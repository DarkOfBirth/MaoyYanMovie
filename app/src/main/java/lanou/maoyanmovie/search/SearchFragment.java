package lanou.maoyanmovie.search;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.HistoryBean;
import lanou.maoyanmovie.event.SearchHistory;
import lanou.maoyanmovie.tools.DBTools;

/**
 * Created by dllo on 16/11/21.
 */

public class SearchFragment extends BaseFragment {

    private EditText searchKey;
    private TextView cancelTv;
    private InitSearchFragment mInitSearchFragment;

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_search;

    }

    @Override
    protected void initView() {
        searchKey = bindView(R.id.search_content_et);
        cancelTv = bindView(R.id.search_cancel_tv);
    }

    @Override
    protected void initData() {
        mInitSearchFragment = new InitSearchFragment();
        getFragmentManager().beginTransaction().add(R.id.serarch_result_fl, mInitSearchFragment).addToBackStack(null).commit();


    }
 @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(SearchHistory event){
        jumpToResult(event.getContent());


    }
    @Override
    protected void initClick() {
        searchKey.setOnKeyListener(new View.OnKeyListener() {
            // 回车键
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    String str = searchKey.getText().toString();
                    if ("".equals(str)) {
                        return false;
                    }
                    // 如果是回车键, 进行插入数据库操作
                    if (event.getAction() == KeyEvent.ACTION_UP) {

                    jumpToResult(str);

                    }

                    return true;
                }
                return false;
            }


        });


        cancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInitSearchFragment = new InitSearchFragment();
                getFragmentManager().beginTransaction().replace(R.id.serarch_result_fl, mInitSearchFragment).addToBackStack(null).commit();
            }
        });


    }

    private void jumpToResult(String str) {

        DBTools.getInstance().deleteOneHistoryInfo(HistoryBean.class,str);
        DBTools.getInstance().inserthistoryInfo(new HistoryBean(str));

        SearchResultFragment searchResultFragment = new SearchResultFragment();
        Bundle bundle = new Bundle();

        bundle.putString("key", str);
        searchResultFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().add(R.id.serarch_result_fl, searchResultFragment).addToBackStack(null).commit();

    }


}
