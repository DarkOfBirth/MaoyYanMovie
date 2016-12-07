package lanou.maoyanmovie.search;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.MyApplication;
import lanou.maoyanmovie.bean.HistoryBean;
import lanou.maoyanmovie.bean.HotSearchBean;
import lanou.maoyanmovie.tools.CommonVH;
import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;
import lanou.maoyanmovie.tools.DBTools;

/**
 * created by 王一鸣 16/12/5.
 * 功能:
 */

public class InitAdapter extends RecyclerView.Adapter<CommonVH> {

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? 1 : 2;
    }


    @Override
    public CommonVH onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 1:
                return CommonVH.getViewHolder(parent, R.layout.item_history_search);
            case 2:
                return CommonVH.getViewHolder(parent, R.layout.item_hot_search);
            default:
                return null;
        }

    }


    @Override
    public void onBindViewHolder(CommonVH holder, int position) {
        switch (holder.getItemViewType()) {
            case 1:
                RecyclerView historyRv = (RecyclerView) holder.getItemView().findViewById(R.id.history_search_rv);
                HistorySearchAdapter historyAdapter = new HistorySearchAdapter();
                historyRv.setAdapter(historyAdapter);
                LinearLayoutManager linLayoutManager = new LinearLayoutManager(holder.getItemView().getContext(), LinearLayoutManager.VERTICAL, false);

                historyRv.setLayoutManager(linLayoutManager);

                //TODO: 从数据库获取数据


                DBTools.getInstance().queryHistoryInfo(HistoryBean.class, new DBTools.OnQueryHistoryInfo<HistoryBean>() {
                    @Override
                    public void OnQuery(ArrayList<HistoryBean> query) {
                        if (query.size() == 0) {
                            historyRv.setVisibility(View.GONE);

                        } else {
                            Collections.reverse(query);

                            ArrayList<String> historyArraylist = new ArrayList<>();
                            for (HistoryBean historyBean : query) {
                                historyArraylist.add(historyBean.getContent());
                            }
                            historyAdapter.setHistoryArrayList(historyArraylist);
                        }
                    }
                });
                break;

            case 2:
                RecyclerView recyclerView = (RecyclerView) holder.getItemView().findViewById(R.id.hot_search_rv);
                HotSearchAdapter adapter = new HotSearchAdapter();
                recyclerView.setAdapter(adapter);
                StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

                GridLayoutManager gridLayoutManager = new GridLayoutManager(holder.getItemView().getContext(), 3);
                recyclerView.setLayoutManager(manager);
                SharedPreferences sharedPreferences = MyApplication.getmContext().getSharedPreferences("cityId", Context.MODE_PRIVATE);
                String cityId = sharedPreferences.getString("cityId","65");
                ArrayList<String> hotArrayList = new ArrayList<>();
                HttpUtil.geHotSearchInfo(cityId, new ResponseCallBack<HotSearchBean>() {
                    @Override
                    public void onError(Exception e) {

                    }

                    @Override
                    public void onResponse(HotSearchBean hotSearchBean) {
                        Log.d("InitAdapter", "热门数据");
                       adapter.setHotSearchBean(hotSearchBean);
                    }
                });


                break;
        }
    }


    @Override
    public int getItemCount() {

        return 2;
    }

}
