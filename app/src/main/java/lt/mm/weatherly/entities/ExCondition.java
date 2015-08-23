package lt.mm.weatherly.entities;

import android.text.TextUtils;
import lt.mm.weatherly.adapters.RecyclerAdapter;
import org.codehaus.jackson.annotate.JsonProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by mariusmerkevicius on 8/22/15.
 */
public class ExCondition extends Condition implements RecyclerAdapter.IData {

    private final SimpleDateFormat inputFormat;
    private final SimpleDateFormat outputFormat;

    @JsonProperty(value = "dt")
    long dt;
    @JsonProperty(value = "dt_txt")
    String dtText;

    public ExCondition() {
        inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        outputFormat = new SimpleDateFormat("HH:mm");
    }

    //region Getters / Setters

    public long getDt() {
        return dt;
    }

    public String getDtText() {
        return dtText;
    }

    //endregion

    //region Convenience

    /**
     * Converts input time to hourly format only
     * @param dtText input text
     * @return hourly format
     */
    String convertDateToTitle(String dtText) {
        if (TextUtils.isEmpty(dtText))
            return null;
        try {
            return outputFormat.format(inputFormat.parse(dtText));
        } catch (ParseException e) { }
        return null;
    }

    //endregion

    //region Adapter Impl

    @Override
    public String getTitle() {
        return convertDateToTitle(dtText);
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
