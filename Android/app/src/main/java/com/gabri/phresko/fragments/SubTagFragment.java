package com.gabri.phresko.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.gabri.phresko.R;
import com.gabri.phresko.adapter.MainTagAdapter;
import com.gabri.phresko.model.Favorites;
import com.gabri.phresko.utils.Constants;
import com.gabri.phresko.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubTagFragment extends Fragment {

    Button tag_button,search_button;
    String tag_string;
    EditText search_edittext;
    ListView sub_listview;
    MainTagAdapter adapter;
    List<Favorites> sublists;
    View sub_view;
    public SubTagFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        sub_view=inflater.inflate(R.layout.fragment_sub_tag, container, false);
        search_button=(Button)sub_view.findViewById(R.id.search_button);
        search_edittext=(EditText)sub_view.findViewById(R.id.search_editText);
        tag_string= Utils.getFromPref(Constants.KEY_TAG,getActivity());
        tag_button=(Button)sub_view.findViewById(R.id.tag_button);
        tag_button.setText(tag_string);
        if (Utils.getFromPref(Constants.KEY_TAG_KIND,getActivity()).equals("slide"))
        {
            tag_button.setBackgroundColor(Color.parseColor("#6400FF"));
        } else if (Utils.getFromPref(Constants.KEY_TAG_KIND,getActivity()).equals("sko")) {
            tag_button.setBackgroundColor(Color.parseColor("#BF5E27"));
        }
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_button.setVisibility(View.GONE);
                search_edittext.setFocusableInTouchMode(true);

            }
        });
        sub_listview=(ListView)sub_view.findViewById(R.id.subtag_listview);
        load_subtag();
        return sub_view;
    }

    public void load_subtag(){

        sublists=new ArrayList<Favorites>();


        Favorites favorites=new Favorites();
        favorites.setTagname("SPORTS");
        sublists.add(favorites);
        Favorites favorites1=new Favorites();
        favorites1.setTagname("POLITICS");
        sublists.add(favorites1);
        Favorites favorites2=new Favorites();
        favorites2.setTagname("SAVAGERY");
        sublists.add(favorites2);
        Favorites favorites3=new Favorites();
        favorites3.setTagname("POLITICS");
        sublists.add(favorites3);
        Favorites favorites4=new Favorites();
        favorites4.setTagname("POPMEDIA");
        sublists.add(favorites4);


        adapter = new MainTagAdapter(getActivity(), sublists);
        sub_listview.setAdapter(adapter);
    }
}
