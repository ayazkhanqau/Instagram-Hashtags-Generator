package com.needle.sub4sub;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.dynamic.IFragmentWrapper;
import com.needle.sub4sub.adapters.GridViewAdapterHashtages;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HashtagsActivity extends AppCompatActivity {
    String link = "";
    GridView gridView;
    ArrayList<String> tages;
    ArrayList<String> arr_fav_list = new ArrayList<String>();
    int found= 0;
    TextView textView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hashtages_layout);
        Bundle b = getIntent().getExtras();
        String id = b.getString("value");
        textView = findViewById(R.id.textView);
        link = link+id;

        gridView = findViewById(R.id.gridViewtages);

        tages = new ArrayList<>();

        getData(link);

    }

    private void getData(String link) {
        //Showing a progress dialog while our app fetches the data from url
        final ProgressDialog loading = ProgressDialog.show(this, "Please wait...","Fetching data...",false,false);
        //Creating a json array request to get the json from our api
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(link,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Dismissing the progressdialog on response
                        loading.dismiss();

                        //Displaying our grid
                        showGrid(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        //Creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //Adding our request to the queue
        requestQueue.add(jsonArrayRequest);
    }

    private void showGrid(JSONArray jsonArray) {
        //Looping through all the elements of json array
        for(int i = 0; i<jsonArray.length(); i++){
            //Creating a json object of the current index
            JSONObject obj = null;
            try {
                //getting json object from current index
                obj = jsonArray.getJSONObject(i);

                //getting image url and title from json object
                tages.add(obj.getString("poet"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        //Creating GridViewAdapter Object
        GridViewAdapterHashtages gridViewAdapter = new GridViewAdapterHashtages(this,tages);

        //Adding adapter to gridview
        gridView.setAdapter(gridViewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText("");
                    int i;
                    if (arr_fav_list.isEmpty()){
                        arr_fav_list.add(tages.get(position));
                        textView.setText("#"+tages.get(position)+" ");
                        return;
                    }
                    for (i=0; i<arr_fav_list.size(); i++){

                        if (arr_fav_list.get(i).equals(tages.get(position))){
                            found = 1;
                            break;
                        }else{
                            found = 2;
                        }
                    }
                    if (found == 1){
                        try {
                            arr_fav_list.remove(i);
                        }catch (Exception e){

                        }
                    }else{
                        arr_fav_list.add(tages.get(position));
                    }
                    for (i=0; i<arr_fav_list.size(); i++){
                        if (i == 0) {
                            textView.setText("#"+arr_fav_list.get(i)+" ");
                        }else{
                            textView.append(","+"#"+arr_fav_list.get(i)+" ");
                        }
                    }

            }
        });
    }

    public void getTags(View view) {
        textView.setText("");
        for (int i=0; i<arr_fav_list.size(); i++){
            textView.append(arr_fav_list.get(i));
        }
        arr_fav_list.clear();
    }
}
