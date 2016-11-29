package lanou.maoyanmovie.find;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.tools.MovieValues;

/**
 * Created by wangYe on 16/11/24.
 */
public class DescriptionFragment extends BaseFragment implements View.OnClickListener {

    private WebView mFindWv;
    private String mUrlIntent;
    private ImageView descriptionBack;
    private TextView descriptionTitle;
    private ImageView descriptionCollect;
    private ImageView descriptionShare;
    private String mTitle;


    @Override
    protected int getLayout() {
        return R.layout.fragment_description;
    }

    @Override
    protected void initView() {
        mFindWv = bindView(R.id.find_description_wv);

        descriptionBack = bindView(R.id.description_back);
        descriptionTitle = bindView(R.id.description_title);
        descriptionCollect = bindView(R.id.description_collect);
        descriptionShare = bindView(R.id.description_share);

    }

    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        int targetId = bundle.getInt("targetID", -1);
        int feedType = bundle.getInt("feedType", -1);
        mTitle = bundle.getString("Title");
        descriptionTitle.setText(mTitle);
        if (feedType == 7){
            mUrlIntent = MovieValues.TODAY_DETAIL + targetId + "?_v_=yes";
        }else if (feedType == 2 || feedType == 10){
            mUrlIntent = "http://m.maoyan.com/topic/"+targetId+"?_v_=yes";
        }else if (mTitle.equals("今日TOP10")){
            mUrlIntent = "http://m.maoyan.com/information?_v_=yes&groupId=1481354&pageType=1&title=今日TOP10";
        }else if (mTitle.equals("实时票房")){
            mUrlIntent = "http://piaofang.maoyan.com/?f=android&userid=-1";
        }else if (mTitle.equals("影视快讯")){
            mUrlIntent = "http://m.maoyan.com/information?_v_=yes";
        }
        mFindWv.loadUrl(mUrlIntent);
        mFindWv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    protected void initClick() {
        descriptionBack.setOnClickListener(this);
        descriptionCollect.setOnClickListener(this);
        descriptionShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.description_back:
                getActivity().onBackPressed();
                break;
            case R.id.description_collect:
                break;
            case R.id.description_share:

                break;
        }
    }

}
