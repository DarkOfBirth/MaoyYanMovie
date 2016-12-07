package lanou.maoyanmovie.bean;

import java.util.List;

/**
 * created by 王一鸣 16/11/30.
 * 功能:
 */

public class WeatherBean {


    /**
     * realtime : {"wind":{"windspeed":null,"direct":"南风","power":"1级","offset":null},"time":"10:00:00","weather":{"humidity":"97","img":"18","info":"雾","temperature":"1"},"dataUptime":"1480473305","date":"2016-11-30","city_code":"101100101","city_name":"太原","week":"3","moon":"十一月初二"}
     * life : {"date":"2016-11-30","info":{"kongtiao":["开启制暖空调","您将感到有些冷，可以适当开启制暖空调调节室内温度，以免着凉感冒。"],"yundong":["较不宜","天气较好，但考虑风力较大，天气寒冷，推荐您进行室内运动，若在户外运动须注意保暖。"],"ziwaixian":["中等","属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"],"ganmao":["较易发","天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"wuran":null,"chuanyi":["冷","天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。"]}}
     * weather : [{"date":"2016-11-30","week":"三","nongli":"十一月初二","info":{"dawn":null,"day":["0","晴","6","西北风","3-4 级","07:25"],"night":["0","晴","-6","西北风","3-4 级","17:11"]}},{"date":"2016-12-01","week":"四","nongli":"十一月初三","info":{"dawn":["0","晴","-6","西北风","3-4 级","17:11"],"day":["0","晴","7","","微风","07:26"],"night":["0","晴","-6","","微风","17:10"]}},{"date":"2016-12-02","week":"五","nongli":"十一月初四","info":{"dawn":["0","晴","-6","无持续风向","微风","17:10"],"day":["0","晴","9","","微风","07:27"],"night":["1","多云","-4","","微风","17:10"]}},{"date":"2016-12-03","week":"六","nongli":"十一月初五","info":{"dawn":["1","多云","-4","无持续风向","微风","17:10"],"day":["1","多云","9","","微风","07:28"],"night":["1","多云","-4","北风","微风","17:10"]}},{"date":"2016-12-04","week":"日","nongli":"十一月初六","info":{"dawn":["1","多云","-4","北风","微风","17:10"],"day":["0","晴","9","西北风","3-4 级","07:29"],"night":["0","晴","-6","西北风","4-5 级","17:10"]}}]
     * pm25 : {"key":"Taiyuan","show_desc":"0","pm25":{"curPm":"310","pm25":"260","pm10":"335","level":"6","quality":"严重污染","des":"健康人运动耐受力降低，有明显强烈症状，提前出现某些疾病 老年人和病人应当留在室内，避免体力消耗，一般人群应尽量减少户外活动。"},"dateTime":"2016年11月30日10时","cityName":"太原"}
     * isForeign : 0
     */

    private ResultBean result;
    /**
     * result : {"realtime":{"wind":{"windspeed":null,"direct":"南风","power":"1级","offset":null},"time":"10:00:00","weather":{"humidity":"97","img":"18","info":"雾","temperature":"1"},"dataUptime":"1480473305","date":"2016-11-30","city_code":"101100101","city_name":"太原","week":"3","moon":"十一月初二"},"life":{"date":"2016-11-30","info":{"kongtiao":["开启制暖空调","您将感到有些冷，可以适当开启制暖空调调节室内温度，以免着凉感冒。"],"yundong":["较不宜","天气较好，但考虑风力较大，天气寒冷，推荐您进行室内运动，若在户外运动须注意保暖。"],"ziwaixian":["中等","属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"],"ganmao":["较易发","天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"wuran":null,"chuanyi":["冷","天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。"]}},"weather":[{"date":"2016-11-30","week":"三","nongli":"十一月初二","info":{"dawn":null,"day":["0","晴","6","西北风","3-4 级","07:25"],"night":["0","晴","-6","西北风","3-4 级","17:11"]}},{"date":"2016-12-01","week":"四","nongli":"十一月初三","info":{"dawn":["0","晴","-6","西北风","3-4 级","17:11"],"day":["0","晴","7","","微风","07:26"],"night":["0","晴","-6","","微风","17:10"]}},{"date":"2016-12-02","week":"五","nongli":"十一月初四","info":{"dawn":["0","晴","-6","无持续风向","微风","17:10"],"day":["0","晴","9","","微风","07:27"],"night":["1","多云","-4","","微风","17:10"]}},{"date":"2016-12-03","week":"六","nongli":"十一月初五","info":{"dawn":["1","多云","-4","无持续风向","微风","17:10"],"day":["1","多云","9","","微风","07:28"],"night":["1","多云","-4","北风","微风","17:10"]}},{"date":"2016-12-04","week":"日","nongli":"十一月初六","info":{"dawn":["1","多云","-4","北风","微风","17:10"],"day":["0","晴","9","西北风","3-4 级","07:29"],"night":["0","晴","-6","西北风","4-5 级","17:10"]}}],"pm25":{"key":"Taiyuan","show_desc":"0","pm25":{"curPm":"310","pm25":"260","pm10":"335","level":"6","quality":"严重污染","des":"健康人运动耐受力降低，有明显强烈症状，提前出现某些疾病 老年人和病人应当留在室内，避免体力消耗，一般人群应尽量减少户外活动。"},"dateTime":"2016年11月30日10时","cityName":"太原"},"isForeign":0}
     * error_code : 0
     * reason : Succes
     */

