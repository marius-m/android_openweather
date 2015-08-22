package lt.mm.weatherly.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by mariusmerkevicius on 8/22/15.
 */
@RunWith(RobolectricTestRunner.class)
public class UserInputControllerTest {

    private UserInputController inputController;
    private UserInputController.Listener inputListener;

    @Test
    public void testInitNull() throws Exception {
        // Should not throw anything
        new UserInputController(null);
    }

    @Before
    public void setUp() throws Exception {
        inputListener = mock(UserInputController.Listener.class);
        inputController = new UserInputController(inputListener);

    }

    @Test
    public void testValidInput() throws Exception {
        inputController.handleInput("asdf");
        verify(inputListener, never()).onInputChange("asdf");
        Robolectric.flushForegroundThreadScheduler();
        verify(inputListener, times(1)).onInputChange("asdf");
    }

    @Test
    public void testValidMultipleInputChange() throws Exception {
        inputController.handleInput("a");
        inputController.handleInput("as");
        inputController.handleInput("asd");
        inputController.handleInput("asdf");
        verify(inputListener, never()).onInputChange(any(String.class));
        Robolectric.flushForegroundThreadScheduler();
        verify(inputListener, times(1)).onInputChange("asdf");
    }

    @Test
    public void testValidMultipleInputChangeAndClear() throws Exception {
        inputController.handleInput("a");
        inputController.handleInput("as");
        inputController.handleInput("asd");
        inputController.handleInput("asdf");
        verify(inputListener, never()).onInputChange(any(String.class));
        Robolectric.flushForegroundThreadScheduler();
        verify(inputListener, times(1)).onInputChange("asdf");
        inputController.handleInput("");
        verify(inputListener, times(1)).onInputClear();
    }

    @Test
    public void testValidMultipleInputAndClearInstantly() throws Exception {
        inputController.handleInput("a");
        inputController.handleInput("as");
        inputController.handleInput("asd");
        inputController.handleInput("asdf");
        inputController.handleInput("");
        verify(inputListener, never()).onInputChange(any(String.class));
        verify(inputListener, times(1)).onInputClear();
    }

}