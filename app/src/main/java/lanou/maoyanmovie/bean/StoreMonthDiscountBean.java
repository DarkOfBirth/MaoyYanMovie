package lanou.maoyanmovie.bean;

import java.util.List;

/**
 * Created by dllo on 16/11/21.
 */

public class StoreMonthDiscountBean {

    /**
     * list : [{"deals":[{"desc":"口碑爆棚","listId":200000104,"pic":"http://p1.meituan.net/movie/066932ddb2c815c6d217a4cdaeb4184472640.png@60q","redirectUrl":"http://m.maoyan.com/store/topicDetail/200000104?_v_=yes","title":"奇异博士"},{"desc":"复古周边","listId":200000131,"pic":"http://p1.meituan.net/movie/08cc7cbc2be1412a62c3bf6d816de88c12522.png@60q","redirectUrl":"http://m.maoyan.com/store/topicDetail/200000131?_v_=yes","title":"神奇动物在哪里"},{"dealid":40184882,"desc":"电影小说","pic":"http://p1.meituan.net/movie/5ce448398b6e21c3add09c07be9bd09b11154.jpg@60q","title":"我不是潘金莲"}],"listId":0,"redirectUrl":"","title":"近期热门电影","type":"threePicEntry"},{"deals":[{"desc":"新品上市","listId":200000020,"pic":"http://p1.meituan.net/movie/a4689854f981e2fdcaac708849f2b57667896.png@60q","redirectUrl":"http://m.maoyan.com/store/topicDetail/200000020?_v_=yes","title":"疯狂动物城"},{"desc":"限量玩偶108元","listId":200000132,"pic":"http://p0.meituan.net/movie/8c89cf5e0ab4703ddfb45b676f8c0ee825977.png@60q","redirectUrl":"http://m.maoyan.com/store/topicDetail/200000132?_v_=yes","title":"勇士之门"},{"dealid":41745243,"desc":"漫长的中场休息","pic":"http://p0.meituan.net/movie/d4dceab481ab1ab1c14391c58116b28d14159.jpg@60q","title":"电影原著"}],"listId":0,"redirectUrl":"","title":"新品尝鲜","type":"threePicEntry"}]
     * total : 2
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
         * deals : [{"desc":"口碑爆棚","listId":200000104,"pic":"http://p1.meituan.net/movie/066932ddb2c815c6d217a4cdaeb4184472640.png@60q","redirectUrl":"http://m.maoyan.com/store/topicDetail/200000104?_v_=yes","title":"奇异博士"},{"desc":"复古周边","listId":200000131,"pic":"http://p1.meituan.net/movie/08cc7cbc2be1412a62c3bf6d816de88c12522.png@60q","redirectUrl":"http://m.maoyan.com/store/topicDetail/200000131?_v_=yes","title":"神奇动物在哪里"},{"dealid":40184882,"desc":"电影小说","pic":"http://p1.meituan.net/movie/5ce448398b6e21c3add09c07be9bd09b11154.jpg@60q","title":"我不是潘金莲"}]
         * listId : 0
         * redirectUrl :
         * title : 近期热门电影
         * type : threePicEntry
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
            private int listId;
            private String redirectUrl;
            private String title;
            private String type;
            /**
             * desc : 口碑爆棚
             * listId : 200000104
             * pic : http://p1.meituan.net/movie/066932ddb2c815c6d217a4cdaeb4184472640.png@60q
             * redirectUrl : http://m.maoyan.com/store/topicDetail/200000104?_v_=yes
             * title : 奇异博士
             */

            private List<DealsBean> deals;

            public int getListId() {
                return listId;
            }

            public void setListId(int listId) {
                this.listId = listId;
            }

            public String getRedirectUrl() {
                return redirectUrl;
            }

            public void setRedirectUrl(String redirectUrl) {
                this.redirectUrl = redirectUrl;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<DealsBean> getDeals() {
                return deals;
            }

            public void setDeals(List<DealsBean> deals) {
                this.deals = deals;
            }

            public static class DealsBean {
                private String desc;
                private int listId;
                private String pic;
                private String redirectUrl;
                private String title;

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public int getListId() {
                    return listId;
                }

                public void setListId(int listId) {
                    this.listId = listId;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getRedirectUrl() {
                    return redirectUrl;
                }

                public void setRedirectUrl(String redirectUrl) {
                    this.redirectUrl = redirectUrl;
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
}
