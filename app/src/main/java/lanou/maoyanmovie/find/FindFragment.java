package lanou.maoyanmovie.find;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.FindTodayBean;
import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;

/**
 * Created by dllo on 16/11/21.
 */

public class FindFragment extends BaseFragment{

    private RecyclerView findRv;
    private FindRvAdapter mAdapter;
    private LinearLayoutManager mManager;

    @Override
    protected int getLayout() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initView() {
        findRv = bindView(R.id.find_rv);
        mAdapter = new FindRvAdapter(getActivity());
        findRv.setAdapter(mAdapter);
        mManager = new LinearLayoutManager(getActivity());
    }

    @Override
    protected void initData() {
        HttpUtil.getFindToday(0, 10, new ResponseCallBack<FindTodayBean>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onResponse(FindTodayBean findTodayBean) {
                mAdapter.setFindTodayBean(findTodayBean);
                Log.d("FindFragment", "findTodayBean.getData().getFeeds().size():" + findTodayBean.getData().getFeeds().size());
                findRv.setLayoutManager(mManager);
            }
        });
    }

    @Override
    protected void initClick() {

    }
}
