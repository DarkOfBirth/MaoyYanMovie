package lanou.maoyanmovie.movie.find;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import lanou.maoyanmovie.bean.MovieFindAllPrizeBodyBean;
import lanou.maoyanmovie.tools.CommonViewHolder;

/**
 * Created by wangYe on 16/12/5.
 */
public class FindItemBodyAdapter extends RecyclerView.Adapter<CommonViewHolder>{
    private MovieFindAllPrizeBodyBean mMovieFindAllPrizeBodyBean;

    public void setMovieFindAllPrizeBodyBean(MovieFindAllPrizeBodyBean movieFindAllPrizeBodyBean) {
        mMovieFindAllPrizeBodyBean = movieFindAllPrizeBodyBean;

    }
    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
