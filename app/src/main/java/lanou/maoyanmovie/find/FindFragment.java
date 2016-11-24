package lanou.maoyanmovie.find;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.widget.Toast;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.FindTodayBean;
import lanou.maoyanmovie.bean.FindTopBean;
import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;

/**
 * Created by wangYe on 16/11/21.
 */

public class FindFragment extends BaseFragment implements OnFindClickListener {

    private PullLoadMoreRecyclerView findRv;
    private FindRvAdapter mAdapter;
    private int count = 0;


    @Override
    protected int getLayout() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initView() {
        findRv = bindView(R.id.find_rv);
        mAdapter = new FindRvAdapter(mContext);

        findRv.setAdapter(mAdapter);
        findRv.setLinearLayout();

    }

    @Override
    protected void initData() {
        //首次进入网络请求
        initNetWorkRequest();
        //上拉加载, 下拉刷新
        upAndDownToRefresh();

        mAdapter.setOnFindClickListener(this);
    }

    private void upAndDownToRefresh() {
        findRv.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                Log.d("FindFragment", "下拉刷新");
                initNetWorkRequest();
                findRv.setPullLoadMoreCompleted();
            }

            @Override
            public void onLoadMore() {
                count++;
                HttpUtil.getFindToday(count * 10, 10, new ResponseCallBack<FindTodayBean>() {
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(mContext, "网络出现问题了!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(FindTodayBean findTodayBean) {
                        mAdapter.addFindTodayBean(findTodayBean);
                    }
                });
            }
        });
    }

    @Override
    protected void initClick() {

    }

    private void initNetWorkRequest() {
        HttpUtil.getFindToday(0, 10, new ResponseCallBack<FindTodayBean>() {
            @Override
            public void onError(Exception e) {
                Toast.makeText(mContext, "网络出现问题了!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(FindTodayBean findTodayBean) {
                mAdapter.setFindTodayBean(findTodayBean);
            }
        });
        HttpUtil.getFindTop(new ResponseCallBack<FindTopBean>() {
            @Override
            public void onError(Exception e) {
                Toast.makeText(mContext, "网络出现问题了!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(FindTopBean findTopBean) {
                mAdapter.setFindTopBean(findTopBean);

            }
        });
    }

    @Override
    public void findClick(int targetID) {
        FragmentManager manager = getActivity().getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        DescriptionFragment fragment = new DescriptionFragment();
        transaction.add(R.id.fragment_find, fragment);
        transaction.commit();
    }
}
