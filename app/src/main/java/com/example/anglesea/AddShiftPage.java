package com.example.anglesea;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.RequestQueue;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Collections;

public class AddShiftPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    //Initialize Variable time
    TextView tv_time;
    boolean[] selectedTime;
    ArrayList<Integer> timeList = new ArrayList<>();
    String[] timeArray = {"AM","PM","MIX","Weekend"};

    //Initialise variable day
    TextView tv_day;
    boolean[] selectedDay;
    ArrayList<Integer> dayList = new ArrayList<>();
    String[] dayArray = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    //initialise variable staff
    TextView tv_staff;
    boolean[] selectedStaff;
    ArrayList<Integer> staffList = new ArrayList<>();
    String[] staffArray = {"Jenna Sanchez", "Sophie Smith", "Kate Guetermann", "Verica Wong"};

    private TextView mTextViewResult;
    private RequestQueue mQueue;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_shifit_activity);






//Assign Variable
        tv_time = findViewById(R.id.tv_time);
        //Initialize Selected Time
        selectedTime = new boolean[timeArray.length];
        tv_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Initialize alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        AddShiftPage.this
                );
                //set title
                builder.setTitle("Select Time");
                //set dialog non cancel
                builder.setCancelable(false);
                builder.setMultiChoiceItems(timeArray, selectedTime, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        //check condition
                        if (b){
                            //when checkbox selected
                            //add position in time list
                            timeList.add(i);
                            //sort day list
                            Collections.sort(timeList);
                        }else {
                            //when checkbox unselected
                            //remove position from day list
                            timeList.remove(i);
                        }
                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //initialize string builder
                        StringBuilder stringBuilder = new StringBuilder();
                                for(int j=0; j<timeList.size(); j++){
                                    stringBuilder.append(timeArray[timeList.get(j)]);
                                    if (j != timeList.size()-1){
                                        stringBuilder.append(", ");
                                    }
                                }
                                tv_time.setText(stringBuilder.toString());
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //dismiss
                        dialogInterface.dismiss();
                    }
                });
                builder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // for loop
                        for (int j=0; j<selectedTime.length; j++){
                            selectedTime[j] = false;
                            timeList.clear();
                            tv_time.setText("");
                        }
                    }
                });
                builder.show();
            }
        });

        //Assign Variable DAY
        tv_day = findViewById(R.id.tv_day);
        //Initialize Selected Time
        selectedDay = new boolean[dayArray.length];
        tv_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Initialize alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        AddShiftPage.this
                );
                //set title
                builder.setTitle("Select Day");
                //set dialog non cancel
                builder.setCancelable(false);
                builder.setMultiChoiceItems(dayArray, selectedDay, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        //check condition
                        if (b){
                            //when checkbox selected
                            //add position in time list
                            dayList.add(i);
                            //sort day list
                            Collections.sort(dayList);
                        }else {
                            //when checkbox unselected
                            //remove position from day list
                            dayList.remove(i);
                        }
                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //initialize string builder
                        StringBuilder stringBuilder = new StringBuilder();
                        for(int j=0; j<dayList.size(); j++){
                            stringBuilder.append(dayArray[dayList.get(j)]);
                            if (j != dayList.size()-1){
                                stringBuilder.append(", ");
                            }
                        }
                        tv_day.setText(stringBuilder.toString());
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //dismiss
                        dialogInterface.dismiss();
                    }
                });
                builder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // for loop
                        for (int j=0; j<selectedDay.length; j++){
                            selectedDay[j] = false;
                            dayList.clear();
                            tv_day.setText("");
                        }
                    }
                });
                builder.show();
            }
        });

        //Assign Variable STAFF
        tv_staff = findViewById(R.id.tv_staff);
        //Initialize Selected Time
        selectedStaff = new boolean[staffArray.length];
        tv_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Initialize alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        AddShiftPage.this
                );
                //set title
                builder.setTitle("Select Staff");
                //set dialog non cancel
                builder.setCancelable(false);
                builder.setMultiChoiceItems(staffArray, selectedStaff, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        //check condition
                        if (b){
                            //when checkbox selected
                            //add position in time list
                            staffList.add(i);
                            //sort day list
                            Collections.sort(staffList);
                        }else {
                            //when checkbox unselected
                            //remove position from day list
                            staffList.remove(i);
                        }
                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //initialize string builder
                        StringBuilder stringBuilder = new StringBuilder();
                        for(int j=0; j<staffList.size(); j++){
                            stringBuilder.append(staffArray[staffList.get(j)]);
                            if (j != staffList.size()-1){
                                stringBuilder.append(", ");
                            }
                        }
                        tv_staff.setText(stringBuilder.toString());
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //dismiss
                        dialogInterface.dismiss();
                    }
                });
                builder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // for loop
                        for (int j=0; j<selectedStaff.length; j++){
                            selectedStaff[j] = false;
                            staffList.clear();
                            tv_staff.setText("");
                        }
                    }
                });
                builder.show();
            }
        });


//-------------------------------------------------------------------------------------------------------------
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        drawer=findViewById(R.id.drawer_layout);//set your drawerLayout id in the xml and change here

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        toggle.syncState();
//-----------------------------------------------------------------------------------------------------------------
    }


//--------------------------------------------------------------------------------------------------------------
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



//--------
//------------------------------------------------------------------------------------------------------
}