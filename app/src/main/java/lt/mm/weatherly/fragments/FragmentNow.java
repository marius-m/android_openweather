package lt.mm.weatherly.fragments;

import android.util.Log;
import lt.mm.weatherly.R;
import lt.mm.weatherly.entities.SearchResult;

/**
 * Created by mariusmerkevicius on 8/22/15.
 * Class that describe how now fragment controller should hook logic with display
 */
public class FragmentNow extends BaseFragment<SearchResult> {

    @Override
    int layout() {
        return R.layout.fragment_now;
    }

    @Override
    void show(SearchResult result) {
        Log.e("asdf", "Showing something");
    }

    @Override
    void hide() {
        Log.e("asdf", "Hiding everything");
    }
}

