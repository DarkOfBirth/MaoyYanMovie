package lanou.maoyanmovie.city;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.decoration.DividerItemDecoration;
import lanou.maoyanmovie.decoration.TitleItemDecoration;
import lanou.maoyanmovie.event.CityMessage;
import lanou.maoyanmovie.weight.SideBar;

/**
 * created by 王一鸣 16/11/26.
 * 功能:
 */

public class CityFragment extends BaseFragment {
    private SideBar mSideBar;
    private TextView buddle;
    private Gson mGson;
    private RecyclerView mRecyclerView;
    private ScrollSpeedLinearLayoutManger mManager;
    private CityAdapter mAdapter;
    private TitleItemDecoration mDecoration;
    private List<CityBean.CtsBean> mDatas;
    private ArrayList<CityBean.CtsBean> mCtsBeanArrayList;
    private OnSelectCity mOnSelectCity;


    public CityFragment setOnSelectCity(OnSelectCity onSelectCity) {
        mOnSelectCity = onSelectCity;
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_city;
    }

    @Override
    protected void initView() {
        mRecyclerView = bindView(R.id.rv);

        mSideBar =bindView(R.id.sidebar);
        buddle = bindView(R.id.bubble);
    }

    @Override
    protected void initData() {
        mSideBar.setOnMoveSideBar(new SideBar.OnMoveSideBar() {
            @Override
            public void onMove(float cellHeight, String character, int index) {
                buddle.setVisibility(View.VISIBLE);
                Log.d("MainActivity", character);
                buddle.setY(cellHeight * index);
                buddle.setText(character);
                //优化部分
                long startTime = System.currentTimeMillis();
                int currentPostion = getFirstLetterCount(character);
                if (currentPostion != mCtsBeanArrayList.size()) {

                    mRecyclerView.smoothScrollToPosition(currentPostion + 3);
                }
                //              Log.d("MainActivity", "System.currentTimeMillis() - startTime:" + (System.currentTimeMillis() - startTime));
            }

            @Override
            public void onKeyDown(float cellHeight, String character, int index) {
                buddle.setVisibility(View.VISIBLE);
                buddle.setY(cellHeight * index);
                buddle.setText(character);

                if(character.equals("#")){
                    mRecyclerView.scrollToPosition(0);
                    return;
                }
                int currentPostion = getFirstLetterCount(character);

                if (currentPostion != mCtsBeanArrayList.size()) {


                    mRecyclerView.scrollToPosition(currentPostion + 4);

                }

            }

            @Override
            public void onKeyUp(float cellHeight, String character, int index) {
                buddle.setVisibility(View.INVISIBLE);
                int currentPostion = getFirstLetterCount(character);
                if (currentPostion != mCtsBeanArrayList.size()) {

                    // mRecyclerView.scrollToPosition(currentPostion);
                }

            }
        });

        getData();

        mRecyclerView.setLayoutManager(mManager = new ScrollSpeedLinearLayoutManger(mContext));
        mManager.setSpeedFast();
        mRecyclerView.setAdapter(mAdapter = new CityAdapter(mContext, getData()));
        mAdapter.setOnSelectCity(new OnSelectCity() {
            @Override
            public void selectCityName(String name, String cityId) {
                EventBus.getDefault().post(new CityMessage(cityId,name));



                     mOnSelectCity.selectCityName(name,cityId);
                getActivity().onBackPressed();
            }
        });
        mRecyclerView.addItemDecoration(mDecoration = new TitleItemDecoration(mContext, mCtsBeanArrayList));
        //如果add两个，那么按照先后顺序，依次渲染。
        // mRecyclerView.addItemDecoration(new TitleItemDecoration2(this, mCtsBeanArrayList));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));



    }

    @Override
    protected void initClick() {

    }


    /**
     * 获取当前字母之前的position
     *
     * @param character
     */
    private int getFirstLetterCount(String character) {
        int count = 0;
        for (int i = 0; i < mCtsBeanArrayList.size() ; i++) {
            if (!character.equals(mCtsBeanArrayList.get(i).getFirstLetter())) {
                count++;
            } else {

                break;
            }
        }
        return count;
    }

    /**
     * 从city.json 中读取数据
     */
    private ArrayList<CityBean.CtsBean> getData() {
        /**
         * 获取
         */
        InputStream inputStream = mContext.getClassLoader().getResourceAsStream("assets/" + "cities.json");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line = "";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                inputStreamReader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Log.d("MainActivity", stringBuilder.toString());
        mGson = new Gson();
        CityBean cityBean = mGson.fromJson(stringBuilder.toString(), CityBean.class);
        Toast.makeText(mContext, "cityBean.getCts().get(1).getId():" + cityBean.getCts().get(1).getId(), Toast.LENGTH_SHORT).show();
        mCtsBeanArrayList = new ArrayList<>();
        for (int i = 0; i < cityBean.getCts().size(); i++) {
            String firstLetter = cityBean.getCts().get(i).getPy().substring(0, 1).toUpperCase();
            cityBean.getCts().get(i).setFirstLetter(firstLetter);

            mCtsBeanArrayList.add(cityBean.getCts().get(i));
            Log.d("MainActivity", mCtsBeanArrayList.get(i).getFirstLetter() + mCtsBeanArrayList.get(i).getNm());

        }
        Collections.sort(mCtsBeanArrayList, new PinyinComparator());
        for (int i = 0; i < cityBean.getCts().size(); i++) {

            Log.d("MainActivity", mCtsBeanArrayList.get(i).getFirstLetter() + mCtsBeanArrayList.get(i).getNm());

        }

        CityBean.CtsBean hotBean = new CityBean.CtsBean();
        hotBean.setFirstLetter("   #");
        mCtsBeanArrayList.add(0,hotBean);
        mCtsBeanArrayList.add(1,hotBean);
        mCtsBeanArrayList.add(2,hotBean);



        return mCtsBeanArrayList;
    }
   public  interface OnSelectCity{
        void selectCityName(String name, String cityId);
    }
}
