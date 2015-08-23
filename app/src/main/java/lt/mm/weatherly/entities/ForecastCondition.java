package lt.mm.weatherly.entities;

import android.text.TextUtils;
import lt.mm.weatherly.adapters.RecyclerAdapter;
import org.codehaus.jackson.annotate.JsonProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by mariusmerkevicius on 8/22/15.
 */
public class ForecastCondition extends Condition implements RecyclerAdapter.IData {

    @JsonProperty(value = "dt")
    long dt;
    @JsonProperty(value = "pressure")
    double pressure;
    @JsonProperty(value = "humidity")
    int humidity;
    @JsonProperty(value = "speed")
    double speed;
    @JsonProperty(value = "deg")
    double deg;
    @JsonProperty(value = "clouds")
    int clouds;
    @JsonProperty(value = "temp")
    Temp temp;

    static String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    static {
        calendar = Calendar.getInstance();
    }

    private static Calendar calendar;

    public ForecastCondition() { }

    //region Getters / Setters

    //endregion

    //region Convenience

    //endregion

    //region Adapter Impl

    @Override
    public String getTitle() {
        if (dt == 0)
            return null;
        calendar.setTime(new Date(dt * 1000));
        return days[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }

    @Override
    public String getSubtitle() {
        if (getFirstWeather() == null)
            return null;
        return getFirstWeather().getMain();
    }

    @Override
    public String getFooter() {
        if (temp == null)
            return null;
        if (temp.getMax() == 0 && temp.getMin() == 0) // sanity check
            return null;
        StringBuilder sb = new StringBuilder();
        if (temp.getMax() > 0)
            sb.append(String.format("%.1f˚", temp.getMax()));
        if (temp.getMax() > 0 && temp.getMin() > 0)
            sb.append(" / ");
        if (temp.getMin() > 0)
            sb.append(String.format("%.1f˚", temp.getMin()));
        return sb.toString();
    }

    @Override
    public String getImageUrl() {
        return null; // fixme whenever image url or something is provided
    }


    //endregion

    //region Classes

    public static class Temp {
        @JsonProperty(value = "day")
        double day;
        @JsonProperty(value = "min")
        double min;
        @JsonProperty(value = "max")
        double max;
        @JsonProperty(value = "night")
        double night;
        @JsonProperty(value = "eve")
        double eve;
        @JsonProperty(value = "morn")
        double morn;

        public double getMin() {
            return min;
        }

        public double getMax() {
            return max;
        }

        @Override
        public String toString() {
            return "Temp{" +
                    "day=" + day +
                    ", min=" + min +
                    ", max=" + max +
                    ", night=" + night +
                    ", eve=" + eve +
                    ", morn=" + morn +
                    '}';
        }
    }

    //endregion


    @Override
    public String toString() {
        return "ForecastCondition{" +
                "dt=" + dt +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", speed=" + speed +
                ", deg=" + deg +
                ", clouds=" + clouds +
                ", temp=" + temp +
                '}';
    }
}
