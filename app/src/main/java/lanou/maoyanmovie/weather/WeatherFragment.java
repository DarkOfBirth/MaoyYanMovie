package lanou.maoyanmovie.weather;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.HashMap;

import lanou.maoyanmovie.R;
import lanou.maoyanmovie.base.BaseFragment;
import lanou.maoyanmovie.bean.WeatherBean;
import lanou.maoyanmovie.httptools.HttpUtil;
import lanou.maoyanmovie.httptools.ResponseCallBack;
import lanou.maoyanmovie.weight.Ring;

/**
 * created by 王一鸣 16/11/28.
 * 功能: 天气
 */

public class WeatherFragment extends BaseFragment {
    // 背景图的Hashmap
    private HashMap<String, int[]> mBgMap;
    // 温度数字的显示
    private int[] numbers = new int[]{R.mipmap.num0, R.mipmap.num1, R.mipmap.num2, R.mipmap.num3,
            R.mipmap.num4, R.mipmap.num5, R.mipmap.num6, R.mipmap.num7, R.mipmap.num8, R.mipmap.num9};
    // 天气小图标
    private HashMap<String, Integer> mIcon;


    private TwinklingRefreshLayout mTwinklingRefreshLayout;
    private ImageView leftWeatherIv;
    private ImageView rightWeatherIv;
    private ImageView treeWeatherIv;
    private LinearLayout tempShow;
    private ImageView leftNumberWeatherIv;
    private ImageView rightNumberWeatherIv;
    private TextView cityAndWindWeatherTv;
    private ImageView minusWeatherIv;
    private TextView windDiectionWeatherTv;
    private TextView windLevelWeatherTv;
    private TextView humidityWeatherTv;
    private TextView airWeatherTv;
    private TextView airNumWeatherTv;

    private ImageView iconForecastIv;
    private TextView dateForecastTv;
    private TextView quailityForecastTv;
    private TextView tempForecastTv;
    private TextView airQuailityTv;
    private TextView publishTimeTv;
    private Ring aqiRing;
    private Ring pm10Ring;
    private ImageView airConditionLifeIv;
    private TextView airConditionTitleLifeTv;
    private TextView airConditionContentLifeTv;
    private ImageView sportLifeIv;
    private TextView sportTitleLifeTv;
    private TextView sportContentLifeTv;
    private ImageView purpleLineLifeIv;
    private TextView purpleLineTitleLifeTv;
    private TextView purpleLineContentLifeTv;
    private ImageView smokeLifeIv;
    private TextView smokeTitleLifeTv;
    private TextView smokeContentLifeTv;
    private ImageView carLifeIv;
    private TextView carTitleLifeTv;
    private TextView carContentLifeTv;
    private ImageView wearLifeIv;
    private TextView wearTitleLifeTv;
    private TextView wearContentLifeTv;
    private WeatherBean mWeatherBean;
    private RelativeLayout bgWeatherIv;
    private ImageView todayIcon, tommorowIcon, thirdIcon;
    private TextView todayDate, todayQuality, todayTemp, tommorowDate, tommorowViewTemp, tommorowQuality, thirdDate, thirdQuality, thirdTemp;


    @Override
    protected int getLayout() {
        return R.layout.fragment_weather;
    }

