package lt.mm.weatherly.network;

/**
 * An interface that reports networking state changes
 */
public interface LoadStateListener {
    /**
     * Reports if class is loading something
     * @param loading load state
     */
    void onLoadStateChange(boolean loading);

}
