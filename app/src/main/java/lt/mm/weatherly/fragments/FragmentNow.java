package lt.mm.weatherly.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import lt.mm.weatherly.R;

/**
 * Created by mariusmerkevicius on 8/22/15.
 */
public class FragmentNow extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_now, container, false);
        return view;
    }

}

