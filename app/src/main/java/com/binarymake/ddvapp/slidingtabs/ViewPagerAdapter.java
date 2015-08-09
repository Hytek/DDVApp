package com.binarymake.ddvapp.slidingtabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Jakob on 27-08-2015.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if (position == 0) // if the position is 0 we are returning the First tab
        {
            TabBreakfast tabBreakfast = new TabBreakfast();
            return tabBreakfast;
        }
        else if (position == 1) // if the position is 1 we are returning the Second tab
        {
            TabLunch tabLunch = new TabLunch();
            return tabLunch;
        }
        else if (position == 2)           // if the position is 2 we are returning the Third tab
        {
            TabDinner tabDinner = new TabDinner();
            return tabDinner;
        }
        else                            // if position is neither 0 through 2 then it must be Fourth tab

        {
            TabSnack tabSnack = new TabSnack();
            return tabSnack;
        }


    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {

        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {

        return NumbOfTabs;
    }
}