package lt.mm.weatherly.network;

import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by mariusmerkevicius on 7/26/15.
 * Wrapper class that is responsible for handling networking functions
 */
public abstract class AbsNetwork {
    protected RequestQueue queue;
    protected JsonRequest request;

    Binder binder;
    LoadResultListener loadResultListener;
    LoadStateListener loadStateListener;
    boolean loading = false;

    public AbsNetwork(RequestQueue requestQueue) {
        if (requestQueue == null)
            throw new IllegalArgumentException("Cant function without RequestQueue!");
        this.queue = requestQueue;
    }

    /**
     * Initializes load method
     * @param args
     */
    public void load(String... args) {
        if (binder == null)
            return;
        if (isLoading())
            queue.stop();
        if (request != null)
            queue.cancelAll(request);
        request = new JsonRequest<>(binder.getClassType(),
                Request.Method.GET,
                binder.formUrl(args),
                successListener,
                errorListener);
        queue.add(request);
        setLoading(true);
        queue.start();
    }

    //region Getters / Setters

    /**
     * Sets the loading state
     * @param loading provided loading state
     */
    void setLoading(boolean loading) {
        if (this.loading == loading)
            return;
        this.loading = loading;
        if (loadStateListener != null)
            loadStateListener.onLoadStateChange(loading);
    }

    public boolean isLoading() {
        return loading;
    }

    public void setLoadStateListener(LoadStateListener loadStateListener) {
        this.loadStateListener = loadStateListener;
    }

    public void setLoadResultListener(LoadResultListener loadResultListener) {
        this.loadResultListener = loadResultListener;
    }

    public void setBinder(Binder binder) {
        this.binder = binder;
    }

    //endregion

    //region Listeners

    Response.Listener successListener = new Response.Listener() {
        @Override
        public void onResponse(Object response) {
            if (request == null)
                return;
            if (loadResultListener != null)
                loadResultListener.onLoadSuccess(response);
            request = null;
            setLoading(false);
        }
    };
    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            if (loadResultListener != null)
                loadResultListener.onLoadFail(error.toString());
            request = null;
            setLoading(false);
        }
    };

    //endregion

    //region Classes

    public interface Binder<T> {
        Class getClassType();
        String formUrl(String... args);
    }

    //endregion

}

