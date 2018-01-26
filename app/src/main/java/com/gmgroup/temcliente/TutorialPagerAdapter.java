package com.gmgroup.temcliente;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by reisi_000 on 25/05/2017.
 */

public class TutorialPagerAdapter extends FragmentStatePagerAdapter {

    public TutorialPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        int slide = 0;
        switch (i) {
            case 0: slide = R.drawable.slide1; break;
            case 1: slide = R.drawable.slide2; break;
            case 2: slide = R.drawable.slide3; break;
            case 3: slide = R.drawable.slide4; break;
        }
        Fragment fragment = new TutorialFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("slide",slide);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }
}
