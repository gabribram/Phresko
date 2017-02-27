package com.gabri.phresko;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.gabri.phresko.adapter.FavAdapter;
import com.gabri.phresko.model.Favorites;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button singin_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        singin_button=(Button)findViewById(R.id.signin_button);
        singin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });

    }

}
