package lanou.maoyanmovie.tools;

/**
 * Created by dllo on 16/11/21.
 */

public class MovieValues {

    //发现 -> 周边商城 -> 您可能喜欢
    public static final String STORE_LIKE = "http://api.maoyan.com/mallpro/recommended.json?";
    //发现 -> 上面四个图标
    public static final String FIND_TOP = "http://api.maoyan.com/sns/v2/buttons.json?utm_term=7.5.0&utm_medium=android";
    //发现 -> 今天
    public static final String FIND_TODAY = "http://api.maoyan.com/sns/v5/feed.json?";
    //发现 -> 今天 -> 点击详情
    public static final String TODAY_DETAIL = "http://m.maoyan.com/information/";
    //post请求都有的 url (不确定 先这样写)
    public static final String BASE_POST_URL = "http://api.mobile.meituan.com/combo/v2/combo.json";
    //周边商城 上面十个按钮
    public static  final String STORE_TOP = "http://api.maoyan.com/mallpro/category.json";
    //周边商城 每月特价
    public static final String STORE_MONTH_DISCOUNT = "http://api.maoyan.com/mallpro/topicList.json";



}
