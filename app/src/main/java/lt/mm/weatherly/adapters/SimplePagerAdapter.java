package lt.mm.weatherly.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mariusmerkevicius on 8/22/15.
 * Controls fragment display for the ViewPager
 */
public class SimplePagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragments = new ArrayList<>();
    private final List<String> titles = new ArrayList<>();

    public SimplePagerAdapter(FragmentManager manager) {
        super(manager);
    }

    //region Public

    public void addFrag(Fragment fragment, String title) {
        fragments.add(fragment);
        titles.add(title);
    }

    //endregion

    //region Overrides

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    //endregion
}
