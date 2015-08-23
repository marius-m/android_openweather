package lt.mm.weatherly.network.binders;

import android.text.TextUtils;
import lt.mm.weatherly.Constants;
import lt.mm.weatherly.entities.Hourly;
import lt.mm.weatherly.network.AbsNetwork;

/**
 * Created by mariusmerkevicius on 8/23/15.
 * Binder configuration that represents the formed url and its class reflection for the response
 */
public class NetworkBinderHourly implements AbsNetwork.Binder<Hourly> {
    
    @Override
    public Class getClassType() {
        return Hourly.class;
    }

    @Override
    public String formUrl(String... args) {
        if (args == null)
            return null;
        if (args.length == 0)
            return null;
        return String.format(Constants.URL_HOURLY, ((TextUtils.isEmpty(args[0])) ? "" : args[0]));
    }
}
