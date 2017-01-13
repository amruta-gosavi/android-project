package amruta.com.recipesonapprest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import static android.R.attr.fragment;

/**
 * Created by AMRUTA on 8/17/16.
 */


public class SampleFragmentPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {

    final int PAGE_COUNT = 3;
    FragmentManager fragmentManager;


    private int tabIcons[] = {R.drawable.ic_home, R.drawable.ic_search, R.drawable.ic_add};

    public SampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);

        this.fragmentManager = fm;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            // Open FragmentTab1.java
            case 0:
                return RecipeHomeFragment.newInstance(position + 1);


            // Open FragmentTab2.java
            case 1:

                return RecipeSearchFragment.newInstance(position + 1);


            case 2:

                return new Fragment();

            default:
                return new Fragment();
        }


    }


    @Override
    public int getPageIconResId(int position) {
        return tabIcons[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.remove((Fragment) object);
        ft.commit();
    }
}



