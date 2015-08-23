package lt.mm.weatherly.adapters;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by mariusmerkevicius on 8/23/15.
 */
@RunWith(RobolectricTestRunner.class)
public class RecyclerAdapterTextHandleTest {

    private RecyclerAdapter adapter;

    @Before
    public void setUp() throws Exception {
        adapter = new RecyclerAdapter();
    }

    @Test // Should ignore changes and avoid crash
    public void testNullView() throws Exception {
        adapter.handleText(null, "asdf");
    }

    @Test // Should hide input
    public void testTextViewNullInput() throws Exception {
        TextView textView = mock(TextView.class);
        adapter.handleText(textView, null);
        verify(textView, times(1)).setVisibility(View.INVISIBLE);
        verify(textView, never()).setVisibility(View.VISIBLE);
        verify(textView, never()).setText(any(String.class));
    }

    @Test // Should hide input
    public void testTextViewEmptyInput() throws Exception {
        TextView textView = mock(TextView.class);
        adapter.handleText(textView, "");
        verify(textView, times(1)).setVisibility(View.INVISIBLE);
        verify(textView, never()).setVisibility(View.VISIBLE);
        verify(textView, never()).setText(any(String.class));
    }

    @Test // Should show input
    public void testTextViewProperInput() throws Exception {
        TextView textView = mock(TextView.class);
        adapter.handleText(textView, "asdf");
        verify(textView, never()).setVisibility(View.INVISIBLE);
        verify(textView, times(1)).setVisibility(View.VISIBLE);
        verify(textView, times(1)).setText("asdf");
    }

    @Test // Should hide input
    public void testImageViewNullInput() throws Exception {
        ImageView imageView = mock(ImageView.class);
        adapter.handleText(imageView, null);
        verify(imageView, times(1)).setVisibility(View.GONE);
        verify(imageView, never()).setVisibility(View.VISIBLE);
        verify(imageView, never()).setImageBitmap(any(Bitmap.class));
    }

    @Test // Should hide input
    public void testImageViewEmptyInput() throws Exception {
        ImageView imageView = mock(ImageView.class);
        adapter.handleText(imageView, "");
        verify(imageView, times(1)).setVisibility(View.GONE);
        verify(imageView, never()).setVisibility(View.VISIBLE);
        verify(imageView, never()).setImageBitmap(any(Bitmap.class));
    }

    @Test // Should show input
    public void testImageViewProperInput() throws Exception {
        ImageView imageView = mock(ImageView.class);
        adapter.handleText(imageView, "asdf");
        verify(imageView, never()).setVisibility(View.GONE);
        verify(imageView, times(1)).setVisibility(View.VISIBLE);
        verify(imageView, times(1)).setImageBitmap(any(Bitmap.class));
    }
}