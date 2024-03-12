package com.example.registerationproject.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    //private FirebaseDatabase database = FirebaseDatabase.getInstance();
    //private DatabaseReference databaseReference = database.getReference();
    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<Notice> noticeList;

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

        final Button courseButton = findViewById(R.id.courseButton);
        final Button statisticButton = findViewById(R.id.statisticButton);
        final Button scheduleButton = findViewById(R.id.scheduleButton);
        final Button gpsButton = findViewById(R.id.gpsButton);
        final Button communityButton = findViewById(R.id.communityButton);
        final Button calendarButton = findViewById(R.id.calendarButton);
        final LinearLayout notice = findViewById(R.id.notice);

        courseButton.setOnClickListener(new View.OnClickListener() {
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
        });


    }

    private long lastTimeBackPressed;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (System.currentTimeMillis() - lastTimeBackPressed < 1500) {
            finish();
            return;
        }
        Toast.makeText(this, "'뒤로' 버튼을 한 번 더 눌러 종료합니다.", Toast.LENGTH_SHORT).show();
        lastTimeBackPressed = System.currentTimeMillis();
    }


}