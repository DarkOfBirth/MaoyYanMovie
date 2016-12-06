package lanou.maoyanmovie.movie.wait;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.bean.MovieWaitBean;

/**
 * Created by 麦建东 on 16/11/30.
 */
public class WaitAdapter extends PagerAdapter {

    private MovieWaitBean mMovieWaitBean;

    public void setMovieWaitBean(MovieWaitBean movieWaitBean) {
        mMovieWaitBean = movieWaitBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mMovieWaitBean == null ? 0 : mMovieWaitBean.getData().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout
                .fragment_movie_wait_item, null);
        LinearLayout waitLl = (LinearLayout) view.findViewById(R.id.fragment_movie_wait_ll);
        ImageView imgIv = (ImageView) view.findViewById(R.id.fragment_movie_wait_Iv);
        TextView originTv = (TextView) view.findViewById(R.id.fragment_movie_wait_origin_tv);
        TextView nameTv = (TextView) view.findViewById(R.id.fragment_movie_wait_name_tv);

        Picasso.with(container.getContext()).load(mMovieWaitBean.getData().get(position).getImg())
                .fit().into(imgIv);
        nameTv.setText(mMovieWaitBean.getData().get(position).getMovieName());
        originTv.setText(mMovieWaitBean.getData().get(position).getOriginName());
        //点击播放视频(虚拟机4.4.4播放失败，需要更高的版本)
        waitLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(mMovieWaitBean.getData().get(position).getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW);
                // video：表示播放类型，如音频，视频
                // * ：表示播放的后缀名为所有可能
                intent.setDataAndType(uri, "video/*");
                container.getContext().startActivity(intent);
            }
        });



        container.addView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }
}
