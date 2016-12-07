package lanou.maoyanmovie.search;

import android.support.v7.widget.RecyclerView;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;

/**
 * created by 王一鸣 16/12/6.
 * 功能:
 */

public class SearchResultFragment extends BaseFragment {

    private RecyclerView resultRv;

    @Override
    protected int getLayout() {
        return R.layout.fragment_search_result;
    }

    @Override
    protected void initView() {
       resultRv =  bindView(R.id.result_rv);
    }

    @Override
    protected void initData() {
        ResultAdapter resultAdapter = new ResultAdapter();
      //  resultRv.setAdapter();
    }

    @Override
    protected void initClick() {

    }
}
