package com.gabri.phresko.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gabri.phresko.R;
import com.gabri.phresko.model.Favorites;
import com.gabri.phresko.utils.Constants;
import com.gabri.phresko.utils.Utils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by gabri on 20/02/2017.
 */

public class SlideSubTagAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Favorites> favelist = new ArrayList<>();

    public SlideSubTagAdapter(Activity activity, List<Favorites> userslist) {
        this.activity = activity;
        this.favelist.addAll(userslist);
    }

    @Override
    public int getCount() {
        return favelist.size();
    }

    @Override
    public Favorites getItem(int location) {
        return favelist.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R.layout.maintag_items, null, false);
            viewHolder = new ViewHolder();
            viewHolder.tagimageview = (ImageView) view.findViewById(R.id.tag_imageView);
            viewHolder.maintagnamne_textview = (TextView) view.findViewById(R.id.tagname_textView);
            viewHolder.tagarrow_imageview=(ImageView)view.findViewById(R.id.arrow_imageView);
            viewHolder.background_layout=(RelativeLayout)view.findViewById(R.id.tag_layout);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.maintagnamne_textview.setText(favelist.get(position).getTagname());
        viewHolder.tagimageview.setImageResource(R.drawable.savagery);
        if (Utils.getFromPref(Constants.KEY_TAG_KIND,activity).equals("slide"))
        {
            viewHolder.background_layout.setBackgroundColor(Color.parseColor("#6400FF"));
            viewHolder.tagarrow_imageview.setBackgroundColor(Color.parseColor("#5100CC"));
        }
        if (Utils.getFromPref(Constants.KEY_TAG_KIND,activity).equals("sko")){
            viewHolder.background_layout.setBackgroundColor(Color.parseColor("#BF5E27"));
            viewHolder.tagarrow_imageview.setBackgroundColor(Color.parseColor("#AC5523"));
        }
