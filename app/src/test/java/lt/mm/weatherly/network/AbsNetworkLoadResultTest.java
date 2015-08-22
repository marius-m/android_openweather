package lt.mm.weatherly.network;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.Assert.assertFalse;
import static org.mockito.Mockito.*;

/**
 * Created by mariusmerkevicius on 8/22/15.
 * Tests out {@link AbsNetwork} for when class is finished loading, to make sure the proper methods
 * are called
 */
@RunWith(RobolectricTestRunner.class)
public class AbsNetworkLoadResultTest {
    private AbsNetwork network;
    private LoadResultListener listener;
    private RequestQueue requestQueue;

    @Before
    public void setUp() throws Exception {
        listener = mock(LoadResultListener.class);
        requestQueue = mock(RequestQueue.class);
        network = new AbsNetwork(requestQueue, String.class) {
            // No abstract methods to implement
        };
        network.setLoadResultListener(listener);
    }

    @Test
    public void testLoadShouldStartQueue() throws Exception {
        network.load();
        verify(requestQueue, times(1)).start();
    }

    @Test
    public void testWhenQueueStartCallbackSuccess() throws Exception {
        final Object responseObject = mock(Object.class);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                network.successListener.onResponse(responseObject);
                return null;
            }
        }).when(requestQueue).start();
        network.load();
        verify(listener, times(1)).onLoadSuccess(responseObject);
    }


    @Test
    public void testWhenQueueStartCallbackFail() throws Exception {
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                network.errorListener.onErrorResponse(new VolleyError());
                return null;
            }
        }).when(requestQueue).start();
        network.load();
        verify(listener, times(1)).onLoadFail(any(String.class));
    }


}