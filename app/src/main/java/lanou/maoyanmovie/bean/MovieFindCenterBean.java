package lanou.maoyanmovie.bean;

import java.util.List;

/**
 * Created by wangYe on 16/12/1.
 */

public class MovieFindCenterBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * boardId : 7
         * boardName : 热映口碑
         * movieId : 246222
         * movieImgs : ["http://p1.meituan.net/w.h/movie/dd600d0f054b234402edc3a93cd21da7133550.jpeg","http://p0.meituan.net/w.h/movie/e17eb219908416b7ee3bf07c2dc295ac945415.jpg"]
         * movieName : 海洋奇缘
         * url : meituanmovie://www.meituan.com/movieBoard/detail?id=7&boardType=7&title=热映口碑榜单
         */

        private int boardId;
        private String boardName;
        private int movieId;
        private String movieName;
        private String url;
        private List<String> movieImgs;

        public int getBoardId() {
            return boardId;
        }

        public void setBoardId(int boardId) {
            this.boardId = boardId;
        }

        public String getBoardName() {
            return boardName;
        }

        public void setBoardName(String boardName) {
            this.boardName = boardName;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<String> getMovieImgs() {
            return movieImgs;
        }

        public void setMovieImgs(List<String> movieImgs) {
            this.movieImgs = movieImgs;
        }
    }
}
