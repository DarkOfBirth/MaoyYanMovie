package lanou.maoyanmovie.search;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.HistoryBean;
import lanou.maoyanmovie.bean.SearchBean;
import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;
import lanou.maoyanmovie.tools.DBTools;

/**
 * Created by dllo on 16/11/21.
 */

public class SearchFragment extends BaseFragment {

    private EditText searchKey;

    @Override
    protected int getLayout() {
        return R.layout.fragment_search;

    }

    @Override
    protected void initView() {
        searchKey = bindView(R.id.search_content_et);
    }

    @Override
    protected void initData() {
        InitSearchFragment initSearchFragment = new InitSearchFragment();
        getFragmentManager().beginTransaction().add(R.id.serarch_result_fl, initSearchFragment).addToBackStack(null).commit();

    }

    @Override
    protected void initClick() {
        searchKey.setOnKeyListener(new View.OnKeyListener() {
            // 回车键
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(keyCode==KeyEvent.KEYCODE_ENTER){
                  // 如果是回车键, 进行插入数据库操作
                    if(event.getAction() == KeyEvent.ACTION_UP){

                    DBTools.getInstance().inserthistoryInfo(new HistoryBean(searchKey.getText().toString()));
                        HttpUtil.getSearcheyInfo(searchKey.getText().toString(), new ResponseCallBack<SearchBean>() {
                            @Override
                            public void onError(Exception e) {

                            }

                            @Override
                            public void onResponse(SearchBean searchBean) {

                            }
                        });
                    }

                    return true;
                }
                return false;
            }
        });





    }


}
