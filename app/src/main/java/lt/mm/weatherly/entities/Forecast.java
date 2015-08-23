package lt.mm.weatherly.entities;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;

/**
 * Created by mariusmerkevicius on 8/23/15.
 */
public class Forecast {

    // Main
    @JsonProperty(value = "id")
    int id;
    @JsonProperty(value = "cod")
    int cod;
    @JsonProperty(value = "message")
    String message;

    @JsonProperty(value = "list")
    ArrayList<ExCondition> list;


    //region Getters / Setters

    public ArrayList<ExCondition> getList() {
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
