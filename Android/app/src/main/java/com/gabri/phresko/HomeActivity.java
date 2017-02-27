package com.gabri.phresko;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.gabri.phresko.fragments.RootFragment;

public class HomeActivity extends AppCompatActivity {
    AHBottomNavigation bottomNavigation;
    RootFragment rootFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.nav_home, R.drawable.media, R.color.colorAccent);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.nav_profile, R.drawable.profile, R.color.colorPrimaryDark);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.nav_camera, R.drawable.photo, R.color.colorAccent);
        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
// Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);



// Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

// Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(false);

// Change colors
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));

// Force to tint the drawable (useful for font with icon for example)
        bottomNavigation.setForceTint(true);

// Force the titles to be displayed (against Material Design guidelines!)
        bottomNavigation.setForceTitlesDisplay(true);

// Use colored navigation with circle reveal effect
        bottomNavigation.setColored(true);

// Set current item programmatically
        bottomNavigation.setCurrentItem(0);

// Customize notification (title, background, typeface)
        bottomNavigation.setNotificationBackgroundColor(Color.parseColor("#F63D2B"));

// Add or remove notification for each item


//        bottomNavigation.setNotification("", 1);
        if (rootFragment==null)rootFragment=new RootFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer, rootFragment).commit();


        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
//                // selection code...
                if (position == 0) {


//                    Utils.setToPrefString(Constants.KEY_FRAGMENTFLAG,"message",MainActivity.this);
//                    Utils.setToPrefString(Constants.KEY_SEND_COUND,"10",MainActivity.this);
                    getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer,rootFragment).commit();

                }
                else if (position == 1) {

                    Intent intent=new Intent(HomeActivity.this,ProfileActivity.class);
                    startActivity(intent);


                }


//
                return true;
            }
        });
    }
}
