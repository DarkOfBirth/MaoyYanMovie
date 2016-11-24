package lanou.maoyanmovie.httptools;

import lanou.maoyanmovie.bean.FindTodayBean;
import lanou.maoyanmovie.bean.FindTodayDetailBean;
import lanou.maoyanmovie.bean.FindTopBean;
import lanou.maoyanmovie.bean.StoreLikeBean;
import lanou.maoyanmovie.bean.StoreMonthDiscountBean;
import lanou.maoyanmovie.bean.StoreTopBean;
import lanou.maoyanmovie.tools.MovieValues;

/**
 * Created by dllo on 16/11/21.
 *
 */

public class HttpUtil {
    /**
     * 发现-> 周边商城 -> 你可能喜欢的网络数据
     *
     * @param offset           数据开始的位置
     * @param limit            需要请求的数据条数
     * @param responseCallBack 接口, 用于数据的返回
     */
    public static void getStoreLike(int offset, int limit, ResponseCallBack<StoreLikeBean> responseCallBack) {
        String url = MovieValues.STORE_LIKE + "offset=" + offset + "&limit=" + limit;
        OkHttpManager.getInstance().get(url, StoreLikeBean.class, responseCallBack);
    }

    /**
     * 发现 -> 上面四个图标
     *
     * @param responseCallBack 接口, 用于数据的返回
     */

    public void getFindTop(ResponseCallBack<FindTopBean> responseCallBack) {
        OkHttpManager.getInstance().get(MovieValues.FIND_TOP, FindTopBean.class, responseCallBack);
    }

    /**
     * 发现-> 今天
     *
     * @param offset           数据开始的位置
     * @param limit            需要请求的数据条数
     * @param responseCallBack 接口, 用于数据的返回
     */

    public  void getFindToday(int offset, int limit, ResponseCallBack<FindTodayBean> responseCallBack) {
        String url = MovieValues.FIND_TODAY + "offset=" + offset + "&limit=" + limit;
        OkHttpManager.getInstance().get(url, FindTodayBean.class, responseCallBack);
    }

    /**
     * 发现-> 今天 -> 点击后 二级界面
     *
     * @param targetId 从要点击的Item中获取到targetId
     */

    public  void getFindTodayDeail(int targetId, ResponseCallBack<FindTodayDetailBean> responseCallBack) {
        String url = MovieValues.TODAY_DETAIL + targetId + ".json";
        OkHttpManager.getInstance().get(url, FindTodayDetailBean.class, responseCallBack);
    }

    /**
     * 发现 -> 商城 -> 上面十个按钮
     */
    public static void getFindStoreTop(ResponseCallBack responseCallBack) {
        OkHttpManager.getInstance().get(MovieValues.STORE_TOP, StoreTopBean.class, responseCallBack);
    }

    /**
     * 发现 -> 商城 -> 每月特价
     */

    public void getFindStoreMonthDiscount(ResponseCallBack<StoreMonthDiscountBean> responseCallBack) {
        OkHttpManager.getInstance().get(MovieValues.STORE_MONTH_DISCOUNT, StoreMonthDiscountBean.class, responseCallBack);
    }


}
