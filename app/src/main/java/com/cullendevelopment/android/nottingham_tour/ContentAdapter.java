package com.cullendevelopment.android.nottingham_tour;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ContentAdapter extends FragmentPagerAdapter {
    // Number of fragments/pages
    final int PAGE_COUNT = 4; //declaring static variable
    //Titles of categories as appears on tabs
    private String tabTitles[] = new String[] { "Accommodation", "Dining", "Explore", "Museums" };
    /** Context of the app */
    private Context context;

    public ContentAdapter(FragmentManager fm) {
        super(fm);
    }
    //instructions to app on which fragment to show
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AccommodationFragment();
        } else if (position == 1){
            return new DiningFragment();
        } else if (position == 2) {
            return new ExploreFragment();
        } else {
            return new MuseumsFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position]; //returns the correct Tab title indicator
    }
}
