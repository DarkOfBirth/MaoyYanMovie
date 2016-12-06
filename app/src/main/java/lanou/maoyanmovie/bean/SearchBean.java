package lanou.maoyanmovie.bean;

import java.util.List;

/**
 * created by 王一鸣 16/12/6.
 * 功能:
 */

public class SearchBean {
    /**
     * data : [{"list":[{"cat":"剧情,爱情,动画","dur":107,"enm":"君の名は。","fra":"日本","frt":"2016-08-26","globalReleased":true,"id":344881,"img":"http://p0.meituan.net/w.h/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg","movieType":0,"nm":"你的名字。","onlinePlay":false,"pubDesc":"2016-12-02大陆上映","rt":"2016-12-02","sc":9.4,"show":"","showst":3,"type":0,"ver":"2D","wish":277114,"wishst":0},{"cat":"爱情,悬疑,犯罪","dur":0,"enm":"Cherry Retures","globalReleased":false,"id":1187526,"img":"http://p1.meituan.net/w.h/movie/76e1ffa117c407637b2443b4f583ecad826883.jpg","movieType":0,"nm":"那年夏天你去了哪里","onlinePlay":false,"pubDesc":"2016-12-30大陆上映","rt":"2016-12-30","sc":0,"show":"","showst":4,"type":0,"ver":"2D","wish":36239,"wishst":0},{"cat":"剧情,喜剧,爱情","dur":113,"enm":"I Belonged to You","globalReleased":true,"id":246390,"img":"http://p1.meituan.net/w.h/movie/7c81af730b119bc04087df7cf2c88f0c310212.png","movieType":0,"nm":"从你的全世界路过","onlinePlay":false,"pubDesc":"2016-09-29大陆上映","rt":"2016-09-29","sc":8.6,"show":"","showst":2,"type":0,"ver":"2D/中国巨幕","wish":240303,"wishst":0}],"total":25940,"type":0},{"list":[{"enm":"Johnny Depp","followCount":3385,"followState":0,"id":29094,"img":"http://p1.meituan.net/w.h/movie/3a97e021e00e7ddb4b68ac5c0ffa78da49283.jpg","nm":"约翰尼·德普","representative":"《加勒比海盗》 《剪刀手爱德华》 《查理和巧克力工厂》","type":1}],"total":17900,"type":1},{"list":[{"addr":"荔湾区芳村大道西塞坝路芳雅苑15号","allowRefund":0,"allowRefundTime":0,"brdId":0,"closeStatus":0,"deal":1,"dealPrice":"33.0","distance":12383.7,"endorse":0,"exclusive":0,"follow":0,"giftDesc":"","giftInfo":{"desc":"","hasGift":0,"isShow":0},"hasGift":0,"id":5968,"imax":0,"isMerchantActivity":0,"isPlatformActivity":0,"lat":23.108416,"lng":113.2177,"nm":"香凝影剧院","poiId":1730691,"preferential":0,"referencePrice":"0.0","sell":false,"sellPrice":"0.0","showGiftTag":0,"snack":0,"type":0,"vipDesc":"","vipInfo":{"isSupport":0,"vipDesc":""}}],"total":1,"type":2}]
     * correction :
     * correctionV2 :
     * correctionType : -1
     * algotype : 1
     * facetList : []
     */

    private String correction;
    private String correctionV2;
    private int correctionType;
    private int algotype;
    /**
     * list : [{"cat":"剧情,爱情,动画","dur":107,"enm":"君の名は。","fra":"日本","frt":"2016-08-26","globalReleased":true,"id":344881,"img":"http://p0.meituan.net/w.h/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg","movieType":0,"nm":"你的名字。","onlinePlay":false,"pubDesc":"2016-12-02大陆上映","rt":"2016-12-02","sc":9.4,"show":"","showst":3,"type":0,"ver":"2D","wish":277114,"wishst":0},{"cat":"爱情,悬疑,犯罪","dur":0,"enm":"Cherry Retures","globalReleased":false,"id":1187526,"img":"http://p1.meituan.net/w.h/movie/76e1ffa117c407637b2443b4f583ecad826883.jpg","movieType":0,"nm":"那年夏天你去了哪里","onlinePlay":false,"pubDesc":"2016-12-30大陆上映","rt":"2016-12-30","sc":0,"show":"","showst":4,"type":0,"ver":"2D","wish":36239,"wishst":0},{"cat":"剧情,喜剧,爱情","dur":113,"enm":"I Belonged to You","globalReleased":true,"id":246390,"img":"http://p1.meituan.net/w.h/movie/7c81af730b119bc04087df7cf2c88f0c310212.png","movieType":0,"nm":"从你的全世界路过","onlinePlay":false,"pubDesc":"2016-09-29大陆上映","rt":"2016-09-29","sc":8.6,"show":"","showst":2,"type":0,"ver":"2D/中国巨幕","wish":240303,"wishst":0}]
     * total : 25940
     * type : 0
     */

