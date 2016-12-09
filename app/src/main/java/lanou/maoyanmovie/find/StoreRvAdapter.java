package lanou.maoyanmovie.find;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.bean.StoreHeaderBean;
import lanou.maoyanmovie.bean.StoreLikeBean;
import lanou.maoyanmovie.bean.StoreMonthDiscountBean;
import lanou.maoyanmovie.bean.StoreTopBean;
import lanou.maoyanmovie.tools.CommonVH;

/**
 * Created by wangYe on 16/11/24.
 */

public class StoreRvAdapter extends RecyclerView.Adapter<CommonVH> {
    private StoreTopBean mStoreTopBeen;
    private StoreMonthDiscountBean mStoreMonthDiscountBean;
    private StoreLikeBean mStoreLikeBean;
    private StoreHeaderBean mStoreHeaderBean;


    private int[] mItemLayouts = {R.layout.store_header, R.layout.store_top,R.layout.store_cheap_one,
        R.layout.store_cheap_two,R.layout.store_title,R.layout.store_maybe_like};

    public void setStoreHeaderBean(StoreHeaderBean storeHeaderBean) {
        mStoreHeaderBean = storeHeaderBean;
        notifyDataSetChanged();
    }

    public void setStoreLikeBean(StoreLikeBean storeLikeBean) {
        mStoreLikeBean = storeLikeBean;
        notifyDataSetChanged();
    }

    public void addStoreLikeBean(StoreLikeBean storeLikeBean) {
        this.mStoreLikeBean.getData().add(storeLikeBean.getData().getList());
        notifyDataSetChanged();
    }
    public void setStoreMonthDiscountBean(StoreMonthDiscountBean storeMonthDiscountBean) {
        mStoreMonthDiscountBean = storeMonthDiscountBean;
        notifyDataSetChanged();
    }

    public void setStoreTopBeen(StoreTopBean storeTopBeen) {
        mStoreTopBeen = storeTopBeen;
        notifyDataSetChanged();
    }

