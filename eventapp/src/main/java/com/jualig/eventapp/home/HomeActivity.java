package com.jualig.eventapp.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jualig.eventapp.R;
import com.jualig.eventapp.event.EventFragment;
import com.jualig.eventapp.map.MapFragment;
import com.jualig.eventapp.profile.ProfileFragment;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView menuBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        menuBottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        menuBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.profile_item:
                                goProfile();
                                return true;

                            case R.id.event_item:
                                goEvent();
                                return true;

                            case R.id.map_item:
                                goMap();
                                return true;
                        }
                        return false;
                    }
                });
        menuBottomNavigationView.setSelectedItemId(R.id.event_item);
        addFragment(new EventFragment(), "EventFragment");

    }

    private void goProfile() {
        addFragment(new ProfileFragment(), "ProfileFragment");
    }

    private void goEvent() {
        addFragment(new EventFragment(), "EventFragment");
    }

    private void goMap() {
        addFragment(new MapFragment(), "MapFragment");
    }

    private void addFragment(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame_layout, fragment, tag)
                .addToBackStack(null)
                .commit();
    }
}
