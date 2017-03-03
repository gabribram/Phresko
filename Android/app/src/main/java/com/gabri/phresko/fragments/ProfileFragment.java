package com.gabri.phresko.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.gabri.phresko.HomeActivity;
import com.gabri.phresko.ProfileActivity;
import com.gabri.phresko.R;
import com.gabri.phresko.activity.ImageViewActivity;
import com.gabri.phresko.adapter.FavAdapter;
import com.gabri.phresko.model.Favorites;
import com.gabri.phresko.utils.Constants;
import com.gabri.phresko.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    ListView favorites_listview;
    ImageButton home_imagebutton;
    FavAdapter adapter;
    List<Favorites> favelist;
    View profile_view;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        profile_view=inflater.inflate(R.layout.fragment_profile, container, false);
        home_imagebutton=(ImageButton)profile_view.findViewById(R.id.home_imageButton);
        home_imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer,new RootFragment()).commit();
            }
        });
        favorites_listview=(ListView)profile_view.findViewById(R.id.favorite_listview);
        load_fave();
        favorites_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Utils.setToPrefString(Constants.KEY_TAG,favelist.get(position).getTagname(),getActivity());
                Intent intent=new Intent(getActivity(), ImageViewActivity.class);
                startActivity(intent);
            }
        });
        return profile_view;
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


        adapter = new FavAdapter(getActivity(), favelist);
        favorites_listview.setAdapter(adapter);



    }
}
