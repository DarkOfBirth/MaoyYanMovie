package lanou.maoyanmovie.find;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.bean.FindTodayBean;
import lanou.maoyanmovie.bean.FindTopBean;


/**
 * Created by 王野 on 16/11/22.
 */

public class FindRvAdapter extends RecyclerView.Adapter<FindRvAdapter.FindViewHolder> implements View.OnClickListener {

    private FindTopBean mFindTopBean;
    private FindTodayBean mFindTodayBean;
    private Context mContext;
    private OnFindClickListener mOnFindClickListener;

    public void setOnFindClickListener(OnFindClickListener onFindClickListener) {
        mOnFindClickListener = onFindClickListener;
    }

    public FindRvAdapter(Context context) {
        mContext = context;
    }

    public void setFindTodayBean(FindTodayBean findTodayBean) {
        mFindTodayBean = findTodayBean;
        notifyDataSetChanged();
    }

    public void addFindTodayBean(FindTodayBean findTodayBean) {
        this.mFindTodayBean.getData().addData(findTodayBean.getData().getFeeds());
        notifyDataSetChanged();
    }

    public void setFindTopBean(FindTopBean findTopBean) {
        mFindTopBean = findTopBean;
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        if (mFindTopBean == null) {
            return mFindTodayBean.getData().getFeeds().get(position).getStyle();
        } else {
            return position == 0 ? -3 : mFindTodayBean.getData().getFeeds().get(position - 1).getStyle();
        }
    }

