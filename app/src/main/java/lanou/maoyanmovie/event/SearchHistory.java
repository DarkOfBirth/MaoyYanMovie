package lanou.maoyanmovie.event;

/**
 * created by 王一鸣 16/12/6.
 * 功能:
 */

public class SearchHistory {
    String content;

    public String getContent() {
        return content;
    }

    public SearchHistory setContent(String content) {
        this.content = content;
        return this;
    }

    public SearchHistory(String content) {

        this.content = content;
    }
}
