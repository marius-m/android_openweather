package lt.mm.weatherly.network;

import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import lt.mm.weatherly.Constants;

/**
 * Created by mariusmerkevicius on 7/26/15.
 * Wrapper class that is responsible for handling networking functions
 */
public abstract class AbsNetwork<Type> {
    protected RequestQueue queue;
    protected Class classType;
    protected JsonRequest<Type> request;

    LoadResultListener loadResultListener;
    LoadStateListener loadStateListener;
    boolean loading = false;

    public AbsNetwork(RequestQueue requestQueue, Class classType) {
        if (requestQueue == null)
            throw new IllegalArgumentException("Cant function without RequestQueue!");
        this.queue = requestQueue;
        this.classType = classType;
    }

    /**
     * Initializes load method
     * @param suffix
     */
    public void load(String suffix) {
        if (isLoading())
            queue.stop();
        if (request != null)
            queue.cancelAll(request);
        // todo remove hardcodings
        request = new JsonRequest<>(classType,
                Request.Method.GET,
                String.format(Constants.BASE_URL, ((TextUtils.isEmpty(suffix)) ? "" : "Kaunas")),
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

    //endregion

    //region Listeners

    Response.Listener<Type> successListener = new Response.Listener<Type>() {
        @Override
        public void onResponse(Type response) {
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

}

