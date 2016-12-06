package lanou.maoyanmovie.event;

/**
 * created by 王一鸣 16/12/5.
 * 功能:
 */

public class CityMessage {
    private String cityId;
    private String cityName;

    public CityMessage(String cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public CityMessage setCityId(String cityId) {
        this.cityId = cityId;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public CityMessage setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }
}
