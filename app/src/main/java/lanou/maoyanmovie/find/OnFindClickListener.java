package lanou.maoyanmovie.find;

/**
 * Created by wangYe on 16/11/24.
 */

public interface OnFindClickListener {
//    String nickName;
//    int time;
//    String urlImg;
//    String title;
//    int targetId;
//    int feedType;
    void findClick(int targetID, int feedType, String nickName, String urlImg, String title);
    void findTopClick(String name);
}