    @Override
    protected void initView() {

        mTwinklingRefreshLayout = bindView(R.id.refreshLayout);
        bgWeatherIv = (RelativeLayout) bindView(R.id.bg_weather_iv);

        leftWeatherIv = (ImageView) bindView(R.id.left_weather_iv);
        rightWeatherIv = (ImageView) bindView(R.id.right_weather_iv);
        treeWeatherIv = (ImageView) bindView(R.id.tree_weather_iv);
        tempShow = (LinearLayout) bindView(R.id.temp_show);
        leftNumberWeatherIv = (ImageView) bindView(R.id.left_number_weather_iv);
        rightNumberWeatherIv = (ImageView) bindView(R.id.right_number_weather_iv);
        cityAndWindWeatherTv = (TextView) bindView(R.id.city_and_wind_weather_tv);
        minusWeatherIv = (ImageView) bindView(R.id.minus_weather_iv);
        windDiectionWeatherTv = (TextView) bindView(R.id.wind_diection_weather_tv);
        windLevelWeatherTv = (TextView) bindView(R.id.wind_level_weather_tv);
        humidityWeatherTv = (TextView) bindView(R.id.humidity_weather_tv);
        airWeatherTv = (TextView) bindView(R.id.air_weather_tv);
        airNumWeatherTv = (TextView) bindView(R.id.air_num_weather_tv);
        iconForecastIv = (ImageView) bindView(R.id.icon_forecast_iv);
        dateForecastTv = (TextView) bindView(R.id.date_forecast_tv);

        tempForecastTv = (TextView) bindView(R.id.temp_forecast_tv);
        iconForecastIv = (ImageView) bindView(R.id.icon_forecast_iv);
        dateForecastTv = (TextView) bindView(R.id.date_forecast_tv);

        tempForecastTv = (TextView) bindView(R.id.temp_forecast_tv);
        iconForecastIv = (ImageView) bindView(R.id.icon_forecast_iv);
        dateForecastTv = (TextView) bindView(R.id.date_forecast_tv);

        tempForecastTv = (TextView) bindView(R.id.temp_forecast_tv);
        airQuailityTv = (TextView) bindView(R.id.air_quaility_tv);
        publishTimeTv = (TextView) bindView(R.id.publish_time_tv);
        aqiRing = (Ring) bindView(R.id.aqi_ring);
        airConditionLifeIv = (ImageView) bindView(R.id.air_condition_life_iv);
        airConditionTitleLifeTv = (TextView) bindView(R.id.air_condition_title_life_tv);
        airConditionContentLifeTv = (TextView) bindView(R.id.air_condition_content_life_tv);
        sportLifeIv = (ImageView) bindView(R.id.sport_life_iv);
        sportTitleLifeTv = (TextView) bindView(R.id.sport_title_life_tv);
        sportContentLifeTv = (TextView) bindView(R.id.sport_content_life_tv);
        purpleLineLifeIv = (ImageView) bindView(R.id.purple_line_life_iv);
        purpleLineTitleLifeTv = (TextView) bindView(R.id.purple_line_title_life_tv);
        purpleLineContentLifeTv = (TextView) bindView(R.id.purple_line_content_life_tv);
        smokeLifeIv = (ImageView) bindView(R.id.smoke_life_iv);
        smokeTitleLifeTv = (TextView) bindView(R.id.smoke_title_life_tv);
        smokeContentLifeTv = (TextView) bindView(R.id.smoke_content_life_tv);
        carLifeIv = (ImageView) bindView(R.id.car_life_iv);
        carTitleLifeTv = (TextView) bindView(R.id.car_title_life_tv);
        carContentLifeTv = (TextView) bindView(R.id.car_content_life_tv);
        wearLifeIv = (ImageView) bindView(R.id.wear_life_iv);
        wearTitleLifeTv = (TextView) bindView(R.id.wear_title_life_tv);
        wearContentLifeTv = (TextView) bindView(R.id.wear_content_life_tv);
        pm10Ring = bindView(R.id.pm10_ring);

    }

    @Override
    protected void initData() {
        loadBgData();
         String city = getArguments().getString("city");
       // String city = "武汉";
        HttpUtil.getWeatherInfo(city, new ResponseCallBack<WeatherBean>() {
            @Override
            public void onError(Exception e) {

            }

            @Override
            public void onResponse(WeatherBean weatherBean) {
                if(weatherBean.getResult() != null){

                    mWeatherBean = weatherBean;
                    handleData();
                    mTwinklingRefreshLayout.finishRefreshing();
                }
            }
        });

    }

