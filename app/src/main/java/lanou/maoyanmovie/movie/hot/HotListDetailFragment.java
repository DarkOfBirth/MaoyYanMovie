package lanou.maoyanmovie.movie.hot;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;

/**
 * Created by 麦建东 on 16/11/24.
 */
public class HotListDetailFragment extends BaseFragment {

    private WebView mHotListDetailWv;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine_movie_list_detail;
    }

    @Override
    protected void initView() {
        mHotListDetailWv = bindView(R.id.fragment_mine_hot_list_detail_wv);
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        int movieId = arguments.getInt("movieId");

//        mHotListDetailWv.loadUrl(MovieValues.MOVIE_HOT_LIST_DETAIL + String.valueOf(movieId));
        String url = "http://m.maoyan.com/movie/" + String.valueOf(movieId) + "?_v_=yes";
        mHotListDetailWv.getSettings().setJavaScriptEnabled(true);
        mHotListDetailWv.setWebChromeClient(new WebChromeClient());
        mHotListDetailWv.loadUrl(url);
//        mHotListDetailWv.setWebViewClient(new WebViewClient() {
////            @Override
////            public boolean shouldOverrideUrlLoading(WebView view, String url) {
////                view.loadUrl(url);
////                return true;
////            }
//
//            @Override
//            public void onLoadResource(WebView view, String url) {
//                Log.d("HotListDetailFragment", url);
//                super.onLoadResource(view, url);
//            }
//        });
        Log.d("HotListDetailFragment", url);
    }

    @Override
    protected void initClick() {

    }
}
