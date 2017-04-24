package com.erickogi14gmail.demo_news_api_android1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.erickogi14gmail.demo_news_api_android1.Login.Login;
import com.erickogi14gmail.demo_news_api_android1.News.Categories;
import com.erickogi14gmail.demo_news_api_android1.News.fragment_all_news;
import com.erickogi14gmail.demo_news_api_android1.News.fragment_tech_news;
import com.erickogi14gmail.demo_news_api_android1.Utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private boolean loggedIn = false;
    private boolean isListView;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE);

        //Fetching the boolean value form sharedpreferences
        loggedIn = sharedPreferences.getBoolean(Constants.LOGGEDIN_SHARED_PREF, false);
        Log.d("loginStatus",String.valueOf(loggedIn));
        if(!loggedIn){
            //We will start the Profile Activity
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Downloading in progress", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        isListView = true;

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
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        this.menu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();



        if (id == R.id.action_toggle) {
            toggle();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void toggle() {
        fragment_all_news fragment_all_news=new fragment_all_news();
        fragment_tech_news fragment_tech_news=new fragment_tech_news();
        MenuItem item = menu.findItem(R.id.action_toggle);
        if (isListView) {


            item.setIcon(R.drawable.ic_list_white_24dp);
            item.setTitle("Show as list");
            isListView = false;


            fragment_all_news.setLayout(isListView);
            fragment_tech_news.setLayout(isListView);
        } else {


            item.setIcon(R.drawable.ic_grid_on_white_24dp);
            item.setTitle("Show as grid");
            isListView = true;

            fragment_all_news.setLayout(isListView);
            fragment_tech_news.setLayout(isListView);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent = new Intent(MainActivity.this, Categories.class);
        if (id == R.id.nav_archives) {


        } else if (id == R.id.nav_business) {
            intent.putExtra(Constants.KEY_CATEGORY_INTENT, Constants.KEY_CATEGORY_BUSINESS);
            intent.putExtra(Constants.KEY_CATEGORY_LABEL, "Business");
            startActivity(intent);
        } else if (id == R.id.nav_entertainment) {
            intent.putExtra(Constants.KEY_CATEGORY_INTENT, Constants.KEY_CATEGORY_ENTERTAINMENT);
            intent.putExtra(Constants.KEY_CATEGORY_LABEL, "Entertainment");
            startActivity(intent);

        } else if (id == R.id.nav_politics) {
            intent.putExtra(Constants.KEY_CATEGORY_INTENT, Constants.KEY_CATEGORY_POLITICS);
            intent.putExtra(Constants.KEY_CATEGORY_LABEL, "Political");
            startActivity(intent);

        } else if (id == R.id.nav_music) {
            intent.putExtra(Constants.KEY_CATEGORY_INTENT, Constants.KEY_CATEGORY_MUSIC);
            intent.putExtra(Constants.KEY_CATEGORY_LABEL, "Music");
            startActivity(intent);

        } else if (id == R.id.nav_science) {
            intent.putExtra(Constants.KEY_CATEGORY_INTENT, Constants.KEY_CATEGORY_SCIENCE);
            intent.putExtra(Constants.KEY_CATEGORY_LABEL, "Science/Nature");
            startActivity(intent);

        } else if (id == R.id.nav_share) {
            Intent in = new Intent();
            in.setAction(Intent.ACTION_SEND);
            in.putExtra(Intent.EXTRA_TEXT, " Wish to share with you \n" +
                    "http://erickogi.co.ke/apps/news.apk");
            in.setType("text/plain");
            startActivity(in);
        } else if (id == R.id.nav_sports) {
            intent.putExtra(Constants.KEY_CATEGORY_INTENT, Constants.KEY_CATEGORY_SPORTS);
            intent.putExtra(Constants.KEY_CATEGORY_LABEL, "Sports");
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new fragment_all_news(), "all");
        adapter.addFragment(new fragment_tech_news(), "tech");

        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(adapter);
    }
    private void setupTabIcons() {

        tabLayout.getTabAt(0).setText("ALL NEWS");
        tabLayout.getTabAt(1).setText("TECH NEWS");


    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}
