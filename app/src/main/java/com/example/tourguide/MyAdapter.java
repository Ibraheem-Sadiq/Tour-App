package com.example.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
  Context context;
  ArrayList<Item>data;

    public MyAdapter(Context context, ArrayList<Item> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v =view;
        if (v==null)
{            v= LayoutInflater.from(this.context).inflate(R.layout.list_item,null,false);
}        TextView textView =v.findViewById(R.id.ui_card_title);
        ImageView imageView =v.findViewById(R.id.ui_card_image);
        Item  item =(Item) getItem(i);
        textView.setText(item.getItemTitle());
        imageView.setImageResource(item.getImageId());
        textView = v.findViewById(R.id.ui_card_price_date_hours);
        textView.setText(item.getDate_price());
        return v;
    }

}
