package com.example.app_ky.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.app_ky.R;
import com.example.app_ky.fragment.BottomSheetFragment;
import com.example.app_ky.fragment.CalendarFragment;
import com.example.app_ky.fragment.ClockFragment;
import com.example.app_ky.fragment.HomeFragment;
import com.example.app_ky.fragment.PlaceholderFragment;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    BottomAppBar bottom_appbar;
    BottomNavigationView bottomNavigationView;
    FloatingActionButton floatingActionButton;
    Fragment selectedFragment = null;
    public static Toolbar toolbar;
    boolean isCheck = true, isShow = true;

    ScrollView scrollView;


    int pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
//        setScroll();
        setMenuToolbar();


        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
//        bottomNavigationView.setItemTextColor(ColorStateList.valueOf(getResources().getColor(R.color.camsang)));

        bottomNavigationView.setItemIconTintList(null);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

//        bottomAppBar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
//
//        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });

        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setBackgroundColor(Color.parseColor("#1a1b1d"));
        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1a1b1d")));
//        floatingActionButton.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1a1b1d")));

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBottomSheet(BottomSheetFragment.class.getName());

            }
        });




    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        bottom_appbar = findViewById(R.id.bottom_appbar);
        scrollView = findViewById(R.id.scrollView);
        bottomNavigationView = findViewById(R.id.bottomNavigation);

    }

    private void setScroll() {
//        scrollView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
//                Toast.makeText(MainActivity.this, "scrolllllllllll", Toast.LENGTH_SHORT).show();
//            }
//        },1000);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {



                    Log.e("scroll", "onScrollChange: " + scrollY);

                    if (scrollY > 230 ) {
                        if (isShow){
                            TranslateAnimation animate1 = new TranslateAnimation(0,0,0,bottom_appbar.getHeight());
                            TranslateAnimation animate2 = new TranslateAnimation(0,0,0,bottomNavigationView.getHeight());
                            animate1.setDuration(500);
                            animate2.setDuration(500);
                            bottom_appbar.setVisibility(View.GONE);
                            bottomNavigationView.setVisibility(View.GONE);
                            bottomNavigationView.startAnimation(animate2);
                            bottom_appbar.startAnimation(animate1);
                            isShow = false;
                        }

//                        Toast.makeText(MainActivity.this, "downnnn", Toast.LENGTH_SHORT).show();
                        Log.i("scroll", "Scroll DOWN");
                    }
                    if (scrollY < oldScrollY) {
                        if (!isShow){
//                            TranslateAnimation animate1 = new TranslateAnimation(0,0,0,bottom_appbar.getHeight());
//                            TranslateAnimation animate2 = new TranslateAnimation(0,0,0,bottomNavigationView.getHeight());
//                            animate1.setDuration(500);
//                            animate2.setDuration(500);
                            bottom_appbar.setVisibility(View.VISIBLE);
                            bottomNavigationView.setVisibility(View.VISIBLE);
//                            bottom_appbar.startAnimation(animate1);
//                            bottomNavigationView.startAnimation(animate2);
//                            isShow = true;
                        }



                        Toast.makeText(MainActivity.this, "uppp", Toast.LENGTH_SHORT).show();
                        Log.i("scroll", "Scroll UP");
                    }

//                    if (scrollY == 0) {
//                        bottom_appbar.setVisibility(View.VISIBLE);
//                        bottomNavigationView.setVisibility(View.VISIBLE);
//
////                        Toast.makeText(MainActivity.this, "TOP SCROLL", Toast.LENGTH_SHORT).show();
//                        Log.i("scroll", "TOP SCROLL");
//                    }

//                    if (scrollY == ( v.getMeasuredHeight() - v.getChildAt(0).getMeasuredHeight() )) {
//                        Log.i("scroll", "BOTTOM SCROLL");
//                    }

                }
            });
        }

//        scrollView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        },2000);
    }

    private void setMenuToolbar() {
        toolbar.inflateMenu(R.menu.menu_toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.edit_floating:
                        if (isCheck == true){
                            item.setTitle("On");
                            floatingActionButton.setVisibility(View.GONE);
                            isCheck = false;
                        } else {
                            item.setTitle("Off");
                            floatingActionButton.setVisibility(View.VISIBLE);
                            isCheck = true;
                        }

                        break;
                }

                return true;
            }
        });



    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.home:
                    selectedFragment = new HomeFragment();
                    toolbar.setTitle("Home");
                    break;
                case R.id.calendar:
                    selectedFragment = new CalendarFragment();
                    toolbar.setTitle("Khám phá");

                    break;
                case R.id.placeholder:
                    selectedFragment = new PlaceholderFragment();
                    toolbar.setTitle("MV");

                    break;
                case R.id.clock:
                    selectedFragment = new ClockFragment();
                    toolbar.setTitle("Cá nhân");

                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();

            return false;
        }
    };

    private void openBottomSheet(String tag) {
        BottomSheetDialogFragment bottomSheet = null;
        if (tag.equals(BottomSheetFragment.class.getName())){
            bottomSheet = new BottomSheetFragment();
            bottomSheet.setAllowEnterTransitionOverlap(true);
        }

        if (bottomSheet != null){
            bottomSheet.show(getSupportFragmentManager(), tag);
        }

    }

}