    @Override
    public CommonVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonVH.getViewHolder(parent,mItemLayouts[viewType]);
    }

    @Override
    public void onBindViewHolder(CommonVH holder, int position) {
        int pos = getItemViewType(position);
        switch (pos) {
            case 0:
                if (mStoreHeaderBean != null){
                    holder.setImage(R.id.store_header_img, mStoreHeaderBean.getData().get(0).getBigImgTypeUrl());
                }
                break;
            case 1:
                if (mStoreTopBeen != null) {
                    holder.setText(R.id.find_header_store_top_tv, mStoreTopBeen.getData().getList().get(0).getTitle());
                    holder.setText(R.id.find_header_store_top_tv1, mStoreTopBeen.getData().getList().get(1).getTitle());
                    holder.setText(R.id.find_header_store_top_tv2, mStoreTopBeen.getData().getList().get(2).getTitle());
                    holder.setText(R.id.find_header_store_top_tv3, mStoreTopBeen.getData().getList().get(3).getTitle());
                    holder.setText(R.id.find_header_store_top_tv4, mStoreTopBeen.getData().getList().get(4).getTitle());
                    holder.setText(R.id.find_header_store_top_tv5, mStoreTopBeen.getData().getList().get(5).getTitle());
                    holder.setText(R.id.find_header_store_top_tv6, mStoreTopBeen.getData().getList().get(6).getTitle());
                    holder.setText(R.id.find_header_store_top_tv7, mStoreTopBeen.getData().getList().get(7).getTitle());
                    holder.setText(R.id.find_header_store_top_tv8, mStoreTopBeen.getData().getList().get(8).getTitle());
                    holder.setText(R.id.find_header_store_top_tv9, mStoreTopBeen.getData().getList().get(9).getTitle());
                    holder.setImage(R.id.find_header_store_top_img, mStoreTopBeen.getData().getList().get(0).getPic());
                    holder.setImage(R.id.find_header_store_top_img1, mStoreTopBeen.getData().getList().get(1).getPic());
                    holder.setImage(R.id.find_header_store_top_img2, mStoreTopBeen.getData().getList().get(2).getPic());
                    holder.setImage(R.id.find_header_store_top_img3, mStoreTopBeen.getData().getList().get(3).getPic());
                    holder.setImage(R.id.find_header_store_top_img4, mStoreTopBeen.getData().getList().get(4).getPic());
                    holder.setImage(R.id.find_header_store_top_img5, mStoreTopBeen.getData().getList().get(5).getPic());
                    holder.setImage(R.id.find_header_store_top_img6, mStoreTopBeen.getData().getList().get(6).getPic());
                    holder.setImage(R.id.find_header_store_top_img7, mStoreTopBeen.getData().getList().get(7).getPic());
                    holder.setImage(R.id.find_header_store_top_img8, mStoreTopBeen.getData().getList().get(8).getPic());
                    holder.setImage(R.id.find_header_store_top_img9, mStoreTopBeen.getData().getList().get(9).getPic());
                }
                break;
            case 2:
                if (mStoreMonthDiscountBean != null) {
                    holder.setText(R.id.find_header_store_cheap_one_title_one, mStoreMonthDiscountBean.getData().getList().get(0).getDeals().get(0).getTitle());
                    holder.setText(R.id.find_header_store_cheap_one_title_two, mStoreMonthDiscountBean.getData().getList().get(0).getDeals().get(1).getTitle());
                    holder.setText(R.id.find_header_store_cheap_one_title_three, mStoreMonthDiscountBean.getData().getList().get(0).getDeals().get(2).getTitle());

                    holder.setText(R.id.find_header_store_cheap_one_desc_one, mStoreMonthDiscountBean.getData().getList().get(0).getDeals().get(0).getDesc());
                    holder.setText(R.id.find_header_store_cheap_one_desc_two, mStoreMonthDiscountBean.getData().getList().get(0).getDeals().get(1).getDesc());
                    holder.setText(R.id.find_header_store_cheap_one_desc_three, mStoreMonthDiscountBean.getData().getList().get(0).getDeals().get(2).getDesc());

                    holder.setImage(R.id.find_header_store_cheap_one_pic_one, mStoreMonthDiscountBean.getData().getList().get(0).getDeals().get(0).getPic());
                    holder.setImage(R.id.find_header_store_cheap_one_pic_two, mStoreMonthDiscountBean.getData().getList().get(0).getDeals().get(1).getPic());
                    holder.setImage(R.id.find_header_store_cheap_one_pic_three, mStoreMonthDiscountBean.getData().getList().get(0).getDeals().get(2).getPic());
                }
                break;
            case 3:
                if (mStoreMonthDiscountBean != null) {
                    holder.setText(R.id.find_header_store_cheap_two_title_one, mStoreMonthDiscountBean.getData().getList().get(1).getDeals().get(0).getTitle());
                    holder.setText(R.id.find_header_store_cheap_two_title_two, mStoreMonthDiscountBean.getData().getList().get(1).getDeals().get(1).getTitle());
                    holder.setText(R.id.find_header_store_cheap_two_title_three, mStoreMonthDiscountBean.getData().getList().get(1).getDeals().get(2).getTitle());

                    holder.setText(R.id.find_header_store_cheap_two_desc_one, mStoreMonthDiscountBean.getData().getList().get(1).getDeals().get(0).getDesc());
                    holder.setText(R.id.find_header_store_cheap_two_desc_two, mStoreMonthDiscountBean.getData().getList().get(1).getDeals().get(1).getDesc());
                    holder.setText(R.id.find_header_store_cheap_two_desc_three, mStoreMonthDiscountBean.getData().getList().get(1).getDeals().get(2).getDesc());

                    holder.setImage(R.id.find_header_store_cheap_two_pic_one, mStoreMonthDiscountBean.getData().getList().get(1).getDeals().get(0).getPic());
                    holder.setImage(R.id.find_header_store_cheap_two_pic_two, mStoreMonthDiscountBean.getData().getList().get(1).getDeals().get(1).getPic());
                    holder.setImage(R.id.find_header_store_cheap_two_pic_three, mStoreMonthDiscountBean.getData().getList().get(1).getDeals().get(2).getPic());
                }
                break;
            case 4:
                holder.setText(R.id.find_header_store_title, "您可能喜欢");
                break;
            case 5:
                if (mStoreLikeBean != null) {
                    holder.setText(R.id.find_header_store_like_title, mStoreLikeBean.getData().getList().get(position - 4).getTitle());
                    holder.setText(R.id.find_header_store_like_price, String.valueOf(mStoreLikeBean.getData().getList().get(position - 4).getPrice()));
                    holder.setText(R.id.find_header_store_like_price_value, String.valueOf(mStoreLikeBean.getData().getList().get(position - 4).getValue()));
                    holder.setImage(R.id.find_header_store_like_pic, mStoreLikeBean.getData().getList().get(position - 4).getPic());
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (mStoreHeaderBean != null){
            count +=1;
        }
        if (mStoreTopBeen != null) {
            count += 1;
        }
        if (mStoreMonthDiscountBean != null) {
            count += 1;
        }
        if (mStoreLikeBean != null) {
            count += 1 + mStoreLikeBean.getData().getList().size();//加上您可能喜欢
        }
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        int num = 0;
        if (position >= 5) {
            num = 5;
        } else {
            num = position;
        }
        return num;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) manager;
            final int spanCount = gridLayoutManager.getSpanCount();
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (position < 5) {
                        return spanCount;
                    } else {
                        return 1;
                    }
                }
            });
        }
    }

    @Override
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver observer) {
        if(observer != null) {
            super.unregisterAdapterDataObserver(observer);
        }
    }
}