    /**
     * 背景图片数据的装载 以及 天气小图标
     */
    private void loadBgData() {
        mBgMap = new HashMap<>();
        mBgMap.put("cloudy", new int[]{R.mipmap.bg_cloudy, R.mipmap.bg_cloudy_left, R.mipmap.bg_cloudy_right, R.mipmap.ic_launcher});
        mBgMap.put("pmdirt", new int[]{R.mipmap.bg_pmdirt, R.mipmap.bg_pmdirt_left, R.mipmap.bg_pmdirt_right, R.mipmap.ic_launcher});
        mBgMap.put("foggy", new int[]{R.mipmap.bg_foggy, R.mipmap.bg_foggy_left, R.mipmap.bg_foggy_right, R.mipmap.bg_foggy_tree_right});
        mBgMap.put("icerain", new int[]{R.mipmap.bg_ice_rain, R.mipmap.bg_ice_rain_left, R.mipmap.bg_ice_rain_right, R.mipmap.bg_ice_rain_tree_right});
        mBgMap.put("sandy", new int[]{R.mipmap.bg_sandy, R.mipmap.bg_sandy_left, R.mipmap.bg_sandy_right, R.mipmap.bg_sandy_tree});
        mBgMap.put("snow", new int[]{R.mipmap.bg_snow, R.mipmap.bg_snow_left, R.mipmap.bg_snow_right, R.mipmap.bg_snow_tree_right});
        mBgMap.put("sunny", new int[]{R.mipmap.bg_sunny, R.mipmap.bg_sunny_left, R.mipmap.bg_sunny_right, R.mipmap.bg_sunny_tree});
        mBgMap.put("sunnyright", new int[]{R.mipmap.bg_sunny_night, R.mipmap.bg_sunny_left_night, R.mipmap.bg_sunny_right_night, R.mipmap.bg_sunny_tree_night});

        mIcon = new HashMap<>();
        mIcon.put("1", R.mipmap.daily_forecast_cloudy);
        mIcon.put("18", R.mipmap.daily_forecast_foggy);
        mIcon.put("7", R.mipmap.daily_forecast_ice_rain);
        mIcon.put("33", R.mipmap.daily_forecast_pm_dirt);
        mIcon.put("-1", R.mipmap.daily_forecast_sandy);
        mIcon.put("13", R.mipmap.daily_forecast_snow);
        mIcon.put("0", R.mipmap.daily_forecast_sunny);
        mIcon.put("2", R.mipmap.daily_forecast_overcast);
    }

    /**
     * 处理天气数据
     *
     * @param
     */
    private void handleData() {
        // 更换背景
        changeBackGround();
        // 设置基本天气的基本数据, 即在背景图上的内容
        setBgWeatherContent();
        // 设置三天的显示天气
        setThreeDayForecast();
        // 设置空气质量
        setAirQualityData();
        // 设置出行建议
        setLifeAdvice();


    }

    /**
     * 设置出行建议
     */
    private void setLifeAdvice() {
        // 空调
        airConditionTitleLifeTv.setText(mWeatherBean.getResult().getLife().getInfo().getKongtiao().get(0));
        airConditionContentLifeTv.setText(mWeatherBean.getResult().getLife().getInfo().getKongtiao().get(1));

        // 运动
        sportTitleLifeTv.setText(mWeatherBean.getResult().getLife().getInfo().getYundong().get(0));
        sportContentLifeTv.setText(mWeatherBean.getResult().getLife().getInfo().getYundong().get(1));

        //紫外线
        purpleLineTitleLifeTv.setText(mWeatherBean.getResult().getLife().getInfo().getZiwaixian().get(0));
        purpleLineContentLifeTv.setText(mWeatherBean.getResult().getLife().getInfo().getZiwaixian().get(1));

        //感冒
        smokeTitleLifeTv.setText(mWeatherBean.getResult().getLife().getInfo().getGanmao().get(0));
        smokeContentLifeTv.setText(mWeatherBean.getResult().getLife().getInfo().getGanmao().get(1));

        //洗车
        carTitleLifeTv.setText(mWeatherBean.getResult().getLife().getInfo().getXiche().get(0));
        carContentLifeTv.setText(mWeatherBean.getResult().getLife().getInfo().getXiche().get(1));

        //穿衣
        wearTitleLifeTv.setText(mWeatherBean.getResult().getLife().getInfo().getChuanyi().get(0));
        wearContentLifeTv.setText(mWeatherBean.getResult().getLife().getInfo().getChuanyi().get(1));
    }

