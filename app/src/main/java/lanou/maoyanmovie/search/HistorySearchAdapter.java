package lanou.maoyanmovie.search;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.bean.HistoryBean;
import lanou.maoyanmovie.city.CommonVH;
import lanou.maoyanmovie.tools.DBTools;

/**
 * created by 王一鸣 16/12/5.
 * 功能:
 */
public class HistorySearchAdapter extends RecyclerView.Adapter<CommonVH> {
    private ArrayList<String> historyArrayList;


    public void setHistoryArrayList(ArrayList<String> historyArrayList) {
        this.historyArrayList = historyArrayList;

        notifyDataSetChanged();
    }

    @Override
    public CommonVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonVH.getViewHolder(parent, R.layout.item_history);
    }


    @Override
    public void onBindViewHolder(CommonVH holder, int position) {
        Log.d("HistorySearchAdapter", historyArrayList.get(position));
        holder.setText(R.id.history_content, historyArrayList.get(position));
        holder.setViewClick(R.id.history_delete, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBTools.getInstance().deleteOneHistoryInfo(HistoryBean.class,historyArrayList.get(position));
                historyArrayList.remove(position);
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return historyArrayList == null ? 0 : historyArrayList.size();
    }
}