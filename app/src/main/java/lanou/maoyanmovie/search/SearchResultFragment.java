package lanou.maoyanmovie.search;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import lanou.maoyanmovie.MainActivity;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.base.MyApplication;
import lanou.maoyanmovie.bean.SearchBean;
import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;
import lanou.maoyanmovie.movie.hot.HotListDetailFragment;

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
        Log.d("SearchResultFragment", "进入搜索结果");
        String key = getArguments().getString("key");
        ResultAdapter resultAdapter = new ResultAdapter();
        resultAdapter.setOnResultClickListener(new ResultAdapter.OnResultClickListener() {
            @Override
            public void onItemClick(int id) {
                MainActivity activity = (MainActivity) getActivity();
                HotListDetailFragment hotListDetailFragment = new HotListDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("movieId",id);
                hotListDetailFragment.setArguments(bundle);
                activity.jumpFragment(hotListDetailFragment);
            }
        });
        resultRv.setAdapter(resultAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getmContext(),LinearLayoutManager.VERTICAL,false);
        resultRv.setLayoutManager(manager);
        HttpUtil.getSearcheyInfo(key, new ResponseCallBack<SearchBean>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onResponse(SearchBean searchBean) {
                Log.d("SearchResultFragment", "开始请求");
                resultAdapter.setSearchBean(searchBean);

            }
        });
    }

    @Override
    protected void initClick() {

    }
}