    /**
     * 设置空气质量
     */
    private void setAirQualityData() {
        airQuailityTv.setText(mWeatherBean.getResult().getPm25().getPm25().getQuality());
        String time = mWeatherBean.getResult().getPm25().getDateTime().substring(11, 13) + ":00 发布";
        publishTimeTv.setText(time);
        aqiRing.setLevel(mWeatherBean.getResult().getPm25().getPm25().getQuality());
        aqiRing.setNum(Integer.parseInt(mWeatherBean.getResult().getPm25().getPm25().getCurPm()));

        Log.d("WeatherSysout", mWeatherBean.getResult().getPm25().getPm25().getQuality());
        pm10Ring.setLevel(mWeatherBean.getResult().getPm25().getPm25().getQuality());
        pm10Ring.setNum(Integer.parseInt(mWeatherBean.getResult().getPm25().getPm25().getPm10()));


    }

    /**
     * 设置三天的显示天气
     */
    private void setThreeDayForecast() {
        View todayView = bindView(R.id.today_weather_ly);
        View tommorowView = bindView(R.id.tommorow_weather_ly);
        View thirdView = bindView(R.id.third_weather_ly);
        // 今天
        todayIcon = bindView(todayView, R.id.icon_forecast_iv);
        todayDate = bindView(todayView, R.id.date_forecast_tv);
        todayQuality = bindView(todayView, R.id.quality_forecast_tv);
        todayTemp = bindView(todayView, R.id.temp_forecast_tv);

        todayIcon.setImageResource(mIcon.get(mWeatherBean.getResult().getWeather().get(0).getInfo().getDay().get(0)));
        todayDate.setText("今天");
        setDailyWeatherQuality(todayQuality, mWeatherBean.getResult().getWeather().get(0).getInfo());
        todayTemp.setText(mWeatherBean.getResult().getWeather().get(0).getInfo().getDay().get(2) + "°/" +
                mWeatherBean.getResult().getWeather().get(0).getInfo().getNight().get(2) + "°");


        // 明天
        tommorowIcon = bindView(tommorowView, R.id.icon_forecast_iv);
        tommorowDate = bindView(tommorowView, R.id.date_forecast_tv);
        tommorowQuality = bindView(tommorowView, R.id.quality_forecast_tv);
        tommorowViewTemp = bindView(tommorowView, R.id.temp_forecast_tv);

        tommorowIcon.setImageResource(mIcon.get(mWeatherBean.getResult().getWeather().get(0).getInfo().getDay().get(0)));
        tommorowDate.setText("明天");

        setDailyWeatherQuality(tommorowQuality, mWeatherBean.getResult().getWeather().get(1).getInfo());
        tommorowViewTemp.setText(mWeatherBean.getResult().getWeather().get(1).getInfo().getDay().get(2) + "°/" +
                mWeatherBean.getResult().getWeather().get(1).getInfo().getNight().get(2) + "°");
        // 第三天

        thirdIcon = bindView(thirdView, R.id.icon_forecast_iv);
        thirdDate = bindView(thirdView, R.id.date_forecast_tv);
        thirdQuality = bindView(thirdView, R.id.quality_forecast_tv);
        thirdTemp = bindView(thirdView, R.id.temp_forecast_tv);

        thirdIcon.setImageResource(mIcon.get(mWeatherBean.getResult().getWeather().get(0).getInfo().getDay().get(0)));
        thirdDate.setText("周" + mWeatherBean.getResult().getWeather().get(2).getWeek());

        setDailyWeatherQuality(thirdQuality, mWeatherBean.getResult().getWeather().get(2).getInfo());

        thirdTemp.setText(mWeatherBean.getResult().getWeather().get(2).getInfo().getDay().get(2) + "° / " +
                mWeatherBean.getResult().getWeather().get(2).getInfo().getNight().get(2) + "°");
    }

    private void setDailyWeatherQuality(TextView textView, WeatherBean.ResultBean.WeatherDayBean.InfoBean bean) {
        String dayQuality = bean.getDay().get(1);
        String nightQuality = bean.getNight().get(1);
        if (!dayQuality.equals(nightQuality)) {
            nightQuality = dayQuality + "转" + nightQuality;
        }

        textView.setText(nightQuality);

    }

    /**
     * 在背景图上的内容
     */
    private void setBgWeatherContent() {
        setTemperature();
        setBgWeatherQuality();
        setBgBottomContent();
    }

