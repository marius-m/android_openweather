package lt.mm.weatherly.fragments;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

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
            int getLayoutId() {
                return 0;
            }

            @Override
            void onShow(Object result) { }

            @Override
            void onHide() { }
        });

    }

    @Test
    public void testUpdateNull() throws Exception {
        fragment.update(null);
        verify(fragment, times(1)).onHide();
        verify(fragment, never()).onShow(any(Object.class));
    }

    @Test
    public void testUpdateValidObject() throws Exception {
        Object objectToShow = mock(Object.class);
        fragment.update(objectToShow);
        verify(fragment, never()).onHide();
        verify(fragment, times(1)).onShow(objectToShow);
    }
}