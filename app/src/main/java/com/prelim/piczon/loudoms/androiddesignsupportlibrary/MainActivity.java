package com.prelim.piczon.loudoms.androiddesignsupportlibrary;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.prelim.piczon.loudoms.androiddesignsupportlibrary.Fragments.CollapseToolbarLayoutActivity;
import com.prelim.piczon.loudoms.androiddesignsupportlibrary.Fragments.FloatingActionButtonActivity;
import com.prelim.piczon.loudoms.androiddesignsupportlibrary.Fragments.MainFragmentActivity;

import java.util.EventListener;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private Toolbar mToolbar;
    private CoordinatorLayout coordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
//                .coordinator_layout);
//
//        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//            Snackbar.make(coordinatorLayout, "Had a snack at Snackbar", Snackbar.LENGTH_LONG)
//                    .show();
//        }
//        });

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.navView);


        if (navView != null) {
            setupDrawerContent(navView);
            navView.setNavigationItemSelectedListener(this);
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.contentView,
                new MainFragmentActivity()).commit();
    }


    private void setupDrawerContent(NavigationView navView) {
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        switch (id){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int item = menuItem.getItemId();
        switch (item){
            case R.id.main:
                getSupportFragmentManager().beginTransaction().replace(R.id.contentView,
                        new MainFragmentActivity()).commit();
            break;
            case R.id.fab:
                getSupportFragmentManager().beginTransaction().replace(R.id.contentView,
                        new FloatingActionButtonActivity()).commit();
            break;
            case R.id.collapse:
                getSupportFragmentManager().beginTransaction().replace(R.id.contentView,
                        new CollapseToolbarLayoutActivity()).commit();
            break;

        }
        drawerLayout.closeDrawers();
        return true;
    }

}