    /**
     * 背景图的底部内容
     */
    private void setBgBottomContent() {
        // 风向和风力
        String windDirection = mWeatherBean.getResult().getRealtime().getWind().getDirect();
        String windLevel = mWeatherBean.getResult().getRealtime().getWind().getPower();
        windDiectionWeatherTv.setText(windDirection);
        windLevelWeatherTv.setText(windLevel);
        // 相对湿度
        String humidity = mWeatherBean.getResult().getRealtime().getWeather().getHumidity();
        humidityWeatherTv.setText(humidity + "%");
        // 污染
        String airWeather = mWeatherBean.getResult().getPm25().getPm25().getQuality();
        String airNum = mWeatherBean.getResult().getPm25().getPm25().getCurPm();
        if (airWeather.length() == 1) {
            airWeather = "空气" + airWeather;
        }
        airWeatherTv.setText(airWeather);
        airNumWeatherTv.setText(airNum);

    }

    /**
     * 在背景图上的天气状况
     */
    private void setBgWeatherQuality() {
        String cityName = mWeatherBean.getResult().getRealtime().getCity_name();
        String cityInfo = mWeatherBean.getResult().getRealtime().getWeather().getInfo();
        cityAndWindWeatherTv.setText(cityName + " | " + cityInfo);
    }

    /**
     * 设置温度
     */
    private void setTemperature() {
        String temp = mWeatherBean.getResult().getRealtime().getWeather().getTemperature();
        String temp1;
        // 是否含有"-"号
        if (!temp.contains("-")) {
            minusWeatherIv.setVisibility(View.INVISIBLE);
            temp1 = temp;
        } else {
            temp1 = temp.substring(1);
        }

        if (temp1.length() > 1) {
            // 是两位数
            int leftNumber = Integer.parseInt(temp1.substring(0, 1));
            leftNumberWeatherIv.setImageResource(numbers[leftNumber]);
            int rightNumber = Integer.parseInt(temp1.substring(1));
            rightNumberWeatherIv.setImageResource(numbers[rightNumber]);
        } else {
            //是一位数
            int rightNumber = Integer.parseInt(temp1);
            rightNumberWeatherIv.setImageResource(numbers[rightNumber]);
        }

    }

    /**
     * 更换背景图
     */
    private void changeBackGround() {
        String weatherImg = mWeatherBean.getResult().getRealtime().getWeather().getImg();
        Log.d("WeatherFragment", weatherImg);
        switch (weatherImg) {
            case "1":
                Log.d("WeatherFragment", "进入多云");
                changeBackGroudByImg("cloudy");

                break;
            case "18":
                changeBackGroudByImg("foggy");
                break;
            case "7":
                changeBackGroudByImg("icerain");
                break;
            case "33":
                changeBackGroudByImg("pmdirt");
                break;
            case "13":
                changeBackGroudByImg("snow");
                break;
            case "0":
                changeBackGroudByImg("sunny");
                break;
            case "2":
                // sunnyright 代表阴天
                changeBackGroudByImg("sunnyright");
                break;
            default:
                changeBackGroudByImg("sandy");


        }
    }

    /**
     * 根据 字段换背景图
     *
     * @param str
     */
    private void changeBackGroudByImg(String str) {
        Log.d("WeatherFragment", "str" + str);

        int[] bgs = mBgMap.get(str);
        if (bgs == null) {
            return;
        }
        bgWeatherIv.setBackgroundResource(bgs[0]);
        leftWeatherIv.setBackgroundResource(bgs[1]);
        rightWeatherIv.setBackgroundResource(bgs[2]);
        treeWeatherIv.setImageResource(bgs[3]);
        // 如果是多云 霾, 没有树
        if (str.equals("cloudy") || str.equals("pmdirt")) {
            treeWeatherIv.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    protected void initClick() {
        // 禁止加载更多
        WeatherRefreshHeader refreshHeader = new WeatherRefreshHeader(mContext);
        mTwinklingRefreshLayout.setHeaderView(refreshHeader);
        mTwinklingRefreshLayout.setEnableLoadmore(false);
        mTwinklingRefreshLayout.setOnRefreshListener(new TwinklingRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);

                    initData();

                    mTwinklingRefreshLayout.finishRefreshing();

            }

        });
    }
}
