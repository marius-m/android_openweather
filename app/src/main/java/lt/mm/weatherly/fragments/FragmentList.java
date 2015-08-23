package lt.mm.weatherly.fragments;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import lt.mm.weatherly.R;
import lt.mm.weatherly.adapters.RecyclerAdapter;

import java.util.ArrayList;

/**
 * Created by mariusmerkevicius on 8/23/15.
 * Base implementation when displaying model in the list
 */
public abstract class FragmentList<T> extends BaseFragment<T> {
    private RecyclerAdapter adapter;
    private View mainContainer;
    private View emptyContainer;

    public FragmentList() { }

    @Override
    int getLayoutId() {
        return R.layout.fragment_hourly;
    }

    @Override
    void onInflate(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.container_main);
        mainContainer = view.findViewById(R.id.container_main);
        emptyContainer = view.findViewById(R.id.container_empty);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    void onShow(T result) {
        if (result == null)
            return;
        mainContainer.setVisibility(View.VISIBLE);
        emptyContainer.setVisibility(View.GONE);
        adapter.setData(getListModel(result));
    }

    @Override
    void onHide() {
        mainContainer.setVisibility(View.GONE);
        emptyContainer.setVisibility(View.VISIBLE);
    }

    abstract ArrayList<? extends RecyclerAdapter.IData> getListModel(T result);

}
