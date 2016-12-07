package lanou.maoyanmovie.httptools;

import lanou.maoyanmovie.bean.FindTodayBean;
import lanou.maoyanmovie.bean.FindTodayDetailBean;
import lanou.maoyanmovie.bean.FindTopBean;
import lanou.maoyanmovie.bean.HotSearchBean;
import lanou.maoyanmovie.bean.LocationBean;
import lanou.maoyanmovie.bean.MovieHotBannerBean;
import lanou.maoyanmovie.bean.MovieHotListBean;
import lanou.maoyanmovie.bean.MovieWaitBean;
import lanou.maoyanmovie.bean.MovieWaitWishBean;
import lanou.maoyanmovie.bean.SearchBean;
import lanou.maoyanmovie.bean.StoreLikeBean;
import lanou.maoyanmovie.bean.StoreMonthDiscountBean;
import lanou.maoyanmovie.bean.StoreTopBean;
import lanou.maoyanmovie.bean.WeatherBean;
import lanou.maoyanmovie.tools.MovieValues;

/**
 * Created by dllo on 16/11/21.
 */

public class HttpUtil {
    /**
     * 电影 -> 热映 -> 轮播图
     *
     * @param responseCallBack 接口, 用于数据的返回
     */
    public static void getMovieHotBanner(ResponseCallBack<MovieHotBannerBean> responseCallBack) {
        OkHttpManager.getInstance().get(MovieValues.MOVIE_HOT_BANNER, MovieHotBannerBean.class, responseCallBack);
    }

    /**
     * 电影 -> 热映 -> 列表
     *
     * @param offset            数据开始的位置
     * @param responseCallBack  接口, 用于数据的返回
     */
    public static void getMovieHotList(String cityId, int offset, ResponseCallBack<MovieHotListBean> responseCallBack) {
        String url = MovieValues.MOVIE_HOT_LIST + "offset=" + offset + "&ci=" + cityId;

        OkHttpManager.getInstance().get(url, MovieHotListBean.class, responseCallBack);
    }

    /**
     * 电影 -> 待映 -> 预告片推荐
     * @param responseCallBack
     */
    public static void getMovieWait(ResponseCallBack<MovieWaitBean> responseCallBack) {
        OkHttpManager.getInstance().get(MovieValues.MOVIE_WAIT_RECOMMENDATION, MovieWaitBean.class, responseCallBack);
    }

    /**
     * 电影 -> 待映 -> 列表
     * @param responseCallBack
     */
    public static void getMovieWaitWish(ResponseCallBack<MovieWaitWishBean> responseCallBack) {
        OkHttpManager.getInstance().get(MovieValues.MOVIE_WAIT_WISH, MovieWaitWishBean.class, responseCallBack);
    }

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
    public static void getFindTop(ResponseCallBack<FindTopBean> responseCallBack) {
        OkHttpManager.getInstance().get(MovieValues.FIND_TOP, FindTopBean.class, responseCallBack);
    }

    /**
     * 发现-> 今天
     *
     * @param offset           数据开始的位置
     * @param limit            需要请求的数据条数
     * @param responseCallBack 接口, 用于数据的返回
     */
    public static void getFindToday(int offset, int limit, ResponseCallBack<FindTodayBean> responseCallBack) {
        String url = MovieValues.FIND_TODAY + "offset=" + offset + "&limit=" + limit;
        OkHttpManager.getInstance().get(url, FindTodayBean.class, responseCallBack);
    }

    /**
     * 发现-> 今天 -> 点击后 二级界面
     *
     * @param targetId 从要点击的Item中获取到targetId
     */
    public static void getFindTodayDeail(int targetId, ResponseCallBack<FindTodayDetailBean> responseCallBack) {
        String url = MovieValues.TODAY_DETAIL + targetId + ".json";
        OkHttpManager.getInstance().get(url, FindTodayDetailBean.class, responseCallBack);
    }

    /**
     * 发现 -> 商城 -> 上面十个按钮
     */
    public void getFindStoreTop(ResponseCallBack<StoreTopBean> responseCallBack) {
        OkHttpManager.getInstance().get(MovieValues.STORE_TOP, StoreTopBean.class, responseCallBack);
    }

    /**
     * 发现 -> 商城 -> 每月特价
     */
    public static  void getFindStoreMonthDiscount(ResponseCallBack<StoreMonthDiscountBean> responseCallBack) {
        OkHttpManager.getInstance().get(MovieValues.STORE_MONTH_DISCOUNT, StoreMonthDiscountBean.class, responseCallBack);
    }

    /**
     * 根据经纬度进行定位
     */
    public static  void getLocationByLongitudeAndLatitude(double longitude, double latitude, ResponseCallBack<LocationBean> responseCallBack) {
        String url = MovieValues.LOCATION_LONGITUDE_LATITUDE + "lat=" + latitude + "&lon=" + longitude;
        OkHttpManager.getInstance().get(url, LocationBean.class, responseCallBack);
    }
    /**
     * 根据城市的名字, 获取天气信息
     */
    public static void getWeatherInfo(String city,ResponseCallBack<WeatherBean> responseCallBack ){
            String url = MovieValues.WEATHER_INFO + city;
        OkHttpManager.getInstance().get(url, WeatherBean.class, responseCallBack );
    }

    /**
     * 获得当前城市的热门搜索
     * @param cityId
     * @param responseCallBack
     */
    public static void geHotSearchInfo(String cityId,ResponseCallBack<HotSearchBean> responseCallBack ){
        String url = MovieValues.HOT_SEARCH + cityId;
        OkHttpManager.getInstance().get(url, HotSearchBean.class, responseCallBack );
    }

    /**
     * 输入搜索内容后的结果
     * @param key
     * @param responseCallBack
     */
    public static void getSearcheyInfo(String key,ResponseCallBack<SearchBean> responseCallBack ){
        String url = MovieValues.SEARCH_KEY + key;
        OkHttpManager.getInstance().get(url, SearchBean.class, responseCallBack );
    }

}
