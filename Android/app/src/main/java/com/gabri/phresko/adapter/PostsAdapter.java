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
import com.gabri.phresko.model.Post;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by gabri on 20/02/2017.
 */

public class PostsAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Post> postList = new ArrayList<>();

    public PostsAdapter(Activity activity, List<Post> userslist) {
        this.activity = activity;
        this.postList.addAll(userslist);
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Post getItem(int location) {
        return postList.get(location);
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
            view = vi.inflate(R.layout.photo_items, null, false);
            viewHolder = new ViewHolder();
            viewHolder.username_textview = (TextView) view.findViewById(R.id.username_textView);
            viewHolder.posttime_textview = (TextView) view.findViewById(R.id.posttime_textView);
            viewHolder.title_textview = (TextView) view.findViewById(R.id.title_textView);
            viewHolder.description_textview = (TextView) view.findViewById(R.id.description_textView);
            viewHolder.defaulttag_textview = (TextView) view.findViewById(R.id.default_textview);
            viewHolder.firsttag_textview = (TextView) view.findViewById(R.id.firsttag_textview);
            viewHolder.secondtag_textview = (TextView) view.findViewById(R.id.secode_textview);
            viewHolder.third_textview = (TextView) view.findViewById(R.id.thirdtag_textview);
            viewHolder.commentcount_textview = (TextView) view.findViewById(R.id.commentcount_textView);
            viewHolder.favcount_textview = (TextView) view.findViewById(R.id.favcount_textView);
            viewHolder.locations_textview = (TextView) view.findViewById(R.id.location_textView);
            viewHolder.comment_iamgebutton=(ImageButton)view.findViewById(R.id.comment_imageButton);
            viewHolder.profile_imageview=(ImageView)view.findViewById(R.id.profile_imageView);
            viewHolder.photo_imageview=(ImageView)view.findViewById(R.id.photo_imageView);
            viewHolder.fav_imageview=(ImageView)view.findViewById(R.id.favorites_imageView);


            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.username_textview.setText(postList.get(position).getUsername());
        viewHolder.title_textview.setText(postList.get(position).getTitle());
        viewHolder.posttime_textview.setText(postList.get(position).getPostime());
        viewHolder.description_textview.setText(postList.get(position).getDescription());
        viewHolder.defaulttag_textview.setText(postList.get(position).getDefaulttag());
        viewHolder.firsttag_textview.setText(postList.get(position).getFirsttag());
        viewHolder.secondtag_textview.setText(postList.get(position).getSescondtag());
        viewHolder.third_textview.setText(postList.get(position).getThirdtag());
        viewHolder.commentcount_textview.setText(postList.get(position).getCommentscount());
        viewHolder.favcount_textview.setText(postList.get(position).getFavcounts());
        viewHolder.locations_textview.setText(postList.get(position).getLocation());

        return view;
    }

    private static final class ViewHolder {
        private TextView username_textview,posttime_textview,title_textview,description_textview,defaulttag_textview,firsttag_textview,secondtag_textview,third_textview,commentcount_textview,favcount_textview,locations_textview;
        private ImageView profile_imageview,photo_imageview,fav_imageview;
        private ImageButton comment_iamgebutton;
    }

}
