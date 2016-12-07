package lanou.maoyanmovie.search;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;

/**
 * created by 王一鸣 16/12/5.
 * 功能:
 */

public class InitSearchFragment extends BaseFragment{

    private InitAdapter mInitAdapter;
    private RecyclerView mInitSearchRv;

    @Override
    protected int getLayout() {
        return R.layout.fragment_init_search;

    }

    @Override
    protected void initView() {
        mInitSearchRv = bindView(R.id.init_search);

        mInitAdapter = new InitAdapter();

    }

    @Override
    protected void initData() {
        mInitSearchRv.setAdapter(mInitAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        mInitSearchRv.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initClick() {

    }
}
