package lanou.maoyanmovie.tools;

/**
 * Created by dllo on 16/11/21.
 */

public class MovieValues {
    //电影 -> 热映 -> 轮播图
    public static final String MOVIE_HOT_BANNER = "http://advert.mobile.meituan" +
            ".com/api/v3/adverts?cityid=10&category=11&version=7.5" +
            ".0&new=0&app=movie&clienttp=android&uuid" +
            "=2C2C0ECD557F366849954BEF88D0017A2348CB73AF77F7971799A5010CBBDD2A&devid" +
            "=000000000000000&uid=&movieid=&partner=1&apptype=1";
    //电影 -> 热映 -> 列表
    public static final String MOVIE_HOT_LIST = "http://m.maoyan.com/movie/list" +
            ".json?type=hot&ci＝65&limit=12&";
    //电影 -> 热映 -> 列表 -> 详情
    public static final String MOVIE_HOT_LIST_DETAIL = "http://m.maoyan.com/movie/";

    //电影
    public static final String MOVIE_WAIT = "http://api.maoyan.com/mmdb/movie/lp/list.json";

    //发现 -> 周边商城 -> 您可能喜欢
    public static final String STORE_LIKE = "http://api.maoyan.com/mallpro/recommended.json?";
    //发现 -> 上面四个图标
    public static final String FIND_TOP = "http://api.maoyan.com/sns/v2/buttons.json?utm_term=7.5.0&utm_medium=android";
    //发现 -> 今天
    public static final String FIND_TODAY = "http://api.maoyan.com/sns/v5/feed.json?";
    //发现 -> 今天 -> 点击详情
    public static final String TODAY_DETAIL = "http://api.maoyan.com/sns/news/v2/";
    //post请求都有的 url (不确定 先这样写)
    public static final String BASE_POST_URL = "http://api.mobile.meituan.com/combo/v2/combo.json";
    //周边商城 上面十个按钮
    public static  final String STORE_TOP = "http://api.maoyan.com/mallpro/category.json";
    //周边商城 每月特价
    public static final String STORE_MONTH_DISCOUNT = "http://api.maoyan.com/mallpro/topicList.json";
    // 根据经纬度获取城市的名字
    public static final String LOCATION_LONGITUDE_LATITUDE = "http://api.avatardata.cn/CoordAddress/Lookup?key=b43534b71d1c4e18b935d548949205ba&";


}
