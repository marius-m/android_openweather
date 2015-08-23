package lt.mm.weatherly.network.binders;

import android.text.TextUtils;
import lt.mm.weatherly.Constants;
import lt.mm.weatherly.entities.SearchResult;
import lt.mm.weatherly.network.AbsNetwork;

/**
 * Created by mariusmerkevicius on 8/23/15.
 */
public class NetworkBinderHourly implements AbsNetwork.Binder {
    
    @Override
    public Class getClassType() {
        return Object.class;
    }

    @Override
    public String formUrl(String... args) {
        if (args == null)
            return null;
        if (args.length == 0)
            return null;
        return String.format(Constants.URL_NOW, ((TextUtils.isEmpty(args[0])) ? "" : args[0]));
    }
}
