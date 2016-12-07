package lanou.maoyanmovie.movie.wait;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by 麦建东 on 16/11/30.
 * 判断图片的位置，给相应的大小
 */

public class PicTransFormer implements ViewPager.PageTransformer {
    private static final float MAX_SCALE = 1.4f;
    private static final float MIN_SCALE = 0.8f;
    @Override
    public void transformPage(View page, float position) {
        if (position >= -1 && position <= 1) {
            float scaleFactor = MIN_SCALE + (1 - Math.abs(position)) * (MAX_SCALE - MIN_SCALE);
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        } else {
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
        }
    }
}
