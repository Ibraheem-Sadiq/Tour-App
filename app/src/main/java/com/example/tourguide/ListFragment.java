package com.example.tourguide;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class ListFragment extends Fragment {
     private  ArrayList<Item> items;
    final static String TEXT_KEY = "text";
    final static String IMaGE_ID_KEY = "imageid";
     public ListView listView;
    public ListFragment() {
        // Required empty public constructor
    }
    public static ListFragment create(ArrayList<Item> data)
    {
        ListFragment listFragment =new ListFragment();
        listFragment.items = data;
        return listFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_list, container, false);
       listView=view.findViewById(R.id.ui_lv);
       final MyAdapter adapter =new MyAdapter(getActivity(),items);
       listView.setAdapter(adapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Item itemSend = (Item) adapter.getItem(i);
               Intent send = new Intent(getActivity(), ItemShowActivity.class);
               send.putExtra(TEXT_KEY, itemSend.getText());
               send.putExtra(IMaGE_ID_KEY, itemSend.getImageId());
               startActivity(send);
           }
       });
        return view;

    }

}