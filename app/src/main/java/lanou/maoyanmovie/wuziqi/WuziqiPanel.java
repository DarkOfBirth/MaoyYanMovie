package lanou.maoyanmovie.wuziqi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import lanou.maoyanmovie.R;


/**
 * Created by 王一鸣 on 16/11/22.
 */

public class WuziqiPanel extends View {
    // 游戏是否结束监听
    private OnGameOVerListener mOnGameOVerListener;
    // 棋盘宽度
    private int mPanelWidth;
    // 棋盘格子的行高
    private float mLineHeight;
    // 棋盘最大行列数(棋盘横竖线的个数)
    private int MAX_LINE_NUM = 10;

    // 定义画笔绘制棋盘格子
    private Paint mPaint = new Paint();
    // 定义黑白棋子的Bitmap
    private Bitmap mWhitePiece;
    private Bitmap mBlcakPiece;

    // 棋子的缩放比例(行高的3/4)
    private float pieceScaleRatio = 3 * 1.0f / 4;

    // 存储黑白棋子的坐标
    private ArrayList<Point> mWhiteArray = new ArrayList<>();
    private ArrayList<Point> mBlackArray = new ArrayList<>();

    // 哪方先下子
    private boolean isWhiteFirst = true;
    // 游戏是否结束
    private boolean isGameOver;
    // 确定赢家
    private boolean isWhiteWinner = false;
    // 游戏结束监听


    public void setOnGameOVerListener(OnGameOVerListener onGameOVerListener) {
        mOnGameOVerListener = onGameOVerListener;
    }

    // 一个参数的构造方法是在new 出一个组建的时候调用
    public WuziqiPanel(Context context) {
        this(context,null);
    }

    // 两个参数的构造方法时在xml中使用自定义View时调用
    public WuziqiPanel(Context context, AttributeSet attrs) {
        this(context, attrs,0);

    }

    // 三个参数的构造方法是在自定你也view中使用了自定义属性的时候调用
    public WuziqiPanel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化设置
     */

    private void init() {
        // 初始化画笔
        mPaint.setColor(0x88000000);
        // 设置抗锯齿
        mPaint.setAntiAlias(true);
        // 设置防抖动
        mPaint.setDither(true);
        // 设置为空心(划线)
        mPaint.setStyle(Paint.Style.STROKE);

        // 初始化棋子
        mWhitePiece = BitmapFactory.decodeResource(getResources(), R.mipmap.white);
        mBlcakPiece = BitmapFactory.decodeResource(getResources(), R.mipmap.black);

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
        // 调用此方法是测量结果生效
        setMeasuredDimension(width, width);


    }

    /**
     * 当宽高发生变化时回调次方法
     *
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // 此处的参数w就是在onMeasure()方法中设置的自定义viewde daxiao
        // 计算出棋盘宽度和行高
        mPanelWidth = w;
        // 行高
        mLineHeight = mPanelWidth * 1.0f / MAX_LINE_NUM;
        // 将棋子根据行高变化
        int pieceWidth = (int) (pieceScaleRatio * mLineHeight); // 比例 * 行高 = 棋子的大小
        Log.d("WuziqiPanel", "pieceWidth:" + pieceWidth);

        Log.d("WuziqiPanel", "mWhitePiece:" + mWhitePiece);

        mWhitePiece = Bitmap.createScaledBitmap(mWhitePiece, pieceWidth, pieceWidth, false);
        mBlcakPiece = Bitmap.createScaledBitmap(mBlcakPiece, pieceWidth, pieceWidth, false);
    }

    /**
     * 绘制棋盘
     *
     * @param canvas
     */

    private void drawBoard(Canvas canvas) {
        int w = mPanelWidth;
        // 行高
        float lineHeight = mLineHeight;
        for (int i = 0; i < MAX_LINE_NUM; i++) {
            int startX = (int) (lineHeight / 2);
            int endX = (int) (w - lineHeight / 2);
            int y = (int) (lineHeight / 2 + i * lineHeight);
            // 画横线
            canvas.drawLine(startX, y, endX, y, mPaint);
            // 画竖线
            canvas.drawLine(y, startX, y, endX, mPaint);
        }
    }

    /**
     * 将用户点击位置的Point转换为类似于(0,0)的坐标
     *
     * @param x
     * @param y
     * @return
     */
    private Point getValidPoint(int x, int y) {
        return new Point((int) (x / mLineHeight), (int) (y / mLineHeight));
    }

    /**
     * 处理用户手势操作
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isGameOver)
            return false;
        int action = event.getAction();
        // 手指抬起后处理
        if (action == MotionEvent.ACTION_UP) {
            // 拦截事件自己处理
            int x = (int) event.getX();
            int y = (int) event.getY();
            Point point = getValidPoint(x, y);
            // 首先判断所点击的位置是不是已经有棋子
            if(mWhiteArray.contains(point) || mBlackArray.contains(point)){
                return false;
            }
            // 白棋先下
            if(isWhiteFirst){
                // 下白棋
                mWhiteArray.add(point);
            }else {
                // 下黑棋
                mBlackArray.add(point);
            }
            // 调用重绘
            invalidate();
            isWhiteFirst = !isWhiteFirst;
        }


        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制棋盘
        drawBoard(canvas);
        // 绘制用户已经下的棋子
        drawPieces(canvas);
        // 判断游戏是否结束
        checkGameOver();
    }

    /**
     * 检查游戏是否结束
     */
    private void checkGameOver() {
        // 检查是否五子连珠
        Log.d("WuziqiPanel", "mWhiteArray.size():" + mWhiteArray.size());

        Log.d("WuziqiPanel", "mBlackArray.size():" + mBlackArray.size());
        boolean whiteWin = WuziqiUtil.checkFiveInLine(mWhiteArray);
        boolean blackWin = WuziqiUtil.checkFiveInLine(mBlackArray);
        if(whiteWin || blackWin){
            isGameOver = true;
            isWhiteWinner = whiteWin;
            String msg = isWhiteWinner ? "白子获胜" : "黑子获胜";
            Toast.makeText(WuziqiPanel.this.getContext(), msg, Toast.LENGTH_SHORT).show();
            mOnGameOVerListener.gameOver(isWhiteWinner);
        }
    }

    /**
     * 绘制用户已经下的棋子
     * @param canvas
     */
    private void drawPieces(Canvas canvas) {
        // 绘制白棋子
        for (int i = 0; i < mWhiteArray.size(); i++) {
            Point whitePoint = mWhiteArray.get(i);
            // 棋子之间的间隔为1/4行高
            //TODO 不太理解
            canvas.drawBitmap(mWhitePiece,
                    (whitePoint.x + (1- pieceScaleRatio)/2)*mLineHeight,
                    (whitePoint.y + (1- pieceScaleRatio)/2)*mLineHeight, null);
        }

        for (int i = 0; i < mBlackArray.size(); i++) {
            Point blackPoint = mBlackArray.get(i);
            // 棋子之间的间隔为1/4行高
            canvas.drawBitmap(mBlcakPiece,
                    (blackPoint.x + (1- pieceScaleRatio)/2)*mLineHeight,
                    (blackPoint.y + (1- pieceScaleRatio)/2)*mLineHeight, null);
        }
    }
    public void restart(){
        mBlackArray.clear();
        mWhiteArray.clear();
        isGameOver = false;
        isWhiteWinner = false;
        // 重绘
        invalidate();
    }
}
