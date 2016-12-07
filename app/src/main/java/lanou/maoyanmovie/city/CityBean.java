package lanou.maoyanmovie.city;

import java.util.List;

/**
 * reated by 王一鸣 16/11/24.
 * 功能:
 */

public class CityBean{

    /**
     * id : 1
     * nm : 北京
     * py : beijing
     */

    private List<CtsBean> cts;

    public List<CtsBean> getCts() {
        return cts;
    }

    public void setCts(List<CtsBean> cts) {
        this.cts = cts;
    }

    public static class CtsBean {
        private int id;
        private String nm;
        private String py;
        private String firstLetter;

        public String getFirstLetter() {
            return firstLetter;
        }

        public void setFirstLetter(String firstLetter) {
            this.firstLetter = firstLetter;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNm() {
            return nm;
        }

        public void setNm(String nm) {
            this.nm = nm;
        }

        public String getPy() {
            return py;
        }

        public void setPy(String py) {
            this.py = py;
        }
    }
}
