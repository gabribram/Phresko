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

public class SubTagAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Favorites> favelist = new ArrayList<>();

    public SubTagAdapter(Activity activity, List<Favorites> userslist) {
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
        if (favelist.get(position).getTagname().equals("Kermit")){
        viewHolder.tagimageview.setImageResource(R.drawable.kermit);
        }
        if (favelist.get(position).getTagname().equals("Most interesting man")){
            viewHolder.tagimageview.setImageResource(R.drawable.mostintestman);
        }
        if (favelist.get(position).getTagname().equals("Neil De Grasse")){
            viewHolder.tagimageview.setImageResource(R.drawable.neildegrasse);
        }
        if (favelist.get(position).getTagname().equals("Overly attached girlfriend")){
            viewHolder.tagimageview.setImageResource(R.drawable.sport);
        }
        if (favelist.get(position).getTagname().equals("Overly attached girlfriend")){
            viewHolder.tagimageview.setImageResource(R.drawable.overlyattached);
        }


        if (favelist.get(position).getTagname().equals("Structures")){
            viewHolder.tagimageview.setImageResource(R.drawable.structe);
        }
        if (favelist.get(position).getTagname().equals("Theme Parks")){
            viewHolder.tagimageview.setImageResource(R.drawable.themparks);
        }
        if (favelist.get(position).getTagname().equals("Nature")){
            viewHolder.tagimageview.setImageResource(R.drawable.nature);
        }
        if (favelist.get(position).getTagname().equals("Things")){
            viewHolder.tagimageview.setImageResource(R.drawable.things);
        }
        if (favelist.get(position).getTagname().equals("Art Images")){
            viewHolder.tagimageview.setImageResource(R.drawable.artimages);
        }

//        politics sko
        if (favelist.get(position).getTagname().equals("Trump")){
            viewHolder.tagimageview.setImageResource(R.drawable.trump);
        }
        if (favelist.get(position).getTagname().equals("Obama")){
            viewHolder.tagimageview.setImageResource(R.drawable.obama);
        }
        if (favelist.get(position).getTagname().equals("Republicans")){
            viewHolder.tagimageview.setImageResource(R.drawable.repulicans);
        }
        if (favelist.get(position).getTagname().equals("Democrat")){
            viewHolder.tagimageview.setImageResource(R.drawable.democrat);
        }

        //        sports sko
        if (favelist.get(position).getTagname().equals("NBA")){
            viewHolder.tagimageview.setImageResource(R.drawable.nba);
        }
        if (favelist.get(position).getTagname().equals("MLB")){
            viewHolder.tagimageview.setImageResource(R.drawable.mlb);
        }
        if (favelist.get(position).getTagname().equals("Soccer")){
            viewHolder.tagimageview.setImageResource(R.drawable.nfl);
        }
        if (favelist.get(position).getTagname().equals("Boxing")){
            viewHolder.tagimageview.setImageResource(R.drawable.boxing);
        }

        //        survage sko
        if (favelist.get(position).getTagname().equals("General")){
            viewHolder.tagimageview.setImageResource(R.drawable.general);
        }
        if (favelist.get(position).getTagname().equals("Unfriendly")){
            viewHolder.tagimageview.setImageResource(R.drawable.unfriend);
        }

        //        petty sko
        if (favelist.get(position).getTagname().equals("Common")){
            viewHolder.tagimageview.setImageResource(R.drawable.common);
        }
        if (favelist.get(position).getTagname().equals("Super Petty")){
            viewHolder.tagimageview.setImageResource(R.drawable.supperpetty);
        }

        //        adult sko
        if (favelist.get(position).getTagname().equals("Jokes")){
            viewHolder.tagimageview.setImageResource(R.drawable.jokes);
        }
        if (favelist.get(position).getTagname().equals("Ideas")){
            viewHolder.tagimageview.setImageResource(R.drawable.ideas);
        }

        //        thins sko
        if (favelist.get(position).getTagname().equals("Food")){
            viewHolder.tagimageview.setImageResource(R.drawable.food);
        }
        if (favelist.get(position).getTagname().equals("Objects")){
            viewHolder.tagimageview.setImageResource(R.drawable.object);
        }
        if (favelist.get(position).getTagname().equals("Wildlife")){
            viewHolder.tagimageview.setImageResource(R.drawable.wildwife);
        }


        //        Events sko
        if (favelist.get(position).getTagname().equals("Holidays")){
            viewHolder.tagimageview.setImageResource(R.drawable.holidays);
        }
        if (favelist.get(position).getTagname().equals("Sporting")){
            viewHolder.tagimageview.setImageResource(R.drawable.sportins);
        }
        if (favelist.get(position).getTagname().equals("Gatherings")){
            viewHolder.tagimageview.setImageResource(R.drawable.gathering);
        }

        //        People sko
        if (favelist.get(position).getTagname().equals("Group")){
            viewHolder.tagimageview.setImageResource(R.drawable.group);
        }
        if (favelist.get(position).getTagname().equals("Selfie")){
            viewHolder.tagimageview.setImageResource(R.drawable.selfi);
        }
        if (favelist.get(position).getTagname().equals("Moods")){
            viewHolder.tagimageview.setImageResource(R.drawable.mode);
        }


        //        Art Images sko
        if (favelist.get(position).getTagname().equals("Drawings")){
            viewHolder.tagimageview.setImageResource(R.drawable.drawing);
        }
        if (favelist.get(position).getTagname().equals("Sculptures")){
            viewHolder.tagimageview.setImageResource(R.drawable.sculptures);
        }
        if (favelist.get(position).getTagname().equals("Animation")){
            viewHolder.tagimageview.setImageResource(R.drawable.animation);
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
