package lt.mm.weatherly.entities;

import lt.mm.weatherly.adapters.RecyclerAdapter;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;

/**
 * Created by mariusmerkevicius on 8/22/15.
 */
public class ExCondition extends Condition implements RecyclerAdapter.IData {

    @JsonProperty(value = "dt")
    long dt;
    @JsonProperty(value = "dt_txt")
    String dtText;

    //region Getters / Setters

    public long getDt() {
        return dt;
    }

    public String getDtText() {
        return dtText;
    }

    //endregion

    //region Adapter Impl

    @Override
    public String getTitle() {
        return dtText;
    }

    @Override
    public String getSubtitle() {
        if (getFirstWeather() == null)
            return null;
        return getFirstWeather().getMain();
    }

    @Override
    public String getFooter() {
        if (getMain() == null)
            return null;
        if (getMain().getTemp() == 0)
            return null;
        return String.format("%.1f˚", getMain().getTemp());
    }

    @Override
    public String getImageUrl() {
        return null; // fixme Fix this
    }


    //endregion

}
