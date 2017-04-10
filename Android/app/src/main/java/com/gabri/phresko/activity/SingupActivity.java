package com.gabri.phresko.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.gabri.phresko.HomeActivity;
import com.gabri.phresko.R;

public class SingupActivity extends AppCompatActivity {
    Button singup_button;
    ImageView terms_imageview;
    boolean terms=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        getSupportActionBar().hide();
        singup_button=(Button)findViewById(R.id.signup_button);
        singup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SingupActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        terms_imageview=(ImageView)findViewById(R.id.terms_imageView);
        terms_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (terms){
                    terms_imageview.setImageResource(R.drawable.termsclick);
                    terms=false;
                }
                else {
                    terms_imageview.setImageResource(R.drawable.terms);
                    terms=true;
                }
            }
        });
    }
}
