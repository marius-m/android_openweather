package lt.mm.weatherly.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import lt.mm.weatherly.R;
import lt.mm.weatherly.entities.SearchResult;

/**
 * Created by mariusmerkevicius on 8/22/15.
 * Basic implementation of the fragment
 */
public abstract class BaseFragment<T> extends Fragment {

    public BaseFragment() { }

    //region Abstract

    abstract int layout();

    abstract void show(T result);

    abstract void hide();

    //endregion

    //region Logic

    public void update(T object) {
        if (object == null) {
            hide();
            return;
        }
        show(object);
    }

    //endregion

    //region Overrides

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(layout(), container, false);
    }

    //endregion

}