//        slide food
        if (favelist.get(position).getTagname().equals("Breakfast")){
        viewHolder.tagimageview.setImageResource(R.drawable.breakfast);
        }
        if (favelist.get(position).getTagname().equals("Lunch")){
            viewHolder.tagimageview.setImageResource(R.drawable.lunch);
        }
        if (favelist.get(position).getTagname().equals("Dinner")){
            viewHolder.tagimageview.setImageResource(R.drawable.dinner);
        }
        if (favelist.get(position).getTagname().equals("Snacks")){
            viewHolder.tagimageview.setImageResource(R.drawable.snaks);
        }


        //        slide Objects
        if (favelist.get(position).getTagname().equals("Furniture")){
            viewHolder.tagimageview.setImageResource(R.drawable.furniture);
        }
        if (favelist.get(position).getTagname().equals("Creations")){
            viewHolder.tagimageview.setImageResource(R.drawable.creations);
        }
        if (favelist.get(position).getTagname().equals("Random")){
            viewHolder.tagimageview.setImageResource(R.drawable.randon);
        }

        //        slide Wildlife
        if (favelist.get(position).getTagname().equals("Animals")){
            viewHolder.tagimageview.setImageResource(R.drawable.animal);
        }
        if (favelist.get(position).getTagname().equals("Insects")){
            viewHolder.tagimageview.setImageResource(R.drawable.insects);
        }
        if (favelist.get(position).getTagname().equals("Plants")){
            viewHolder.tagimageview.setImageResource(R.drawable.plants);//////
        }

        //        Holidays Wildlife
        if (favelist.get(position).getTagname().equals("Religious")){
            viewHolder.tagimageview.setImageResource(R.drawable.religous);
        }
        if (favelist.get(position).getTagname().equals("National")){
            viewHolder.tagimageview.setImageResource(R.drawable.natrional);
        }
        if (favelist.get(position).getTagname().equals("Social")){
            viewHolder.tagimageview.setImageResource(R.drawable.social);//////
        }

        //        slide Sporting
        if (favelist.get(position).getTagname().equals("NBA")){
            viewHolder.tagimageview.setImageResource(R.drawable.nbasmall);
        }
        if (favelist.get(position).getTagname().equals("MLB")){
            viewHolder.tagimageview.setImageResource(R.drawable.mlp);
        }
        if (favelist.get(position).getTagname().equals("NFL")){
            viewHolder.tagimageview.setImageResource(R.drawable.nflsmall);
        }
        if (favelist.get(position).getTagname().equals("Soccer")){
            viewHolder.tagimageview.setImageResource(R.drawable.soccersmall);//////
        }
        if (favelist.get(position).getTagname().equals("Boxing")){
            viewHolder.tagimageview.setImageResource(R.drawable.boxingsmall);//////
        }
        //        slide Gatherings
        if (favelist.get(position).getTagname().equals("Concerts")){
            viewHolder.tagimageview.setImageResource(R.drawable.concerts);
        }
        if (favelist.get(position).getTagname().equals("Protests")){
            viewHolder.tagimageview.setImageResource(R.drawable.protests);
        }
        //        slide Group
        if (favelist.get(position).getTagname().equals("Family")){
            viewHolder.tagimageview.setImageResource(R.drawable.family);
        }
        if (favelist.get(position).getTagname().equals("Friends")){
            viewHolder.tagimageview.setImageResource(R.drawable.friend);
        }
        if (favelist.get(position).getTagname().equals("Team")){
            viewHolder.tagimageview.setImageResource(R.drawable.team);
        }
        if (favelist.get(position).getTagname().equals("Work")){
            viewHolder.tagimageview.setImageResource(R.drawable.work);
        }
        //        slide Selfie
        if (favelist.get(position).getTagname().equals("Home")){
            viewHolder.tagimageview.setImageResource(R.drawable.home);
        }
        if (favelist.get(position).getTagname().equals("Nature")){
            viewHolder.tagimageview.setImageResource(R.drawable.nature);
        }
        if (favelist.get(position).getTagname().equals("Public")){
            viewHolder.tagimageview.setImageResource(R.drawable.publicsmall);
        }
        //        slide Moods
        if (favelist.get(position).getTagname().equals("Happy")){
            viewHolder.tagimageview.setImageResource(R.drawable.happy);
        }
        if (favelist.get(position).getTagname().equals("Sad")){
            viewHolder.tagimageview.setImageResource(R.drawable.sad);
        }
        if (favelist.get(position).getTagname().equals("Excited")){
            viewHolder.tagimageview.setImageResource(R.drawable.excited);
        }
        if (favelist.get(position).getTagname().equals("Bored")){
            viewHolder.tagimageview.setImageResource(R.drawable.bored);
        }
        if (favelist.get(position).getTagname().equals("Calm")){
            viewHolder.tagimageview.setImageResource(R.drawable.calm);
        }
        if (favelist.get(position).getTagname().equals("Other")){
            viewHolder.tagimageview.setImageResource(R.drawable.other);
        }


        //        slide Structures
        if (favelist.get(position).getTagname().equals("Buildings")){
            viewHolder.tagimageview.setImageResource(R.drawable.buildings);
        }
        if (favelist.get(position).getTagname().equals("Homes")){
            viewHolder.tagimageview.setImageResource(R.drawable.home);
        }
        if (favelist.get(position).getTagname().equals("Religious")){
            viewHolder.tagimageview.setImageResource(R.drawable.religious);
        }
        if (favelist.get(position).getTagname().equals("Bridges")){
            viewHolder.tagimageview.setImageResource(R.drawable.bored);
        }
        //        slide Theme Parks
        if (favelist.get(position).getTagname().equals("Rides")){
            viewHolder.tagimageview.setImageResource(R.drawable.rides);
        }
        if (favelist.get(position).getTagname().equals("People")){
            viewHolder.tagimageview.setImageResource(R.drawable.people);
        }
        if (favelist.get(position).getTagname().equals("Costumes")){
            viewHolder.tagimageview.setImageResource(R.drawable.costume);
        }


        //        slide Nature
        if (favelist.get(position).getTagname().equals("Forrests")){
            viewHolder.tagimageview.setImageResource(R.drawable.forest);
        }
        if (favelist.get(position).getTagname().equals("Water")){
            viewHolder.tagimageview.setImageResource(R.drawable.water);
        }
        if (favelist.get(position).getTagname().equals("Plant")){
            viewHolder.tagimageview.setImageResource(R.drawable.plantssmall);
        }
        if (favelist.get(position).getTagname().equals("Sky")){
            viewHolder.tagimageview.setImageResource(R.drawable.sky);
        }



        //        slide Drawings
        if (favelist.get(position).getTagname().equals("People")){
            viewHolder.tagimageview.setImageResource(R.drawable.peoplessmall);
        }
        if (favelist.get(position).getTagname().equals("Places")){
            viewHolder.tagimageview.setImageResource(R.drawable.places);
        }
        if (favelist.get(position).getTagname().equals("Things")){
            viewHolder.tagimageview.setImageResource(R.drawable.things);
        }


        //        slide Sculptures
        if (favelist.get(position).getTagname().equals("Vases")){
            viewHolder.tagimageview.setImageResource(R.drawable.vases);
        }
        if (favelist.get(position).getTagname().equals("Modern")){
            viewHolder.tagimageview.setImageResource(R.drawable.moders);
        }
        if (favelist.get(position).getTagname().equals("Historical")){
            viewHolder.tagimageview.setImageResource(R.drawable.historical);
        }




        //        slide Animation
        if (favelist.get(position).getTagname().equals("Graphics")){
            viewHolder.tagimageview.setImageResource(R.drawable.graphics);
        }
        if (favelist.get(position).getTagname().equals("Capture")){
            viewHolder.tagimageview.setImageResource(R.drawable.capture);
        }
        if (favelist.get(position).getTagname().equals("By hand")){
            viewHolder.tagimageview.setImageResource(R.drawable.byhand);
        }

//        if (favelist.get(position).getTagname().equals("PETTY")){
//            viewHolder.tagimageview.setImageResource(R.drawable.);
//        }


        return view;
    }

    private static final class ViewHolder {
        private TextView maintagnamne_textview;
        private ImageView tagimageview;
        private ImageView tagarrow_imageview;
        private RelativeLayout background_layout;
    }

}
