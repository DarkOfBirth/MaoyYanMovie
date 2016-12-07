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
            ".json?type=hot&limit=12&";
    //电影 -> 热映 -> 列表 -> 详情
    public static final String MOVIE_HOT_LIST_DETAIL = "http://m.maoyan.com/movie/";

    //电影 -> 待映 -> 预告片推荐
    public static final String MOVIE_WAIT_RECOMMENDATION = "http://api.maoyan" +
            ".com/mmdb/movie/lp/list.json";
    //电影 -> 待映 -> 近期最受期待
    public static final String MOVIE_WAIT_WISH = "http://api.maoyan" +
            ".com/mmdb/movie/v1/list/wish/order/coming.json?offset=0&limit=50&ci=65";

    //发现 -> 周边商城 -> 您可能喜欢
    public static final String STORE_LIKE = "http://api.maoyan.com/mallpro/recommended.json?";
    //发现 -> 上面四个图标
    public static final String FIND_TOP = "http://api.maoyan.com/sns/v2/buttons.json?utm_term=7.5.0&utm_medium=android";
    //发现 -> 今天
    public static final String FIND_TODAY = "http://api.maoyan.com/sns/v5/feed.json?";
    //发现 -> 今天 -> 点击详情
    public static final String TODAY_DETAIL = "http://m.maoyan.com/information/";
    //发现 -> 今天 -> 点击详情(另一种)
    public static final String TODAY_DETAIL_ELSE = "http://m.maoyan.com/topic/";
    //post请求都有的 url (不确定 先这样写)
    public static final String BASE_POST_URL = "http://api.mobile.meituan.com/combo/v2/combo.json";
    //周边商城 上面十个按钮
    public static final String STORE_TOP = "http://api.maoyan.com/mallpro/category.json";
    //周边商城 每月特价
    public static final String STORE_MONTH_DISCOUNT = "http://api.maoyan.com/mallpro/topicList.json";


    //电影 ->发现 ->快讯
    public static final String MOVIE_FIND_FAST_MSG = "http://m.maoyan.com/information?_v_=yes";
    //电影 ->发现 ->实时票房
    public static final String MOVIE_FIND_NOW = "http://piaofang.maoyan.com/?f=android&userid=-1";
    //电影 ->发现 ->TOP10
    public static final String MOVIE_FIND_TOP10 = "http://m.maoyan.com/information?_v_=yes&groupId=1481354&pageType=1&title=今日TOP10";
    //电影 ->发现 ->找片 -> 类型/地区/年代
    public static final String MOVIE_FIND_TYPE_WHERE_WHEN = "http://api.maoyan.com/mmdb/search/movie/tag/types.json?";
    //电影 ->发现 ->找片 -> 热映口碑等四个
    public static final String MOVIE_FIND_CENTER = "http://api.maoyan.com/mmdb/movieboard/fixedboard/v1/hot/list.json?";
    //电影 ->发现 ->找片 -> 全球电影奖项
    public static final String MOVIE_FIND_ALL_PRIZE = "http://api.maoyan.com/mmdb/movie/winning/film/2016-11-21/list.json?";
    //电影 ->发现 ->找片 ->全部电影奖项
    public static final String MOVIE_FIND_ALL_PRIZE_BODY = "http://api.maoyan.com/mmdb/movie/region/festival/list.json?";

    // 根据经纬度获取城市的名字
    public static final String LOCATION_LONGITUDE_LATITUDE = "http://api.avatardata.cn/CoordAddress/Lookup?key=b43534b71d1c4e18b935d548949205ba&";
    // 获取天气状况
    public static final String WEATHER_INFO = "http://api.avatardata.cn/Weather/Query?key=332e124a609c4e8ebcb1493a380ff48a&cityname=";
    // 热门搜索
    public static final String HOT_SEARCH = "http://api.maoyan.com/mmdb/search/movie/hotmovie/list.json?tp=4&keyword=&limit=0&offset=0&cityId=";
    // 搜索框
    public static final String SEARCH_KEY = "http://api.maoyan.com/mmdb/search/integrated/keyword/list.json?almtype=1&stype=-1&refer=1&iscorrected=false&limit=10&offset=0&ci=20&keyword=";

}
