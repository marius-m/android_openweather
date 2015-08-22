package lt.mm.weatherly;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import com.android.volley.toolbox.Volley;
import lt.mm.weatherly.adapters.SimplePagerAdapter;
import lt.mm.weatherly.entities.SearchResult;
import lt.mm.weatherly.fragments.BaseFragment;
import lt.mm.weatherly.fragments.FragmentNow;
import lt.mm.weatherly.network.LoadResultListener;
import lt.mm.weatherly.network.SearchNetwork;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);
        viewPager = (ViewPager) findViewById(R.id.tabanim_viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabanim_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(tablSelectionListener);

        SearchNetwork network = new SearchNetwork(Volley.newRequestQueue(this));
        network.setLoadResultListener(new LoadResultListener() {
            @Override
            public void onLoadSuccess(Object response) {
                Log.e("Asdc", String.valueOf(response));
            }

            @Override
            public void onLoadFail(String error) {

            }
        });
        network.load();

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

    TabLayout.OnTabSelectedListener tablSelectionListener = new TabLayout.OnTabSelectedListener() {
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

    //endregion

}
