package com.dnerd.dipty.mytablayoutapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dipty on 10/14/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public final List<Fragment> listOfFragment = new ArrayList<>();
    public final List<String> titleFragment = new ArrayList<>();


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listOfFragment.get(position);
    }

    @Override
    public int getCount() {
        return listOfFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleFragment.get(position);
    }
    public void add(Fragment fragment,String t)
    {
        listOfFragment.add(fragment);
        titleFragment.add(t);
    }
}