    private int error_code;
    private String reason;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static class ResultBean {
        /**
         * wind : {"windspeed":null,"direct":"南风","power":"1级","offset":null}
         * time : 10:00:00
         * weather : {"humidity":"97","img":"18","info":"雾","temperature":"1"}
         * dataUptime : 1480473305
         * date : 2016-11-30
         * city_code : 101100101
         * city_name : 太原
         * week : 3
         * moon : 十一月初二
         */

        private RealtimeBean realtime;
        /**
         * date : 2016-11-30
         * info : {"kongtiao":["开启制暖空调","您将感到有些冷，可以适当开启制暖空调调节室内温度，以免着凉感冒。"],"yundong":["较不宜","天气较好，但考虑风力较大，天气寒冷，推荐您进行室内运动，若在户外运动须注意保暖。"],"ziwaixian":["中等","属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"],"ganmao":["较易发","天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"],"xiche":["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"],"wuran":null,"chuanyi":["冷","天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。"]}
         */

        private LifeBean life;
        /**
         * key : Taiyuan
         * show_desc : 0
         * pm25 : {"curPm":"310","pm25":"260","pm10":"335","level":"6","quality":"严重污染","des":"健康人运动耐受力降低，有明显强烈症状，提前出现某些疾病 老年人和病人应当留在室内，避免体力消耗，一般人群应尽量减少户外活动。"}
         * dateTime : 2016年11月30日10时
         * cityName : 太原
         */

        private Pm25Bean pm25;
        private int isForeign;
        /**
         * date : 2016-11-30
         * week : 三
         * nongli : 十一月初二
         * info : {"dawn":null,"day":["0","晴","6","西北风","3-4 级","07:25"],"night":["0","晴","-6","西北风","3-4 级","17:11"]}
         */

        private List<WeatherDayBean> weather;

        public RealtimeBean getRealtime() {
            return realtime;
        }

        public void setRealtime(RealtimeBean realtime) {
            this.realtime = realtime;
        }

        public LifeBean getLife() {
            return life;
        }

        public void setLife(LifeBean life) {
            this.life = life;
        }

        public Pm25Bean getPm25() {
            return pm25;
        }

        public void setPm25(Pm25Bean pm25) {
            this.pm25 = pm25;
        }

        public int getIsForeign() {
            return isForeign;
        }

        public void setIsForeign(int isForeign) {
            this.isForeign = isForeign;
        }

        public List<WeatherDayBean> getWeather() {
            return weather;
        }

        public void setWeather(List<WeatherDayBean> weather) {
            this.weather = weather;
        }

        public static class RealtimeBean {
            /**
             * windspeed : null
             * direct : 南风
             * power : 1级
             * offset : null
             */

            private WindBean wind;
            private String time;
            /**
             * humidity : 97
             * img : 18
             * info : 雾
             * temperature : 1
             */

            private WeatherDetaileBean weather;
            private String dataUptime;
            private String date;
            private String city_code;
            private String city_name;
            private String week;
            private String moon;

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public WeatherDetaileBean getWeather() {
                return weather;
            }

            public void setWeather(WeatherDetaileBean weather) {
                this.weather = weather;
            }

            public String getDataUptime() {
                return dataUptime;
            }

            public void setDataUptime(String dataUptime) {
                this.dataUptime = dataUptime;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCity_code() {
                return city_code;
            }

            public void setCity_code(String city_code) {
                this.city_code = city_code;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getMoon() {
                return moon;
            }

            public void setMoon(String moon) {
                this.moon = moon;
            }

            public static class WindBean {
                private Object windspeed;
                private String direct;
                private String power;
                private Object offset;

                public Object getWindspeed() {
                    return windspeed;
                }

                public void setWindspeed(Object windspeed) {
                    this.windspeed = windspeed;
                }

                public String getDirect() {
                    return direct;
                }

                public void setDirect(String direct) {
                    this.direct = direct;
                }

                public String getPower() {
                    return power;
                }

                public void setPower(String power) {
                    this.power = power;
                }

                public Object getOffset() {
                    return offset;
                }

                public void setOffset(Object offset) {
                    this.offset = offset;
                }
            }

            public static class WeatherDetaileBean {
                private String humidity;
                private String img;
                private String info;
                private String temperature;

                public String getHumidity() {
                    return humidity;
                }

                public void setHumidity(String humidity) {
                    this.humidity = humidity;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getInfo() {
                    return info;
                }

                public void setInfo(String info) {
                    this.info = info;
                }

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }
            }
        }

        public static class LifeBean {
            private String date;
            /**
             * kongtiao : ["开启制暖空调","您将感到有些冷，可以适当开启制暖空调调节室内温度，以免着凉感冒。"]
             * yundong : ["较不宜","天气较好，但考虑风力较大，天气寒冷，推荐您进行室内运动，若在户外运动须注意保暖。"]
             * ziwaixian : ["中等","属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"]
             * ganmao : ["较易发","天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。"]
             * xiche : ["较适宜","较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"]
             * wuran : null
             * chuanyi : ["冷","天气冷，建议着棉服、羽绒服、皮夹克加羊毛衫等冬季服装。年老体弱者宜着厚棉衣、冬大衣或厚羽绒服。"]
             */

            private InfoBean info;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public InfoBean getInfo() {
                return info;
            }

            public void setInfo(InfoBean info) {
                this.info = info;
            }

            public static class InfoBean {
                private Object wuran;
                private List<String> kongtiao;
                private List<String> yundong;
                private List<String> ziwaixian;
                private List<String> ganmao;
                private List<String> xiche;
                private List<String> chuanyi;

                public Object getWuran() {
                    return wuran;
                }

                public void setWuran(Object wuran) {
                    this.wuran = wuran;
                }

                public List<String> getKongtiao() {
                    return kongtiao;
                }

                public void setKongtiao(List<String> kongtiao) {
                    this.kongtiao = kongtiao;
                }

                public List<String> getYundong() {
                    return yundong;
                }

                public void setYundong(List<String> yundong) {
                    this.yundong = yundong;
                }

                public List<String> getZiwaixian() {
                    return ziwaixian;
                }

                public void setZiwaixian(List<String> ziwaixian) {
                    this.ziwaixian = ziwaixian;
                }

                public List<String> getGanmao() {
                    return ganmao;
                }

                public void setGanmao(List<String> ganmao) {
                    this.ganmao = ganmao;
                }

                public List<String> getXiche() {
                    return xiche;
                }

                public void setXiche(List<String> xiche) {
                    this.xiche = xiche;
                }

                public List<String> getChuanyi() {
                    return chuanyi;
                }

                public void setChuanyi(List<String> chuanyi) {
                    this.chuanyi = chuanyi;
                }
            }
        }

        public static class Pm25Bean {
            private String key;
            private String show_desc;
            /**
             * curPm : 310
             * pm25 : 260
             * pm10 : 335
             * level : 6
             * quality : 严重污染
             * des : 健康人运动耐受力降低，有明显强烈症状，提前出现某些疾病 老年人和病人应当留在室内，避免体力消耗，一般人群应尽量减少户外活动。
             */

            private Pm25CustomBean pm25;
            private String dateTime;
            private String cityName;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getShow_desc() {
                return show_desc;
            }

            public void setShow_desc(String show_desc) {
                this.show_desc = show_desc;
            }

            public Pm25CustomBean getPm25() {
                return pm25;
            }

            public void setPm25(Pm25CustomBean pm25) {
                this.pm25 = pm25;
            }

            public String getDateTime() {
                return dateTime;
            }

            public void setDateTime(String dateTime) {
                this.dateTime = dateTime;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public static class Pm25CustomBean {
                private String curPm;
                private String pm25;
                private String pm10;
                private String level;
                private String quality;
                private String des;

                public String getCurPm() {
                    return curPm;
                }

                public void setCurPm(String curPm) {
                    this.curPm = curPm;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getPm10() {
                    return pm10;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getQuality() {
                    return quality;
                }

                public void setQuality(String quality) {
                    this.quality = quality;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }
        }

        public static class WeatherDayBean {
            private String date;
            private String week;
            private String nongli;
            /**
             * dawn : null
             * day : ["0","晴","6","西北风","3-4 级","07:25"]
             * night : ["0","晴","-6","西北风","3-4 级","17:11"]
             */

            private InfoBean info;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getNongli() {
                return nongli;
            }

            public void setNongli(String nongli) {
                this.nongli = nongli;
            }

            public InfoBean getInfo() {
                return info;
            }

            public void setInfo(InfoBean info) {
                this.info = info;
            }

            public static class InfoBean {
                private Object dawn;
                private List<String> day;
                private List<String> night;

                public Object getDawn() {
                    return dawn;
                }

                public void setDawn(Object dawn) {
                    this.dawn = dawn;
                }

                public List<String> getDay() {
                    return day;
                }

                public void setDay(List<String> day) {
                    this.day = day;
                }

                public List<String> getNight() {
                    return night;
                }

                public void setNight(List<String> night) {
                    this.night = night;
                }
            }
        }
    }
}
