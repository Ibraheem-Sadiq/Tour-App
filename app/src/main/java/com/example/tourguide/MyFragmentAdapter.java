package com.example.tourguide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
public class MyFragmentAdapter extends FragmentPagerAdapter {
    Page[]pages;
    public MyFragmentAdapter(@NonNull FragmentManager fm,Page[]pages) {
        super(fm);
        this.pages =pages;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return pages[position].getFragment();
    }

    @Override
    public int getCount() {
        return pages.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pages[position].getTabTitle();
    }
}
