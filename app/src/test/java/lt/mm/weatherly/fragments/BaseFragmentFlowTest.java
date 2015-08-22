package lt.mm.weatherly.fragments;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by mariusmerkevicius on 8/23/15.
 * Tests out basic show flow
 */
@RunWith(RobolectricTestRunner.class)
public class BaseFragmentFlowTest {

    private BaseFragment fragment;

    @Before
    public void setUp() throws Exception {
        fragment = spy(new BaseFragment() {
            @Override
            int layout() {
                return 0;
            }

            @Override
            void show(Object result) { }

            @Override
            void hide() { }
        });

    }

    @Test
    public void testUpdateNull() throws Exception {
        fragment.update(null);
        verify(fragment, times(1)).hide();
        verify(fragment, never()).show(any(Object.class));
    }

    @Test
    public void testUpdateValidObject() throws Exception {
        Object objectToShow = mock(Object.class);
        fragment.update(objectToShow);
        verify(fragment, never()).hide();
        verify(fragment, times(1)).show(objectToShow);
    }
}