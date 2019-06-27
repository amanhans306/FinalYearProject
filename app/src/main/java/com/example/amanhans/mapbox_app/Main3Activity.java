package com.example.amanhans.mapbox_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;



public class Main3Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private View contentview;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        contentview = findViewById(R.id.content);

        setNavigationDrawer();

        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        animateContainer();

    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void animateContainer() {

        contentview
                .animate()
//                .scaleXBy(-.05f)
//                .scaleYBy(-.05f)
                .setInterpolator(new AnticipateOvershootInterpolator())
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {

                    }
                })
                .setDuration(300)
                .start();
    }

    @SuppressLint("ResourceAsColor")
    private void setNavigationDrawer() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        drawer.setScrimColor(Color.TRANSPARENT);
        drawer.setDrawerElevation(0);

        drawer.addDrawerListener(new DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                float drawerWidth =drawerView.getWidth();

                contentview.setX(slideOffset *drawerWidth);

                float min =0.7f;
                float max= 1.0f;
                float scalefactor =(max-((max-min)*slideOffset));

                contentview.setScaleX(scalefactor);
                contentview.setScaleY(scalefactor);
            }

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onDrawerOpened(final View drawerView) {

                contentview
                        .animate()
//                        .scaleXBy(-.1f)
//                        .scaleYBy(-.1f)
                        .setInterpolator(new AnticipateOvershootInterpolator())
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                contentview
                                        .animate()
                                        .scaleXBy(.1f)
                                        .scaleYBy(.1f)
                                        .setInterpolator(new AnticipateOvershootInterpolator())
                                        .setDuration(300)
                                        .start();
                            }
                        })
                        .setDuration(300)
                        .start();

                drawerView
                        .animate()
                        .scaleXBy(-.1f)
                        .scaleYBy(-.1f)
                        .setInterpolator(new AnticipateOvershootInterpolator())
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                drawerView
                                        .animate()
                                        .scaleXBy(.1f)
                                        .scaleYBy(.1f)
                                        .setInterpolator(new AnticipateOvershootInterpolator())
                                        .setDuration(300)
                                        .start();
                            }
                        })
                        .setDuration(300)
                        .start();

            }

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onDrawerClosed(View drawerView) {
                animateContainer();
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main3, menu);
        return true;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_notification)
//        {
//            Intent intent =new Intent(getApplicationContext(),notification.class);
//
//            startActivity(intent);
//        }
//        else if (id == R.id.action_home){
//
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
//
//        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_interest) {

            Intent intent =new Intent(getApplicationContext(),Main2Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(intent);


        } else if (id == R.id.nav_route) {

            Intent intent =new Intent(getApplicationContext(),MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(intent);


        }
       else if (id == R.id.pre_defined) {
            Intent intent =new Intent(getApplicationContext(),DirectionsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(intent);
        }
       // else if (id == R.id.nav_send) {
//
//
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
