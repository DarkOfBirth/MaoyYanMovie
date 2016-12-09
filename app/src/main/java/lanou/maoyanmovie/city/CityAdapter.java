package lanou.maoyanmovie.city;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.MyApplication;
import lanou.maoyanmovie.bean.HistoryCityBean;
import lanou.maoyanmovie.bean.LocationBean;
import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;
import lanou.maoyanmovie.tools.CommonVH;
import lanou.maoyanmovie.tools.DBTools;

/**
 * Created by 王一鸣
 * Date: 16/08/28
 */

public class CityAdapter extends RecyclerView.Adapter<CommonVH> {
    private Context mContext;
    private List<CityBean.CtsBean> mDatas;
    private LayoutInflater mInflater;
    // 定位后的维度
    double mLatitude;
    // 定位后的经度
    double mLongitude;
    private String mCity;
    private String mString;
    private CityFragment.OnSelectCity mOnSelectCity;

    public CityAdapter setOnSelectCity(CityFragment.OnSelectCity onSelectCity) {
        mOnSelectCity = onSelectCity;
        return this;
    }

    public CityAdapter(Context mContext, List<CityBean.CtsBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public CommonVH onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return CommonVH.getViewHolder(parent, R.layout.location_city);

            case 1:
                return CommonVH.getViewHolder(parent, R.layout.history_scan);

            case 2:
                return CommonVH.getViewHolder(parent, R.layout.hot_city);

            case 3:
                return CommonVH.getViewHolder(parent, R.layout.item_city);

            default:
                break;
        }
        return null;

    }


    @Override
    public void onBindViewHolder(final CommonVH holder, final int position) {
        switch (getItemViewType(position)) {
            // 定位
            case 0:
                holder.setViewClick(R.id.postion_city_tv, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Location cityLocation = getLocation();
                        Log.d("CityAdapter", "cityLocation:" + cityLocation);
                        if (cityLocation != null) {
                            // 显示当前设备的位置信息
                            mLatitude = cityLocation.getLatitude();
                            mLongitude = cityLocation.getLongitude();
                            Log.d("CityAdapter", "mLatitude:" + mLatitude);
                            HttpUtil.getLocationByLongitudeAndLatitude(mLongitude, mLatitude, new ResponseCallBack<LocationBean>() {
                                @Override
                                public void onError(Exception e) {

                                }

                                @Override
                                public void onResponse(LocationBean locationBean) {
                                    mCity = locationBean.getResult().getCity().replace("市", "");

                                    holder.setText(R.id.postion_city_tv, mCity);

                                    getCityId();
                                    mOnSelectCity.selectCityName(mCity, getCityId());

                                }
                            });
                        }


                    }
                });
                break;
            case 1:
                // 历史
                GridLayoutManager historyManager = new GridLayoutManager(mContext, 3);
                RecyclerView historyCityRv = (RecyclerView) holder.getItemView().findViewById(R.id.city_scan_history_rv);
                HistoryCityAdapter historyCityAdapter = new HistoryCityAdapter();
                historyCityRv.setAdapter(historyCityAdapter);
                historyCityRv.setLayoutManager(historyManager);
                DBTools.getInstance().queryHistoryInfo(HistoryCityBean.class, new DBTools.OnQueryHistoryInfo<HistoryCityBean>() {
                    @Override
                    public void OnQuery(ArrayList<HistoryCityBean> query) {

                        ArrayList<String> arrayList = new ArrayList<String>();
                        Log.d("CityAdapter", "query.size():" + query.size()+"");
                        if (query.size() != 0) {

                            Collections.reverse(query);

                            for (int i = 0; i < (query.size() <= 3 ? query.size() : 3); i++) {
                                Log.d("CityAdapter", "query.get(i):" + query.get(i).getContent());
                                arrayList.add(query.get(i).getContent());
                            }
                        historyCityAdapter.setStringArrayList(arrayList);
                        }
                    }
                });


                break;
            case 2:
                // 热门

                RecyclerView hotCityRv = (RecyclerView) holder.getItemView().findViewById(R.id.hot_city_rv);
                HotCityAdapter hotCityAdapter = new HotCityAdapter();
                GridLayoutManager hotManager = new GridLayoutManager(mContext, 3);
                hotCityRv.setAdapter(hotCityAdapter);
                hotCityRv.setLayoutManager(hotManager);
                hotCityAdapter.setOnSelcetHotCityListener(new HotCityAdapter.OnSelcetHotCityListener() {
                    @Override
                    public void onSelectHotCity(String cityName) {
                        getCityId(cityName);
                        mOnSelectCity.selectCityName(cityName, getCityId(cityName));
                    }
                });

                break;

            case 3:
                holder.setText(R.id.tvCity, mDatas.get(position).getNm());
                holder.setItemClick(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "mDatas.get(position).getId():" + mDatas.get(position).getId(), Toast.LENGTH_SHORT).show();
                        mOnSelectCity.selectCityName(mDatas.get(position).getNm(), mDatas.get(position).getId() + "");
                        //  删除之后 插入数据
                        DBTools.getInstance().deleteOneHistoryInfo(HistoryCityBean.class, mDatas.get(position).getNm());
                        DBTools.getInstance().inserthistoryInfo(new HistoryCityBean(mDatas.get(position).getNm()));

                    }
                });
                break;

        }
    }


    @Override
    public int getItemViewType(int position) {


        return position < 3 ? position : 3;
    }

    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    private String getCityId() {
        String cityId = "-1";
        for (CityBean.CtsBean data : mDatas) {
            if (mCity.equals(data.getNm())) {

                cityId = String.valueOf(data.getId());


            }
        }
        return cityId;
    }

    private String getCityId(String cityName) {
        String cityId = "-1";
        for (CityBean.CtsBean data : mDatas) {
            if (cityName.equals(data.getNm())) {

                cityId = String.valueOf(data.getId());


            }
        }
        return cityId;
    }

    /**
     * 获取经纬度
     *
     * @return
     */
    public Location getLocation() {
        String mProvider;
        Location mLocation;

        // 权限检查, 自动添加的
        if (ActivityCompat.checkSelfPermission(MyApplication.getmContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MyApplication.getmContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

        }
        LocationManager locationManager = (LocationManager) MyApplication.getmContext().getSystemService(Context.LOCATION_SERVICE);
        mProvider = LocationManager.NETWORK_PROVIDER;
        // 获取所有可用的位置提供器
        List<String> providerList = locationManager.getProviders(true);

        if (providerList.contains(LocationManager.NETWORK_PROVIDER)) {

            mProvider = LocationManager.NETWORK_PROVIDER;
        } else {
            Toast.makeText(MyApplication.getmContext(), "No location provider to use", Toast.LENGTH_SHORT).show();
        }


        mLocation = locationManager.getLastKnownLocation(mProvider);


        return mLocation;
    }


}
