package lt.mm.weatherly.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import lt.mm.weatherly.R;

/**
 * Created by mariusmerkevicius on 8/22/15.
 * Basic implementation of the fragment
 */
public class BaseFragment extends Fragment {

    public BaseFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        return view;
    }
}
