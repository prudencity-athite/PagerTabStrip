package com.adhish.pagertabstriptutorial;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 2;
    // Tab Titles
    private final String tabtitles[] = new String[] { "Tab1", "Tab2" };
    //Context context;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
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
                //FragmentTab1 fragmenttab1 = new FragmentTab1();
                return new FragmentTab1();

            // Open FragmentTab2.java
            case 1:
                //FragmentTab2 fragmenttab2 = new FragmentTab2();
                return new FragmentTab2();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}
