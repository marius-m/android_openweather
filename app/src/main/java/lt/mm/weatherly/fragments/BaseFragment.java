package lt.mm.weatherly.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mariusmerkevicius on 8/22/15.
 * Basic implementation of the fragment
 */
public abstract class BaseFragment<T> extends Fragment {

    public BaseFragment() { }

    //region Abstract

    abstract int getLayoutId();

    abstract void onInflate(View view);

    abstract void onShow(T result);

    abstract void onHide();

    //endregion

    //region Logic

    public void update(T object) {
        if (object == null) {
            onHide();
            return;
        }
        onShow(object);
    }

    //endregion

    //region Overrides

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        onInflate(view);
        return view;
    }

    //endregion

}
