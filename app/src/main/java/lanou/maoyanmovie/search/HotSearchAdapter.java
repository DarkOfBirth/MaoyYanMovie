package lanou.maoyanmovie.search;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.bean.HotSearchBean;
import lanou.maoyanmovie.tools.CommonVH;
import lanou.maoyanmovie.event.SearchHistory;

/**
 * created by 王一鸣 16/12/5.
 * 功能:
 */
public class HotSearchAdapter extends RecyclerView.Adapter<CommonVH>{
    private HotSearchBean mHotSearchBean;

    public HotSearchAdapter setHotSearchBean(HotSearchBean hotSearchBean) {
        mHotSearchBean = hotSearchBean;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public CommonVH onCreateViewHolder(ViewGroup parent, int viewType) {
       return CommonVH.getViewHolder(parent,R.layout.item_hot);
    }


    @Override
    public void onBindViewHolder(CommonVH holder, int position) {
            holder.setText(R.id.hot_content_tv,mHotSearchBean.getData().get(position).getNm());
            holder.setItemClick(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventBus.getDefault().post(new SearchHistory(mHotSearchBean.getData().get(position).getNm()+ ""));
                }
            });
    }


    @Override
    public int getItemCount() {
        return mHotSearchBean == null ? 0 : mHotSearchBean.getData().size();
    }
}
