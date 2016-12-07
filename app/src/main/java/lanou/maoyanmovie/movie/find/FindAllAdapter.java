package lanou.maoyanmovie.movie.find;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.bean.MovieFindAllPrizeBean;
import lanou.maoyanmovie.tools.CommonViewHolder;

/**
 * Created by wangYe on 16/12/2.
 */
public class FindAllAdapter extends RecyclerView.Adapter<CommonViewHolder>{
    private MovieFindAllPrizeBean mMovieFindAllPrizeBean;

    public void setMovieFindAllPrizeBean(MovieFindAllPrizeBean movieFindAllPrizeBean) {
        mMovieFindAllPrizeBean = movieFindAllPrizeBean;
        notifyDataSetChanged();
    }
    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonViewHolder.getViewHolder(parent, R.layout.movie_find_all_rv);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        holder.setText(R.id.movie_find_all_festival_name, mMovieFindAllPrizeBean.getData().get(position).getFestivalName());
        holder.setText(R.id.movie_find_all_date, mMovieFindAllPrizeBean.getData().get(position).getHeldDate().substring(5));
        holder.setText(R.id.movie_find_all_prize_name, mMovieFindAllPrizeBean.getData().get(position).getPrizeName());
        holder.setText(R.id.movie_find_all_movie_name, mMovieFindAllPrizeBean.getData().get(position).getMovieName());
        holder.setImage(R.id.movie_find_all_img, mMovieFindAllPrizeBean.getData().get(position).getImg().replace("w.h","165.220"));
    }

    @Override
    public int getItemCount() {
        return mMovieFindAllPrizeBean.getData() == null ? 0 : mMovieFindAllPrizeBean.getData().size();
    }
}
