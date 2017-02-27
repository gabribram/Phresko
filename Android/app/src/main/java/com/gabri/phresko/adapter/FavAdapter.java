package com.gabri.phresko.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.gabri.phresko.R;
import com.gabri.phresko.model.Favorites;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by gabri on 20/02/2017.
 */

public class FavAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Favorites> favelist = new ArrayList<>();

    public FavAdapter(Activity activity, List<Favorites> userslist) {
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
            view = vi.inflate(R.layout.favorites_items, null, false);
            viewHolder = new ViewHolder();
            viewHolder.favaction_imagebutton = (ImageView) view.findViewById(R.id.represh_imageButton);
            viewHolder.favenamne_textview = (TextView) view.findViewById(R.id.favname_textView);
            viewHolder.favimageview=(ImageView)view.findViewById(R.id.fav_imageView);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.favenamne_textview.setText(favelist.get(position).getTagname());
        viewHolder.favimageview.setImageResource(R.drawable.savagery);
        return view;
    }

    private static final class ViewHolder {
        private TextView favenamne_textview;
        private ImageView favimageview;
        private ImageView favaction_imagebutton;
    }

}
