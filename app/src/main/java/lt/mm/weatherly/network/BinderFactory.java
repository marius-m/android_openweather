package lt.mm.weatherly.network;

import lt.mm.weatherly.network.binders.NetworkBinderForecast;
import lt.mm.weatherly.network.binders.NetworkBinderHourly;
import lt.mm.weatherly.network.binders.NetworkBinderNow;

/**
 * Created by mariusmerkevicius on 8/23/15.
 */
public class BinderFactory {

    private NetworkBinderNow now;
    private NetworkBinderHourly hourly;
    private NetworkBinderForecast forecast;

    public AbsNetwork.Binder now() {
        if (now == null)
            now = new NetworkBinderNow();
        return now;
    }

    public AbsNetwork.Binder hourly() {
        if (hourly == null)
            hourly = new NetworkBinderHourly();
        return hourly;
    }

    public AbsNetwork.Binder forecast() {
        if (forecast == null)
            forecast = new NetworkBinderForecast();
        return forecast;
    }
}
