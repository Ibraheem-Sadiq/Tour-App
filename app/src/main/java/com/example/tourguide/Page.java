package com.example.tourguide;

public class Page {
    private  String tabTitle;
    private ListFragment fragment;


    public Page(String tabTitle, ListFragment fragment) {
        this.tabTitle = tabTitle;
        this.fragment = fragment;
    }

    public String getTabTitle() {
        return tabTitle;
    }

    public void setTabTitle(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    public ListFragment getFragment() {
        return fragment;
    }

    public void setFragment(ListFragment fragment) {
        this.fragment = fragment;
    }
}
