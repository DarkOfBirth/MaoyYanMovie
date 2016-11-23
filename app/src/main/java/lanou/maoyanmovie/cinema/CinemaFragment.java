package lanou.maoyanmovie.cinema;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;

/**
 * Created by dllo on 16/11/21.
 */

public class CinemaFragment extends BaseFragment{
    @Override
    protected int getLayout() {
        return R.layout.fragment_cinema;
    }

    @Override
    protected void initView() {
//        HttpUtil.getStoreLike(0, 10, new ResponseCallBack() {
//            @Override
//            public void onError(Exception e) {
//
//            }
//
//            @Override
//            public void onResponse(Object o) {
//                StoreLikeBean storeLikeBean = (StoreLikeBean) o;
//                storeLikeBean.getData().getTotal();
//            }
//        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initClick() {

    }
}
