package com.muharyman.weather.view.page;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapter extends FragmentPagerAdapter {

    public Adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return new Fragment1();
            case 1: // Fragment # 1 - This will show SecondFragment
                return new Fragment2();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
