package lanou.maoyanmovie.find;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.bean.FindTodayBean;
import lanou.maoyanmovie.bean.FindTopBean;

/**
 * Created by 王野 on 16/11/22.
 */

public class FindRvAdapter extends RecyclerView.Adapter<FindRvAdapter.FindViewHolder> {
    private FindTopBean mFindTopBean;
    private FindTodayBean mFindTodayBean;
    private Context mContext;
private Fragment mFragment;
    public FindRvAdapter(Context context, FindFragment findFragment) {
        mContext = context;
        //TODO 传入当前的Fragment,将Glide与当前页绑定在一起
        mFragment = findFragment;

    }

    public void setFindTodayBean(FindTodayBean findTodayBean) {
        mFindTodayBean = findTodayBean;
        notifyDataSetChanged();
    }

    public void setFindTopBean(FindTopBean findTopBean) {
        mFindTopBean = findTopBean;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        //TODO 需要处理type = 4的情况
        return mFindTodayBean.getData().getFeeds().get(position).getStyle() == 2 ? 2 : 3;
    }

    @Override
    public FindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("FindRvAdapter", "viewType:" + viewType);
        //TODO ViewHolder 一定不能变成全局变量
        FindViewHolder mViewHolder = null;
        switch (viewType) {
            case 3:
                View view = LayoutInflater.from(mContext).inflate(R.layout.item_find_thire, parent, false);
                mViewHolder = new FindViewHolder(view);
                break;
            case 2:
                View view1 = LayoutInflater.from(mContext).inflate(R.layout.item_find_two, parent, false);
                mViewHolder = new FindViewHolder(view1);
                break;
            default:
                break;
        }
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(FindViewHolder holder, int position) {
        Log.d("FindRvAdapter", "mFindTodayBean.getData().getFeeds().get(position).getStyle():" + mFindTodayBean.getData().getFeeds().get(position).getStyle());
        switch (mFindTodayBean.getData().getFeeds().get(position).getStyle()){
            case 2:
                holder.findTwoCommentCountTv.setText(String.valueOf(mFindTodayBean.getData().getFeeds().get(position).getCommentCount()));
                holder.findTwoNickNameTv.setText(mFindTodayBean.getData().getFeeds().get(position).getUser().getNickName());
                holder.findTwoTitleTv.setText(mFindTodayBean.getData().getFeeds().get(position).getTitle());
                holder.findTwoViewCountTv.setText(String.valueOf(mFindTodayBean.getData().getFeeds().get(position).getViewCount()));

                Glide.with(mFragment).load(mFindTodayBean.getData().getFeeds().get(position).getImages().get(0).getUrl()).into(holder.findTwoImage);
                break;
            case 3:
                holder.findThirdCommentCountTv.setText(String.valueOf(mFindTodayBean.getData().getFeeds().get(position).getCommentCount()));
                holder.findThirdNickNameTv.setText(mFindTodayBean.getData().getFeeds().get(position).getUser().getNickName());
                holder.findThirdTitleTv.setText(mFindTodayBean.getData().getFeeds().get(position).getTitle());
                holder.findThirdViewCountTv.setText(String.valueOf(mFindTodayBean.getData().getFeeds().get(position).getViewCount()));
                Glide.with(mFragment).load(mFindTodayBean.getData().getFeeds().get(position).getImages().get(0).getUrl()).into(holder.findThirdImagesOneImg);
                Glide.with(mFragment).load(mFindTodayBean.getData().getFeeds().get(position).getImages().get(1).getUrl()).into(holder.findThirdImagesTwoImg);
                Log.d("FindRvAdapter", mFindTodayBean.getData().getFeeds().get(position).getImages().get(2).getUrl());
                Glide.with(mFragment).load(mFindTodayBean.getData().getFeeds().get(position).getImages().get(2).getUrl()).into(holder.findThirdImagesThirdImg);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mFindTodayBean.getData().getFeeds().size();
    }

    //TODO 改成通用的ViewHolder,构造方法不需要传入Context
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

        public FindViewHolder(View itemView) {
            super(itemView);

            findThirdTitleTv = (TextView) itemView.findViewById(R.id.find_third_title_tv);
            findThirdImagesOneImg = (ImageView) itemView.findViewById(R.id.find_third_images_one_img);
            findThirdImagesTwoImg = (ImageView) itemView.findViewById(R.id.find_third_images_two_img);
            findThirdImagesThirdImg = (ImageView) itemView.findViewById(R.id.find_third_images_third_img);
            findThirdNickNameTv = (TextView) itemView.findViewById(R.id.find_third_nick_name_tv);
            findThirdViewCountTv = (TextView) itemView.findViewById(R.id.find_third_view_count_tv);
            findThirdCommentCountTv = (TextView) itemView.findViewById(R.id.find_third_comment_count_tv);

            findTwoImage = (ImageView) itemView.findViewById(R.id.find_two_image);
            findTwoTitleTv = (TextView) itemView.findViewById(R.id.find_two_title_tv);
            findTwoNickNameTv = (TextView) itemView.findViewById(R.id.find_two_nick_name_tv);
            findTwoViewCountTv = (TextView) itemView.findViewById(R.id.find_two_view_count_tv);
            findTwoCommentCountTv = (TextView) itemView.findViewById(R.id.find_two_comment_count_tv);

        }
    }
}
