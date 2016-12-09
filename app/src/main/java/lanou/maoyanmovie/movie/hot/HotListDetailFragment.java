package lanou.maoyanmovie.movie.hot;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.tools.MovieValues;

/**
 * Created by 麦建东 on 16/11/24.
 */
public class HotListDetailFragment extends BaseFragment implements View.OnClickListener {
    private WebView mHotListDetailWv;
    private ImageView mReturnIv;

    @Override
    protected int getLayout() {
        return R.layout.fragment_movie_hot_list_detail;
    }

    @Override
    protected void initView() {
        mReturnIv = bindView(R.id.fragment_movie_hot_list_detail_return_iv);
        mHotListDetailWv = bindView(R.id.fragment_movie_hot_list_detail_wv);
    }

    @Override

    protected void initData() {
        Bundle arguments = getArguments();
        int movieId = arguments.getInt("movieId");
        String webUrl = MovieValues.MOVIE_HOT_LIST_DETAIL  + String.valueOf(movieId) + "?_v_=yes";
        mHotListDetailWv.getSettings().setJavaScriptEnabled(true);
        mHotListDetailWv.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                mHotListDetailWv.setVisibility(View.VISIBLE);
                String fun = "javascript:function getClass(parent,sClass) { var aEle=parent" +
                        ".getElementsByTagName('div'); var aResult=[]; var i=0; for(i<0;i<aEle.length;i++) { if(aEle[i].className==sClass) { aResult.push(aEle[i]); } }; return aResult; } ";

                view.loadUrl(fun);

                String funFinal = "javascript:function hideOther() {getClass(document,'navload " +
                        "clearfix')[0].style.display='none';getClass(document,'navbar')[0].style.display='none';}";

                view.loadUrl(funFinal);

                view.loadUrl("javascript:hideOther();");
                super.onPageFinished(view, url);
            }
        });

        mHotListDetailWv.loadUrl(webUrl);
    }

    @Override
    protected void initClick() {
        mReturnIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        getActivity().onBackPressed();
    }
}
