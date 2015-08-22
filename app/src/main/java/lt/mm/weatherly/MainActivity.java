package lt.mm.weatherly;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.android.volley.toolbox.Volley;
import lt.mm.weatherly.adapters.SimplePagerAdapter;
import lt.mm.weatherly.controllers.UserInputController;
import lt.mm.weatherly.fragments.BaseFragment;
import lt.mm.weatherly.fragments.FragmentNow;
import lt.mm.weatherly.network.LoadResultListener;
import lt.mm.weatherly.network.SearchNetwork;
import lt.mm.weatherly.views.SearchView;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SearchView searchView;
    private SearchNetwork searchNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        viewPager = (ViewPager) findViewById(R.id.tabanim_viewpager);
        searchView = (SearchView) findViewById(R.id.view_search);
        searchView.setInputHandler(searchInputHandler);

        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabanim_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(tabSelectionListener);

        searchNetwork = new SearchNetwork(Volley.newRequestQueue(this));
        searchNetwork.setLoadStateListener(searchView);
        searchNetwork.setLoadResultListener(loadResultListener);
    }

    //region Convenience

    private void setupViewPager(ViewPager viewPager) {
        SimplePagerAdapter adapter = new SimplePagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FragmentNow(), getString(R.string.fragment_title_tab1));
        adapter.addFrag(new BaseFragment(), getString(R.string.fragment_title_tab2));
        adapter.addFrag(new BaseFragment(), getString(R.string.fragment_title_tab3));
        viewPager.setAdapter(adapter);
    }

    //endregion

    //region Listeners

    TabLayout.OnTabSelectedListener tabSelectionListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());
            switch (tab.getPosition()) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };

    LoadResultListener loadResultListener = new LoadResultListener() {
        @Override
        public void onLoadSuccess(Object response) {
            Log.e("asdc", "yay");
        }

        @Override
        public void onLoadFail(String error) {
            // todo: Needs some kind of handler for error cases. For now we assume everything works as expected
        }
    };

    UserInputController.Listener searchInputHandler = new UserInputController.Listener() {
        @Override
        public void onInputChange(String input) {
            searchNetwork.load(input);
        }

        @Override
        public void onInputClear() {
            // Clear everything
        }
    };

    //endregion

}
