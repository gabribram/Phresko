package com.gabri.phresko.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.gabri.phresko.R;
import com.gabri.phresko.adapter.FavAdapter;
import com.gabri.phresko.adapter.MainTagAdapter;
import com.gabri.phresko.model.Favorites;
import com.gabri.phresko.utils.Constants;
import com.gabri.phresko.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainTagFragment extends Fragment {

    Button search_button;
    EditText search_edittext;
    View main_view;
    ListView tag_listview;
    MainTagAdapter adapter;
    List<Favorites> favelist;
    public MainTagFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        main_view=inflater.inflate(R.layout.fragment_main_tag, container, false);
        search_button=(Button)main_view.findViewById(R.id.search_button);
        search_edittext=(EditText)main_view.findViewById(R.id.search_editText);
        tag_listview=(ListView)main_view.findViewById(R.id.maintag_listview);
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_button.setVisibility(View.GONE);
                search_edittext.setFocusableInTouchMode(true);

            }
        });
        load_tag();
        tag_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Utils.setToPrefString(Constants.KEY_TAG,favelist.get(position).getTagname(),getActivity());
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer,new SubTagFragment()).commit();
            }
        });
        return main_view;
    }
public void load_tag(){

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


    adapter = new MainTagAdapter(getActivity(), favelist);
    tag_listview.setAdapter(adapter);

}
}
