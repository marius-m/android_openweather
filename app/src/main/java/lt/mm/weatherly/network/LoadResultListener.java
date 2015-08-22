package lt.mm.weatherly.network;

/**
 * An interface that reports networking state changes
 */
public interface LoadResultListener<Type> {
    /**
     * Callback with a string response from the server
     * @param response
     */
    void onLoadSuccess(Type response);

    /**
     * Callback with a fail message from the server
     * @param error
     */
    void onLoadFail(String error);
}
