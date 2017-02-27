package com.gabri.phresko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.gabri.phresko.adapter.FavAdapter;
import com.gabri.phresko.model.Favorites;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    ListView favorites_listview;
    ImageButton home_imagebutton;
    FavAdapter adapter;
    List<Favorites> favelist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();
        home_imagebutton=(ImageButton)findViewById(R.id.home_imageButton);
        home_imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProfileActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        favorites_listview=(ListView)findViewById(R.id.favorite_listview);
        load_fave();
    }

    public void load_fave(){


        favelist=new ArrayList<Favorites>();


        Favorites favorites=new Favorites();
        favorites.setTagname("SPORTS");
        favelist.add(favorites);
        Favorites favorites1=new Favorites();
        favorites1.setTagname("POLITICS");
        favelist.add(favorites1);
        Favorites favorites2=new Favorites();
        favorites2.setTagname("SAVAGERY");
        favelist.add(favorites2);
        Favorites favorites3=new Favorites();
        favorites3.setTagname("POLITICS");
        favelist.add(favorites3);
        Favorites favorites4=new Favorites();
        favorites4.setTagname("POPMEDIA");
        favelist.add(favorites4);


        adapter = new FavAdapter(this, favelist);
        favorites_listview.setAdapter(adapter);



    }
}
