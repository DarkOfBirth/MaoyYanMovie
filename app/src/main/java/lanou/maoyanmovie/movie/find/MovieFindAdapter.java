package lanou.maoyanmovie.movie.find;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.MyApplication;
import lanou.maoyanmovie.bean.MovieFindAllPrizeBean;
import lanou.maoyanmovie.bean.MovieFindCenterBean;
import lanou.maoyanmovie.bean.MovieFindTypeOtherBean;
import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;
import lanou.maoyanmovie.tools.CommonViewHolder;

/**
 * Created by wangYe on 16/12/1.
 */

public class MovieFindAdapter extends RecyclerView.Adapter<CommonViewHolder> {
    private MovieFindTypeOtherBean mMovieFindTypeOtherBean;
    private MovieFindCenterBean mMovieFindCenterBean;
    private RecyclerView mRv;

    public void setMovieFindCenterBean(MovieFindCenterBean movieFindCenterBean) {
        mMovieFindCenterBean = movieFindCenterBean;
        notifyDataSetChanged();
    }

    public void setMovieFindTypeOtherBean(MovieFindTypeOtherBean movieFindTypeOtherBean) {
        mMovieFindTypeOtherBean = movieFindTypeOtherBean;
        notifyDataSetChanged();
    }

    private int[] mItemLayouts = {R.layout.movie_find_zero, R.layout.movie_find_one, R.layout.movie_find_two,
            R.layout.movie_find_three, R.layout.movie_find_four};

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommonViewHolder.getViewHolder(parent, mItemLayouts[viewType]);
    }

    @Override
    public void onBindViewHolder(final CommonViewHolder holder, int position) {
        int pos = getItemViewType(position);
        switch (pos) {
            case 0:
                if (mMovieFindTypeOtherBean != null) {
                    LinearLayout llType = holder.getView(R.id.movie_find_type);
                    LinearLayout llCenter = holder.getView(R.id.movie_find_where);
                    LinearLayout llAll = holder.getView(R.id.movie_find_when);
                    for (int j = 0; j < 3; j++) {
                        for (int i = 0; i < mMovieFindTypeOtherBean.getData().get(j).getTagList().size(); i++) {
                            Button button = new Button(holder.getItemView().getContext());
                            button.setBackground(MyApplication.getmContext().getResources().getDrawable(R.drawable.button_style));
                            button.setPadding(5,0,5,0);
                            button.setTextSize(12f);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                            layoutParams.setMargins(5,0,5,0);//4个参数按顺序分别是左上右下
                            button.setLayoutParams(layoutParams);
                            button.setText(mMovieFindTypeOtherBean.getData().get(j).getTagList().get(i).getTagName());
                            if (j == 0){
                                llType.addView(button);
                            }else if (j == 1){
                                llCenter.addView(button);
                            }else {
                                llAll.addView(button);
                            }
                        }
                    }

                }
                break;
            case 1:
                if (mMovieFindCenterBean != null) {
                    holder.setText(R.id.movie_find_center_board_name_one, mMovieFindCenterBean.getData().get(0).getBoardName());
                    holder.setText(R.id.movie_find_center_movie_name_one, mMovieFindCenterBean.getData().get(0).getMovieName());
                    holder.setText(R.id.movie_find_center_board_name_two, mMovieFindCenterBean.getData().get(1).getBoardName());
                    holder.setText(R.id.movie_find_center_movie_name_two, mMovieFindCenterBean.getData().get(1).getMovieName());
                    holder.setText(R.id.movie_find_center_board_name_three, mMovieFindCenterBean.getData().get(2).getBoardName());
                    holder.setText(R.id.movie_find_center_movie_name_three, mMovieFindCenterBean.getData().get(2).getMovieName());
                    holder.setText(R.id.movie_find_center_board_name_four, mMovieFindCenterBean.getData().get(3).getBoardName());
                    holder.setText(R.id.movie_find_center_movie_name_four, mMovieFindCenterBean.getData().get(3).getMovieName());
                    holder.setImage(R.id.movie_find_center_movie_img_one, mMovieFindCenterBean.getData().get(0).getMovieImgs().get(1).replace("w.h","165.220"));
                    holder.setImage(R.id.movie_find_center_movie_img_two, mMovieFindCenterBean.getData().get(1).getMovieImgs().get(1).replace("w.h","165.220"));
                    holder.setImage(R.id.movie_find_center_movie_img_three, mMovieFindCenterBean.getData().get(2).getMovieImgs().get(1).replace("w.h","165.220"));
                    holder.setImage(R.id.movie_find_center_movie_img_four, mMovieFindCenterBean.getData().get(3).getMovieImgs().get(1).replace("w.h","165.220"));

                    holder.setImage(R.id.movie_find_center_movie_img_one_before, mMovieFindCenterBean.getData().get(0).getMovieImgs().get(0).replace("w.h","165.220"));
                    holder.setImage(R.id.movie_find_center_movie_img_two_before, mMovieFindCenterBean.getData().get(1).getMovieImgs().get(0).replace("w.h","165.220"));
                    holder.setImage(R.id.movie_find_center_movie_img_three_before, mMovieFindCenterBean.getData().get(2).getMovieImgs().get(0).replace("w.h","165.220"));
                    holder.setImage(R.id.movie_find_center_movie_img_four_before, mMovieFindCenterBean.getData().get(3).getMovieImgs().get(0).replace("w.h","165.220"));

                }
                break;
            case 2:
                break;
            case 3:
                mRv = holder.getView(R.id.movie_find_all_rv);
                final FindAllAdapter adapter = new FindAllAdapter();
                HttpUtil.getMovieFindAllPrize(new ResponseCallBack<MovieFindAllPrizeBean>() {
                    @Override
                    public void onError(Exception e) {

                    }
                    @Override
                    public void onResponse(MovieFindAllPrizeBean movieFindAllPrizeBean) {
                        mRv.setAdapter(adapter);
                        adapter.setMovieFindAllPrizeBean(movieFindAllPrizeBean);
                        LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getmContext(), LinearLayoutManager.HORIZONTAL, false);
                        mRv.setLayoutManager(manager);
                    }
                });
                break;
            case 4:
                holder.setItemClick(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("MovieFindAdapter", "点击了");
                    }
                });
                break;
        }

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= 4) {
            return 4;
        } else {
            return position;
        }
    }


}
