package lt.mm.weatherly.entities;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;

/**
 * Created by mariusmerkevicius on 8/23/15.
 */
public class Hourly {

    // Main
    @JsonProperty(value = "id")
    int id;
    @JsonProperty(value = "cod")
    int cod;
    @JsonProperty(value = "message")
    String message;

    @JsonProperty(value = "list")
    ArrayList<HourlyCondition> list;


    //region Getters / Setters

    public ArrayList<HourlyCondition> getList() {
        return list;
    }

    //endregion

    @Override
    public String toString() {
        return "Forecast{" +
                "id=" + id +
                ", cod=" + cod +
                ", message='" + message + '\'' +
                '}';
    }
}
