package lanou.maoyanmovie.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * reated by 王一鸣 16/11/23.
 * 功能:
 */

public class SideBar extends View {
    private OnMoveSideBar mOnMoveSideBar;

    public void setOnMoveSideBar(OnMoveSideBar onMoveSideBar) {
        mOnMoveSideBar = onMoveSideBar;
    }
    private String lastHint = "";

    private static final String[] CHARACTERS = {"#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    // 字母的区域
    private Rect mTextRect;
    // 字母的画笔
    private Paint mCharacterPaint;
    // sideBar 的高度
    private int height;
    // sideBar 的宽度
    private int width;
    // cellHeight 每个字母的高度
    private float cellHeight;

    // 手指触摸屏幕的x, y
    private float touchX;
    private float touchY;

    public SideBar(Context context) {
        super(context);
        init();
    }


    public SideBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SideBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化方法
     */
    private void init() {
        mTextRect = new Rect();
        mCharacterPaint = new Paint();
        mCharacterPaint.setAntiAlias(true);
        mCharacterPaint.setColor(0xff3c3f41);
    }

    /**
     * onLayout方法是ViewGroup中子View的布局方法，用于放置子View的位置
     *
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) { //在这里测量sideBar的高度和宽度
            width = getMeasuredWidth();
            height = getMeasuredHeight();
            // sideBar 的高度除以需要显示的个数, 就是每个字母显示的高度
            cellHeight = height * 1.0f / CHARACTERS.length;
            // 根据SideBar的宽度和高度显示每个字母的高度, 确定绘制字母的大小, 处理的好处是, 对于不同的分辨率, 文字大小随之改变
            int textSize = (int) ((width > cellHeight ? cellHeight : width) * (3 * 1.0f / 4));
            mCharacterPaint.setTextSize(textSize);


        }
    }

    // 画sidebar 上面的字母
    private void drawCharacter(Canvas canvas) {
        for (int i = 0; i < CHARACTERS.length; i++) {
            String s = CHARACTERS[i];
            mCharacterPaint.getTextBounds(s, 0, s.length(), mTextRect);
            // 将字母的宽和高的值放在了mTextRect中
            canvas.drawText(s, (width - mTextRect.width()) / 2f,
                    cellHeight * i + (cellHeight + mTextRect.height()) / 2f, mCharacterPaint);

        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCharacter(canvas);
    }

    // 根据手指触摸的坐标, 获取当前选择的字母
    private String getHint() {
        int index = (int) ((int) touchY / cellHeight);
        if (index >= 0 && index < CHARACTERS.length) {
            return CHARACTERS[index];

        }
        return null;

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchX = event.getX();
        touchY = event.getY();
        int action = event.getAction();
        int index = (int) ((int) touchY / cellHeight);
        switch (action) {

            case MotionEvent.ACTION_DOWN:
                setBackgroundColor(0xffd1d1d1);
                if (getHint() == null) {
                    break;
                }
                Log.d("SideBar", getHint());

                mOnMoveSideBar.onKeyDown(cellHeight, getHint(), index);
                break;
            case MotionEvent.ACTION_MOVE:
                String hint = getHint();
                if (hint == null) {
                    break;
                }
                Log.d("SideBar", hint);
                if(!hint.equals(lastHint)) {
                    lastHint = hint;
                    mOnMoveSideBar.onMove(cellHeight, hint, index);
                }
                // Log.d("SideBar", "action_move");

                break;
            case MotionEvent.ACTION_UP:
                setBackgroundColor(0xfffafafa);


              // mOnMoveSideBar.onKeyUp();
                mOnMoveSideBar.onKeyUp(cellHeight, getHint(), index);

        }
        return true;


    }

   public interface OnMoveSideBar {
        void onMove(float cellHeight, String character, int index);
        void onKeyDown(float cellHeight, String character, int index);
        void onKeyUp(float cellHeight, String character, int index);
    }


}
