package lanou.maoyanmovie.weather;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.IHeaderView;

import lanou.maoyanmovie.R;

/**
 * created by 王一鸣 16/12/2.
 * 功能:
 */

public class WeatherRefreshHeader extends FrameLayout implements IHeaderView {
    private TextView refreshTextView;

    private ImageView refreshArrow;
    View rootView;
    RotateAnimation rotateAnimation;
    private View mRootView;

    public WeatherRefreshHeader(Context context) {
        super(context);
        if (rootView == null) {
            mRootView = View.inflate(context, R.layout.view_weather, null);
            refreshArrow = (ImageView) mRootView.findViewById(R.id.iv_arrow);
            refreshTextView = (TextView) mRootView.findViewById(R.id.tv);

            rotateAnimation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            rotateAnimation.setDuration(2000);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setRepeatMode(Animation.RESTART);
            refreshArrow.setAnimation(rotateAnimation);
            addView(mRootView);
        }

    }

    @Override
    public View getView() {
        return this;
    }

    /**
     * 下拉准备刷新动作
     *
     * @param fraction      当前下拉高度与总高度的比
     * @param maxHeadHeight
     * @param headHeight
     */
    @Override
    public void onPullingDown(float fraction, float maxHeadHeight, float headHeight) {
        rotateAnimation.cancel();
        if (fraction < 1f)
            refreshTextView.setText("刷新数据");
        if (fraction > 1f)
            refreshTextView.setText("刷新数据");
        refreshArrow.setRotation(fraction * headHeight / maxHeadHeight * 180);
        mRootView.setBackgroundColor(0xffffffff);

    }

    /**
     * 下拉释放过程
     *
     * @param fraction
     * @param maxHeadHeight
     * @param headHeight
     */
    @Override
    public void onPullReleasing(float fraction, float maxHeadHeight, float headHeight) {
        if (fraction < 1f && fraction > 0.1f) {

            mRootView.setBackgroundColor(0x00ffffff);


        }

    }

    @Override
    public void startAnim(float maxHeadHeight, float headHeight) {
        if(headHeight < maxHeadHeight){


        mRootView.setBackgroundColor(0x00ffffff);
        rotateAnimation.start();
        refreshArrow.setVisibility(GONE);

        }

    }


    @Override
    public void onFinish() {
        // refreshArrow.setVisibility(INVISIBLE);
        //refreshTextView.setVisibility(INVISIBLE);
    }


}
