package lt.mm.weatherly.network;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by mariusmerkevicius on 8/23/15.
 * Tests out {@link AbsNetwork} class for load state changes whenever load is initialized
 */
@RunWith(RobolectricTestRunner.class)
public class AbsNetworkLoadStateTest {
    private AbsNetwork network;
    private LoadStateListener listener;
    private RequestQueue requestQueue;

    @Before
    public void setUp() throws Exception {
        listener = mock(LoadStateListener.class);
        requestQueue = mock(RequestQueue.class);
        network = new AbsNetwork(requestQueue) {
            // No abstract methods to implement
        };
        network.setBinder(mock(AbsNetwork.Binder.class));
        network.setLoadStateListener(listener);
    }


    @Test
    public void testStartLoad() throws Exception {
        assertFalse(network.isLoading());
        network.load();
        verify(listener, times(1)).onLoadStateChange(true);
        assertTrue(network.isLoading());
    }

    @Test
    public void testStartEndLoadSuccess() throws Exception {
        assertFalse(network.isLoading());
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                network.successListener.onResponse(new String());
                return null;
            }
        }).when(requestQueue).start();
        network.load();
        verify(listener, times(2)).onLoadStateChange(any(Boolean.class));
        assertFalse(network.isLoading());
    }

    @Test
    public void testStartEndLoadFail() throws Exception {
        assertFalse(network.isLoading());
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                network.errorListener.onErrorResponse(new VolleyError());
                return null;
            }
        }).when(requestQueue).start();
        network.load();
        verify(listener, times(2)).onLoadStateChange(any(Boolean.class));
        assertFalse(network.isLoading());
    }
}