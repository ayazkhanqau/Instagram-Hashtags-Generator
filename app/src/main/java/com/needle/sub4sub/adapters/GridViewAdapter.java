package com.needle.sub4sub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.needle.sub4sub.CustomVolleyRequest;
import com.needle.sub4sub.R;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {

    //Context
    private Context context;

    //Array List that would contain the urls and the titles for the images
    private ArrayList<String> names;

    public GridViewAdapter (Context context, ArrayList<String> names){
        //Getting all the values
        this.context = context;
        this.names = names;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
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
            v = vi.inflate(R.layout.grid_layout, null);
        }

        TextView textView = v.findViewById(R.id.textView_grid);
        textView.setText(names.get(position));

        return v;
    }
}