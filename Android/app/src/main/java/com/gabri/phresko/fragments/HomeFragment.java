package com.gabri.phresko.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.gabri.phresko.R;
import com.gabri.phresko.adapter.PostsAdapter;
import com.gabri.phresko.model.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    TextView tagname_textview;
    ImageButton back_imagebutton;
    List<Post> posts;
    ListView postlistview;
    PostsAdapter adapter;
    View home_view;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        home_view=inflater.inflate(R.layout.fragment_home, container, false);
        tagname_textview=(TextView)home_view.findViewById(R.id.tagname_textView);
        postlistview=(ListView)home_view.findViewById(R.id.image_listview);
        load_posts();



        return home_view;
    }

    public void load_posts(){


        posts=new ArrayList<Post>();


        Post favorites=new Post();
        favorites.setUsername("JOHN DEO");
        favorites.setPostime("3.00 PM");
        favorites.setTitle("Evil Jesus");
        favorites.setLocation("MI,USD");
        favorites.setDefaulttag("Fun");
        favorites.setDescription("Lorem lpsum is simply dummy text of the printing and typesetting industry.Lorem lpsum is simply summy text");
        favorites.setFirsttag("#fun");
        favorites.setSescondtag("#jokes");
        favorites.setThirdtag("#kidding");
        favorites.setCommentscount("34");
        favorites.setFavcounts("230");
        posts.add(favorites);


        Post favorites1=new Post();
        favorites1.setUsername("JENNY SEGURA");
        favorites1.setPostime("6.00 PM");
        favorites1.setTitle("Love vs Lust(jenny segura)");
        favorites1.setLocation("MI,USD");
        favorites1.setDefaulttag("Love");
        favorites1.setDescription("Lorem lpsum is simply dummy text of the printing and typesetting industry.Lorem lpsum is simply summy text");
        favorites1.setFirsttag("#lust");
        favorites1.setSescondtag("#love");
        favorites1.setThirdtag("#persons");
        favorites1.setCommentscount("34");
        favorites1.setFavcounts("230");
        posts.add(favorites1);


        Post favorites2=new Post();
        favorites2.setUsername("GABRI DOGA");
        favorites2.setPostime("7.00 PM");
        favorites2.setTitle("Evil Jesus");
        favorites2.setLocation("MI,USD");
        favorites2.setDefaulttag("Fun");
        favorites2.setDescription("Lorem lpsum is simply dummy text of the printing and typesetting industry.Lorem lpsum is simply summy text");
        favorites2.setFirsttag("#fun");
        favorites2.setSescondtag("#jokes");
        favorites2.setThirdtag("#kidding");
        favorites2.setCommentscount("34");
        favorites2.setFavcounts("230");
        posts.add(favorites2);


        Post favorites3=new Post();
        favorites3.setUsername("FRANK OSCAR");
        favorites3.setPostime("9.00 PM");
        favorites3.setTitle("Evil Jesus");
        favorites3.setLocation("MI,USD");
        favorites3.setDefaulttag("Fun");
        favorites3.setDescription("Lorem lpsum is simply dummy text of the printing and typesetting industry.Lorem lpsum is simply summy text");
        favorites3.setFirsttag("#fun");
        favorites3.setSescondtag("#jokes");
        favorites3.setThirdtag("#kidding");
        favorites3.setCommentscount("34");
        favorites3.setFavcounts("230");
        posts.add(favorites3);



        adapter = new PostsAdapter(getActivity(), posts);
        postlistview.setAdapter(adapter);


    }


}
