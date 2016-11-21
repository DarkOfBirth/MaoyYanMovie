package lanou.maoyanmovie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpUtil.getStoreLike(1, 10, new ResponseCallBack() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onResponse(Object o) {

            }
        });
    }
}
