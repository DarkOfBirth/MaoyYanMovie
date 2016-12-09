package lanou.maoyanmovie.tools;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import lanou.maoyanmovie.R;

/**
 * Created by Chen fengYao on 2015/8/5.
 * 用于展示Loading图
 */
public class MainLoadingDialogFragment extends DialogFragment implements View.OnClickListener {
    //    private LoadingView loadingView;
    private TextView loadFailedTv;//用于显示loading时的文字
    View view;
    private ImageView mImg;
    private RotateAnimation ra;
    private MyNoOrderBroadCast mCast;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new BitmapDrawable());
        this.setCancelable(false);

        view = inflater.inflate(R.layout.dialog_main_loading, container, false);
        mImg = (ImageView) view.findViewById(R.id.loading_img);
        ImageView imgWrite = (ImageView) view.findViewById(R.id.img_test);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.wriet);
        CircleDrawable drawable = new CircleDrawable(bitmap);
        imgWrite.setImageDrawable(drawable);

        loadFailedTv = (TextView) view.findViewById(R.id.tv_load_failed);
        startAnim();

        //注册接收器
        mCast = new MyNoOrderBroadCast();
        IntentFilter filter = new IntentFilter();
        filter.addAction("Hello");
        getActivity().registerReceiver(mCast, filter);

        Log.d("zzz", "第一次走这个方法");
        return view;
    }


    //开启动画
    public void startAnim() {
        ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setInterpolator(new Interpolator() {
            @Override
            public float getInterpolation(float input) {
                return input;
            }
        });
        ra.setInterpolator(new Interpolator() {
            @Override
            public float getInterpolation(float input) {
                return input;
            }
        });
        //设置播放时间
        ra.setDuration(1000);
        //设置重复次数
        ra.setRepeatCount(30);
        //动画重复播放的模式
        ra.setRepeatMode(Animation.RESTART);
        //动画播放完毕后，组件停留在动画结束的位置上
        ra.setFillAfter(true);
        mImg.startAnimation(ra);
    }

    @Override
    public void onClick(View v) {

    }

    class MyNoOrderBroadCast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            //参数intent, 就是无序广播携带值得intent
            String text = intent.getStringExtra("text");
            Log.d("zzz", "接到了广播");
            if (text != null){
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.remove(MainLoadingDialogFragment.this);
                transaction.commit();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(mCast);
    }
}

