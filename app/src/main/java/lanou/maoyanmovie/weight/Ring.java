package lanou.maoyanmovie.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import lanou.maoyanmovie.R;


/**
 * created by 王一鸣 16/11/29.
 * 功能:
 */

public class Ring extends View {
    // 整个组件的宽与高
    private int mWidth;
    private int mHeight;
    // 绿色画笔与灰色画笔
    private Paint mGrayPaint;
    private Paint mGreenPaint;
    // 获取自定义属性的内容  文本, 数值, 简写, 级别
    private String mText;
    private int mNum;
    private String mAbbr;
    private String mLevel;

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getNum() {
        return mNum;
    }

    public void setNum(int num) {
        mNum = num;
        invalidate();
    }

    public String getAbbr() {
        return mAbbr;
    }

    public void setAbbr(String abbr) {
        mAbbr = abbr;
    }

    public String getLevel() {
        return mLevel;
    }

    public void setLevel(String level) {
        mLevel = level;
        Log.d("Ring", level);
        invalidate();

    }

    public Ring(Context context) {
        this(context, null);
        //init();
    }


    public Ring(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        //init();
    }


    public Ring(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        getCustomContent(context, attrs);
    }


    /**
     * 获取自定义属性的值
     *
     * @param context
     * @param attrs
     */
    private void getCustomContent(Context context, AttributeSet attrs) {


        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.Ring);

        // 使用相应的方法获取各个类型属性的值，第二个参数是获取不到属性值默认的属性值。
        mText = typedArray.getString(R.styleable.Ring_text);
        mAbbr = typedArray.getString(R.styleable.Ring_abbr);
        mNum = typedArray.getInteger(R.styleable.Ring_num, 0);
        mLevel = typedArray.getString(R.styleable.Ring_leval);

        // 没啥，google推荐的，使用完及时释放
        typedArray.recycle();


    }

    /**
     * 初始化方法
     */
    private void init() {
        mGrayPaint = new Paint();
        mGrayPaint.setColor(0xfff0f0f0);
        mGrayPaint.setAntiAlias(true);
        mGrayPaint.setStrokeWidth(2.0f);
        mGrayPaint.setStyle(Paint.Style.FILL);

        mGreenPaint = new Paint();
        mGreenPaint.setColor(0xff5fdc61);
        mGreenPaint.setAntiAlias(true);
        mGreenPaint.setStrokeWidth(2.0f);
        mGreenPaint.setStyle(Paint.Style.FILL);

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
        drawText(canvas);
        invalidate();
    }

    /**
     * 画圆弧
     *
     * @param canvas
     */
    private void drawCircle(Canvas canvas) {
        mGrayPaint.setStyle(Paint.Style.STROKE);
        mGrayPaint.setColor(0xfff0f0f0);
        mGreenPaint = setPaintColor(mGreenPaint);
        canvas.drawArc(1.0f / 6 * mWidth, 1.0f / 6 * mHeight, 5.0f / 6 * mHeight, 5.0f / 6 * mWidth, 135, 270, false, mGrayPaint);
        mGreenPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(1.0f / 6 * mWidth, 1.0f / 6 * mHeight, 5.0f / 6 * mHeight, 5.0f / 6 * mWidth, 135, mNum * 270.0f / 500, false, mGreenPaint);
    }

    /**
     * 画文字, 文本, 数值, 缩写
     *
     * @param canvas
     */
    private void drawText(Canvas canvas) {
        mGreenPaint.setStyle(Paint.Style.FILL);
        mGrayPaint.setStyle(Paint.Style.FILL);
        // 居中
        mGrayPaint.setTextAlign(Paint.Align.CENTER);
        // 画简写
        mGrayPaint.setTextSize(25);
        canvas.drawText(mAbbr, getWidth() / 2,getHeight()/2 + (1.0f /10) *mWidth , mGrayPaint);

        // 画底部的文字
        mGrayPaint.setColor(0xff7d7d7c);
        mGrayPaint.setTextSize(35);

        canvas.drawText(mText, getWidth() / 2, (float) ((1.0f / 2) * mWidth + mWidth / (3 * Math.sqrt(1.2))), mGrayPaint);


        // 画指数
        mGreenPaint.setTextAlign(Paint.Align.CENTER);

        mGreenPaint.setTextSize(100);
        canvas.drawText(String.valueOf(mNum), getWidth() / 2,getHeight()/2 + (1.0f / 30) * mWidth, mGreenPaint);

    }

    /**
     * 根据天气级别设置画笔的颜色
     * @param paint
     */
    private  Paint setPaintColor(Paint paint){
        if(mLevel.equals("优")){
            paint.setColor(0xff5fdc61);
        }else if(mLevel.equals("轻度污染")){
            paint.setColor(0xfff5592d);
        }else if (mLevel.equals("重度污染")){
            paint.setColor(0xffeb1223);
        }
        else {
            paint.setColor(0xff5fdc61);
        }

        return paint;
    }
}
