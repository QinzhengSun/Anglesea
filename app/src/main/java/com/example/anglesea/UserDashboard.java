package com.example.anglesea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    TextView cv_staff_info_name, cv_staff_info_dob, cv_staff_info_role, cv_staff_info_id_number;
    ImageView cv_staff_image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        //-------------------------------------------------------------------------------------------------------------
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        drawer=findViewById(R.id.userDashboard_layout);//set your drawerLayout id in the xml and change here

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        toggle.syncState();
//-----------------------------------------------------------------------------------------------------------------

        cv_staff_info_name = findViewById(R.id.cv_staff_info_name);
        cv_staff_info_dob = findViewById(R.id.cv_staff_info_dob);
        cv_staff_info_role = findViewById(R.id.cv_staff_info_role);
        cv_staff_info_id_number = findViewById(R.id.cv_staff_info_id_number);

        cv_staff_image = findViewById(R.id.cv_staff_image);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://address")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AngleseaAPI angleseaAPI = retrofit.create(AngleseaAPI.class);

        Call<List<StaffData>> call = AngleseaAPI.getStaffData();

        call.enqueue(new Callback<List<StaffData>>() {
            @Override
            public void onResponse(Call<List<StaffData>> call, Response<List<StaffData>> response) {
                if (!response.isSuccessful()) {
                    cv_staff_info_name.setText("CODE: " + response.code());
                    return;
                }

                List<StaffData> staffdata = response.body();

                for (StaffData staffData : staffdata) {
                 //   String
                }
            }

            @Override
            public void onFailure(Call<List<StaffData>> call, Throwable t) {

            }
        });

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