    private List<DataBean> data;
    private List<?> facetList;

    public String getCorrection() {
        return correction;
    }

    public void setCorrection(String correction) {
        this.correction = correction;
    }

    public String getCorrectionV2() {
        return correctionV2;
    }

    public void setCorrectionV2(String correctionV2) {
        this.correctionV2 = correctionV2;
    }

    public int getCorrectionType() {
        return correctionType;
    }

    public void setCorrectionType(int correctionType) {
        this.correctionType = correctionType;
    }

    public int getAlgotype() {
        return algotype;
    }

    public void setAlgotype(int algotype) {
        this.algotype = algotype;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<?> getFacetList() {
        return facetList;
    }

    public void setFacetList(List<?> facetList) {
        this.facetList = facetList;
    }

    public static class DataBean {
        private int total;
        private int type;
        /**
         * cat : 剧情,爱情,动画
         * dur : 107
         * enm : 君の名は。
         * fra : 日本
         * frt : 2016-08-26
         * globalReleased : true
         * id : 344881
         * img : http://p0.meituan.net/w.h/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg
         * movieType : 0
         * nm : 你的名字。
         * onlinePlay : false
         * pubDesc : 2016-12-02大陆上映
         * rt : 2016-12-02
         * sc : 9.4
         * show :
         * showst : 3
         * type : 0
         * ver : 2D
         * wish : 277114
         * wishst : 0
         */

        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String cat;
            private int dur;
            private String enm;
            private String fra;
            private String frt;
            private boolean globalReleased;
            private int id;
            private String img;
            private int movieType;
            private String nm;
            private boolean onlinePlay;
            private String pubDesc;
            private String rt;
            private double sc;
            private String show;
            private int showst;
            private int type;
            private String ver;
            private int wish;
            private int wishst;

            public String getCat() {
                return cat;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public int getDur() {
                return dur;
            }

            public void setDur(int dur) {
                this.dur = dur;
            }

            public String getEnm() {
                return enm;
            }

            public void setEnm(String enm) {
                this.enm = enm;
            }

            public String getFra() {
                return fra;
            }

            public void setFra(String fra) {
                this.fra = fra;
            }

            public String getFrt() {
                return frt;
            }

            public void setFrt(String frt) {
                this.frt = frt;
            }

            public boolean isGlobalReleased() {
                return globalReleased;
            }

            public void setGlobalReleased(boolean globalReleased) {
                this.globalReleased = globalReleased;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getMovieType() {
                return movieType;
            }

            public void setMovieType(int movieType) {
                this.movieType = movieType;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public boolean isOnlinePlay() {
                return onlinePlay;
            }

            public void setOnlinePlay(boolean onlinePlay) {
                this.onlinePlay = onlinePlay;
            }

            public String getPubDesc() {
                return pubDesc;
            }

            public void setPubDesc(String pubDesc) {
                this.pubDesc = pubDesc;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public double getSc() {
                return sc;
            }

            public void setSc(double sc) {
                this.sc = sc;
            }

            public String getShow() {
                return show;
            }

            public void setShow(String show) {
                this.show = show;
            }

            public int getShowst() {
                return showst;
            }

            public void setShowst(int showst) {
                this.showst = showst;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getVer() {
                return ver;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public int getWish() {
                return wish;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }

            public int getWishst() {
                return wishst;
            }

            public void setWishst(int wishst) {
                this.wishst = wishst;
            }
        }
    }
}
