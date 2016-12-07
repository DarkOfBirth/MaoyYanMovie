package lanou.maoyanmovie.bean;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

/**
 * created by 王一鸣 16/12/5.
 * 功能:
 */

public class HistoryBean {
    // 指定自增，每个对象需要有一个主键
    @PrimaryKey(AssignType.AUTO_INCREMENT)
   private int id;
    private String content;

    public HistoryBean(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public HistoryBean setContent(String content) {
        this.content = content;
        return this;
    }
}
