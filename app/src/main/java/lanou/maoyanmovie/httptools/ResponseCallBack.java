package lanou.maoyanmovie.httptools;

/**
 * Created by dllo on 16/11/21.
 */

public interface ResponseCallBack<T> {
    /**
     *  请求失败返回
     * @param e 错误的异常
     */
    void onError(Exception e);

    /**
     * 请求成功返回
     * @param t 返回的数据类
     */
    void onResponse(T t);

}
