package com.gabri.phresko.fragments;


import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.gabri.phresko.R;
import com.gabri.phresko.utils.Constants;
import com.gabri.phresko.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class RootFragment extends Fragment {

    Button next_button;
    ImageButton sko_imagebutton;
    ImageButton slide_imagebutton;
    String buttonflag="sko";
    View root_view;
    public RootFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root_view=inflater.inflate(R.layout.fragment_root, container, false);
        sko_imagebutton=(ImageButton)root_view.findViewById(R.id.sko_imageButton);
        slide_imagebutton=(ImageButton)root_view.findViewById(R.id.slides_imageButton);
        sko_imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonflag.equals("")){

                    sko_imagebutton.setBackgroundResource(R.drawable.skobutton_bg_click);
                    buttonflag="sko";
                    slide_imagebutton.setBackgroundResource(R.drawable.slidebutton_bg);
                }
                else if(buttonflag.equals("sko")){

                    sko_imagebutton.setBackgroundResource(R.drawable.skobutton_bg_click);
                    buttonflag="sko";
                    slide_imagebutton.setBackgroundResource(R.drawable.slidebutton_bg);
                }
                else if(buttonflag.equals("slide")){

                    sko_imagebutton.setBackgroundResource(R.drawable.skobutton_bg_click);
                    buttonflag="sko";
                    slide_imagebutton.setBackgroundResource(R.drawable.slidebutton_bg);

                }

            }
        });
        slide_imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonflag.equals("")){

                    sko_imagebutton.setBackgroundResource(R.drawable.skobutton_bg);
                    buttonflag="slide";
                    slide_imagebutton.setBackgroundResource(R.drawable.slidebutton_bg_click);
                }
                else if(buttonflag.equals("sko")){

                    sko_imagebutton.setBackgroundResource(R.drawable.skobutton_bg);
                    buttonflag="slide";
                    slide_imagebutton.setBackgroundResource(R.drawable.slidebutton_bg_click);
                }
                else if(buttonflag.equals("slide")){

                    sko_imagebutton.setBackgroundResource(R.drawable.skobutton_bg);
                    buttonflag="slide";
                    slide_imagebutton.setBackgroundResource(R.drawable.slidebutton_bg_click);

                }
            }
        });

        next_button=(Button)root_view.findViewById(R.id.next_button);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (buttonflag.equals("sko")){

                    Utils.setToPrefString(Constants.KEY_TAG_KIND,buttonflag,getActivity());
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer,new SkoRootFragment()).commit();

                }
                else {

                    Utils.setToPrefString(Constants.KEY_TAG_KIND,buttonflag,getActivity());
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer,new MainTagFragment()).commit();

                }



            }
        });
        return root_view;
    }

    public void show_dialog(){



        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                getActivity());
        alertDialog.setTitle("Confirm Delete...");
        alertDialog.setMessage("Are you sure you want delete this file?");
        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();

                    }
                });
        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog

                        dialog.cancel();
                    }
                });
        alertDialog.show();




    }

}
