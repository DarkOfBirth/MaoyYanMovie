package lanou.maoyanmovie.bean;

import cn.bmob.v3.BmobUser;

/**
 * Created by 麦建东 on 16/12/3.
 * 对BmobUser类进行扩展，添加一些新的属性
 */

public class MyUser extends BmobUser {
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
