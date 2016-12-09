package lanou.maoyanmovie.tools;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by dllo on 16/11/7.
 * 显示圆形图片的Drawable
 */
public class CircleDrawable extends Drawable {
    private Bitmap bitmap;
    private Paint paint;
    private int r;//半径

    public CircleDrawable(Bitmap bitmap) {
        this.bitmap = bitmap;
        paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.MIRROR);//图片重复时使用的模式
        paint.setShader(shader);//设置画笔的花纹
        //计算出最大的半径
        r = Math.min(bitmap.getHeight() / 2, bitmap.getHeight() / 2);
    }

    @Override
    public void draw(Canvas canvas) {
        //画圆
        canvas.drawCircle(bitmap.getHeight() / 2, bitmap.getWidth() / 2, r, paint);
    }


    @Override
    public void setAlpha(int i) {
        paint.setAlpha(i);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }

    //负责告诉Drawable他的宽高是多少
    @Override
    public int getIntrinsicHeight() {
        return 2 * r;
    }

    @Override
    public int getIntrinsicWidth() {
        return 2 * r;
    }
}
