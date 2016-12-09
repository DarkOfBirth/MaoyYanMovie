package lanou.maoyanmovie.movie.hot;

import android.os.CountDownTimer;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.bean.MovieHotBannerBean;
import lanou.maoyanmovie.bean.MovieHotListBean;
import lanou.maoyanmovie.tools.CommonVH;

/**
 * Created by 麦建东 on 16/11/24.
 */
public class MovieHotListAdapter extends RecyclerView.Adapter<CommonVH> {

    private MovieHotBannerBean mHotBannerBean;
//    private SlideShowViewHolder mSlideShowViewHolder;
    private boolean isInit = true;
    private OnMovieIdClickListener mOnMovieIdClickListener;
    private MovieHotListBean mMovieHotListBean;
    private ViewPager mHotVp;

    public void setMovieHotListBean(MovieHotListBean movieHotListBean) {
        mMovieHotListBean = movieHotListBean;
        notifyDataSetChanged();
    }

    public void addMovieHotListBean(MovieHotListBean movieHotListBean) {
        this.mMovieHotListBean.getData().addData(movieHotListBean.getData().getMovies());
        notifyDataSetChanged();
    }

    public void setHotBannerBean(MovieHotBannerBean hotBannerBean) {
        mHotBannerBean = hotBannerBean;
        notifyDataSetChanged();
    }

    public void setOnMovieIdClickListener(OnMovieIdClickListener onMovieIdClickListener) {
        mOnMovieIdClickListener = onMovieIdClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? 2 : mMovieHotListBean.getData().getMovies().get(position - 1).getPreSale();
    }

//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        switch (viewType) {
//            case 0://在售
//                View saleView = LayoutInflater.from(parent.getContext()).inflate(R.layout
//                        .fragment_movie_hot_list_sale, parent, false);
//                MovieHotListSaleViewHolder saleViewHolder = new MovieHotListSaleViewHolder(saleView);
//                return saleViewHolder;
//            case 1://预售
//                View waitView = LayoutInflater.from(parent.getContext()).inflate(R.layout
//                        .fragment_movie_hot_list_wait, parent, false);
//                MovieHotListWaitViewHolder waitViewHolder = new MovieHotListWaitViewHolder(waitView);
//                return waitViewHolder;
//            case 2://轮播图
//                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_show, parent, false);
//                mSlideShowViewHolder = new SlideShowViewHolder(view);
//                return mSlideShowViewHolder;
//        }
//        return null;
//    }

