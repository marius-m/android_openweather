package lt.mm.weatherly.entities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by mariusmerkevicius on 8/23/15.
 */
@RunWith(RobolectricTestRunner.class)
public class ForecastConditionIDateImplTest {
    @Test
    public void testNullTitle() throws Exception {
        ForecastCondition condition = new ForecastCondition();
        condition.dt = 0;
        assertNull(condition.getTitle());
    }

    @Test
    public void testProperTitle() throws Exception {
        ForecastCondition condition = new ForecastCondition();
        condition.dt = 1440321725 * 1000;
        assertNotNull(condition.getTitle());
        assertEquals("Thursday", condition.getTitle());
    }

    @Test
    public void testProperTitle1() throws Exception {
        ForecastCondition condition = new ForecastCondition();
        condition.dt = 1440321725 * 1000;
        condition.dt += 1000 * 60 * 60 * 24;
        assertNotNull(condition.getTitle());
        assertEquals("Wednesday", condition.getTitle());
    }

    @Test
    public void testProperTitle2() throws Exception {
        ForecastCondition condition = new ForecastCondition();
        condition.dt = 1440321725 * 1000;
        condition.dt += 2 * (1000 * 60 * 60 * 24);
        assertNotNull(condition.getTitle());
        assertEquals("Tuesday", condition.getTitle());
    }

    @Test
    public void testNullSubtitle() throws Exception {
        ForecastCondition condition = new ForecastCondition();
        condition.weather = null;
        assertNull(condition.getSubtitle());
    }

    @Test
    public void testEmptySubtitle() throws Exception {
        ForecastCondition condition = new ForecastCondition();
        condition.weather = new ArrayList<>();
        assertNull(condition.getSubtitle());
    }

    @Test
    public void testMalformedWeatherSubtitle() throws Exception {
        ForecastCondition condition = new ForecastCondition();
        condition.weather = new ArrayList<Condition.Weather>(){{
            add(new Condition.Weather());
        }};
        assertNull(condition.getSubtitle());
    }

    @Test
    public void testProperWeatherSubtitle() throws Exception {
        ForecastCondition condition = new ForecastCondition();
        condition.weather = new ArrayList<Condition.Weather>(){{
            add(new Condition.Weather(){{
                main = "asdf";
            }});
        }};
        assertNotNull(condition.getSubtitle());
        assertEquals("asdf", condition.getSubtitle());
    }

    @Test
    public void testNullFooter() throws Exception {
        ForecastCondition condition = new ForecastCondition();
        condition.temp = null;
        assertNull(condition.getFooter());
    }

    @Test
    public void testEmptyFooter() throws Exception {
        ForecastCondition condition = new ForecastCondition();
        condition.temp = new ForecastCondition.Temp();
        assertNull(condition.getFooter());
    }

    @Test
    public void testOnlyMaxFooter() throws Exception {
        ForecastCondition condition = new ForecastCondition();
        condition.temp = new ForecastCondition.Temp(){{
            max = 12.1;
            min = 0;
        }};
        assertNotNull(condition.getFooter());
        assertEquals("12.1˚", condition.getFooter());
    }

    @Test
    public void testOnlyMinFooter() throws Exception {
        ForecastCondition condition = new ForecastCondition();
        condition.temp = new ForecastCondition.Temp(){{
            max = 0;
            min = 12.1;
        }};
        assertNotNull(condition.getFooter());
        assertEquals("12.1˚", condition.getFooter());
    }

    @Test
    public void testProperFooter() throws Exception {
        ForecastCondition condition = new ForecastCondition();
        condition.temp = new ForecastCondition.Temp(){{
            max = 13.3;
            min = 12.1;
        }};
        assertNotNull(condition.getFooter());
        assertEquals("13.3˚ / 12.1˚", condition.getFooter());
    }

}