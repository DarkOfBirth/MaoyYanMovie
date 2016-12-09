package lanou.maoyanmovie;

import android.content.Intent;
import android.os.CountDownTimer;

import lanou.maoyanmovie.base.BaseActivity;

/**
 * Created by 麦建东 on 16/12/8.
 */
public class StartActivity extends BaseActivity {
    @Override
    protected int getLayout() {
        return R.layout.activity_start;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initData() {
        /**
         * CountDownTimer() : 计时器
         * 第一个参数 : 总时间
         * 第二个参数 : 间隔时间
         */
        CountDownTimer timer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer.start();
    }

    @Override
    protected void initClick() {

    }
}
