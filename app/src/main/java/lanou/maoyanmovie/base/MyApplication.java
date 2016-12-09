package lanou.maoyanmovie.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/11/21.
 */

public class MyApplication extends Application {
    private static Context mContext;

    public MyApplication() {
        this.mContext = this;

    }

    /**
     * 获得 上下文, 此上下文 除了 View 的都可以使用
     * @return
     */
    public static Context getmContext(){
        return mContext;
    }

}
