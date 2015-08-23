package lt.mm.weatherly.network;

import com.android.volley.RequestQueue;
import lt.mm.weatherly.entities.SearchResult;
import lt.mm.weatherly.views.SearchView;

/**
 * Created by mariusmerkevicius on 8/22/15.
 */
public class SearchNetwork extends AbsNetwork<SearchResult> {

    public SearchNetwork(RequestQueue requestQueue) {
        super(requestQueue, SearchResult.class);
    }

    @Override
    String getBaseUrl() {
        return null;
    }
}
