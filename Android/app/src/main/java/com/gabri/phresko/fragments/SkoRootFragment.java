package com.gabri.phresko.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.gabri.phresko.R;
import com.gabri.phresko.utils.Constants;
import com.gabri.phresko.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkoRootFragment extends Fragment {


    Button next_button;
    ImageButton sko_imagebutton;
    ImageButton slide_imagebutton;
    String buttonflag="everybody";
    View root_view;
    public SkoRootFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root_view=inflater.inflate(R.layout.fragment_sko_root, container, false);
        sko_imagebutton=(ImageButton)root_view.findViewById(R.id.every_imageButton);
        slide_imagebutton=(ImageButton)root_view.findViewById(R.id.mature_imageButton);
        sko_imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonflag.equals("")){

                    sko_imagebutton.setBackgroundResource(R.drawable.skobutton_bg_click);
                    buttonflag="everybody";
                    slide_imagebutton.setBackgroundResource(R.drawable.slidebutton_bg);
                }
                else if(buttonflag.equals("everybody")){

                    sko_imagebutton.setBackgroundResource(R.drawable.skobutton_bg_click);
                    buttonflag="everybody";
                    slide_imagebutton.setBackgroundResource(R.drawable.slidebutton_bg);
                }
                else if(buttonflag.equals("mature")){

                    sko_imagebutton.setBackgroundResource(R.drawable.skobutton_bg_click);
                    buttonflag="everybody";
                    slide_imagebutton.setBackgroundResource(R.drawable.slidebutton_bg);

                }

            }
        });
        slide_imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonflag.equals("")){

                    sko_imagebutton.setBackgroundResource(R.drawable.skobutton_bg);
                    buttonflag="mature";
                    slide_imagebutton.setBackgroundResource(R.drawable.slidebutton_bg_click);
                }
                else if(buttonflag.equals("mature")){

                    sko_imagebutton.setBackgroundResource(R.drawable.skobutton_bg);
                    buttonflag="mature";
                    slide_imagebutton.setBackgroundResource(R.drawable.slidebutton_bg_click);
                }
                else if(buttonflag.equals("everybody")){

                    sko_imagebutton.setBackgroundResource(R.drawable.skobutton_bg);
                    buttonflag="mature";
                    slide_imagebutton.setBackgroundResource(R.drawable.slidebutton_bg_click);

                }
            }
        });

        next_button=(Button)root_view.findViewById(R.id.next_button);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.setToPrefString(Constants.KEY_TAG,buttonflag,getActivity());
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer,new MainTagFragment()).commit();
            }
        });
        return root_view;
    }

}
