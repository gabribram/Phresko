package com.gabri.phresko;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.gabri.phresko.utils.Constants;
import com.yalantis.ucrop.UCrop;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PostActivity extends AppCompatActivity {
    ImageButton back_imagebutton,careraimagebutton;
    ImageView profile_imageview;
    Button post_button;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_SELECT_PICTURE = 2;
    String path,avata_path;
    Bitmap userBitmap;
    UCrop uCrop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        getSupportActionBar().hide();
        post_button=(Button)findViewById(R.id.post_button);
        back_imagebutton=(ImageButton)findViewById(R.id.back_imageButton);
        back_imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        profile_imageview=(ImageView)findViewById(R.id.post_imageView);
        careraimagebutton=(ImageButton)findViewById(R.id.carmera_imageButton);
        careraimagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             show_takephoto_popup();
            }
        });
        post_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }
    public void show_takephoto_popup(){


        PopupMenu popupMenu = new PopupMenu(this,careraimagebutton);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.d("popup",""+item.getItemId());
                switch (item.getTitle().toString()){
                    case "TakePhoto":
                         dispatchTakePictureIntent();
                        return true;
                    case "Select Image From Gallery":
                        selectimage_fromgallery();
                        return true;
                    default:
                        return true;
                }

            }
        });
        popupMenu.getMenu().add("TakePhoto");
        popupMenu.getMenu().add("Select Image From Gallery");
        popupMenu.show();


    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
   private void selectimage_fromgallery(){
       Intent intent = new Intent();
       intent.setType("image/*");
       intent.setAction(Intent.ACTION_GET_CONTENT);
       intent.addCategory(Intent.CATEGORY_OPENABLE);
       startActivityForResult(Intent.createChooser(intent, getString(R.string.label_select_picture)), REQUEST_SELECT_PICTURE);
   }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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
            uCrop = UCrop.of(data.getData(), Uri.fromFile(destination));
            uCrop.withAspectRatio(3,2);
            uCrop.start(this);
        }
        else if (requestCode==REQUEST_SELECT_PICTURE  && resultCode == RESULT_OK){
            String uploadFolder = Constants.KEY_SAVEPHOTO_URL;
            String PATH = Environment.getExternalStorageDirectory() + "/" + uploadFolder + "/";
            File folder = new File(PATH);
            if (!folder.exists()) {
                folder.mkdir();//If there is no folder it will be created.
            }
            File destination = new File(PATH,
                    System.currentTimeMillis() + ".jpg");
            uCrop = UCrop.of(data.getData(), Uri.fromFile(destination));
            uCrop.withAspectRatio(3,2);
            uCrop.start(this);
        }
        else if (requestCode== uCrop.REQUEST_CROP && resultCode == RESULT_OK){
            final Uri resultUri = UCrop.getOutput(data);
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), resultUri);
                profile_imageview.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }


}
