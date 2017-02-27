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

public class MainTagAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Favorites> favelist = new ArrayList<>();

    public MainTagAdapter(Activity activity, List<Favorites> userslist) {
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

        return view;
    }

    private static final class ViewHolder {
        private TextView maintagnamne_textview;
        private ImageView tagimageview;
        private ImageView tagarrow_imageview;
        private RelativeLayout background_layout;
    }

}
