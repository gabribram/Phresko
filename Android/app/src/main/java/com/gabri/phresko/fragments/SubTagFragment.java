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
import com.gabri.phresko.adapter.MainTagAdapter;
import com.gabri.phresko.adapter.SubTagAdapter;
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
    SubTagAdapter adapter;
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
        sub_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (Utils.getFromPref(Constants.KEY_TAG_KIND,getActivity()).equals("slide")){
                    Utils.setToPrefString(Constants.KEY_TAG,sublists.get(position).getTagname(),getActivity());
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer,new SlideSubFragment()).commit();
                }
                else {

                    Utils.setToPrefString(Constants.KEY_TAG,sublists.get(position).getTagname(),getActivity());
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer,new SelectImagesFragment()).commit();

                }

            }
        });
        return sub_view;
    }

    public void load_subtag(){
        if (Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Politics")){
            sublists=new ArrayList<Favorites>();


            Favorites favorites=new Favorites();
            favorites.setTagname("Trump/Pence");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Obama/Biden");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("Republicans");
            sublists.add(favorites2);
            Favorites favorites3=new Favorites();
            favorites3.setTagname("Democrats");
            sublists.add(favorites3);
            adapter = new SubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Sports")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("NBA");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("MLB");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("NFL");
            sublists.add(favorites2);
            Favorites favorites3=new Favorites();
            favorites3.setTagname("Soccer");
            sublists.add(favorites3);
            Favorites favorites4=new Favorites();
            favorites4.setTagname("Boxing/MMA");
            sublists.add(favorites4);
            adapter = new SubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Pop Media")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Kermit");
            sublists.add(favorites1);
            Favorites favorites=new Favorites();
            favorites.setTagname("Most interesting man");
            sublists.add(favorites);

            Favorites favorites2=new Favorites();
            favorites2.setTagname("Neil De Grasse");
            sublists.add(favorites2);
            Favorites favorites3=new Favorites();
            favorites3.setTagname("Overly attached girlfriend");
            sublists.add(favorites3);
            adapter = new SubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Savagery")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("General");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Unfriendly");
            sublists.add(favorites1);
            adapter = new SubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("PETTY")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("Common");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Super-Petty");
            sublists.add(favorites1);
            adapter = new SubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("ADULT")){
            Favorites favorites=new Favorites();
            favorites.setTagname("Jokes");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Ideas");
            sublists.add(favorites1);
            adapter = new SubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Things")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("Food");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Objects");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("Wildlife");
            sublists.add(favorites2);
            adapter = new SubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Events")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("Holidays");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Sporting");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("Gatherings");
            sublists.add(favorites2);
            adapter = new SubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("People")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("Group");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Selfie");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("Moods");
            sublists.add(favorites2);
            adapter = new SubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Places")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("Structures");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Theme Parks");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("Nature");
            sublists.add(favorites2);
            adapter = new SubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }
        else if(Utils.getFromPref(Constants.KEY_TAG,getActivity()).equals("Art Images")){
            sublists=new ArrayList<Favorites>();
            Favorites favorites=new Favorites();
            favorites.setTagname("Drawings");
            sublists.add(favorites);
            Favorites favorites1=new Favorites();
            favorites1.setTagname("Sculptures");
            sublists.add(favorites1);
            Favorites favorites2=new Favorites();
            favorites2.setTagname("Animation");
            sublists.add(favorites2);
            adapter = new SubTagAdapter(getActivity(), sublists);
            sub_listview.setAdapter(adapter);
        }

    }
}
