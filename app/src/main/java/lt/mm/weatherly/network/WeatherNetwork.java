package lt.mm.weatherly.network;

import com.android.volley.RequestQueue;

/**
 * Created by mariusmerkevicius on 8/22/15.
 * A concrete networking class that is set to download information about the weather
 */
public class WeatherNetwork extends AbsNetwork {

    public WeatherNetwork(RequestQueue requestQueue) {
        super(requestQueue);
    }

}
