package lt.mm.weatherly.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.*;
import lt.mm.weatherly.R;
import lt.mm.weatherly.controllers.UserInputController;
import lt.mm.weatherly.network.LoadStateListener;

import java.util.ArrayList;

/**
 * Created by mariusmerkevicius on 8/22/15.
 * A view that handles logic when searching for the cities.
 *
 * Incomplete implementation! View should not push content down when displaying items in the list view.
 * Needs proper handling for this.
 */
public class SearchView extends RelativeLayout implements LoadStateListener {

    // Controllers
    UserInputController inputController;

    // Views
    private ProgressBar viewProgress;
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

        inputController = new UserInputController(null);

        // Variables
        viewInput = (EditText) findViewById(R.id.view_input);
        viewInput.addTextChangedListener(inputWatcher);
        viewProgress = (ProgressBar) findViewById(R.id.view_progress);
    }

    //region Getters / Setters

    public void setInputHandler(UserInputController.Listener inputHandler) {
        inputController.setListener(inputHandler);
    }

    //endregion

    //region Listeners

    @Override
    public void onLoadStateChange(boolean loading) {
        viewProgress.setVisibility( (loading) ? VISIBLE : GONE );
    }

    TextWatcher inputWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            inputController.handleInput(String.valueOf(charSequence));
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    //endregion

    //region Classes


    //endregion

}
