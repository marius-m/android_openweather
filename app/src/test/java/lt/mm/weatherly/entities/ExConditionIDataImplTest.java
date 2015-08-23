package lt.mm.weatherly.entities;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by mariusmerkevicius on 8/23/15.
 */
@RunWith(RobolectricTestRunner.class)
public class ExConditionIDataImplTest {
    @Test
    public void testNullTitle() throws Exception {
        ExCondition condition = new ExCondition();
        condition.dtText = null;
        assertNull(condition.getTitle());
    }

    @Test
    public void testProperTitle() throws Exception {
        ExCondition condition = new ExCondition();
        condition.dtText = "asdf";
        assertNotNull(condition.getTitle());
    }

    @Test
    public void testNullSubtitle() throws Exception {
        ExCondition condition = new ExCondition();
        condition.weather = null;
        assertNull(condition.getSubtitle());
    }

    @Test
    public void testEmptySubtitle() throws Exception {
        ExCondition condition = new ExCondition();
        condition.weather = new ArrayList<>();
        assertNull(condition.getSubtitle());
    }

    @Test
    public void testMalformedWeatherSubtitle() throws Exception {
        ExCondition condition = new ExCondition();
        condition.weather = new ArrayList<Condition.Weather>(){{
            add(new Condition.Weather());
        }};
        assertNull(condition.getSubtitle());
    }

    @Test
    public void testProperWeatherSubtitle() throws Exception {
        ExCondition condition = new ExCondition();
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
        ExCondition condition = new ExCondition();
        condition.main = null;
        assertNull(condition.getFooter());
    }

    @Test
    public void testMalformedFooter() throws Exception {
        ExCondition condition = new ExCondition();
        condition.main = new Condition.Main();
        assertNull(condition.getFooter());
    }

    @Test
    public void testProperFooter() throws Exception {
        ExCondition condition = new ExCondition();
        condition.main = new Condition.Main() {{
            temp = 23.4f;
        }};
        assertNotNull(condition.getFooter());
        assertEquals("23.4˚", condition.getFooter());
    }

}