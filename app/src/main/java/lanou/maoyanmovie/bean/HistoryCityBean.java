package lanou.maoyanmovie.bean;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

/**
 * created by 王一鸣 16/12/9.
 * 功能:
 */

public class HistoryCityBean {
    // 指定自增，每个对象需要有一个主键
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;

    private String content;




    public HistoryCityBean(String content) {

        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public HistoryCityBean setContent(String content) {
        this.content = content;
        return this;
    }
}
