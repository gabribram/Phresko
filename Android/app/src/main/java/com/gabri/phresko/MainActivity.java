package com.gabri.phresko;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.gabri.phresko.activity.ImageViewActivity;
import com.gabri.phresko.activity.SingupActivity;
import com.gabri.phresko.adapter.FavAdapter;
import com.gabri.phresko.model.Favorites;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button singin_button;
    private static final int STORAGE_PERMISSION_CODE = 123;
    TextView creat_account_textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creat_account_textview=(TextView)findViewById(R.id.create_accouttextView);


        singin_button=(Button)findViewById(R.id.signin_button);
        singin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               load_mainscreen();
            }
        });
        creat_account_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this, SingupActivity.class);
            startActivity(intent);
            }
        });


    }



    public void load_mainscreen(){
        Intent intent=new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);

    }

}
