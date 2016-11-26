package lanou.maoyanmovie.bean;

import java.util.List;

/**
 * Created by 麦建东 on 16/11/24.
 */

public class MovieHotListBean {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String stid;
        private int total;
        private List<?> coming;
        private List<HotBean> hot;
        private List<Integer> movieIds;
        private List<StidsBean> stids;

        public String getStid() {
            return stid;
        }

        public void setStid(String stid) {
            this.stid = stid;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<?> getComing() {
            return coming;
        }

        public void setComing(List<?> coming) {
            this.coming = coming;
        }

        public List<HotBean> getHot() {
            return hot;
        }

        public void setHot(List<HotBean> hot) {
            this.hot = hot;
        }

        public List<Integer> getMovieIds() {
            return movieIds;
        }

        public void setMovieIds(List<Integer> movieIds) {
            this.movieIds = movieIds;
        }

        public List<StidsBean> getStids() {
            return stids;
        }

        public void setStids(List<StidsBean> stids) {
            this.stids = stids;
        }

        public static class HotBean {
            private String boxInfo;
            private String cat;
            private int civilPubSt;
            private String desc;
            private String dir;
            private int dur;
            private int effectShowNum;
            private String fra;
            private String frt;
            private boolean globalReleased;
            private boolean headLineShow;
            private int id;
            private String img;
            private boolean late;
            private int localPubSt;
            private float mk;
            private String nm;
            private int pn;
            private int preSale;
            private boolean preShow;
            private float proScore;
            private int proScoreNum;
            private long pubDate;
            private int pubShowNum;
            private long recentShowDate;
            private int recentShowNum;
            private String rt;
            private float sc;
            private String scm;
            private String showInfo;
            private int showNum;
            private String showTimeInfo;
            private int showst;
            private int snum;
            private String star;
            private int totalShowNum;
            private String ver;
            private int videoId;
            private String videoName;
            private String videourl;
            private int vnum;
            private int weight;
            private int wish;
            private int wishst;
            private List<?> headLines;
            private List<HeadLinesVOBean> headLinesVO;
            private List<NewsHeadlinesBean> newsHeadlines;

            public String getBoxInfo() {
                return boxInfo;
            }

            public void setBoxInfo(String boxInfo) {
                this.boxInfo = boxInfo;
            }

            public String getCat() {
                return cat;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public int getCivilPubSt() {
                return civilPubSt;
            }

            public void setCivilPubSt(int civilPubSt) {
                this.civilPubSt = civilPubSt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public int getDur() {
                return dur;
            }

            public void setDur(int dur) {
                this.dur = dur;
            }

            public int getEffectShowNum() {
                return effectShowNum;
            }

            public void setEffectShowNum(int effectShowNum) {
                this.effectShowNum = effectShowNum;
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

            public boolean isHeadLineShow() {
                return headLineShow;
            }

            public void setHeadLineShow(boolean headLineShow) {
                this.headLineShow = headLineShow;
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

            public boolean isLate() {
                return late;
            }

            public void setLate(boolean late) {
                this.late = late;
            }

            public int getLocalPubSt() {
                return localPubSt;
            }

            public void setLocalPubSt(int localPubSt) {
                this.localPubSt = localPubSt;
            }

            public float getMk() {
                return mk;
            }

            public void setMk(float mk) {
                this.mk = mk;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getPn() {
                return pn;
            }

            public void setPn(int pn) {
                this.pn = pn;
            }

            public int getPreSale() {
                return preSale;
            }

            public void setPreSale(int preSale) {
                this.preSale = preSale;
            }

            public boolean isPreShow() {
                return preShow;
            }

            public void setPreShow(boolean preShow) {
                this.preShow = preShow;
            }

            public float getProScore() {
                return proScore;
            }

            public void setProScore(float proScore) {
                this.proScore = proScore;
            }

            public int getProScoreNum() {
                return proScoreNum;
            }

            public void setProScoreNum(int proScoreNum) {
                this.proScoreNum = proScoreNum;
            }

            public long getPubDate() {
                return pubDate;
            }

            public void setPubDate(long pubDate) {
                this.pubDate = pubDate;
            }

            public int getPubShowNum() {
                return pubShowNum;
            }

            public void setPubShowNum(int pubShowNum) {
                this.pubShowNum = pubShowNum;
            }

            public long getRecentShowDate() {
                return recentShowDate;
            }

            public void setRecentShowDate(long recentShowDate) {
                this.recentShowDate = recentShowDate;
            }

            public int getRecentShowNum() {
                return recentShowNum;
            }

            public void setRecentShowNum(int recentShowNum) {
                this.recentShowNum = recentShowNum;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public float getSc() {
                return sc;
            }

            public void setSc(float sc) {
                this.sc = sc;
            }

            public String getScm() {
                return scm;
            }

            public void setScm(String scm) {
                this.scm = scm;
            }

            public String getShowInfo() {
                return showInfo;
            }

            public void setShowInfo(String showInfo) {
                this.showInfo = showInfo;
            }

            public int getShowNum() {
                return showNum;
            }

            public void setShowNum(int showNum) {
                this.showNum = showNum;
            }

            public String getShowTimeInfo() {
                return showTimeInfo;
            }

            public void setShowTimeInfo(String showTimeInfo) {
                this.showTimeInfo = showTimeInfo;
            }

            public int getShowst() {
                return showst;
            }

            public void setShowst(int showst) {
                this.showst = showst;
            }

            public int getSnum() {
                return snum;
            }

            public void setSnum(int snum) {
                this.snum = snum;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public int getTotalShowNum() {
                return totalShowNum;
            }

            public void setTotalShowNum(int totalShowNum) {
                this.totalShowNum = totalShowNum;
            }

            public String getVer() {
                return ver;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public int getVideoId() {
                return videoId;
            }

            public void setVideoId(int videoId) {
                this.videoId = videoId;
            }

            public String getVideoName() {
                return videoName;
            }

            public void setVideoName(String videoName) {
                this.videoName = videoName;
            }

            public String getVideourl() {
                return videourl;
            }

            public void setVideourl(String videourl) {
                this.videourl = videourl;
            }

            public int getVnum() {
                return vnum;
            }

            public void setVnum(int vnum) {
                this.vnum = vnum;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
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

            public List<?> getHeadLines() {
                return headLines;
            }

            public void setHeadLines(List<?> headLines) {
                this.headLines = headLines;
            }

            public List<HeadLinesVOBean> getHeadLinesVO() {
                return headLinesVO;
            }

            public void setHeadLinesVO(List<HeadLinesVOBean> headLinesVO) {
                this.headLinesVO = headLinesVO;
            }

            public List<NewsHeadlinesBean> getNewsHeadlines() {
                return newsHeadlines;
            }

            public void setNewsHeadlines(List<NewsHeadlinesBean> newsHeadlines) {
                this.newsHeadlines = newsHeadlines;
            }

            public static class HeadLinesVOBean {
                private int movieId;
                private String title;
                private String type;
                private String url;

                public int getMovieId() {
                    return movieId;
                }

                public void setMovieId(int movieId) {
                    this.movieId = movieId;
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

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }

            public static class NewsHeadlinesBean {
                private int movieId;
                private String title;
                private String type;
                private String url;

                public int getMovieId() {
                    return movieId;
                }

                public void setMovieId(int movieId) {
                    this.movieId = movieId;
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

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class StidsBean {
            private int movieId;
            private String stid;

            public int getMovieId() {
                return movieId;
            }

            public void setMovieId(int movieId) {
                this.movieId = movieId;
            }

            public String getStid() {
                return stid;
            }

            public void setStid(String stid) {
                this.stid = stid;
            }
        }
    }
}
