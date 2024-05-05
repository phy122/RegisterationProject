package com.example.registerationproject.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.registerationproject.Notice;
import com.example.registerationproject.NoticeListAdapter;
import com.example.registerationproject.R;
import com.example.registerationproject.ui.fragments.CalendarFragment;
import com.example.registerationproject.ui.fragments.CommunityFragment;
import com.example.registerationproject.ui.fragments.CourseFragment;
import com.example.registerationproject.ui.fragments.GPSFragment;
import com.example.registerationproject.ui.fragments.ScheduleFragment;
import com.example.registerationproject.ui.fragments.StatisticsFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<Notice> noticeList;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Notice 리스트뷰 초기화
        noticeListView = findViewById(R.id.noticeListView);
        noticeList = new ArrayList<>();
        noticeList.add(new Notice("[AI·SW학 전공] 소프트웨어 종합학술대회 참석 후기 <AI·SW계열>", "박호영", "2023-11-25", "https://www.hs.ac.kr/kor/10671/subview.do?enc=Zm5jdDF8QEB8JTJGYmJzJTJGa29yJTJGMjIxNSUyRjE0MjY3MiUyRmFydGNsVmlldy5kbyUzRnBhZ2UlM0QxJTI2c3JjaENvbHVtbiUzRHNqJTI2c3JjaFdyZCUzREFJJTI2YmJzQ2xTZXElM0QlMjZiYnNPcGVuV3JkU2VxJTNEJTI2cmdzQmduZGVTdHIlM0QlMjZyZ3NFbmRkZVN0ciUzRCUyNmlzVmlld01pbmUlM0RmYWxzZSUyNnBhc3N3b3JkJTNEJTI2"));
        noticeList.add(new Notice("[AI·SW학 전공] 지금 우리 선배님은? AI·SW 주요 동문 및 직무 소개 <AI·SW계열>.", "이찬우", "2023-11-26", "https://www.hs.ac.kr/kor/10671/subview.do?enc=Zm5jdDF8QEB8JTJGYmJzJTJGa29yJTJGMjIxNSUyRjE0MjQ5NCUyRmFydGNsVmlldy5kbyUzRnBhZ2UlM0QxJTI2c3JjaENvbHVtbiUzRHNqJTI2c3JjaFdyZCUzREFJJTI2YmJzQ2xTZXElM0QlMjZiYnNPcGVuV3JkU2VxJTNEJTI2cmdzQmduZGVTdHIlM0QlMjZyZ3NFbmRkZVN0ciUzRCUyNmlzVmlld01pbmUlM0RmYWxzZSUyNnBhc3N3b3JkJTNEJTI2"));
        noticeList.add(new Notice("[AI·SW학 전공] AI·SW계열 MT 참석 후기 <AI·SW계열>.", "박호영", "2024-03-25", "https://www.hs.ac.kr/kor/10671/subview.do?enc=Zm5jdDF8QEB8JTJGYmJzJTJGa29yJTJGMjIxNSUyRjE0MjM0OCUyRmFydGNsVmlldy5kbyUzRnBhZ2UlM0QxJTI2c3JjaENvbHVtbiUzRHNqJTI2c3JjaFdyZCUzREFJJTI2YmJzQ2xTZXElM0QlMjZiYnNPcGVuV3JkU2VxJTNEJTI2cmdzQmduZGVTdHIlM0QlMjZyZ3NFbmRkZVN0ciUzRCUyNmlzVmlld01pbmUlM0RmYWxzZSUyNnBhc3N3b3JkJTNEJTI2"));
        noticeList.add(new Notice("[AI·SW학 전공] 한신 정보과학·융합논문 발표대회 참석 후기 <AI·SW계열>", "이찬우", "2024-04-17", "https://www.hs.ac.kr/kor/10671/subview.do?enc=Zm5jdDF8QEB8JTJGYmJzJTJGa29yJTJGMjIxNSUyRjE0MjMxOSUyRmFydGNsVmlldy5kbyUzRnBhZ2UlM0QxJTI2c3JjaENvbHVtbiUzRHNqJTI2c3JjaFdyZCUzREFJJTI2YmJzQ2xTZXElM0QlMjZiYnNPcGVuV3JkU2VxJTNEJTI2cmdzQmduZGVTdHIlM0QlMjZyZ3NFbmRkZVN0ciUzRCUyNmlzVmlld01pbmUlM0RmYWxzZSUyNnBhc3N3b3JkJTNEJTI2"));
        noticeList.add(new Notice("[AI시스템반도체학 전공] 왜 한신대학교일까? <AI·SW 계열>.", "박호영", "2024-04-25", "https://www.hs.ac.kr/kor/10671/subview.do?enc=Zm5jdDF8QEB8JTJGYmJzJTJGa29yJTJGMjIxNSUyRjE0MDk5MiUyRmFydGNsVmlldy5kbyUzRnBhZ2UlM0QxJTI2c3JjaENvbHVtbiUzRHNqJTI2c3JjaFdyZCUzREFJJTI2YmJzQ2xTZXElM0QlMjZiYnNPcGVuV3JkU2VxJTNEJTI2cmdzQmduZGVTdHIlM0QlMjZyZ3NFbmRkZVN0ciUzRCUyNmlzVmlld01pbmUlM0RmYWxzZSUyNnBhc3N3b3JkJTNEJTI2"));
        noticeList.add(new Notice("[AI시스템반도체학 전공] 교수진 / 커리큘럼 Q&A <AI·SW 계열>.", "이찬우", "2024-05-01", "https://www.hs.ac.kr/kor/10671/subview.do?enc=Zm5jdDF8QEB8JTJGYmJzJTJGa29yJTJGMjIxNSUyRjE0MDk5MSUyRmFydGNsVmlldy5kbyUzRnBhZ2UlM0QxJTI2c3JjaENvbHVtbiUzRHNqJTI2c3JjaFdyZCUzREFJJTI2YmJzQ2xTZXElM0QlMjZiYnNPcGVuV3JkU2VxJTNEJTI2cmdzQmduZGVTdHIlM0QlMjZyZ3NFbmRkZVN0ciUzRCUyNmlzVmlld01pbmUlM0RmYWxzZSUyNnBhc3N3b3JkJTNEJTI2"));

        adapter = new NoticeListAdapter(getApplicationContext(), noticeList);
        noticeListView.setAdapter(adapter);

        // 리스트뷰 아이템 클릭 리스너 설정
        noticeListView.setOnItemClickListener((adapterView, view, position, id) -> {
            // 클릭된 아이템의 URL을 가져와 브라우저에서 열기
            Notice clickedNotice = noticeList.get(position);
            String url = clickedNotice.getUrl();

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        // 툴바 설정
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24);

        // 드로어 레이아웃 및 네비게이션 뷰 초기화
        drawerLayout = findViewById(R.id.activity_main);
        navigationView = findViewById(R.id.navigation_view);

        // 네비게이션 아이템 선택 리스너 설정
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            menuItem.setChecked(true);
            drawerLayout.closeDrawers();
            final LinearLayout notice = findViewById(R.id.notice);

            int id = menuItem.getItemId();
            if (id == R.id.menu_home) {
                // 홈 메뉴 선택 시 기본 메인 액티비티 화면으로 돌아갑니다.
                notice.setVisibility(View.VISIBLE);

                // 현재 표시 중인 프래그먼트를 제거하고 메인 액티비티로 돌아갑니다.
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                return true;
            } else {
                // 다른 메뉴 선택 시 프래그먼트를 표시합니다.
                notice.setVisibility(View.GONE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Fragment fragment = null;
                switch (id) {
                    case R.id.menu_course:
                        fragment = new CourseFragment();
                        break;
                    case R.id.menu_statistics:
                        fragment = new StatisticsFragment();
                        break;
                    case R.id.menu_schedule:
                        fragment = new ScheduleFragment();
                        break;
                    case R.id.menu_calendar:
                        fragment = new CalendarFragment();
                        break;
                    case R.id.menu_community:
                        fragment = new CommunityFragment();
                        break;
                    case R.id.menu_gps:
                        fragment = new GPSFragment();
                        break;
                }

                if (fragment != null) {
                    fragmentTransaction.replace(R.id.fragment, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        // 백 스택이 비어 있지 않은 경우
        if (fragmentManager.getBackStackEntryCount() > 0) {
            // 프래그먼트를 팝합니다.
            fragmentManager.popBackStack();
        } else {
            // 백 스택이 비어 있는 경우 액티비티를 종료합니다.
            super.onBackPressed();
        }
    }
}
