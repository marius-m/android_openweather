package lt.mm.weatherly.fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import lt.mm.weatherly.R;
import lt.mm.weatherly.entities.CityCondition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by mariusmerkevicius on 8/22/15.
 * Class that describe how now fragment controller should hook logic with display
 */
public class FragmentNow extends BaseFragment<CityCondition> {

    // Views
    private View mainContainer;
    private View emptyContainer;
    private ImageView imageViewBig;
    private ImageView imageViewSmall;
    private TextView textMajorConditionVerbal;
    private TextView textMajorConditionNumber;
    private TextView textMinorHl;
    private TextView textMinorHumidity;
    private TextView textMinorWinds;
    private TextView textMinorSunrise;
    private TextView textMinorSunset;

    // Other
    SimpleDateFormat simpleDateFormat;

    public FragmentNow() {
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

    }

    @Override
    int getLayoutId() {
        return R.layout.fragment_now;
    }

    @Override
    void onInflate(View view) {

        // Base views
        mainContainer = view.findViewById(R.id.container_main);
        emptyContainer = view.findViewById(R.id.container_empty);

        // Views to fill info
        imageViewBig = (ImageView) view.findViewById(R.id.image_big);
        imageViewSmall = (ImageView) view.findViewById(R.id.image_small);
        textMajorConditionVerbal = (TextView) view.findViewById(R.id.text_major_condition_verbal);
        textMajorConditionNumber = (TextView) view.findViewById(R.id.text_major_condition_number);
        textMinorHl = (TextView) view.findViewById(R.id.text_minor_hl);
        textMinorHumidity = (TextView) view.findViewById(R.id.text_minor_humidity);
        textMinorWinds = (TextView) view.findViewById(R.id.text_minor_winds);
        textMinorSunrise = (TextView) view.findViewById(R.id.text_minor_sunrise);
        textMinorSunset = (TextView) view.findViewById(R.id.text_minor_sunset);
    }

    @Override
    void onShow(CityCondition result) {
        mainContainer.setVisibility(View.VISIBLE);
        emptyContainer.setVisibility(View.GONE);

        if (result.getFirstWeather() != null)
            textMajorConditionVerbal.setText(result.getFirstWeather().getMain());
        if (result.getMain() != null) {
            // API shortcoming, cant find a way to tell the API, to return in celcius, so makind a conversion.
            textMajorConditionNumber.setText(String.format("%.0f˚", result.getMain().getTemp()));
            textMinorHl.setText(
                    String.format("H: %.0f˚ / L: %.0f˚",
                            result.getMain().getTempMax(),
                            result.getMain().getTempMin()
                    )
            );
            textMinorHumidity.setText(String.format("%.0f", result.getMain().getHumidity()));
            textMinorWinds.setText(String.format("%.2f m/s", result.getWind().getSpeed()));
            // fixme : probably not a proper way to calculate sunrise/sunset - need to read documentation
            textMinorSunrise.setText(simpleDateFormat.format(new Date(System.currentTimeMillis() + result.getSys().getSunrise())));
            textMinorSunset.setText(simpleDateFormat.format(new Date(System.currentTimeMillis() + result.getSys().getSunset())));
        }
    }

//    private double getCelsiusFromKelvin(double kelvin) {
//        return kelvin - 273.0;
//    }

    @Override
    void onHide() {
        mainContainer.setVisibility(View.GONE);
        emptyContainer.setVisibility(View.VISIBLE);
    }
}

