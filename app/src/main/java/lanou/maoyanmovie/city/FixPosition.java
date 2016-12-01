package lanou.maoyanmovie.city;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import lanou.maoyanmovie.base.MyApplication;
import lanou.maoyanmovie.bean.LocationBean;
import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;

/**
 * created by 王一鸣 16/11/26.
 * 功能:
 */

public class FixPosition {
    private String mProvider;
    private Location mLocation;
    // 定位后的维度
    private double mLatitude;
    // 定位后的经度
    private double mLongitude;
    private String mCity;

    public String getLocation() {

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
        Log.d("MainActivity", "providerList:" + providerList);
        //        if(providerList.contains(LocationManager.GPS_PROVIDER)){
        //            Log.d("MainActivity", "gps");
        //
        //            // gps 提供定位
        //            mProvider = LocationManager.GPS_PROVIDER;
        //        }else
        if (providerList.contains(LocationManager.NETWORK_PROVIDER)) {
            Log.d("MainActivity", "network");

            mProvider = LocationManager.NETWORK_PROVIDER;
        } else {
            Toast.makeText(MyApplication.getmContext(), "No location provider to use", Toast.LENGTH_SHORT).show();
        }
        Log.d("MainActivity1", mProvider);

        mLocation = locationManager.getLastKnownLocation(mProvider);
        Log.d("MainActivity", "mLocation:" + mLocation);
        if (mLocation != null) {
            // 显示当前设备的位置信息
            mLatitude = mLocation.getLatitude();
            mLongitude = mLocation.getLongitude();

            HttpUtil.getLocationByLongitudeAndLatitude(mLongitude, mLatitude, new ResponseCallBack<LocationBean>() {
                @Override
                public void onError(Exception e) {

                }

                @Override
                public void onResponse(LocationBean locationBean) {
                    mCity = locationBean.getResult().getCity();

                }
            });
        }

        return mCity;
    }

}
