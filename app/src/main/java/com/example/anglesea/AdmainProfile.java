package com.example.anglesea;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class AdmainProfile extends AppCompatActivity {
    private DrawerLayout drawer;
    List<User> userList = new ArrayList<>();
    private EditText mSearch;
    private RecyclerView mRec;
    private NavigationView mNavView;
    private DrawerLayout mDrawLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);
        initViews();

        /*ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.menu);*/
        /*
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        drawer=findViewById(R.id.draw_layout_adminprofile);//set your drawerLayout id in the xml and change here

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        toggle.syncState();
        */
        mRec.setLayoutManager(new LinearLayoutManager(this));
        userList.add(new User("Jenna Sanchez", "2535", 0, "7:00"));
        userList.add(new User("Jenna Sanchez", "2535", 1, "7:00"));
        userList.add(new User("Jenna Sanchez", "2535", 1, "7:00"));
        userList.add(new User("Jenna Sanchez", "2535", 2, "7:00"));
        userList.add(new User("Jenna Sanchez", "2535", 0, "7:00"));
        mSearch.setBackground(ShapeUtil.getSoldWithStrockRadiusBg(Color.WHITE, 2, Color.BLACK, 30));
        mRec.setAdapter(new MyAdpter());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.i("xtf", "onOptionsItemSelected: "+item.getItemId());
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawLayout.openDrawer(mNavView);
                Log.i("xtf", "onOptionsItemSelected: ");
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void initViews() {
        mSearch = findViewById(R.id.search);
        mRec = findViewById(R.id.rec);
        mNavView = findViewById(R.id.nav_view);

        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return false;
            }
        });
        mDrawLayout = findViewById(R.id.draw_layout);

        findViewById(R.id.addstaff).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdmainProfile.this,AddStaff.class));
            }
        });
        findViewById(R.id.addsheft).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdmainProfile.this,AddShiftPage.class));
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
/*
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


        switch (menuItem.getItemId()){
            case R.id.profile:
                Intent in1 = new Intent(this,AdmainProfile.class);
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
*/
    class MyAdpter extends RecyclerView.Adapter<MyAdpter.MyViewHolder> {


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(AdmainProfile.this).inflate(R.layout.adapter_item, null);

            return new MyViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.mMsg.setText(userList.get(position).getNumber());
            holder.mTitle.setText(userList.get(position).getName());
            holder.mTime.setText(userList.get(position).getTime());
            if (userList.get(position).getType() == 0) {
                holder.mConetnt.setBackground(ShapeUtil.getSoldWithStrockRadiusBg(Color.parseColor("#f9f5f4"), 2, Color.parseColor("#0cc927"), 10));
                holder.mTime.setBackground(ShapeUtil.getSoldRadiusBg(Color.parseColor("#0cc927"), 5));
            } else if (userList.get(position).getType() == 1) {
                holder.mConetnt.setBackground(ShapeUtil.getSoldWithStrockRadiusBg(Color.parseColor("#f9f5f4"), 2, Color.parseColor("#c8a118"), 10));
                holder.mTime.setBackground(ShapeUtil.getSoldRadiusBg(Color.parseColor("#c8a118"), 5));

            } else if (userList.get(position).getType() == 2) {
                holder.mConetnt.setBackground(ShapeUtil.getSoldWithStrockRadiusBg(Color.parseColor("#f9f5f4"), 2, Color.parseColor("#c60601"), 10));
                holder.mTime.setBackground(ShapeUtil.getSoldRadiusBg(Color.parseColor("#c60601"), 5));

            }
        }


        @Override
        public int getItemCount() {
            return userList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {


            TextView mTitle;
            TextView mMsg;
            TextView mTime;
            RelativeLayout mConetnt;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                this.mTitle = itemView.findViewById(R.id.title);
                this.mMsg = itemView.findViewById(R.id.msg);
                this.mTime = itemView.findViewById(R.id.time);
                this.mConetnt = itemView.findViewById(R.id.conetnt);
            }
        }


    }


}