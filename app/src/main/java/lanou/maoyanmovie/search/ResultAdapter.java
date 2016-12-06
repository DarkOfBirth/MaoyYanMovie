package lanou.maoyanmovie.search;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.city.CommonVH;

/**
 * created by 王一鸣 16/12/6.
 * 功能:
 */
public class ResultAdapter extends RecyclerView.Adapter<CommonVH>{

    @Override
    public CommonVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonVH.getViewHolder(parent, R.layout.item_search);
    }


    @Override
    public void onBindViewHolder(CommonVH holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }
}
