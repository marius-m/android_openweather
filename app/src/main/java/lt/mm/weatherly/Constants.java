package lt.mm.weatherly;

/**
 * Created by mariusmerkevicius on 8/22/15.
 */
public class Constants {
    public static final String TAG = "Weatherly";
    public static final boolean DEBUG = true;

    public static final String URL_NOW = "http://api.openweathermap.org/data/2.5/weather?units=metric&q=%s";
    public static final String URL_HOURLY = "http://api.openweathermap.org/data/2.5/forecast?units=metric&q=%s";
    public static final String URL_FORECAST = "http://api.openweathermap.org/data/2.5/forecast/daily?units=metric&q=%s";
    public static final String API_KEY = "77bb6fd2d07ebb334da21ef5b2106056";
}
