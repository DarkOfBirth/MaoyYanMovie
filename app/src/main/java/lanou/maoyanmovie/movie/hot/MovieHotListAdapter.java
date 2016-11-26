package lanou.maoyanmovie.movie.hot;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import lanou.maoyanmovie.MainActivity;
import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.MyApplication;
import lanou.maoyanmovie.bean.MovieHotBannerBean;
import lanou.maoyanmovie.bean.MovieHotListBean;

/**
 * Created by 麦建东 on 16/11/24.
 */
public class MovieHotListAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private MovieHotListBean mMovieHotListBean;
    private int mMovieId;
    private MovieHotBannerBean mHotBannerBean;
    private SlideShowViewHolder mSlideShowViewHolder;
    private boolean isInit = true;

    public MovieHotListAdapter(Context context) {
        mContext = context;
    }

    public void setMovieHotListBean(MovieHotListBean movieHotListBean) {
        mMovieHotListBean = movieHotListBean;
        notifyDataSetChanged();
    }

    public void setHotBannerBean(MovieHotBannerBean hotBannerBean) {
        mHotBannerBean = hotBannerBean;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? 2 : mMovieHotListBean.getData().getHot().get(position - 1)
                .getPreSale();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0://在售
                View saleView = LayoutInflater.from(parent.getContext()).inflate(R.layout
                        .fragment_movie_hot_list_sale, parent, false);
                MovieHotListSaleViewHolder saleViewHolder = new MovieHotListSaleViewHolder(saleView);
                return saleViewHolder;
            case 1://预售
                View waitView = LayoutInflater.from(parent.getContext()).inflate(R.layout
                        .fragment_movie_hot_list_wait, parent, false);
                MovieHotListWaitViewHolder waitViewHolder = new MovieHotListWaitViewHolder(waitView);
                return waitViewHolder;
            case 2://轮播图
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_show, parent, false);
                mSlideShowViewHolder = new SlideShowViewHolder(view);
                return mSlideShowViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        String ver;
        switch (type) {
            case 0://在售
                position -= 1;
                MovieHotListSaleViewHolder saleViewHolder = (MovieHotListSaleViewHolder) holder;
                Picasso.with(MyApplication.getmContext()).load(mMovieHotListBean.getData().getHot
                        ().get(position).getImg().replace("/w.h/","/165.220/")).fit()
                        .into(saleViewHolder.mPicIv);
                saleViewHolder.mNmTv.setText(mMovieHotListBean.getData().getHot
                        ().get(position).getNm());
                ver = mMovieHotListBean.getData().getHot().get(position).getVer();
                if (ver.contains("3D") && ver.contains("IMAX")) {
                    saleViewHolder.mVerIv.setImageResource(R.mipmap.main_movie_hot_3d_imax);
                } else if (ver.contains("3D") && !ver.contains("IMAX")) {
                    saleViewHolder.mVerIv.setImageResource(R.mipmap.main_movie_hot_3d);
                }
                saleViewHolder.mMkTv.setText(String.valueOf(mMovieHotListBean.getData().getHot
                        ().get(position).getMk()));
                if (String.valueOf(mMovieHotListBean.getData().getHot
                        ().get(position).getProScore()).equals("0.0")) {
                    saleViewHolder.mProLl.setVisibility(View.INVISIBLE);
                } else {
                    saleViewHolder.mProTv.setText(String.valueOf(mMovieHotListBean.getData().getHot
                            ().get(position).getProScore()));
                }
                saleViewHolder.mScmTv.setText(mMovieHotListBean.getData().getHot
                        ().get(position).getScm());
                saleViewHolder.mInfoTv.setText(mMovieHotListBean.getData().getHot
                        ().get(position).getShowInfo());
                if (position == 0) {
                    saleViewHolder.mHeadLineLl.setVisibility(View.VISIBLE);
                    saleViewHolder.mSpecialismTv.setText(mMovieHotListBean.getData().getHot
                            ().get(position).getNewsHeadlines().get(0).getTitle());
                    saleViewHolder.mInformationTv.setText(mMovieHotListBean.getData().getHot
                            ().get(position).getNewsHeadlines().get(1).getTitle());
                } else {
                    saleViewHolder.mHeadLineLl.setVisibility(View.GONE);
                }
                mMovieId = mMovieHotListBean.getData().getMovieIds().get(position);
                saleViewHolder.mListLl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity activity = (MainActivity) mContext;
                        HotListDetailFragment hotListDetailFragment = new HotListDetailFragment();
                        activity.jumpFragment(hotListDetailFragment);
                        Bundle bundle = new Bundle();
                        bundle.putInt("movieId", mMovieId);
                        hotListDetailFragment.setArguments(bundle);
                    }
                });
                break;
            case 1://预售
                position -= 1;
                MovieHotListWaitViewHolder waitViewHolder = (MovieHotListWaitViewHolder) holder;
                Picasso.with(MyApplication.getmContext()).load(mMovieHotListBean.getData().getHot
                        ().get(position).getImg().replace("/w.h/","/165.220/")).fit()
                        .into(waitViewHolder.mPicIv);
                waitViewHolder.mNmTv.setText(mMovieHotListBean.getData().getHot
                        ().get(position).getNm());
                ver = mMovieHotListBean.getData().getHot().get(position).getVer();
                if (ver.contains("3D") && ver.contains("IMAX")) {
                    waitViewHolder.mVerIv.setImageResource(R.mipmap.main_movie_hot_3d_imax);
                } else if (ver.contains("3D") && !ver.contains("IMAX")) {
                    waitViewHolder.mVerIv.setImageResource(R.mipmap.main_movie_hot_3d);
                }
                waitViewHolder.mWishTv.setText(String.valueOf(mMovieHotListBean.getData().getHot
                        ().get(position).getWish()));
                waitViewHolder.mScmTv.setText(mMovieHotListBean.getData().getHot
                        ().get(position).getScm());
                waitViewHolder.mInfoTv.setText(mMovieHotListBean.getData().getHot
                        ().get(position).getShowInfo());
                if (position == 0) {
                    waitViewHolder.mHeadLineLl.setVisibility(View.VISIBLE);
                    waitViewHolder.mSpecialismTv.setText(mMovieHotListBean.getData().getHot
                            ().get(position).getNewsHeadlines().get(0).getTitle());
                    waitViewHolder.mInformationTv.setText(mMovieHotListBean.getData().getHot
                            ().get(position).getNewsHeadlines().get(1).getTitle());
                } else {
                    waitViewHolder.mHeadLineLl.setVisibility(View.GONE);
                }
                mMovieId = mMovieHotListBean.getData().getMovieIds().get(position);
                waitViewHolder.mListLl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity activity = (MainActivity)mContext ;
                        HotListDetailFragment hotListDetailFragment = new HotListDetailFragment();
                        activity.jumpFragment(hotListDetailFragment);
                        Bundle bundle = new Bundle();
                        bundle.putInt("movieId", mMovieId);
                        hotListDetailFragment.setArguments(bundle);
                    }
                });
                break;
            case 2://轮播图
                mSlideShowViewHolder = (SlideShowViewHolder) holder;
                SlideShowAdapter slideShowAdapter = new SlideShowAdapter(mContext);

                int slideShowSize = mHotBannerBean.getData().size();
                ArrayList<String> imgUrlList = new ArrayList<>();
                String imgUrl;
                for (int i = 0; i < slideShowSize; i++) {
                    imgUrl = mHotBannerBean.getData().get(i).getBigImgTypeUrl();
                    imgUrlList.add(imgUrl);
                }

                mSlideShowViewHolder.hotVp.setAdapter(slideShowAdapter);
                slideShowAdapter.setStringList(imgUrlList);

                if (isInit) {
                    MyCounter myCounter = new MyCounter(Long.MAX_VALUE, 3000);
                    myCounter.start();
                    isInit = false;
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mMovieHotListBean.getData().getHot() == null ? 0 : mMovieHotListBean.getData()
                .getHot().size();
    }

    // 预售
    public class MovieHotListWaitViewHolder extends RecyclerView.ViewHolder {
        private ImageView mPicIv;
        private TextView mNmTv;
        private ImageView mVerIv;
        private TextView mWishTv;
        private TextView mScmTv;
        private TextView mInfoTv;
        private TextView mSpecialismTv;
        private TextView mInformationTv;
        private LinearLayout mHeadLineLl;
        private LinearLayout mListLl;
        public MovieHotListWaitViewHolder(View itemView) {
            super(itemView);
            mPicIv = (ImageView) itemView.findViewById(R.id.main_movie_hot_list_pic);
            mNmTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_nm_tv);
            mVerIv = (ImageView) itemView.findViewById(R.id.main_movie_hot_list_ver_iv);
            mWishTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_wish_tv);
            mScmTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_scm_tv);
            mInfoTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_info_tv);
            mSpecialismTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_specialism_tv);
            mInformationTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_information_tv);
            mHeadLineLl = (LinearLayout) itemView.findViewById(R.id.main_movie_hot_list_wait_headline);
            mListLl = (LinearLayout) itemView.findViewById(R.id.main_movie_hot_list_ll);
        }
    }

    //在售
    public class MovieHotListSaleViewHolder extends RecyclerView.ViewHolder {
        private ImageView mPicIv;
        private TextView mNmTv;
        private ImageView mVerIv;
        private TextView mMkTv;
        private TextView mProTv;
        private TextView mScmTv;
        private TextView mInfoTv;
        private TextView mSpecialismTv;
        private TextView mInformationTv;
        private LinearLayout mHeadLineLl;
        private LinearLayout mListLl;
        private LinearLayout mProLl;

        public MovieHotListSaleViewHolder(View itemView) {
            super(itemView);
            mPicIv = (ImageView) itemView.findViewById(R.id.main_movie_hot_list_sale_pic);
            mNmTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_sale_nm_tv);
            mVerIv = (ImageView) itemView.findViewById(R.id.main_movie_hot_list_sale_ver_iv);
            mMkTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_sale_mk_tv);
            mProLl = (LinearLayout) itemView.findViewById(R.id.main_movie_hot_list_sale_pro_ll);
            mProTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_sale_pro_tv);
            mScmTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_sale_scm_tv);
            mInfoTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_sale_info_tv);
            mSpecialismTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_sale_specialism_tv);
            mInformationTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_sale_information_tv);
            mHeadLineLl = (LinearLayout) itemView.findViewById(R.id.main_movie_hot_list_sale_headline);
            mListLl = (LinearLayout) itemView.findViewById(R.id.main_movie_hot_list_ll);
        }
    }

    //轮播图
    public class SlideShowViewHolder extends RecyclerView.ViewHolder {
        private ViewPager hotVp;
        public SlideShowViewHolder(View itemView) {
            super(itemView);
            hotVp = (ViewPager) itemView.findViewById(R.id.fragment_movie_hot_vp);
        }
    }

    //计时器
    private class MyCounter extends CountDownTimer {
        public MyCounter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long time) {
            if (mSlideShowViewHolder.hotVp != null) {
                int num = mSlideShowViewHolder.hotVp.getCurrentItem();
                mSlideShowViewHolder.hotVp.setCurrentItem(num + 1);
            }
        }

        @Override
        public void onFinish() {

        }
    }

    public ArrayList<Integer> getMovieId() {
        ArrayList<Integer> movieId = new ArrayList<>();
        for (int i = 0; i < mMovieHotListBean.getData().getMovieIds().size(); i++) {
            movieId.add(mMovieHotListBean.getData().getMovieIds().get(i));
        }
        return movieId;
    }
}
