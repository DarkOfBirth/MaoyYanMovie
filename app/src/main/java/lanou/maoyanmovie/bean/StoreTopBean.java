package lanou.maoyanmovie.bean;

import java.util.List;

/**
 * Created by dllo on 16/11/21.
 */

public class StoreTopBean {

    /**
     * list : [{"addTime":1449026449,"categoryType":0,"id":400000020,"modTime":1453706324,"order":1,"pic":"http://p0.meituan.net/movie/3927505f6e8c7e740895fad9151cf8791187.png","status":0,"title":"数码"},{"addTime":1449026449,"categoryType":0,"id":400000019,"modTime":1453706345,"order":2,"pic":"http://p0.meituan.net/movie/d7f7f302886e7a05f45c60e17b6132d71159.png","status":0,"title":"高玩专区"},{"addTime":1449026449,"categoryType":0,"id":400000021,"modTime":1479104060,"order":3,"pic":"http://p0.meituan.net/movie/25824cfe9bf15f96d9d50d4c636f4e4d1566.png","status":0,"title":"玩具"},{"addTime":1449026449,"categoryType":0,"id":400000023,"modTime":1453706334,"order":4,"pic":"http://p1.meituan.net/movie/c85dbaa1756bd8a674e97e48021ccbb61232.png","status":0,"title":"生活"},{"addTime":1449026449,"categoryType":0,"id":400000022,"modTime":1449653148,"order":5,"pic":"http://p0.meituan.net/movie/80a6e99b95e6a00a97514d818e2aaf7a1368.png","status":0,"title":"服饰"},{"addTime":1458012468,"categoryType":1,"id":400000102,"modTime":1458724329,"order":6,"pic":"http://p0.meituan.net/movie/8d89f0cfb07fabf2491690994796db6a4636.png@60q","status":0,"title":"超蝙"},{"addTime":1449026448,"categoryType":1,"id":400000015,"modTime":1461034266,"order":7,"pic":"http://p1.meituan.net/movie/f186269e1d914232cc777e0eb924df461556.png","status":0,"title":"机器猫"},{"addTime":1461725725,"categoryType":1,"id":400000103,"modTime":1464159227,"order":8,"pic":"http://p1.meituan.net/movie/e1de20b5673c9504db1924e933b837ed5416.png@60q","status":0,"title":"魔兽"},{"addTime":1449026448,"categoryType":1,"id":400000016,"modTime":1462356534,"order":9,"pic":"http://p1.meituan.net/movie/75be51d4d115af2715b7bdd55f2180cd3888.png@60q","status":0,"title":"美队"},{"addTime":1449026449,"categoryType":1,"id":400000018,"modTime":1458724342,"order":10,"pic":"http://p1.meituan.net/movie/9d3027ca5f44ec1d2b753f7d033159a71959.png","status":0,"title":"星球大战"},{"addTime":1452656649,"categoryType":1,"id":400000098,"modTime":1461034286,"order":11,"pic":"http://p1.meituan.net/movie/64c785180caba83ed973e6eeb9aa56f93700.jpg@60q","status":0,"title":"功夫熊猫"},{"addTime":1449026448,"categoryType":1,"id":400000017,"modTime":1451034012,"order":11,"pic":"http://p1.meituan.net/movie/bdcd19f74da97ece1f53f4e7ecf679452196.png","status":0,"title":"变形金刚"},{"addTime":1449026450,"categoryType":1,"id":400000024,"modTime":1449026450,"order":11,"pic":"http://p1.meituan.net/movie/d1b592e6ce042e5e0853992f0fbe50ea1569.png","status":0,"title":"其他主题"},{"addTime":1449026450,"categoryType":1,"id":400000025,"modTime":1449026450,"order":12,"pic":"http://p1.meituan.net/movie/d1b592e6ce042e5e0853992f0fbe50ea1569.png","status":0,"title":"超人"},{"addTime":1449026450,"categoryType":1,"id":400000026,"modTime":1449026450,"order":13,"pic":"http://p1.meituan.net/movie/d1b592e6ce042e5e0853992f0fbe50ea1569.png","status":0,"title":"迪士尼"},{"addTime":1449026450,"categoryType":1,"id":400000027,"modTime":1449026450,"order":14,"pic":"http://p1.meituan.net/movie/d1b592e6ce042e5e0853992f0fbe50ea1569.png","status":0,"title":"钢铁侠"},{"addTime":1449026450,"categoryType":1,"id":400000028,"modTime":1449026450,"order":15,"pic":"http://p1.meituan.net/movie/d1b592e6ce042e5e0853992f0fbe50ea1569.png","status":0,"title":"史努比"},{"addTime":1451034001,"categoryType":1,"id":400000090,"modTime":1458724261,"order":999,"pic":"http://p0.meituan.net/movie/4d3c6864a1ec58f6516eb5ff88ebb6fc3810.png","status":0,"title":"大圣"},{"addTime":1452504311,"categoryType":0,"id":400000092,"modTime":1458118877,"order":999,"pic":"http://p0.meituan.net/movie/6407abd59799ebd0dca1784708c6daa05332.png@60q","status":0,"title":"3C配件"},{"addTime":1455597849,"categoryType":1,"id":400000101,"modTime":1455597849,"order":999,"pic":"http://p0.meituan.net/movie/e36a57efe0d46fd2aa49ba14b76c105e1975.png@60q","status":0,"title":"日漫"},{"addTime":1453199550,"categoryType":0,"id":400000100,"modTime":1453199550,"order":999,"pic":"http://p0.meituan.net/movie/e36a57efe0d46fd2aa49ba14b76c105e1975.png@60q","status":0,"title":"箱包"},{"addTime":1453199133,"categoryType":0,"id":400000099,"modTime":1453199133,"order":999,"pic":"http://p0.meituan.net/movie/e36a57efe0d46fd2aa49ba14b76c105e1975.png@60q","status":0,"title":"手办公仔"},{"addTime":1452506256,"categoryType":1,"id":400000097,"modTime":1452506437,"order":999,"pic":"http://p0.meituan.net/movie/6407abd59799ebd0dca1784708c6daa05332.png@60q","status":0,"title":"大白"},{"addTime":1452505327,"categoryType":0,"id":400000096,"modTime":1452505327,"order":999,"pic":"http://p0.meituan.net/movie/6407abd59799ebd0dca1784708c6daa05332.png@60q","status":0,"title":"电影原著"},{"addTime":1452504938,"categoryType":0,"id":400000095,"modTime":1452504938,"order":999,"pic":"http://p0.meituan.net/movie/6407abd59799ebd0dca1784708c6daa05332.png@60q","status":0,"title":"配饰"},{"addTime":1452504796,"categoryType":0,"id":400000094,"modTime":1452504796,"order":999,"pic":"http://p0.meituan.net/movie/6407abd59799ebd0dca1784708c6daa05332.png@60q","status":0,"title":"家纺"},{"addTime":1452504375,"categoryType":0,"id":400000093,"modTime":1452504375,"order":999,"pic":"http://p0.meituan.net/movie/6407abd59799ebd0dca1784708c6daa05332.png@60q","status":0,"title":"文具"},{"addTime":1452503946,"categoryType":0,"id":400000091,"modTime":1452504271,"order":999,"pic":"http://p0.meituan.net/movie/6407abd59799ebd0dca1784708c6daa05332.png@60q","status":0,"title":"毛绒公仔"},{"addTime":1449026448,"categoryType":1,"id":400000014,"modTime":1464159216,"order":9999,"pic":"http://p0.meituan.net/movie/3cfea2c832153632bb21126080ca3ee91738.png","status":0,"title":"小黄人"}]
     * total : 29
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int total;
        /**
         * addTime : 1449026449
         * categoryType : 0
         * id : 400000020
         * modTime : 1453706324
         * order : 1
         * pic : http://p0.meituan.net/movie/3927505f6e8c7e740895fad9151cf8791187.png
         * status : 0
         * title : 数码
         */

        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private int addTime;
            private int categoryType;
            private int id;
            private int modTime;
            private int order;
            private String pic;
            private int status;
            private String title;

            public int getAddTime() {
                return addTime;
            }

            public void setAddTime(int addTime) {
                this.addTime = addTime;
            }

            public int getCategoryType() {
                return categoryType;
            }

            public void setCategoryType(int categoryType) {
                this.categoryType = categoryType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getModTime() {
                return modTime;
            }

            public void setModTime(int modTime) {
                this.modTime = modTime;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}

