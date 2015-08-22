package lt.mm.weatherly.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.*;
import lt.mm.weatherly.R;
import lt.mm.weatherly.controllers.UserInputController;

import java.util.ArrayList;

/**
 * Created by mariusmerkevicius on 8/22/15.
 * A view that handles logic when searching for the cities.
 *
 * Incomplete implementation! View should not push content down when displaying items in the list view.
 * Needs proper handling for this.
 */
public class SearchView extends RelativeLayout {

    // Controllers
    UserInputController inputController;

    // Views
    private ProgressBar viewProgress;
    private ArrayList<String> searchItems;
    private ListView viewList;
    private EditText viewInput;


    public SearchView(Context context) {
        super(context);
        init();
    }

    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SearchView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_search, this);

        inputController = new UserInputController(userInputController);

        // Variables
        searchItems = new ArrayList<>();

        viewInput = (EditText) findViewById(R.id.view_input);
        viewProgress = (ProgressBar) findViewById(R.id.view_progress);
    }

    //region Listeners

    UserInputController.Listener userInputController = new UserInputController.Listener() {
        @Override
        public void onInputChange(String input) {

        }

        @Override
        public void onInputClear() {

        }
    };

    //endregion

    //region Classes

    public interface Listener {
        void onRegionChange();
    }

    //endregion

}
