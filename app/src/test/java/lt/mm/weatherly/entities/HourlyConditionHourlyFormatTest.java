package lt.mm.weatherly.entities;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

/**
 * Created by mariusmerkevicius on 8/23/15.
 */
@RunWith(RobolectricTestRunner.class)
public class HourlyConditionHourlyFormatTest {

    private HourlyCondition condition;

    @Before
    public void setUp() throws Exception {
        condition = new HourlyCondition();
    }

    @Test
    public void testInputNull() throws Exception {
        condition = new HourlyCondition();
        assertNull(condition.convertDateToTitle(null));
    }

    @Test
    public void testInputEmpty() throws Exception {
        assertNull(condition.convertDateToTitle(""));
    }

    @Test
    public void testInputMalformed() throws Exception {
        assertNull(condition.convertDateToTitle("asdf"));
    }
    @Test
    public void testInputProper() throws Exception {
        String convert = condition.convertDateToTitle("1969-12-31 16:00:00");
        assertNotNull(convert);
        assertEquals("16:00", convert);
    }
}