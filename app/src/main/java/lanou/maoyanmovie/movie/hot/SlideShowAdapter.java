package lanou.maoyanmovie.movie.hot;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import lanou.maoyanmovie.base.MyApplication;

/**
 * Created by 麦建东 on 16/11/23.
 */
public class SlideShowAdapter extends PagerAdapter {
    private ArrayList<String> stringList;

    public void setStringList(ArrayList<String> stringList) {
        this.stringList = stringList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return stringList == null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView image = new ImageView(container.getContext());
        Picasso.with(MyApplication.getmContext()).load(stringList.get(position % stringList.size())).fit()
                .into(image);
        container.addView(image);
        return image;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if(container.getChildAt(position) == object){
            container.removeViewAt(position);
        }
    }

//    /**
//     * 获取图片的数量
//     * @return
//     */
//    public int getImageCount() {
//        return stringList.size();
//    }

}
