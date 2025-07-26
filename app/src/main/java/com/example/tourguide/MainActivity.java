package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TabLayout mainTabLayout;
    ViewPager mainViewPager;
    MyFragmentAdapter fragmentAdapter;
    Page[] mainpages;
    final static int HOTELS_ARRAY = 0;
    final static int TRANSPORTATIONS_ARRAY = 1;
    final static int RESTAURANTS_ARRAY = 2;
    final static int TOURIST_ATTRACTIONS_ARRAY = 3;
    Page hotels;
    Page transportations;
    Page restaurants;
    Page touristAttractions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTabLayout = findViewById(R.id.ui_main_tabs);
        mainViewPager = findViewById(R.id.ui_main_pager);
        getHotels();
        getTransportations();
        getRestaurants();
        getTouristAttractions();
        mainpages=new Page[4];
        mainpages[0]=hotels;
        mainpages[1]=transportations;
        mainpages[2]=restaurants;
        mainpages[3]=touristAttractions;
        fragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), mainpages);
        mainViewPager.setAdapter(fragmentAdapter);
        mainTabLayout.setupWithViewPager(mainViewPager);


    }

    public String[][] getItemsStringArray(int itemType) {
        String arr[][] = null;
        if (itemType == HOTELS_ARRAY) {
            arr = new String[5][];
            arr[0] = getResources().getStringArray(R.array.hotels_item1_array);
            arr[1] = getResources().getStringArray(R.array.hotels_item2_array);
            arr[2] = getResources().getStringArray(R.array.hotels_item3_array);
            arr[3] = getResources().getStringArray(R.array.hotels_item4_array);
            arr[4] = getResources().getStringArray(R.array.hotels_item5_array);
        } else if (itemType == TRANSPORTATIONS_ARRAY) {
            arr = new String[4][];
            arr[0] = getResources().getStringArray(R.array.transportation_1);
            arr[1] = getResources().getStringArray(R.array.transportation_2);
            arr[2] = getResources().getStringArray(R.array.transportation_3);
            arr[3] = getResources().getStringArray(R.array.transportation_4);
        } else if (itemType == RESTAURANTS_ARRAY) {
            arr = new String[5][];
            arr[0] = getResources().getStringArray(R.array.restaurants_1);
            arr[1] = getResources().getStringArray(R.array.restaurants_2);
            arr[2] = getResources().getStringArray(R.array.restaurants_3);
            arr[3] = getResources().getStringArray(R.array.restaurants_4);
            arr[4] = getResources().getStringArray(R.array.restaurants_5);
        } else if (itemType == TOURIST_ATTRACTIONS_ARRAY) {
            arr = new String[4][];
            arr[0] = getResources().getStringArray(R.array.tourists_attractions_1);
            arr[1] = getResources().getStringArray(R.array.tourists_attractions_2);
            arr[2] = getResources().getStringArray(R.array.tourists_attractions_3);
            arr[3] = getResources().getStringArray(R.array.tourists_attractions_4);

        }
        return arr;
    }
    public int[] getImageIds(int itemType) {
        int[] images;
        switch (itemType) {
            case HOTELS_ARRAY:
                images = new int[5];
                images[0] = R.drawable.hotel_1;
                images[1] = R.drawable.hotel_2;
                images[2] = R.drawable.hotel_3;
                images[3] = R.drawable.hotel_4;
                images[4] = R.drawable.hotel_5;
                break;
            case TRANSPORTATIONS_ARRAY:
                images = new int[5];
                images[0] = R.drawable.trnsportaion_1;
                images[1] = R.drawable.trnsportaion_2;
                images[2] = R.drawable.trnsportaion_3;
                images[3] = R.drawable.trnsportaion_4;
                break;
            case RESTAURANTS_ARRAY:
                images = new int[5];
                images[0] = R.drawable.restaurant_1;
                images[1] = R.drawable.restaurant_2;
                images[2] = R.drawable.restaurant_3;
                images[3] = R.drawable.restaurant_4;
                images[4] = R.drawable.restaurant_5;
                break;
            case TOURIST_ATTRACTIONS_ARRAY:
                images = new int[4];
                images[0] = R.drawable.attraction_1;
                images[1] = R.drawable.attraction_2;
                images[2] = R.drawable.attraction_3;
                images[3] = R.drawable.attraction_4;
                break;
            default:
                images = null;
        }
      return images;
    }
    public String getPageTitle(int itemType) {
        String title;
        switch (itemType) {
            case HOTELS_ARRAY:
                title = getResources().getString(R.string.hotel_page_title);
                break;
            case TRANSPORTATIONS_ARRAY:
                title = getResources().getString(R.string.transportation_page_title);
                break;
            case RESTAURANTS_ARRAY:
                title = getResources().getString(R.string.restaurants_page_title);
                break;
            case TOURIST_ATTRACTIONS_ARRAY:
                title = getResources().getString(R.string.tourist_attractions_page_title);
                break;
            default:
                title = "noTitle";
        }
        return title;
    }
    public void getHotels()
    {
        ArrayList<Item> tempArr= Item.getFinalItemFromArrays(getItemsStringArray(HOTELS_ARRAY),getImageIds(HOTELS_ARRAY));
        ListFragment tempFragment ;
        tempFragment =ListFragment.create(tempArr);
        hotels = new Page(getPageTitle(HOTELS_ARRAY), tempFragment);
    }
    public void getRestaurants()
    {
        ArrayList<Item> tempArr= Item.getFinalItemFromArrays(getItemsStringArray(RESTAURANTS_ARRAY),getImageIds(RESTAURANTS_ARRAY));
        ListFragment tempFragment;
        tempFragment =ListFragment.create(tempArr);
        restaurants = new Page(getPageTitle(RESTAURANTS_ARRAY), tempFragment);
    }
    public void getTransportations()
    {
        ArrayList<Item> tempArr= Item.getFinalItemFromArrays(getItemsStringArray(TRANSPORTATIONS_ARRAY),getImageIds(TRANSPORTATIONS_ARRAY));
        ListFragment tempFragment ;
        tempFragment =ListFragment.create(tempArr);
        transportations = new Page(getPageTitle(TRANSPORTATIONS_ARRAY), tempFragment);
    }
    public void getTouristAttractions()
    {
        ArrayList<Item> tempArr= Item.getFinalItemFromArrays(getItemsStringArray(TOURIST_ATTRACTIONS_ARRAY),getImageIds(TOURIST_ATTRACTIONS_ARRAY));
        ListFragment tempFragment ;
        tempFragment =ListFragment.create(tempArr);
        touristAttractions = new Page(getPageTitle(TOURIST_ATTRACTIONS_ARRAY), tempFragment);
    }
}