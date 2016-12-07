package lanou.maoyanmovie.movie.wait;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.bean.MovieWaitWishBean;
import lanou.maoyanmovie.city.CommonVH;

/**
 * Created by 麦建东 on 16/12/6.
 */
public class WishAdapter extends RecyclerView.Adapter<CommonVH> {
    private MovieWaitWishBean mBean;
    private OnMovieWaitWishClickListener mWishClickListener;

    public void setWishClickListener(OnMovieWaitWishClickListener wishClickListener) {
        mWishClickListener = wishClickListener;
    }

    public void setBean(MovieWaitWishBean bean) {
        mBean = bean;
    }

    @Override
    public CommonVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonVH.getViewHolder(parent, R.layout.fragment_movie_wait_wish_item);
    }

    @Override
    public void onBindViewHolder(CommonVH holder, int position) {
        if (mBean.getData().getComing().get(position).getComingTitle().contains("2017年")) {
            String str = mBean.getData().getComing().get(position).getComingTitle().substring(2, 10);
            holder.setText(R.id.fragment_movie_wait_wish_date_tv, str);
        } else {
            String str = mBean.getData().getComing().get(position).getComingTitle().substring(0, 6);
            holder.setText(R.id.fragment_movie_wait_wish_date_tv, str);
        }
        String imageUrl = mBean.getData().getComing().get(position).getImg().replace("/w.h/",
                "/165.220/");
        holder.setImage(R.id.fragment_movie_wait_wish_iv, imageUrl);
        if (mBean.getData().getComing().get(position).getNm().length() > 5) {
            String name = mBean.getData().getComing().get(position).getNm().substring(0, 5) + "...";
            holder.setText(R.id.fragment_movie_wait_wish_name_tv, name);
        } else {
            holder.setText(R.id.fragment_movie_wait_wish_name_tv, mBean.getData().getComing().get
                    (position).getNm());
        }
        holder.setText(R.id.fragment_movie_wait_wish_count_tv, String.valueOf(mBean.getData().getComing().get
                (position).getWish() + "人想看"));
        holder.setItemClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWishClickListener.onItemClick(mBean.getData().getComing().get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBean == null ? 0 : mBean.getData().getComing().size();
    }
}
