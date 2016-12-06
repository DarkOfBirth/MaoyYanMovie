package lanou.maoyanmovie.search;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.city.CommonVH;

/**
 * created by 王一鸣 16/12/5.
 * 功能:
 */
public class HotSearchAdapter extends RecyclerView.Adapter<CommonVH>{
    private ArrayList<String> hotArrayList;

    public void setHotArrayList(ArrayList<String> hotArrayList) {
        this.hotArrayList = hotArrayList;
       notifyDataSetChanged();
    }

    @Override
    public CommonVH onCreateViewHolder(ViewGroup parent, int viewType) {
       return CommonVH.getViewHolder(parent,R.layout.item_hot);
    }


    @Override
    public void onBindViewHolder(CommonVH holder, int position) {
            holder.setText(R.id.hot_content_tv,hotArrayList.get(position));
    }


    @Override
    public int getItemCount() {
        return hotArrayList == null ? 0 : hotArrayList.size();
    }
}
