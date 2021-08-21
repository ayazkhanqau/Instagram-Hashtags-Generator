package com.needle.sub4sub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class AddVideoLink extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_video_link);
    }

    public void clicMe(View view) {
        String str2 = "https://www.youtube.com/channel/" + "UCe9JSDmyqNgA_l2BzGHq1Ug";
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage("com.google.android.youtube");
            intent.setData(Uri.parse(str2));
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(str2));
            startActivity(intent2);
        }
    }
}