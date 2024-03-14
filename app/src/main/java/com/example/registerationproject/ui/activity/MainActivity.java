package com.example.registerationproject.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.registerationproject.ui.fragments.CalendarFragment;
import com.example.registerationproject.ui.fragments.CommunityFragment;
import com.example.registerationproject.ui.fragments.CourseFragment;
import com.example.registerationproject.ui.fragments.GPSFragment;
import com.example.registerationproject.Notice;
import com.example.registerationproject.NoticeListAdapter;
import com.example.registerationproject.R;
import com.example.registerationproject.ui.fragments.ScheduleFragment;
import com.example.registerationproject.ui.fragments.StatisticsFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    //private FirebaseDatabase database = FirebaseDatabase.getInstance();
    //private DatabaseReference databaseReference = database.getReference();
    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<Notice> noticeList;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noticeListView = findViewById(R.id.noticeListView);
        noticeList = new ArrayList<Notice>();
        noticeList.add(new Notice("공지사항입니다.","박호영","2023-11-25"));
        noticeList.add(new Notice("공지사항입니다.","이찬우","2023-11-26"));

        adapter = new NoticeListAdapter(getApplicationContext(), noticeList);
        noticeListView.setAdapter(adapter);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 왼쪽 상단 버튼 만들기
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24); //왼쪽 상단 버튼 아이콘 지정

        drawerLayout = findViewById(R.id.activity_main);
        navigationView = (NavigationView)findViewById(R.id.navigation_view);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                final LinearLayout notice = findViewById(R.id.notice);

                int id = menuItem.getItemId();
                String title = menuItem.getTitle().toString();

                if(id == R.id.menu_course){
                    notice.setVisibility(View.GONE);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    CourseFragment courseFragment = new CourseFragment();
                    fragmentTransaction.replace(R.id.fragment, courseFragment);
                    fragmentTransaction.commit();
                    //Toast.makeText(context, title + ": 계정 정보를 확인합니다.", Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.menu_statistics){
                    notice.setVisibility(View.GONE);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment, new StatisticsFragment());
                    fragmentTransaction.commit();
                    //Toast.makeText(context, title + ": 설정 정보를 확인합니다.", Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.menu_schedule){
                    notice.setVisibility(View.GONE);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment, new ScheduleFragment());
                    fragmentTransaction.commit();
                    //Toast.makeText(context, title + ": 로그아웃 시도중", Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.menu_calendar){
                    notice.setVisibility(View.GONE);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment, new CalendarFragment());
                    fragmentTransaction.commit();
                    //Toast.makeText(context, title + ": 로그아웃 시도중", Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.menu_community){
                    notice.setVisibility(View.GONE);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment, new CommunityFragment());
                    fragmentTransaction.commit();
                    //Toast.makeText(context, title + ": 로그아웃 시도중", Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.menu_gps){
                    notice.setVisibility(View.GONE);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment, new GPSFragment());
                    fragmentTransaction.commit();
                    //Toast.makeText(context, title + ": 로그아웃 시도중", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });


        /*final Button courseButton = findViewById(R.id.courseButton);
        final Button statisticButton = findViewById(R.id.statisticButton);
        final Button scheduleButton = findViewById(R.id.scheduleButton);
        final Button gpsButton = findViewById(R.id.gpsButton);
        final Button communityButton = findViewById(R.id.communityButton);
        final Button calendarButton = findViewById(R.id.calendarButton);
        final LinearLayout notice = findViewById(R.id.notice);*/


        /*courseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.black));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                statisticButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                calendarButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                communityButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                gpsButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                CourseFragment courseFragment = new CourseFragment();
                fragmentTransaction.replace(R.id.fragment, courseFragment);
                fragmentTransaction.commit();

            }
        });

        statisticButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                statisticButton.setBackgroundColor(getResources().getColor(R.color.black));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                calendarButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                communityButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                gpsButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new StatisticsFragment());
                fragmentTransaction.commit();

            }
        });

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                statisticButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.black));
                calendarButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                communityButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                gpsButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new ScheduleFragment());
                fragmentTransaction.commit();

            }
        });

        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                statisticButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                calendarButton.setBackgroundColor(getResources().getColor(R.color.black));
                communityButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                gpsButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new CalendarFragment());
                fragmentTransaction.commit();
            }
        });

        communityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                statisticButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                calendarButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                communityButton.setBackgroundColor(getResources().getColor(R.color.black));
                gpsButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new CommunityFragment());
                fragmentTransaction.commit();
            }
        });

        gpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                statisticButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                calendarButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                communityButton.setBackgroundColor(getResources().getColor(R.color.purple_200));
                gpsButton.setBackgroundColor(getResources().getColor(R.color.black));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new GPSFragment());
                fragmentTransaction.commit();
            }
        });*/


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{ // 왼쪽 상단 버튼 눌렀을 때
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() { //뒤로가기 했을 때
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private long lastTimeBackPressed;

    //@Override
    //public void onBackPressed() {
      //  super.onBackPressed();
        //if (System.currentTimeMillis() - lastTimeBackPressed < 1500) {
          //  finish();
            //return;
        //}
        //Toast.makeText(this, "'뒤로' 버튼을 한 번 더 눌러 종료합니다.", Toast.LENGTH_SHORT).show();
        //lastTimeBackPressed = System.currentTimeMillis();
    //}


}