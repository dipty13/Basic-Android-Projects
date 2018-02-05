package com.dnerd.dipty.mytablayoutapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tablayout;
    ViewPager viewpager;
    private int[] tabicons =
            {
                    R.drawable.icon_call,
                    R.drawable.icon_group,
                    R.drawable.icon_person

            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        viewpager =(ViewPager)findViewById(R.id.myViewPager);
        setUpPager(viewpager);

        tablayout = (TabLayout) findViewById(R.id.tabLayout);
        tablayout.setupWithViewPager(viewpager);

       setUpTabIcons();

    }

    private void setUpTabIcons() {
        tablayout.getTabAt(0).setIcon(tabicons[0]);
        tablayout.getTabAt(1).setIcon(tabicons[1]);
        tablayout.getTabAt(2).setIcon(tabicons[2]);
    }

    private void setUpPager(ViewPager viewPager) {
        ViewPagerAdapter adapeter = new ViewPagerAdapter(getSupportFragmentManager());
        adapeter.add(new CallFragment(),"Call");
        adapeter.add(new GroupFragment(),"Group");
        adapeter.add(new PersonFragment(),"Person");
        viewPager.setAdapter(adapeter);
    }


}
