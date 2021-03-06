package lt.mm.weatherly.fragments;

import lt.mm.weatherly.adapters.RecyclerAdapter;
import lt.mm.weatherly.entities.Hourly;

import java.util.ArrayList;

/**
 * Created by mariusmerkevicius on 8/22/15.
 * Class that describe how now fragment controller should hook logic with display
 */
public class FragmentHourly extends FragmentList<Hourly> {

    @Override
    ArrayList<? extends RecyclerAdapter.IData> getListModel(Hourly result) {
        return result.getList();
    }

    @Override
    Class getClassType() {
        return Hourly.class;
    }
}

