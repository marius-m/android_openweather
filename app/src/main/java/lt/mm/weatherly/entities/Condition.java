package lt.mm.weatherly.entities;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;

/**
 * Created by mariusmerkevicius on 8/22/15.
 */
public class Condition {

    // Other
    @JsonProperty(value = "sys")
    Sys sys;
    @JsonProperty(value = "clouds")
    Clouds clouds;
    @JsonProperty(value = "wind")
    Wind wind;
    @JsonProperty(value = "main")
    Main main;
    @JsonProperty(value = "weather")
    ArrayList<Weather> weather;
    @JsonProperty(value = "coord")
    Coord coord;

    //region Getters / Setters

    public Weather getFirstWeather() {
        if (weather == null)
            return null;
        if (weather.size() > 0)
            return weather.get(0);
        return null;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Sys getSys() {
        return sys;
    }

    //endregion

    @Override
    public String toString() {
        return "Condition{" +
                ", sys=" + sys +
                ", clouds=" + clouds +
                ", wind=" + wind +
                ", main=" + main +
                ", weather=" + weather +
                ", coord=" + coord +
                '}';
    }

    //region Classes

    public static class Coord {
        @JsonProperty(value = "lon")
        double lon;
        @JsonProperty(value = "lat")
        double lat;

        @Override
        public String toString() {
            return "Coord{" +
                    "lon=" + lon +
                    ", lat=" + lat +
                    '}';
        }
    }

    public static class Weather {
        @JsonProperty(value = "id")
        int id;
        @JsonProperty(value = "main")
        String main;
        @JsonProperty(value = "description")
        String description;
        @JsonProperty(value = "icon")
        String icon;

        public String getIcon() {
            return icon;
        }

        public String getMain() {
            return main;
        }
    }

    public static class Main {
        @JsonProperty(value = "temp")
        double temp;
        @JsonProperty(value = "pressure")
        double pressure;
        @JsonProperty(value = "humidity")
        double humidity;
        @JsonProperty(value = "temp_min")
        double tempMin;
        @JsonProperty(value = "temp_max")
        double tempMax;

        public double getTemp() {
            return temp;
        }

        public double getPressure() {
            return pressure;
        }

        public double getHumidity() {
            return humidity;
        }

        public double getTempMin() {
            return tempMin;
        }

        public double getTempMax() {
            return tempMax;
        }

        @Override
        public String toString() {
            return "Main{" +
                    "temp=" + temp +
                    ", pressure=" + pressure +
                    ", humidity=" + humidity +
                    ", tempMin=" + tempMin +
                    ", tempMax=" + tempMax +
                    '}';
        }
    }

    public static class Wind {
        @JsonProperty(value = "speed")
        double speed;
        @JsonProperty(value = "deg")
        int deg;

        public double getSpeed() {
            return speed;
        }

        @Override
        public String toString() {
            return "Wind{" +
                    "speed=" + speed +
                    ", deg=" + deg +
                    '}';
        }
    }

    public static class Clouds {
        @JsonProperty(value = "all")
        int all;

        @Override
        public String toString() {
            return "Clouds{" +
                    "all=" + all +
                    '}';
        }
    }

    public static class Sys {
        @JsonProperty(value = "type")
        int type;
        @JsonProperty(value = "id")
        int id;
        @JsonProperty(value = "message")
        String message;
        @JsonProperty(value = "country")
        String country;
        @JsonProperty(value = "sunrise")
        long sunrise;
        @JsonProperty(value = "sunset")
        long sunset;


        public long getSunrise() {
            return sunrise;
        }

        public long getSunset() {
            return sunset;
        }

        @Override
        public String toString() {
            return "Sys{" +
                    "type=" + type +
                    ", id=" + id +
                    ", message='" + message + '\'' +
                    ", country='" + country + '\'' +
                    ", sunrise=" + sunrise +
                    ", sunset=" + sunset +
                    '}';
        }
    }

    //endregion

}
