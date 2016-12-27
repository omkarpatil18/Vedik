package in.myvedik.android.vedik;


import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class UserPostActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    private boolean isAutoRenew;
    private TabLayout tabLayout ;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        isAutoRenew = prefs.getBoolean("AutoRenewStatus", false);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, myToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tabLayout.getSelectedTabPosition()) {
                    case 0:
                        //do what you want when tab 0 is selected
                        tab.setIcon(R.drawable.ic_trending_up_black_24dp);
                        break;
                    case 1:
                        //do what you want when tab 1 is selected
                        tab.setIcon(R.drawable.ic_account_balance_black_24dp);
                        break;
                    case 2:
                        //do what you want when tab 2 is selected
                        tab.setIcon(R.drawable.ic_file_upload_black_24dp);
                        break;
                    case 3:
                        //do what you want when tab 2 is selected
                        tab.setIcon(R.drawable.ic_event_black_24dp);
                        break;
                    case 4:
                        //do what you want when tab 2 is selected
                        tab.setIcon(R.drawable.ic_person_black_24dp);
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                switch (tabLayout.getSelectedTabPosition()) {
                    case 0:
                        //do what you want when tab 0 is selected
                        tab.setIcon(R.drawable.ic_trending_up_white_24dp);
                        break;
                    case 1:
                        //do what you want when tab 1 is selected
                        tab.setIcon(R.drawable.ic_account_balance_white_24dp);
                        break;
                    case 2:
                        //do what you want when tab 2 is selected
                        tab.setIcon(R.drawable.ic_file_upload_white_24dp);
                        break;
                    case 3:
                        //do what you want when tab 2 is selected
                        tab.setIcon(R.drawable.ic_event_white_24dp);
                        break;
                    case 4:
                        //do what you want when tab 2 is selected
                        tab.setIcon(R.drawable.ic_person_white_24dp);
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        MyPagerAdapter mFragmentStatePagerAdapter;
        ViewPager mViewPager;
        mFragmentStatePagerAdapter =
                MyPagerAdapter.getPagerAdapter(
                        getSupportFragmentManager(),this);
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mFragmentStatePagerAdapter);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putBoolean("AutoRenewStatus", isAutoRenew);
        editor.apply();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.search) {
            return true;
        }
        if (id == R.id.autorenew) {
            if(isAutoRenew) {
                isAutoRenew=false;
                item.setIcon(R.drawable.ic_autorenew_deselected);
            }
            else{
                isAutoRenew=true;
                item.setIcon(R.drawable.ic_autorenew_selected);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
