package com.needle.sub4sub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.needle.sub4sub.fragments.CampaignFragment;
import com.needle.sub4sub.fragments.LikeFragment;
import com.needle.sub4sub.fragments.SubsFragment;
import com.needle.sub4sub.fragments.ViewsFragment;

public class MainActivity extends AppCompatActivity {
    FragmentManager manager;
    ViewsFragment viewsFragment;
    SubsFragment subsFragment;
    LikeFragment likeFragment;
    CampaignFragment campaignFragment;

    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewsFragment = new ViewsFragment();
        subsFragment = new SubsFragment();
        likeFragment = new LikeFragment();
        campaignFragment = new CampaignFragment();

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.home_fragments, viewsFragment, "Frag_Top_tag");
        transaction.commit();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_views:
                        transaction = manager.beginTransaction();
                        transaction.replace(R.id.home_fragments, viewsFragment, "Frag_Top_tag");
                        transaction.commit();
                        break;
                    case R.id.action_subs:
                        transaction = manager.beginTransaction();
                        transaction.replace(R.id.home_fragments,subsFragment,"Frag_Top_tag");
                        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        transaction.commit();
                        //transaction.add(R.id.home_fragments, subsFragment, "Frag_Top_tag");
                        //transaction.commit();
                        break;
                    case R.id.action_likes:
                        transaction = manager.beginTransaction();
                        transaction.replace(R.id.home_fragments,likeFragment,"Frag_Top_tag");
                        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        transaction.commit();
                        break;
                    case R.id.action_campaigns:
                        transaction = manager.beginTransaction();
                        transaction.replace(R.id.home_fragments,campaignFragment,"Frag_Top_tag");
                        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        transaction.commit();
                        break;
                }
                return true;
            }
        });


        
    }
}