package lt.mm.weatherly.fragments;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import lt.mm.weatherly.R;
import lt.mm.weatherly.adapters.RecyclerAdapter;
import lt.mm.weatherly.entities.SearchResult;

/**
 * Created by mariusmerkevicius on 8/22/15.
 * Class that describe how now fragment controller should hook logic with display
 */
public class FragmentHourly extends BaseFragment {

    public FragmentHourly() {
    }

    @Override
    int getLayoutId() {
        return R.layout.fragment_hourly;
    }

    @Override
    void onInflate(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.container_main);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerAdapter(new String[]{"First", "Second", "Third"}));
    }

    @Override
    void onShow(Object result) {

    }

    @Override
    void onHide() {

    }
}

