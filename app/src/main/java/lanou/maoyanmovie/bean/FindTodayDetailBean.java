package lanou.maoyanmovie.bean;

/**
 * Created by dllo on 16/11/21.
 */

public class FindTodayDetailBean {

    /**
     * news : {"commentCount":95,"created":1479718654000,"id":16642,"source":"猫眼电影","title":"一周口碑榜：《我不是潘金莲》成为华语年度最佳","type":0,"upCount":13,"url":"http://m.maoyan.com/information/16642?_v_=yes","viewCount":5543}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentCount : 95
         * created : 1479718654000
         * id : 16642
         * source : 猫眼电影
         * title : 一周口碑榜：《我不是潘金莲》成为华语年度最佳
         * type : 0
         * upCount : 13
         * url : http://m.maoyan.com/information/16642?_v_=yes
         * viewCount : 5543
         */

        private NewsBean news;

        public NewsBean getNews() {
            return news;
        }

        public void setNews(NewsBean news) {
            this.news = news;
        }

        public static class NewsBean {
            private int commentCount;
            private long created;
            private int id;
            private String source;
            private String title;
            private int type;
            private int upCount;
            private String url;
            private int viewCount;

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public long getCreated() {
                return created;
            }

            public void setCreated(long created) {
                this.created = created;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUpCount() {
                return upCount;
            }

            public void setUpCount(int upCount) {
                this.upCount = upCount;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getViewCount() {
                return viewCount;
            }

            public void setViewCount(int viewCount) {
                this.viewCount = viewCount;
            }
        }
    }
}
