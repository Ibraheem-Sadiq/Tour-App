package com.example.tourguide;


import android.widget.TextView;

import java.util.ArrayList;

public class    Item   {
    private String ItemTitle;
    private String text;
    private int imageId;
    private String date_price;
    public static  final int TITLE_POSITION=0;
    public  static  final  int  TEXT_POSITION=1;
    public  static  final  int  PRICE_WORk_HOURS_DATE_POSITION=2;

    public Item() {

    }

    public String getItemTitle() {
        return ItemTitle;
    }

    public void setItemTitle(String itemTitle) {
        ItemTitle = itemTitle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDate_price() {
        return date_price;
    }

    public void setDate_price(String date_price) {
        this.date_price = date_price;
    }

    public static ArrayList<Item> getFinalItemFromArrays(String[][]itemsData, int[]imageids)
    {
        ArrayList<Item> finalItems =new ArrayList<Item>();
        for (int i=0;i<itemsData.length;i++)
      {
          finalItems.add(makeItem(itemsData[i],imageids[i]));
      }
   return  finalItems;
    }
    public static Item makeItem(String[]itemData,int imageId)
    {
        Item item =new Item();
        item.setImageId(imageId);
        item.setItemTitle(itemData[TITLE_POSITION]);
        item.setText(itemData[TEXT_POSITION]);
        item.setDate_price(itemData[PRICE_WORk_HOURS_DATE_POSITION]);
        return item;
    }
}
