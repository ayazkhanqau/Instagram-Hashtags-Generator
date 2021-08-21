package com.needle.sub4sub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.needle.sub4sub.R;

import java.util.ArrayList;

public class GridViewAdapterHashtages extends BaseAdapter {

    //Context
    private Context context;

    //Array List that would contain the urls and the titles for the images
    private ArrayList<String> tages;

    public GridViewAdapterHashtages (Context context, ArrayList<String> names){
        //Getting all the values
        this.context = context;
        this.tages = names;
    }

    @Override
    public int getCount() {
        return tages.size();
    }

    @Override
    public Object getItem(int position) {
        return tages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Creating a linear layout
        View v = convertView;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            v = vi.inflate(R.layout.grid_hashtages_item, null);
        }

        TextView textView = v.findViewById(R.id.textView_grid);
        textView.setText("#"+tages.get(position));

        return v;
    }
}