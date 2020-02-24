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
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
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
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    BottomAppBar bottomAppBar;
    BottomNavigationView bottomNavigationView;
    FloatingActionButton floatingActionButton;
    Fragment selectedFragment = null;
    public static Toolbar toolbar;
    boolean isCheck = true;

    ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setScroll();
        setMenuToolbar();


        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
//        bottomNavigationView.setItemTextColor(ColorStateList.valueOf(getResources().getColor(R.color.camsang)));

        bottomNavigationView.setItemIconTintList(null);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

        bottomAppBar = findViewById(R.id.bottom_appbar);
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
        scrollView = findViewById(R.id.scrollView);
        bottomNavigationView = findViewById(R.id.bottomNavigation);


    }

    private void setScroll() {
//        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
//            @Override
//            public void onScrollChanged() {
//                if (scrollView != null) {
//                    if (scrollView.getChildAt(0).getBottom() <= (scrollView.getHeight() + scrollView.getScrollY())) {
//                        bottomNavigationView.setVisibility(View.VISIBLE);
//                    }
//                    else {
//                        bottomNavigationView.setVisibility(View.INVISIBLE);
//                    }
//                }
//            }
//        });

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
