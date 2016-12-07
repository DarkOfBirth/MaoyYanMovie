package lanou.maoyanmovie.find;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.CollectBean;
import lanou.maoyanmovie.collect.CollectDBTool;
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
    private int mFeedType;
    private int mTargetId;
    private String mNickName;
    private String mUrlImg;
    private String mMainTitle;
    private boolean isCollect = false;


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
        mTargetId = bundle.getInt("targetID", -1);
        mFeedType = bundle.getInt("feedType", -1);
        mNickName = bundle.getString("nickName");
        mUrlImg = bundle.getString("urlImg");
        mMainTitle = bundle.getString("title");
        
        mTitle = bundle.getString("Title");
        descriptionTitle.setText(mTitle);
        if (mFeedType == 7) {
            mUrlIntent = MovieValues.TODAY_DETAIL + mTargetId + "?_v_=yes";
        } else if (mFeedType == 2 || mFeedType == 10) {
            mUrlIntent = MovieValues.TODAY_DETAIL_ELSE + mTargetId + "?_v_=yes";
        } else if (mTitle.equals("今日TOP10")) {
            mUrlIntent = MovieValues.MOVIE_FIND_TOP10;
        } else if (mTitle.equals("实时票房")) {
            mUrlIntent = MovieValues.MOVIE_FIND_NOW;
        } else if (mTitle.equals("影视快讯")) {
            mUrlIntent = MovieValues.MOVIE_FIND_FAST_MSG;
        }
        mFindWv.loadUrl(mUrlIntent);
        mFindWv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        CollectDBTool.getInstance().queryByValuesCollectBean(CollectBean.class, "title", new String[]{mMainTitle}, new CollectDBTool.OnQueryListener() {
            @Override
            public void onQuery(List<CollectBean> collectBean) {
                Log.d("DescriptionFragment", "collectBean:" + collectBean);
                if (collectBean.size() > 0) {
                    descriptionCollect.setImageResource(R.mipmap.xingxing_select);
                } else {
                    descriptionCollect.setImageResource(R.mipmap.xingxing);
                }
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
        switch (v.getId()) {
            case R.id.description_back:
                getActivity().onBackPressed();
                break;
            case R.id.description_collect:
                if (!isCollect) {
                    //获取当前的系统时间
                    SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    String data = sDateFormat.format(new java.util.Date());
                    String data1 = data.substring(5, 10);
                    CollectBean collectBean = new CollectBean();
                    collectBean.setFeedType(mFeedType);
                    collectBean.setTargetId(mTargetId);
                    collectBean.setNickName(mNickName);
                    collectBean.setTime(data1);
                    collectBean.setUrlImg(mUrlImg);
                    collectBean.setTitle(mMainTitle);
                    CollectDBTool.getInstance().insertCollectBean(collectBean);
                    descriptionCollect.setImageResource(R.mipmap.xingxing_select);
                    isCollect = !isCollect;
                } else {
                    CollectDBTool.getInstance().deleteValueBean(CollectBean.class, "title", new String[]{mMainTitle});
                    descriptionCollect.setImageResource(R.mipmap.xingxing);
                    isCollect = !isCollect;
                }
                break;
            case R.id.description_share:
                Log.d("DescriptionFragment", "点击分享");
                break;
        }
    }

}
