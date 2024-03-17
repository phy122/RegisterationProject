package com.example.registerationproject.ui.fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.registerationproject.R;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.overlay.OverlayImage;
import com.naver.maps.map.util.FusedLocationSource;

public class GPSFragment extends Fragment implements OnMapReadyCallback {

    private static final int PERMISSION_REQUEST_CODE = 100;
    private static final String[] PERMISSIONS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };

    private MapView mapView;
    private NaverMap naverMap;
    private FusedLocationSource locationSource;

    private Marker marker1 = new Marker();
    private Marker marker2 = new Marker();
    private Marker marker3 = new Marker();
    private Marker marker4 = new Marker();
    private Marker marker5 = new Marker();
    private Marker marker6 = new Marker();
    private Marker marker7 = new Marker();
    private Marker marker8 = new Marker();
    private Marker marker9 = new Marker();
    private Marker marker10 = new Marker();
    private Marker marker11 = new Marker();
    private Marker marker12 = new Marker();

    private Button btnMark1,btnMark2,btnMark3,btnMark4,btnMark5,btnMark6,btnMark7,btnMark8,btnMark9,btnMark10,btnMark11,btnMark12;


    private InfoWindow infoWindow = new InfoWindow();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_g_p_s, container, false);



        mapView = view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);



        btnMark1 = view.findViewById(R.id.btnmark1);
        btnMark2 = view.findViewById(R.id.btnmark2);
        btnMark3 = view.findViewById(R.id.btnmark3);
        btnMark4 = view.findViewById(R.id.btnmark4);
        btnMark5 = view.findViewById(R.id.btnmark5);
        btnMark6 = view.findViewById(R.id.btnmark6);
        btnMark7 = view.findViewById(R.id.btnmark7);
        btnMark8 = view.findViewById(R.id.btnmark8);
        btnMark9 = view.findViewById(R.id.btnmark9);
        btnMark10 = view.findViewById(R.id.btnmark10);
        btnMark11 = view.findViewById(R.id.btnmark11);
        btnMark12 = view.findViewById(R.id.btnmark12);

        btnMark1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // btnMark1 버튼을 클릭했을 때 marker1을 생성하는 코드를 여기에 작성합니다.
                setMarker(marker1, 37.193515900000165, 127.02317886907377, R.drawable.ic_baseline_place_24, 10);
            }
        });
        marker1.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("장공관(본관)").setMessage("건물 번호 : 1 \n 오월광장");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });

        btnMark2.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setMarker(marker2, 37.19341076735539, 127.02378853577918, R.drawable.ic_baseline_place_24, 10);

            }
        });
        marker2.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("필헌관").setMessage("건물 번호 : 2 \n 대학원,ATM");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
        btnMark3.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setMarker(marker3, 37.192666099999, 127.02725644231066, R.drawable.ic_baseline_place_24, 10);

            }
        });
        marker3.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("장준하통일관").setMessage("건물 번호 : 18 \n 카페,편의점,ATM");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
        btnMark4.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setMarker(marker4, 37.19406279999989, 127.0241712423097, R.drawable.ic_baseline_place_24, 10);

            }
        });
        marker4.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("경삼관(도서관)").setMessage("건물 번호 : 6 \n 카페,ATM,증명서 발급기");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
        btnMark5.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setMarker(marker5, 37.19298459999949, 127.0235913423098, R.drawable.ic_baseline_place_24, 10);

            }
        });
        marker5.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("늦봄관").setMessage("건물 번호 : 20");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
        btnMark6.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setMarker(marker6, 37.19312889999997, 127.02267844231021, R.drawable.ic_baseline_place_24, 10);

            }
        });
        marker6.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("만우관").setMessage("건물 번호 : 3");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
        btnMark7.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setMarker(marker7, 37.19350070000136, 127.02623714231125, R.drawable.ic_baseline_place_24, 10);

            }
        });
        marker7.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("송암관").setMessage("건물 번호 : 7");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
        btnMark8.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setMarker(marker8, 37.19382489999945, 127.02500894231025, R.drawable.ic_baseline_place_24, 10);

            }
        });
        marker8.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("소통관").setMessage("건물 번호 : 8 \n 교수실,교무팀,대학행정팀");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
        btnMark9.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setMarker(marker9, 37.19415080000044, 127.02208194230982, R.drawable.ic_baseline_place_24, 10);

            }
        });
        marker9.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("임마누엘관").setMessage("건물 번호 : 5 \n 식당,학생회관");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
        btnMark10.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setMarker(marker10, 37.194193499998505, 127.0198019423099, R.drawable.ic_baseline_place_24, 10);

            }
        });
        marker10.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("한울관").setMessage("건물 번호 : 10 \n 체육관");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
        btnMark11.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setMarker(marker11, 37.194185200000156, 127.02260544231315, R.drawable.ic_baseline_place_24, 10);

            }
        });
        marker11.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("해오름관").setMessage("건물 번호 : 17 \n 보건소,우체국,ATM");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
        btnMark12.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setMarker(marker12, 37.19360280000055, 127.02127174231111, R.drawable.ic_baseline_place_24, 10);

            }
        });

        marker12.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("샬롬채플관").setMessage("건물 번호 : 4");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });

        return view;
    }

    private void setMarker(Marker marker,  double lat, double lng, int resourceID, int zIndex)
    {
        //원근감 표시
        marker.setIconPerspectiveEnabled(true);
        //아이콘 지정
        marker.setIcon(OverlayImage.fromResource(resourceID));
        //마커의 투명도
        marker.setAlpha(0.8f);
        //마커 위치
        marker.setPosition(new LatLng(lat, lng));
        //마커 우선순위
        marker.setZIndex(zIndex);
        //마커 표시
        marker.setMap(naverMap);
    }

    private void setInfoWindow(InfoWindow infoWindow,  double lat, double lng, int resourceID, int zIndex)
    {
    }



    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        this.naverMap = naverMap;

        // 위치 서비스 액세스 권한 요청
        locationSource = new FusedLocationSource(this, PERMISSION_REQUEST_CODE);
        requestLocationPermission();

        // 현재 위치 표시 모드 설정
        naverMap.setLocationSource(locationSource);
        naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);

        // 초기 카메라 위치 설정
        CameraPosition cameraPosition = new CameraPosition(
                new LatLng( 37.193542073879996, 127.02249811222823), // 초기 위치는 서울로 설정할 수 있습니다.
                16 // 줌 레벨
        );
        naverMap.setCameraPosition(cameraPosition);
    }

    private void requestLocationPermission() {
        if (ActivityCompat.checkSelfPermission(requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(),
                    PERMISSIONS, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults)) {
                if (!locationSource.isActivated()) {
                    Toast.makeText(requireContext(), "위치 권한을 부여해야 현재 위치를 표시할 수 있습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
