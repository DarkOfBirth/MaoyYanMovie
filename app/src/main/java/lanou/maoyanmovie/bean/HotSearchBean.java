package lanou.maoyanmovie.bean;

import java.util.List;

/**
 * created by 王一鸣 16/12/6.
 * 功能:
 */

public class HotSearchBean {

    /**
     * data : [{"cat":"动作,恐怖,冒险","dur":0,"enm":"The Mummy","fra":"美国","frt":"2017-06-09","globalReleased":false,"id":249895,"img":"http://p0.meituan.net/w.h/movie/9199538b976e9673d2fa420f31ce19eb920925.jpg","movieType":0,"nm":"新木乃伊","onlinePlay":false,"pubDesc":"2017-06-09美国上映","sc":0,"show":"","showst":1,"type":0,"ver":"2D","wish":2126,"wishst":0},{"cat":"剧情,爱情,动画","dur":107,"enm":"君の名は。","fra":"日本","frt":"2016-08-26","globalReleased":true,"id":344881,"img":"http://p0.meituan.net/w.h/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg","movieType":0,"nm":"你的名字。","onlinePlay":false,"pubDesc":"2016-12-02大陆上映","rt":"2016-12-02","sc":9.4,"show":"","showst":3,"type":0,"ver":"2D","wish":277114,"wishst":0},{"cat":"剧情,喜剧","dur":95,"enm":"Pure Hearts：Into Chinese Showbiz","globalReleased":false,"id":340946,"img":"http://p0.meituan.net/w.h/movie/ad48eec319582068c14f3b391d70782c106705.jpeg","movieType":0,"nm":"纯洁心灵·逐梦演艺圈","onlinePlay":false,"pubDesc":"2017-02-17大陆上映","rt":"2017-02-17","sc":0,"show":"","showst":1,"type":0,"ver":"2D","wish":54082,"wishst":0},{"cat":"动作,冒险,奇幻","dur":115,"enm":"Doctor Strange","fra":"美国","frt":"2016-11-04","globalReleased":true,"id":246124,"img":"http://p1.meituan.net/w.h/movie/aa492b57443fc95a5b3b46c459d59e50898549.jpg","movieType":0,"nm":"奇异博士","onlinePlay":false,"pubDesc":"2016-11-04大陆上映","rt":"2016-11-04","sc":9,"show":"","showst":2,"type":0,"ver":"3D/IMAX 3D/中国巨幕/全景声","wish":205273,"wishst":0},{"cat":"动作,科幻","dur":0,"enm":"Guardians of the Galaxy Volume 2","fra":"美国","frt":"2017-05-05","globalReleased":false,"id":248683,"img":"http://p0.meituan.net/w.h/movie/b7689709e044baace0b544bfa6cbda3e192518.jpg","movieType":0,"nm":"银河护卫队2","onlinePlay":false,"pubDesc":"2017-05-05美国上映","sc":0,"show":"","showst":1,"type":0,"ver":"2D","wish":16691,"wishst":0},{"cat":"恐怖,惊悚,悬疑","dur":0,"enm":"Mystery Zone:Soul Eating Hill","globalReleased":false,"id":346464,"img":"http://p0.meituan.net/w.h/movie/2af851bd4c5103ec8fe6d39e84679a34735139.jpg","movieType":0,"nm":"谜域之噬魂岭","onlinePlay":false,"pubDesc":"2017-02-01大陆上映","rt":"2017-02-01","sc":0,"show":"","showst":1,"type":0,"ver":"2D","wish":22570,"wishst":0},{"cat":"剧情,喜剧","dur":140,"enm":"I Am Not Madame Bovary","fra":"多伦多国际电影节","frt":"2016-09-08","globalReleased":true,"id":341749,"img":"http://p1.meituan.net/w.h/movie/8e5eabeadf237a10227a3124419410ef549583.jpg","movieType":0,"nm":"我不是潘金莲","onlinePlay":false,"pubDesc":"2016-11-18大陆上映","rt":"2016-11-18","sc":7.9,"show":"","showst":3,"type":0,"ver":"2D/中国巨幕/全景声","wish":185572,"wishst":0},{"cat":"喜剧,动作,冒险","dur":0,"enm":"Buddies in India","globalReleased":false,"id":248935,"img":"http://p0.meituan.net/w.h/movie/ea67816f455239cd93f22e462d14dadc173993.jpg","movieType":0,"nm":"大闹天竺","onlinePlay":false,"pubDesc":"2017-01-28大陆上映","rt":"2017-01-28","sc":0,"show":"","showst":1,"type":0,"ver":"2D","wish":133454,"wishst":0},{"cat":"喜剧,爱情","dur":0,"enm":"See You Tomorrow","globalReleased":false,"id":246388,"img":"http://p1.meituan.net/w.h/movie/7f41742a5c2ea24fcd2018ad333451ae193120.jpg","movieType":0,"nm":"摆渡人","onlinePlay":false,"pubDesc":"2016-12-23大陆上映","rt":"2016-12-23","sc":0,"show":"","showst":1,"type":0,"ver":"2D","wish":139581,"wishst":0},{"cat":"纪录片","dur":0,"enm":"Masters in the Forbidden City","globalReleased":false,"id":1196913,"img":"http://p0.meituan.net/w.h/movie/8c4e2707c513bfc598d3111463572e52160440.jpg","movieType":0,"nm":"我在故宫修文物","onlinePlay":false,"pubDesc":"2016-12-16大陆上映","rt":"2016-12-16","sc":0,"show":"","showst":1,"type":0,"ver":"2D","wish":12190,"wishst":0}]
     * total : 10
     */

    private int total;
    /**
     * cat : 动作,恐怖,冒险
     * dur : 0
     * enm : The Mummy
     * fra : 美国
     * frt : 2017-06-09
     * globalReleased : false
     * id : 249895
     * img : http://p0.meituan.net/w.h/movie/9199538b976e9673d2fa420f31ce19eb920925.jpg
     * movieType : 0
     * nm : 新木乃伊
     * onlinePlay : false
     * pubDesc : 2017-06-09美国上映
     * sc : 0
     * show :
     * showst : 1
     * type : 0
     * ver : 2D
     * wish : 2126
     * wishst : 0
     */

    private List<DataBean> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
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
        private String sc;
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

        public String getSc() {
            return sc;
        }

        public void setSc(String sc) {
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
