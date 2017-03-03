package com.gabri.phresko.fragments;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.gabri.phresko.R;
import com.gabri.phresko.utils.Constants;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostFragment extends Fragment {

    View post_view;
    ImageButton back_imagebutton,careraimagebutton;
    ImageView profile_imageview;
    Button post_button;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    String path,avata_path;
    Bitmap userBitmap;
    UCrop uCrop;
    public PostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        post_view=inflater.inflate(R.layout.fragment_post, container, false);
        post_button=(Button)post_view.findViewById(R.id.post_button);
        profile_imageview=(ImageView)post_view.findViewById(R.id.post_imageView);
        careraimagebutton=(ImageButton)post_view.findViewById(R.id.carmera_imageButton);
        careraimagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });
        return post_view;
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

//        UCrop uCrop = UCrop.of(uri, Uri.fromFile(new File(getCacheDir(), destinationFileName)));
//        if (resultCode == RESULT_OK && requestCode == UCrop.REQUEST_CROP) {
//            final Uri resultUri = UCrop.getOutput(data);
//        } else if (resultCode == UCrop.RESULT_ERROR) {
//            final Throwable cropError = UCrop.getError(data);
//        }


        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            String uploadFolder = Constants.KEY_SAVEPHOTO_URL;
            Bundle extras = data.getExtras();
            Bitmap thumbnail = (Bitmap) extras.get("data");
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
            String PATH = Environment.getExternalStorageDirectory() + "/" + uploadFolder + "/";
            File folder = new File(PATH);
            if (!folder.exists()) {
                folder.mkdir();//If there is no folder it will be created.
            }
            File destination = new File(PATH,
                    System.currentTimeMillis() + ".jpg");

            FileOutputStream fo;
            try {
                destination.createNewFile();
                fo = new FileOutputStream(destination);
                fo.write(bytes.toByteArray());
                fo.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            uCrop = UCrop.of(data.getData(),Uri.fromFile(destination));
            uCrop.start(getActivity());
//            uCrop.ge
//            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uCrop.getOutput);
//            path = destination.getAbsolutePath();
//
////            userBitmap = thumbnail;
//            profile_imageview.setImageBitmap(temp_bitmap);

        }
        else if (requestCode== uCrop.REQUEST_CROP && resultCode == RESULT_OK){
            Log.d("Image","No");
            Bundle extras = uCrop.getIntent(getActivity()).getExtras();
            if (extras==null){
                Log.d("Image","No");
            }
            else {
                Log.d("Image","Yes");
            }
            Bitmap thumbnail = (Bitmap) extras.get("data");
            profile_imageview.setImageBitmap(thumbnail);

        }
    }
}