    @Override
    public FindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        FindViewHolder mViewHolder = null;
        switch (viewType) {
            case -3:
                View view3 = LayoutInflater.from(mContext).inflate(R.layout.item_find_head, parent, false);
                mViewHolder = new FindViewHolder(view3);
                break;
            case 3:
                View view = LayoutInflater.from(mContext).inflate(R.layout.item_find_thire, parent, false);
                mViewHolder = new FindViewHolder(view);
                break;
            case 2:
                View view1 = LayoutInflater.from(mContext).inflate(R.layout.item_find_two, parent, false);
                mViewHolder = new FindViewHolder(view1);
                break;
            case 4:
                View view2 = LayoutInflater.from(mContext).inflate(R.layout.item_find_four, parent, false);
                mViewHolder = new FindViewHolder(view2);
                break;
            default:
                View view4 = LayoutInflater.from(mContext).inflate(R.layout.item_find_seven, parent, false);
                mViewHolder = new FindViewHolder(view4);
                break;
        }
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(FindViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type != -3) {
            position = position - 1;
        }
        switch (type) {
            case 2:
                holder.findTwoCommentCountTv.setText(String.valueOf(mFindTodayBean.getData().getFeeds().get(position).getCommentCount()));
                if (mFindTodayBean.getData().getFeeds().get(position).getUser() != null) {
                    holder.findTwoNickNameTv.setText(mFindTodayBean.getData().getFeeds().get(position).getUser().getNickName());
                } else {
                    holder.findTwoNickNameTv.setText("");
                }
                holder.findTwoTitleTv.setText(mFindTodayBean.getData().getFeeds().get(position).getTitle());
                holder.findTwoViewCountTv.setText(String.valueOf(mFindTodayBean.getData().getFeeds().get(position).getViewCount()));
                Picasso.with(mContext).load(mFindTodayBean.getData().getFeeds().get(position).getImages().get(0).getUrl()).into(holder.findTwoImage);
                final int finalPosition = position;
                holder.findTwoItemRv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mOnFindClickListener != null){
                          mOnFindClickListener.findClick(
                                  mFindTodayBean.getData().getFeeds().get(finalPosition).getImages().get(0).getTargetId(),
                                  mFindTodayBean.getData().getFeeds().get(finalPosition).getFeedType(),
                                  mFindTodayBean.getData().getFeeds().get(finalPosition).getUser().getNickName(),
                                  mFindTodayBean.getData().getFeeds().get(finalPosition).getImages().get(0).getUrl(),
                                  mFindTodayBean.getData().getFeeds().get(finalPosition).getTitle());
                        }
                    }
                });
                break;
            case 3:
                holder.findThirdCommentCountTv.setText(String.valueOf(mFindTodayBean.getData().getFeeds().get(position).getCommentCount()));
                holder.findThirdNickNameTv.setText(mFindTodayBean.getData().getFeeds().get(position).getUser().getNickName());
                holder.findThirdTitleTv.setText(mFindTodayBean.getData().getFeeds().get(position).getTitle());
                holder.findThirdViewCountTv.setText(String.valueOf(mFindTodayBean.getData().getFeeds().get(position).getViewCount()));
                Picasso.with(mContext).load(mFindTodayBean.getData().getFeeds().get(position).getImages().get(0).getUrl()).into(holder.findThirdImagesOneImg);
                Picasso.with(mContext).load(mFindTodayBean.getData().getFeeds().get(position).getImages().get(1).getUrl()).into(holder.findThirdImagesTwoImg);
                Picasso.with(mContext).load(mFindTodayBean.getData().getFeeds().get(position).getImages().get(2).getUrl()).into(holder.findThirdImagesThirdImg);
                final int finalPosition1 = position;
                holder.findThirdItemLl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(mOnFindClickListener != null){
                        mOnFindClickListener.findClick(
                                mFindTodayBean.getData().getFeeds().get(finalPosition1).getImages().get(0).getTargetId(),
                                mFindTodayBean.getData().getFeeds().get(finalPosition1).getFeedType(),
                                mFindTodayBean.getData().getFeeds().get(finalPosition1).getUser().getNickName(),
                                mFindTodayBean.getData().getFeeds().get(finalPosition1).getImages().get(0).getUrl(),
                                mFindTodayBean.getData().getFeeds().get(finalPosition1).getTitle()
                                );
                        }
                    }
                });
                break;
            case 4:
                holder.findFourCommentCountTv.setText(String.valueOf(mFindTodayBean.getData().getFeeds().get(position).getCommentCount()));
                holder.findFourNickNameTv.setText(mFindTodayBean.getData().getFeeds().get(position).getUser().getNickName());
                holder.findFourTitleTv.setText(mFindTodayBean.getData().getFeeds().get(position).getTitle());
                holder.findFourViewCountTv.setText(String.valueOf(mFindTodayBean.getData().getFeeds().get(position).getViewCount()));
                Picasso.with(mContext).load(mFindTodayBean.getData().getFeeds().get(position).getImages().get(0).getUrl()).into(holder.findFourImagesOneImg);
                Picasso.with(mContext).load(mFindTodayBean.getData().getFeeds().get(position).getImages().get(1).getUrl()).into(holder.findFourImagesTwoImg);
                Picasso.with(mContext).load(mFindTodayBean.getData().getFeeds().get(position).getImages().get(2).getUrl()).into(holder.findFourImagesThreeImg);
                final int finalPosition2 = position;
                holder.findFourItemRv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnFindClickListener.findClick(
                                mFindTodayBean.getData().getFeeds().get(finalPosition2).getImages().get(0).getTargetId(),
                                mFindTodayBean.getData().getFeeds().get(finalPosition2).getFeedType(),
                                mFindTodayBean.getData().getFeeds().get(finalPosition2).getUser().getNickName(),
                                mFindTodayBean.getData().getFeeds().get(finalPosition2).getImages().get(0).getUrl(),
                                mFindTodayBean.getData().getFeeds().get(finalPosition2).getTitle());
                    }
                });
                break;
            case -3:
                Picasso.with(mContext).load(mFindTopBean.getData().get(0).getImage().getUrl()).into(holder.findHeaderTop);
                Picasso.with(mContext).load(mFindTopBean.getData().get(1).getImage().getUrl()).into(holder.findHeaderNew);
                Picasso.with(mContext).load(mFindTopBean.getData().get(2).getImage().getUrl()).into(holder.findHeaderStore);
                Picasso.with(mContext).load(mFindTopBean.getData().get(3).getImage().getUrl()).into(holder.findHeaderHouse);
                holder.findHeaderTop.setOnClickListener(this);
                holder.findHeaderNew.setOnClickListener(this);
                holder.findHeaderStore.setOnClickListener(this);
                holder.findHeaderHouse.setOnClickListener(this);
                break;
            case 7:
                holder.findSevenTitleTv.setText(mFindTodayBean.getData().getFeeds().get(position).getTitle());
                if (mFindTodayBean.getData().getFeeds().get(position).getUser() != null) {
                    holder.findSevenNickNameTv.setText(mFindTodayBean.getData().getFeeds().get(position).getUser().getNickName());
                } else {
                    holder.findSevenNickNameTv.setText("");
                }
                Picasso.with(mContext).load(mFindTodayBean.getData().getFeeds().
                        get(position).getImages().get(0).getUrl()).into(holder.findSevenImageImg);
                final int finalPosition3 = position;
                holder.findSevenItemLl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnFindClickListener.findClick(
                                mFindTodayBean.getData().getFeeds().get(finalPosition3).getImages().get(0).getTargetId(),
                                mFindTodayBean.getData().getFeeds().get(finalPosition3).getFeedType(),
                                mFindTodayBean.getData().getFeeds().get(finalPosition3).getUser().getNickName(),
                                mFindTodayBean.getData().getFeeds().get(finalPosition3).getImages().get(0).getUrl(),
                                mFindTodayBean.getData().getFeeds().get(finalPosition3).getTitle());
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        int num = 0;
        if (mFindTopBean != null) {
            num += 1;
        }
        if (mFindTodayBean != null) {
            try {
                num += mFindTodayBean.getData().getFeeds().size();
            } catch (NullPointerException e) {

            }
        }
        return num;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.find_header_top:
                mOnFindClickListener.findTopClick(mFindTopBean.getData().get(0).getTitle());
                break;
            case R.id.find_header_new:
                mOnFindClickListener.findTopClick(mFindTopBean.getData().get(1).getTitle());
                break;
            case R.id.find_header_store:
                mOnFindClickListener.findTopClick(mFindTopBean.getData().get(2).getTitle());
                break;
            case R.id.find_header_house:
                mOnFindClickListener.findTopClick(mFindTopBean.getData().get(3).getTitle());
                break;
        }
    }

    public class FindViewHolder extends RecyclerView.ViewHolder {
        private TextView findThirdTitleTv;
        private ImageView findThirdImagesOneImg;
        private ImageView findThirdImagesTwoImg;
        private ImageView findThirdImagesThirdImg;
        private TextView findThirdNickNameTv;
        private TextView findThirdViewCountTv;
        private TextView findThirdCommentCountTv;

        private ImageView findTwoImage;
        private TextView findTwoTitleTv;
        private TextView findTwoNickNameTv;
        private TextView findTwoViewCountTv;
        private TextView findTwoCommentCountTv;

        private TextView findFourTitleTv;
        private ImageView findFourImagesOneImg;
        private ImageView findFourImagesTwoImg;
        private ImageView findFourImagesThreeImg;
        private TextView findFourNickNameTv;
        private TextView findFourViewCountTv;
        private TextView findFourCommentCountTv;

        private ImageView findHeaderTop;
        private ImageView findHeaderNew;
        private ImageView findHeaderStore;
        private ImageView findHeaderHouse;
        private LinearLayout findThirdItemLl;
        private RelativeLayout findTwoItemRv;
        private RelativeLayout findFourItemRv;

        private LinearLayout findSevenItemLl;
        private TextView findSevenTitleTv;
        private ImageView findSevenImageImg;
        private TextView findSevenNickNameTv;

        public FindViewHolder(View itemView) {
            super(itemView);

            findThirdItemLl = (LinearLayout) itemView.findViewById(R.id.find_three_item_ll);

            findThirdTitleTv = (TextView) itemView.findViewById(R.id.find_third_title_tv);
            findThirdImagesOneImg = (ImageView) itemView.findViewById(R.id.find_third_images_one_img);
            findThirdImagesTwoImg = (ImageView) itemView.findViewById(R.id.find_third_images_two_img);
            findThirdImagesThirdImg = (ImageView) itemView.findViewById(R.id.find_third_images_third_img);
            findThirdNickNameTv = (TextView) itemView.findViewById(R.id.find_third_nick_name_tv);
            findThirdViewCountTv = (TextView) itemView.findViewById(R.id.find_third_view_count_tv);
            findThirdCommentCountTv = (TextView) itemView.findViewById(R.id.find_third_comment_count_tv);

            findTwoItemRv = (RelativeLayout) itemView.findViewById(R.id.find_two_item_rv);
            findTwoImage = (ImageView) itemView.findViewById(R.id.find_two_image);
            findTwoTitleTv = (TextView) itemView.findViewById(R.id.find_two_title_tv);
            findTwoNickNameTv = (TextView) itemView.findViewById(R.id.find_two_nick_name_tv);
            findTwoViewCountTv = (TextView) itemView.findViewById(R.id.find_two_view_count_tv);
            findTwoCommentCountTv = (TextView) itemView.findViewById(R.id.find_two_comment_count_tv);

            findFourItemRv = (RelativeLayout) itemView.findViewById(R.id.find_four_item_rv);
            findFourTitleTv = (TextView) itemView.findViewById(R.id.find_four_title_tv);
            findFourImagesOneImg = (ImageView) itemView.findViewById(R.id.find_four_images_one_img);
            findFourImagesTwoImg = (ImageView) itemView.findViewById(R.id.find_four_images_two_img);
            findFourImagesThreeImg = (ImageView) itemView.findViewById(R.id.find_four_images_three_img);
            findFourNickNameTv = (TextView) itemView.findViewById(R.id.find_four_nick_name_tv);
            findFourViewCountTv = (TextView) itemView.findViewById(R.id.find_four_view_count_tv);
            findFourCommentCountTv = (TextView) itemView.findViewById(R.id.find_four_comment_count_tv);


            findHeaderTop = (ImageView) itemView.findViewById(R.id.find_header_top);
            findHeaderNew = (ImageView) itemView.findViewById(R.id.find_header_new);
            findHeaderStore = (ImageView) itemView.findViewById(R.id.find_header_store);
            findHeaderHouse = (ImageView) itemView.findViewById(R.id.find_header_house);


            findSevenItemLl = (LinearLayout) itemView.findViewById(R.id.find_seven_item_ll);
            findSevenTitleTv = (TextView) itemView.findViewById(R.id.find_seven_title_tv);
            findSevenImageImg = (ImageView) itemView.findViewById(R.id.find_seven_image_img);
            findSevenNickNameTv = (TextView) itemView.findViewById(R.id.find_seven_nick_name_tv);


        }
    }

    @Override
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver observer) {
        if (observer != null){
            super.unregisterAdapterDataObserver(observer);
        }
    }


}
