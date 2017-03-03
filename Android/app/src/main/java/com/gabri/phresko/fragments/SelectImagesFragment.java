package com.gabri.phresko.fragments;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.gabri.phresko.R;
import com.gabri.phresko.activity.ImageViewActivity;
import com.gabri.phresko.utils.Constants;
import com.gabri.phresko.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectImagesFragment extends Fragment {

    Button tagname_button;
    ImageButton all_button,hash_button;
    View selectimage_view;
    public SelectImagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        selectimage_view=inflater.inflate(R.layout.fragment_select_images, container, false);
        tagname_button=(Button)selectimage_view.findViewById(R.id.tagname_button);
        all_button=(ImageButton)selectimage_view.findViewById(R.id.all_button);
        hash_button=(ImageButton)selectimage_view.findViewById(R.id.hash_button);
        if (Utils.getFromPref(Constants.KEY_TAG_KIND,getActivity()).equals("slide"))
        {
            tagname_button.setBackgroundColor(Color.parseColor("#6400FF"));
            all_button.setBackgroundColor(Color.parseColor("#6400FF"));
            hash_button.setBackgroundColor(Color.parseColor("#6400FF"));
        } else if (Utils.getFromPref(Constants.KEY_TAG_KIND,getActivity()).equals("sko")) {
            tagname_button.setBackgroundColor(Color.parseColor("#BF5E27"));
            all_button.setBackgroundColor(Color.parseColor("#BF5E27"));
            hash_button.setBackgroundColor(Color.parseColor("#BF5E27"));
        }
        tagname_button.setText(Utils.getFromPref(Constants.KEY_TAG,getActivity()));
        all_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ImageViewActivity.class);
                startActivity(intent);
            }
        });
        hash_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ImageViewActivity.class);
                startActivity(intent);
            }
        });
        return selectimage_view;
    }

}
