package com.example.anglesea;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class HelpPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_page);
        final VideoView videoView = findViewById(R.id.videoView);
        String videoPath = "android.resource://"+getPackageName()+"/"+R.raw.video;


        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        drawer=findViewById(R.id.drawer_layout_help);//set your drawerLayout id in the xml and change here

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        toggle.syncState();


        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
            }
        });

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);




    }
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


        switch (menuItem.getItemId()){
            case R.id.profile:
                Intent in1 = new Intent(this,UserDashboard.class);
                startActivity(in1);
                break;
            case R.id.history:
                Intent in2 = new Intent(this,HistoryPage.class);
                startActivity(in2);
                break;
            case R.id.help:
                Intent in =new Intent(this,HelpPage.class);
                startActivity(in);
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}