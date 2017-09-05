package com.example.sqlite;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import android.widget.Switch;

/**
 * Created by Xue on 2017/9/5.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 4;
    private AddFragment addFragment = null;
    private DeleteFragment deleteFragment = null;
    private UpdateFragment updateFragment = null;
    private QueryFragment queryFragment = null;


    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        addFragment = new AddFragment();
        deleteFragment = new DeleteFragment();
        updateFragment = new UpdateFragment();
        queryFragment = new QueryFragment();


    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container,position,object);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position) {
            case MainActivity.PAGE_ONE:
                fragment = addFragment;
                break;
            case MainActivity.PAGE_TWO:
                fragment = deleteFragment;
                break;
            case MainActivity.PAGE_THREE:
                fragment = updateFragment;
                break;
            case MainActivity.PAGE_FOUR:
                fragment = queryFragment;
                break;
        }
        return fragment;
    }


}
