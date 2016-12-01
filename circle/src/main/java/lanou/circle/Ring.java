package lanou.circle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * created by 王一鸣 16/11/29.
 * 功能:
 */

public class Ring extends View {
    // 整个组件的宽与高
    private int mWidth;
    private int mHeight;
    // 绿色画笔与灰色画笔

    private Paint grayPaint;
    private Paint greenPaint;

    public Ring(Context context) {
        super(context);
        init();
    }


    public Ring(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }



    public Ring(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化方法
     */
    private void init() {
        grayPaint = new Paint();
        grayPaint.setColor(0xfff0f0f0);
        grayPaint.setAntiAlias(true);
        grayPaint.setStrokeWidth(3.0f);

        greenPaint = new Paint();
        greenPaint.setColor(0xfff0f0f0);
        greenPaint.setAntiAlias(true);

    }


    /**
     * 测量
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int width = Math.min(widthMode, widthSize);
        //此处的逻辑是判断当我们的自定义的View被嵌套在ScrollView中时, 获得的测量模式会使UNSPECIFIED
        if (widthMode == MeasureSpec.UNSPECIFIED) {
            width = heightSize;
        } else if (heightMode == MeasureSpec.UNSPECIFIED) {
            width = widthSize;

        }
        // 此处宽与高是一样的
        mWidth = width;
        mHeight = width;

        // 调用此方法是测量结果生效
        setMeasuredDimension(width, width);


    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCircle(canvas);

        invalidate();
    }

    /**
     * 画圆弧
     * @param canvas
     */
    private void drawCircle(Canvas canvas) {
        canvas.drawArc(1.0f / 8 * mWidth,1.0f /8 * mHeight,7.0f /8 * mHeight,7.0f / 8 * mWidth,-225, -45,true,grayPaint);
    }
}
