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
import lt.mm.weatherly.fragments.FragmentHourly;
import lt.mm.weatherly.fragments.FragmentNow;
import lt.mm.weatherly.network.BinderFactory;
import lt.mm.weatherly.network.LoadResultListener;
import lt.mm.weatherly.network.WeatherNetwork;
import lt.mm.weatherly.views.SearchView;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SearchView searchView;
    private WeatherNetwork weatherNetwork;
    private SimplePagerAdapter pagerAdapter;
    private BinderFactory binderFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        searchView = (SearchView) findViewById(R.id.view_search);
        searchView.setInputHandler(searchInputHandler);

        viewPager = (ViewPager) findViewById(R.id.tabanim_viewpager);
        pagerAdapter = new SimplePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFrag(new FragmentNow(), getString(R.string.fragment_title_tab1));
        pagerAdapter.addFrag(new FragmentHourly(), getString(R.string.fragment_title_tab2));
        pagerAdapter.addFrag(new FragmentNow(), getString(R.string.fragment_title_tab3));
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabanim_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(tabSelectionListener);

        binderFactory = new BinderFactory();
        weatherNetwork = new WeatherNetwork(Volley.newRequestQueue(this));
        weatherNetwork.setLoadStateListener(searchView);
        weatherNetwork.setLoadResultListener(loadResultListener);
        weatherNetwork.setBinder(binderFactory.now());
    }

    //region Convenience

    //endregion

    //region Listeners

    TabLayout.OnTabSelectedListener tabSelectionListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());
            switch (tab.getPosition()) {
                case 0:
                    weatherNetwork.setBinder(binderFactory.now());
                    break;
                case 1:
                    weatherNetwork.setBinder(binderFactory.hourly());
                    break;
                case 2:
                    weatherNetwork.setBinder(binderFactory.forecast());
                    break;
            }
            searchView.notifyInputChange();
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            ((BaseFragment) pagerAdapter.getItem(viewPager.getCurrentItem())).update(null);
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) { }
    };

    LoadResultListener loadResultListener = new LoadResultListener() {
        @Override
        public void onLoadSuccess(Object response) {
            Log.d(Constants.TAG, "SearchResult:"+response);
            ((BaseFragment) pagerAdapter.getItem(viewPager.getCurrentItem())).update(response);
        }

        @Override
        public void onLoadFail(String error) {
            ((BaseFragment) pagerAdapter.getItem(viewPager.getCurrentItem())).update(null);
        }
    };

    UserInputController.Listener searchInputHandler = new UserInputController.Listener() {
        @Override
        public void onInputChange(String input) {
            weatherNetwork.load(input);
        }

        @Override
        public void onInputClear() {
            ((BaseFragment) pagerAdapter.getItem(viewPager.getCurrentItem())).update(null);
        }
    };

    //endregion

}
