package com.gabri.phresko.fragments;


import android.graphics.Color;
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
import com.gabri.phresko.adapter.SlideSubTagAdapter;
import com.gabri.phresko.adapter.SubTagAdapter;
import com.gabri.phresko.model.Favorites;
import com.gabri.phresko.utils.Constants;
import com.gabri.phresko.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SlideSubFragment extends Fragment {

    Button tag_button,search_button;
    String tag_string;
    EditText search_edittext;
    ListView sub_listview;
    SlideSubTagAdapter adapter;
    List<Favorites> sublists;
    View slide_view;
    public SlideSubFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        slide_view=inflater.inflate(R.layout.fragment_slide_sub, container, false);

        search_button=(Button)slide_view.findViewById(R.id.search_button);
        search_edittext=(EditText)slide_view.findViewById(R.id.search_editText);
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_button.setVisibility(View.GONE);
                search_edittext.setFocusableInTouchMode(true);

            }
        });
        sub_listview=(ListView)slide_view.findViewById(R.id.slide_listview);
        load_subtag();
        sub_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Utils.setToPrefString(Constants.KEY_TAG,sublists.get(position).getTagname(),getActivity());
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer,new SelectImagesFragment()).commit();
            }
        });



        return slide_view;
    }


    public void load_subtag(){
        if (Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Food")){
            sublists=new ArrayList<Favorites>();


            Favorites favorites=new Favorites();
            favorites.setTagname("Breakfast");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Lunch");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("Dinner");
            sublists.add(favorites2);
            Favorites favorites3=new Favorites();
            favorites3.setTagname("Snacks");
            sublists.add(favorites3);
            adapter = new SlideSubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Objects")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("Furniture");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Creations");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("Random");
            sublists.add(favorites2);
            adapter = new SlideSubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Wildlife")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Animals");
            sublists.add(favorites1);
            Favorites favorites=new Favorites();
            favorites.setTagname("Insects");
            sublists.add(favorites);

            Favorites favorites2=new Favorites();
            favorites2.setTagname("Plants");
            sublists.add(favorites2);
            adapter = new SlideSubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Holidays")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("Religious");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("National");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("Social");
            sublists.add(favorites2);
            adapter = new SlideSubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Sporting")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("NBA");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("MLB");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("Soccer");
            sublists.add(favorites2);
            Favorites favorites3=new Favorites();
            favorites3.setTagname("NFL");
            sublists.add(favorites3);
            Favorites favorites4=new Favorites();
            favorites4.setTagname("Boxing/MMA");
            sublists.add(favorites4);
            adapter = new SlideSubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Gatherings")){
            Favorites favorites=new Favorites();
            favorites.setTagname("Concerts");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Protests");
            sublists.add(favorites1);
            adapter = new SlideSubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Group")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("Family");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Friends");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("Team");
            sublists.add(favorites2);
            Favorites favorites3=new Favorites();
            favorites3.setTagname("Work");
            sublists.add(favorites3);
            adapter = new SlideSubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Selfie")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("Home");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Nature");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("Public");
            sublists.add(favorites2);
            adapter = new SlideSubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Moods")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("Happy");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Sad");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("Excited");
            sublists.add(favorites2);
            Favorites favorites3=new Favorites();
            favorites3.setTagname("Bored");
            sublists.add(favorites3);
            Favorites favorites4=new Favorites();
            favorites4.setTagname("Calm");
            sublists.add(favorites4);
            Favorites favorites5=new Favorites();
            favorites5.setTagname("Other");
            sublists.add(favorites5);
            adapter = new SlideSubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Structures")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("Buildings");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Homes");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("Religious");
            sublists.add(favorites2);
            Favorites favorites3=new Favorites();
            favorites3.setTagname("Bridges");
            sublists.add(favorites3);
            adapter = new SlideSubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Theme Parks")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("Rides");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("People");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("Costumes");
            sublists.add(favorites2);
            adapter = new SlideSubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Nature")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("FOrrests");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Water");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("Plants");
            sublists.add(favorites2);
            Favorites favorites3=new Favorites();
            favorites3.setTagname("Sky/Mtns");
            sublists.add(favorites3);
            adapter = new SlideSubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Drawings")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("People");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Places");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("Things");
            sublists.add(favorites2);
            adapter = new SlideSubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Sculptures")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("Vases");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Modern");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("Historical");
            sublists.add(favorites2);
            adapter = new SlideSubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Animation")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("CGI/Graphics");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Cptr");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("By hand");
            sublists.add(favorites2);
            adapter = new SlideSubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }


    }

}
