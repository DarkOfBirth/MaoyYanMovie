package lanou.maoyanmovie.collect;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lanou.maoyanmovie.MainActivity;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.bean.CollectBean;
import lanou.maoyanmovie.find.DescriptionFragment;
import lanou.maoyanmovie.tools.CommonViewHolder;

/**
 * Created by wangYe on 16/12/6.
 */
public class CollectRvAdapter extends RecyclerView.Adapter<CommonViewHolder> {
    ArrayList<CollectBean> mCollectBeen;

    public void setCollectBeen(ArrayList<CollectBean> collectBeen) {
        mCollectBeen = collectBeen;
        notifyDataSetChanged();
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonViewHolder.getViewHolder(parent, R.layout.item_collect);
    }

    @Override
    public void onBindViewHolder(final CommonViewHolder holder, final int position) {
        holder.setText(R.id.item_collect_nick_name, mCollectBeen.get(position).getNickName());
        holder.setText(R.id.item_collect_title, mCollectBeen.get(position).getTitle());
        holder.setImage(R.id.item_collect_img, mCollectBeen.get(position).getUrlImg());
        holder.setText(R.id.item_collect_time, mCollectBeen.get(position).getTime());

        holder.setItemClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DescriptionFragment fragment = new DescriptionFragment();
                MainActivity activity = (MainActivity) holder.getItemView().getContext();
                Bundle bundle = new Bundle();
                bundle.putInt("targetID", mCollectBeen.get(position).getTargetId());
                bundle.putInt("feedType", mCollectBeen.get(position).getFeedType());
                bundle.putString("nickName", mCollectBeen.get(position).getNickName());
                bundle.putString("urlImg", mCollectBeen.get(position).getUrlImg());
                bundle.putString("title", mCollectBeen.get(position).getTitle());
                fragment.setArguments(bundle);
                activity.jumpFragment(fragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCollectBeen == null ? 0 : mCollectBeen.size();
    }
}