    @Override
    public CommonVH onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0://在售
                return CommonVH.getViewHolder(parent, R.layout.fragment_movie_hot_list_sale);
            case 1://预售
                return CommonVH.getViewHolder(parent, R.layout.fragment_movie_hot_list_wait);
            case 2://轮播图
                return CommonVH.getViewHolder(parent, R.layout.slide_show);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(CommonVH holder, int position) {
        int type = getItemViewType(position);
        String ver;
        switch (type) {
            case 0://在售
                position -= 1;
                holder.setImage(R.id.main_movie_hot_list_sale_pic, mMovieHotListBean.getData()
                        .getMovies().get(position).getImg().replace("/w.h/", "/165.220/"));
                holder.setText(R.id.main_movie_hot_list_sale_nm_tv, mMovieHotListBean.getData()
                        .getMovies().get(position).getNm());
                ver = mMovieHotListBean.getData().getMovies().get(position).getVer();
                if (ver.contains("3D") && ver.contains("IMAX")) {
                    holder.setImage(R.id.main_movie_hot_list_sale_ver_iv, R.mipmap
                            .main_movie_hot_3d_imax);
                } else if (ver.contains("3D") && !ver.contains("IMAX")) {
                    holder.setImage(R.id.main_movie_hot_list_sale_ver_iv, R.mipmap
                            .main_movie_hot_3d);
                }
                holder.setText(R.id.main_movie_hot_list_sale_sc_tv, String.valueOf
                        (mMovieHotListBean.getData().getMovies().get(position).getSc()));
                holder.setText(R.id.main_movie_hot_list_sale_scm_tv, mMovieHotListBean.getData()
                        .getMovies().get(position).getScm());
                holder.setText(R.id.main_movie_hot_list_sale_info_tv, mMovieHotListBean.getData()
                        .getMovies().get(position).getShowInfo());
                holder.setItemClick(new MyClickListener(position) {
                    @Override
                    public void onClick(View v) {
                        mOnMovieIdClickListener.getId(mMovieHotListBean.getData().getMovies().get(pos).getId());
                    }
                });
                break;
            case 1://预售
                position -= 1;
                holder.setImage(R.id.main_movie_hot_list_pic, mMovieHotListBean.getData()
                        .getMovies().get(position).getImg().replace("/w.h/", "/165.220/"));
                holder.setText(R.id.main_movie_hot_list_nm_tv, mMovieHotListBean.getData()
                        .getMovies().get(position).getNm());
                ver = mMovieHotListBean.getData().getMovies().get(position).getVer();
                if (ver.contains("3D") && ver.contains("IMAX")) {
                    holder.setImage(R.id.main_movie_hot_list_ver_iv, R.mipmap
                            .main_movie_hot_3d_imax);
                } else if (ver.contains("3D") && !ver.contains("IMAX")) {
                    holder.setImage(R.id.main_movie_hot_list_ver_iv, R.mipmap
                            .main_movie_hot_3d);
                }
                holder.setText(R.id.main_movie_hot_list_wish_tv, String.valueOf(mMovieHotListBean
                        .getData().getMovies().get(position).getWish()));
                holder.setText(R.id.main_movie_hot_list_scm_tv, mMovieHotListBean.getData()
                        .getMovies().get(position).getScm());
                holder.setText(R.id.main_movie_hot_list_info_tv, mMovieHotListBean.getData()
                        .getMovies().get(position).getShowInfo());
                holder.setItemClick(new MyClickListener(position) {
                    @Override
                    public void onClick(View v) {
                        mOnMovieIdClickListener.getId(mMovieHotListBean.getData().getMovies().get(pos).getId());
                    }
                });
                break;
            case 2://轮播图
                SlideShowAdapter slideShowAdapter = new SlideShowAdapter();
                if (mHotBannerBean != null) {
                    int slideShowSize = mHotBannerBean.getData().size();
                    ArrayList<String> imgUrlList = new ArrayList<>();
                    String imgUrl;
                    for (int i = 0; i < slideShowSize; i++) {
                        imgUrl = mHotBannerBean.getData().get(i).getImgUrl();
                        imgUrlList.add(imgUrl);
                    }
                    mHotVp = (ViewPager) holder.getItemView().findViewById(R.id
                            .fragment_movie_hot_vp);
                    mHotVp.setAdapter(slideShowAdapter);
                    slideShowAdapter.setStringList(imgUrlList);

                    if (isInit) {
                        MyCounter myCounter = new MyCounter(Long.MAX_VALUE, 3000);
                        myCounter.start();
                        isInit = false;
                    }
                }

                break;
        }
    }

//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder,  int position) {
//        int type = getItemViewType(position);
//        String ver;
//        switch (type) {
//            case 0://在售
//                position -= 1;
//                MovieHotListSaleViewHolder saleViewHolder = (MovieHotListSaleViewHolder) holder;
//                Picasso.with(MyApplication.getmContext()).load(mMovieHotListBean.getData().getMovies().get(position).getImg().replace("/w.h/", "/165.220/")).fit()
//                        .into(saleViewHolder.mPicIv);
//                saleViewHolder.mNmTv.setText(mMovieHotListBean.getData().getMovies().get(position).getNm());
//                ver = mMovieHotListBean.getData().getMovies().get(position).getVer();
//                if (ver.contains("3D") && ver.contains("IMAX")) {
//                    saleViewHolder.mVerIv.setImageResource(R.mipmap.main_movie_hot_3d_imax);
//                } else if (ver.contains("3D") && !ver.contains("IMAX")) {
//                    saleViewHolder.mVerIv.setImageResource(R.mipmap.main_movie_hot_3d);
//                }
//                saleViewHolder.mScTv.setText(String.valueOf(mMovieHotListBean.getData().getMovies().get(position).getSc()));
//                saleViewHolder.mScmTv.setText(mMovieHotListBean.getData().getMovies().get(position).getScm());
//                saleViewHolder.mInfoTv.setText(mMovieHotListBean.getData().getMovies().get(position).getShowInfo());
//                saleViewHolder.mListLl.setOnClickListener(new MyClickListener(position) {
//                    @Override
//                    public void onClick(View v) {
//                        mOnMovieIdClickListener.getId(mMovieHotListBean.getData().getMovies().get(pos).getId());
//                    }
//                });
//                break;
//            case 1://预售
//                position -= 1;
//                MovieHotListWaitViewHolder waitViewHolder = (MovieHotListWaitViewHolder) holder;
//                Picasso.with(MyApplication.getmContext()).load(mMovieHotListBean.getData().getMovies().get(position).getImg().replace("/w.h/", "/165.220/")).fit()
//                        .into(waitViewHolder.mPicIv);
//                waitViewHolder.mNmTv.setText(mMovieHotListBean.getData().getMovies().get(position).getNm());
//                ver = mMovieHotListBean.getData().getMovies().get(position).getVer();
//                if (ver.contains("3D") && ver.contains("IMAX")) {
//                    waitViewHolder.mVerIv.setImageResource(R.mipmap.main_movie_hot_3d_imax);
//                } else if (ver.contains("3D") && !ver.contains("IMAX")) {
//                    waitViewHolder.mVerIv.setImageResource(R.mipmap.main_movie_hot_3d);
//                }
//                waitViewHolder.mWishTv.setText(String.valueOf(mMovieHotListBean.getData().getMovies().get(position).getWish()));
//                waitViewHolder.mScmTv.setText(mMovieHotListBean.getData().getMovies().get(position).getScm());
//                waitViewHolder.mInfoTv.setText(mMovieHotListBean.getData().getMovies().get(position).getShowInfo());
//                waitViewHolder.mListLl.setOnClickListener(new MyClickListener(position) {
//                    @Override
//                    public void onClick(View v) {
//                        mOnMovieIdClickListener.getId(mMovieHotListBean.getData().getMovies().get(pos).getId());
//                    }
//                });
//
//                break;
//            case 2://轮播图
//                mSlideShowViewHolder = (SlideShowViewHolder) holder;
//                SlideShowAdapter slideShowAdapter = new SlideShowAdapter();
//                if (mHotBannerBean != null) {
//                    int slideShowSize = mHotBannerBean.getData().size();
//                    ArrayList<String> imgUrlList = new ArrayList<>();
//                    String imgUrl;
//                    for (int i = 0; i < slideShowSize; i++) {
//                        imgUrl = mHotBannerBean.getData().get(i).getImgUrl();
//                        imgUrlList.add(imgUrl);
//                    }
//
//                    mSlideShowViewHolder.hotVp.setAdapter(slideShowAdapter);
//                    slideShowAdapter.setStringList(imgUrlList);
//
//                    if (isInit) {
//                        MyCounter myCounter = new MyCounter(Long.MAX_VALUE, 3000);
//                        myCounter.start();
//                        isInit = false;
//                    }
//                }
//
//                break;
//        }
//    }

