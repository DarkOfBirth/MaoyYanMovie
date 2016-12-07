package lanou.maoyanmovie.collect;

import android.os.Handler;
import android.os.Looper;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.WhereBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import lanou.maoyanmovie.base.MyApplication;
import lanou.maoyanmovie.bean.CollectBean;

/**
 * Created by dllo on 16/10/28.
 * 数据库的操作类
 */
public class CollectDBTool {
    //饿汉式 一加载就会申请  无法进行传值
    private static CollectDBTool sDBTool = new CollectDBTool();
    private LiteOrm liteOrm;
    private Handler handler;
    private Executor mThreadPool;

    //构造方法私有化
    private CollectDBTool() {
        liteOrm = liteOrm.newSingleInstance(MyApplication.getmContext(), "maoYanMovie.db");
        handler = new Handler(Looper.getMainLooper());
        int coreNum = Runtime.getRuntime().availableProcessors();
        mThreadPool = Executors.newFixedThreadPool(coreNum + 1);
    }

    public static CollectDBTool getInstance() {
        return sDBTool;
    }


    public void insertCollectBean(final List<CollectBean> collectBean) {
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                liteOrm.insert(collectBean);
            }
        });
    }

    //插入方法
    public void insertCollectBean(final CollectBean collectBean) {
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                liteOrm.insert(collectBean);

            }
        });
    }

    //删除表方法
    public void deleteCollectBean(final Class<CollectBean> collectBean) {
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                liteOrm.delete(collectBean);
            }
        });
    }

    //删除某一数值
    public void deleteValueBean(final Class<CollectBean> collectBean, final String field, final String[] value) {
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                liteOrm.delete(collectBean, WhereBuilder.create(collectBean).where(field + "=?", value));
            }
        });
    }

    //这个方式的查询或者是插入, 没有返回值的, 都是通过接口的形式
    public void queryByValuesCollectBean(final Class<CollectBean> collectBean,
                                         final String field, final String[] value,
                                         final OnQueryListener onQueryListener) {
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                final List<CollectBean> data = liteOrm.query(new QueryBuilder(collectBean).where(field + "= ?", value));
                // 传值
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // 主线程
                        onQueryListener.onQuery(data);
                    }
                });
            }
        });
    }

    //查询方法
    public void queryAllCollectBean(final OnQueryListener onQueryListener) {
        //查询
        mThreadPool.execute(new QueryRunnable(onQueryListener));
    }

    class QueryRunnable implements Runnable {//查询
        private OnQueryListener mOnQueryListener;

        public QueryRunnable(OnQueryListener mOnQueryListener) {
            this.mOnQueryListener = mOnQueryListener;
        }

        @Override
        public void run() {
            ArrayList<CollectBean> query = liteOrm.query(CollectBean.class);
            handler.post(new CallBackRunnable(mOnQueryListener, query));
        }
    }

    //Handler使用的 将查询的数据返回到主线程使用的Runnable
    class CallBackRunnable implements Runnable {
        private OnQueryListener mOnQueryListener;
        private List<CollectBean> collectBean;

        public CallBackRunnable(OnQueryListener mOnQueryListener, ArrayList<CollectBean> collectBean) {
            this.mOnQueryListener = mOnQueryListener;
            this.collectBean = collectBean;
        }

        @Override
        public void run() {
            mOnQueryListener.onQuery(collectBean);
        }
    }

    //返回查询结果用的接口
    public interface OnQueryListener {
        void onQuery(List<CollectBean> collectBean);
    }

}
