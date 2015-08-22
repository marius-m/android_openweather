package lt.mm.weatherly.entities;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;

/**
 * Created by mariusmerkevicius on 8/22/15.
 * A data holder for search result
 */
public class SearchResult {

    // Main
    @JsonProperty(value = "id")
    int id;
    @JsonProperty(value = "name")
    String name;
    @JsonProperty(value = "cod")
    int cod;
    @JsonProperty(value = "dt")
    long dt;
    @JsonProperty(value = "base")
    String base;

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

    @Override
    public String toString() {
        return "SearchResult{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                ", dt=" + dt +
                ", base='" + base + '\'' +
                ", sys=" + sys +
                ", clouds=" + clouds +
                ", wind=" + wind +
                ", main=" + main +
                ", weather=" + weather +
                ", coord=" + coord +
                '}';
    }

    //region Classes

    private static class Coord {
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

    private static class Weather {
        @JsonProperty(value = "id")
        int id;
        @JsonProperty(value = "main")
        String main;
        @JsonProperty(value = "description")
        String description;
        @JsonProperty(value = "icon")
        String icon;
    }

    private static class Main {
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

    private static class Wind {
        @JsonProperty(value = "speed")
        double speed;
        @JsonProperty(value = "deg")
        int deg;

        @Override
        public String toString() {
            return "Wind{" +
                    "speed=" + speed +
                    ", deg=" + deg +
                    '}';
        }
    }

    private static class Clouds {
        @JsonProperty(value = "all")
        int all;

        @Override
        public String toString() {
            return "Clouds{" +
                    "all=" + all +
                    '}';
        }
    }

    private static class Sys {
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
