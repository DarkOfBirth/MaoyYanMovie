package lanou.maoyanmovie.collect;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.CollectBean;

/**
 * Created by wangYe on 16/12/6.
 */
public class CollectFragment extends BaseFragment{

    private RecyclerView mBodyRv;
    private ImageView mBackImg;
    private CollectRvAdapter mAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_collect;

    }

    @Override
    protected void initView() {
        mBodyRv = bindView(R.id.collect_body_rv);
        mBackImg = bindView(R.id.collect_back_img);
        mAdapter = new CollectRvAdapter();
        mBodyRv.setAdapter(mAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        mBodyRv.setLayoutManager(manager);
    }

    @Override
    protected void initData() {

        //查询数据库
        CollectDBTool.getInstance().queryAllCollectBean(new CollectDBTool.OnQueryListener() {
            @Override
            public void onQuery(List<CollectBean> collectBean) {
                ArrayList<CollectBean> collectBeen = new ArrayList<>();
                for (int i = 0; i < collectBean.size(); i++) {
                    CollectBean bean = new CollectBean();
                    bean.setTitle(collectBean.get(i).getTitle());
                    bean.setUrlImg(collectBean.get(i).getUrlImg());
                    bean.setNickName(collectBean.get(i).getNickName());
                    bean.setFeedType(collectBean.get(i).getFeedType());
                    bean.setTargetId(collectBean.get(i).getTargetId());
                    bean.setTime(collectBean.get(i).getTime());
                    collectBeen.add(bean);
                }
                mAdapter.setCollectBeen(collectBeen);
            }
        });


    }

    @Override
    protected void initClick() {
        mBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        CollectDBTool.getInstance().queryAllCollectBean(new CollectDBTool.OnQueryListener() {
            @Override
            public void onQuery(List<CollectBean> collectBean) {
                ArrayList<CollectBean> collectBeen = new ArrayList<>();
                for (int i = 0; i < collectBean.size(); i++) {
                    CollectBean bean = new CollectBean();
                    bean.setTitle(collectBean.get(i).getTitle());
                    bean.setUrlImg(collectBean.get(i).getUrlImg());
                    bean.setNickName(collectBean.get(i).getNickName());
                    bean.setFeedType(collectBean.get(i).getFeedType());
                    bean.setTargetId(collectBean.get(i).getTargetId());
                    bean.setTime(collectBean.get(i).getTime());
                    collectBeen.add(bean);
                }
                mAdapter.setCollectBeen(collectBeen);
            }
        });
    }
}
