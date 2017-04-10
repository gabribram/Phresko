package com.gabri.phresko.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.gabri.phresko.R;
import com.gabri.phresko.utils.Constants;
import com.gabri.phresko.utils.Utils;

public class ImageDetailsActivity extends AppCompatActivity {
    ImageView display_imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);
        display_imageview=(ImageView)findViewById(R.id.display_imageView);
        if (Utils.getFromPref(Constants.KEY_TAG_KIND,this).equals("slide"))
        {
            display_imageview.setImageResource(R.drawable.slidefullimage);
        }
        else {
            display_imageview.setImageResource(R.drawable.skofullimages);
        }

    }
}