    @Override
    public int getItemCount() {
        return mMovieHotListBean == null ? 0 : mMovieHotListBean.getData().getMovies().size();
    }

    //构造方法实现position的传值
    abstract class MyClickListener implements View.OnClickListener{
        protected int pos;
        public MyClickListener(int pos) {
            this.pos = pos;
        }
    }

//    // 预售
//    public class MovieHotListWaitViewHolder extends RecyclerView.ViewHolder {
//        private ImageView mPicIv;
//        private TextView mNmTv;
//        private ImageView mVerIv;
//        private TextView mWishTv;
//        private TextView mScmTv;
//        private TextView mInfoTv;
//        private LinearLayout mListLl;
//        public MovieHotListWaitViewHolder(View itemView) {
//            super(itemView);
//            mPicIv = (ImageView) itemView.findViewById(R.id.main_movie_hot_list_pic);
//            mNmTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_nm_tv);
//            mVerIv = (ImageView) itemView.findViewById(R.id.main_movie_hot_list_ver_iv);
//            mWishTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_wish_tv);
//            mScmTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_scm_tv);
//            mInfoTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_info_tv);
//            mListLl = (LinearLayout) itemView.findViewById(R.id.main_movie_hot_list_ll);
//        }
//    }
//
//    //在售
//    public class MovieHotListSaleViewHolder extends RecyclerView.ViewHolder {
//        private ImageView mPicIv;
//        private TextView mNmTv;
//        private ImageView mVerIv;
//        private TextView mScTv;
//        private TextView mScmTv;
//        private TextView mInfoTv;
//        private LinearLayout mListLl;
//
//        public MovieHotListSaleViewHolder(View itemView) {
//            super(itemView);
//            mPicIv = (ImageView) itemView.findViewById(R.id.main_movie_hot_list_sale_pic);
//            mNmTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_sale_nm_tv);
//            mVerIv = (ImageView) itemView.findViewById(R.id.main_movie_hot_list_sale_ver_iv);
//            mScTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_sale_sc_tv);
//            mScmTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_sale_scm_tv);
//            mInfoTv = (TextView) itemView.findViewById(R.id.main_movie_hot_list_sale_info_tv);
//            mListLl = (LinearLayout) itemView.findViewById(R.id.main_movie_hot_list_ll);
//        }
//    }
//
//    //轮播图
//    public class SlideShowViewHolder extends RecyclerView.ViewHolder {
//        private ViewPager hotVp;
//        public SlideShowViewHolder(View itemView) {
//            super(itemView);
//            hotVp = (ViewPager) itemView.findViewById(R.id.fragment_movie_hot_vp);
//        }
//    }

    //计时器
    private class MyCounter extends CountDownTimer {
        public MyCounter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long time) {

            if (mHotVp != null) {
                int num = mHotVp.getCurrentItem();
                mHotVp.setCurrentItem(num + 1);
            }
        }

        @Override
        public void onFinish() {

        }
    }

}
