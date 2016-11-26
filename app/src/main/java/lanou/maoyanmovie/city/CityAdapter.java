package lanou.maoyanmovie.city;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.MyApplication;
import lanou.maoyanmovie.bean.LocationBean;
import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;

/**
 * Created by zhangxutong .
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
    public void onBindViewHolder(final CommonVH holder, int position) {
        switch (getItemViewType(position)) {
            case 0:
                holder.setViewClick(R.id.postion_city_tv, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Location cityLocation = getLocation();

                        if (cityLocation != null) {
                            // 显示当前设备的位置信息
                            mLatitude = cityLocation.getLatitude();
                            mLongitude = cityLocation.getLongitude();

                            HttpUtil.getLocationByLongitudeAndLatitude(mLongitude, mLatitude, new ResponseCallBack<LocationBean>() {
                                @Override
                                public void onError(Exception e) {

                                }

                                @Override
                                public void onResponse(LocationBean locationBean) {
                                    mCity = locationBean.getResult().getCity().replace("市", "");

                                    holder.setText(R.id.postion_city_tv, mCity);

                                    for (CityBean.CtsBean data : mDatas) {
                                        if (mCity.equals(data.getNm())) {
                                            Log.d("CityAdapter", "匹配成功");
                                            Toast.makeText(mContext, "data.getId():" + data.getId() + "", Toast.LENGTH_SHORT).show();
                                            break;
                                        }
                                    }

                                }
                            });
                        }


                    }
                });
                break;
            case 1:
                break;
            case 2:
                break;

            case 3:
                holder.setText(R.id.tvCity, mDatas.get(position).getNm());
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
            Log.d("MainActivity", "network");

            mProvider = LocationManager.NETWORK_PROVIDER;
        } else {
            Toast.makeText(MyApplication.getmContext(), "No location provider to use", Toast.LENGTH_SHORT).show();
        }
        Log.d("MainActivity1", mProvider);

        mLocation = locationManager.getLastKnownLocation(mProvider);
        Log.d("MainActivity", "mLocation:" + mLocation);

        return mLocation;
    }

}
