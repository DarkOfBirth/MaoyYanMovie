package lanou.maoyanmovie.httptools;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by dllo on 16/11/21.
 * OkHttpManager 网络请求的封装 一个get 和 两个post请求(body 是key- value 和 json)
 * 不要随意改动
 */

public class OkHttpManager {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private static OkHttpManager mOkHttpManager;
    private OkHttpClient mOkHttpClient;

    private Handler mHandler;
    private Gson mGson;

    private OkHttpManager() {
        mOkHttpClient = new OkHttpClient();
        // 确保在主线程执行
        mHandler = new Handler(Looper.myLooper());
        mGson = new Gson();

    }

    /**
     * 懒汉式单例
     *
     * @return
     */
    public static OkHttpManager getInstance() {
        if (mOkHttpManager == null) {
            synchronized (OkHttpManager.class) {
                if (mOkHttpManager == null) {
                    mOkHttpManager = new OkHttpManager();
                }
            }
        }
        return mOkHttpManager;
    }

    /**
     * get 请求
     *
     * @param url
     * @param tClass           类名
     * @param responseCallBack 回调接口对象
     * @param <T>
     */
    public <T> void get(String url, Class<T> tClass, ResponseCallBack<T> responseCallBack) {
        Request mRequest = new Request.Builder().url(url).build();
        sendHttpRequest(url, mRequest, tClass, responseCallBack);

    }

    /**
     * post get 请求 key-value 形式的
     *
     * @param url              网络请求地址
     * @param tClass
     * @param responseCallBack 返回
     * @param body             body的hashMap的集合
     * @param <T>
     */
    public <T> void post(String url, Class<T> tClass, ResponseCallBack<T> responseCallBack, HashMap<String, String> body) {

        FormBody.Builder formBuilder = new FormBody.Builder();
        for (String s : body.keySet()) {
            formBuilder.add(s, body.get(s));
        }
        FormBody formBody = formBuilder.build();

        //class FormBody extends RequestBody   post(RequestBody) 因为FormBody继承自RequestBody
        Request request = new Request.Builder().post(formBody).url(url).build();
        sendHttpRequest(url, request, tClass, responseCallBack);

    }

    /**
     * post 请求  json 是一个字符串, 一个大集合
     *
     * @param url
     * @param tClass
     * @param responseCallBack
     * @param json
     * @param <T>
     */
    public  <T> void post(String url, Class<T> tClass, ResponseCallBack<T> responseCallBack, String json) {

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();


        sendHttpRequest(url, request, tClass, responseCallBack);

    }


    /**
     * 发送Request 请求
     *
     * @param url
     * @param request
     * @param tClass
     * @param responseCallBack
     * @param <T>
     */
    private <T> void sendHttpRequest(String url, Request request, final Class<T> tClass, final ResponseCallBack<T> responseCallBack) {
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mHandler.post(new ErrorRunnable<T>(responseCallBack, e));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string();
                T t = mGson.fromJson(data, tClass);
                mHandler.post(new ResponseRunnable<T>(responseCallBack, t));
            }
        });
    }


    abstract class OkHttpRunnable<T> implements Runnable {
        protected ResponseCallBack<T> responCallBack;

        public OkHttpRunnable(ResponseCallBack<T> responCallBack) {
            this.responCallBack = responCallBack;
        }
    }

    class ErrorRunnable<T> extends OkHttpRunnable<T> {
        private Exception exception;

        public ErrorRunnable(ResponseCallBack<T> responCallBack, Exception e) {
            super(responCallBack);
            this.exception = e;
        }

        @Override
        public void run() {
            responCallBack.onError(exception);
        }
    }

    class ResponseRunnable<T> extends OkHttpRunnable<T> {
        private T t;

        public ResponseRunnable(ResponseCallBack<T> responCallBack, T t) {
            super(responCallBack);
            this.t = t;
        }

        @Override
        public void run() {
            // 将Object 强转为自己的数据类
            responCallBack.onResponse(t);
        }
    }
}
