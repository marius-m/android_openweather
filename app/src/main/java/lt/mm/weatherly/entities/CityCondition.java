package lt.mm.weatherly.entities;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by mariusmerkevicius on 8/23/15.
 */
public class CityCondition extends Condition {

    // Main
    @JsonProperty(value = "id")
    int id;
    @JsonProperty(value = "name")
    String name;
    @JsonProperty(value = "cod")
    int cod;
    @JsonProperty(value = "dt")
    long dt;
    @JsonProperty(value = "base")
    String base;

    //region Getters / Setters

    public long getDt() {
        return dt;
    }

    //endregion


    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cod=" + cod +
                ", dt=" + dt +
                ", base='" + base + '\'' +
                '}';
    }
}
