package lanou.maoyanmovie.search;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.bean.SearchBean;
import lanou.maoyanmovie.tools.CommonVH;

/**
 * created by 王一鸣 16/12/6.
 * 功能:
 */
public class ResultAdapter extends RecyclerView.Adapter<CommonVH>{
    private SearchBean mSearchBean;
    private OnResultClickListener mOnResultClickListener;

    public ResultAdapter setOnResultClickListener(OnResultClickListener onResultClickListener) {
        mOnResultClickListener = onResultClickListener;
        return this;
    }

    public ResultAdapter setSearchBean(SearchBean searchBean) {
        mSearchBean = searchBean;
        Log.d("ResultAdapter", "mSearchBean.getData().get(0).getList().size():" + mSearchBean.getData().get(0).getList().size());
        notifyDataSetChanged();
        return this;
    }

    @Override
    public CommonVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonVH.getViewHolder(parent, R.layout.item_search);
    }


    @Override
    public void onBindViewHolder(CommonVH holder, int position) {
        SearchBean.DataBean.ListBean listBean = mSearchBean.getData().get(0).getList().get(position);
        if(listBean.getImg()== null){
            return;
        }
        holder.setImage(R.id.img_search_result_iv, listBean.getImg().replace("w.h","165.220"));

        holder.setText(R.id.nm_search_result_tv,listBean.getNm());
        holder.setText(R.id.enm_search_result_tv,listBean.getEnm());
        holder.setText(R.id.pubdesc_search_result_tv,listBean.getPubDesc());
        holder.setText(R.id.cat_search_result_tv,listBean.getCat());
        holder.setText(R.id.sc_search_result_tv,listBean.getSc() == 0 ? "暂无评分":listBean.getSc() + "分");

        holder.setItemClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnResultClickListener.onItemClick(listBean.getId());

            }
        });
    }


    @Override
    public int getItemCount() {
        return mSearchBean == null ? 0 : mSearchBean.getData().get(0).getList().size();
    }

    interface OnResultClickListener{
        void onItemClick(int id );
    }
}
