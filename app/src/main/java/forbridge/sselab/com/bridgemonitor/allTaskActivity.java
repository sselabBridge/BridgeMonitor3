package forbridge.sselab.com.bridgemonitor;

/**
 * Created by Administrator on 2017/10/9.
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import forbridge.sselab.com.bridgemonitor.fragmetshow.fragmentAllTaskDailyCheck;
import forbridge.sselab.com.bridgemonitor.fragmetshow.fragmentAllTaskOftenCheck;
import forbridge.sselab.com.bridgemonitor.fragmetshow.fragmentAllTaskPeriodcCheck;
import forbridge.sselab.com.bridgemonitor.fragmetshow.fragmentAllTaskSpecialCheck;
import forbridge.sselab.com.bridgemonitor.fragmetshow.fragmentAllTasks;
import forbridge.sselab.com.bridgemonitor.fragmetshow.fragmentHasDoneTasks;
import forbridge.sselab.com.bridgemonitor.fragmetshow.fragmentHasDoneTasksDailyCheck;
import forbridge.sselab.com.bridgemonitor.fragmetshow.fragmentHasDoneTasksOftenCheck;
import forbridge.sselab.com.bridgemonitor.fragmetshow.fragmentHasDoneTasksPeriodcCheck;
import forbridge.sselab.com.bridgemonitor.fragmetshow.fragmentHasDoneTasksSpecialCheck;
import forbridge.sselab.com.bridgemonitor.fragmetshow.fragmentSettings;
import forbridge.sselab.com.bridgemonitor.fragmetshow.fragmentUnDoneTasks;
import forbridge.sselab.com.bridgemonitor.fragmetshow.fragmentUnDoneTasksDailyCheck;
import forbridge.sselab.com.bridgemonitor.fragmetshow.fragmentUnDoneTasksOftenCheck;
import forbridge.sselab.com.bridgemonitor.fragmetshow.fragmentUnDoneTasksPeriodcCheck;
import forbridge.sselab.com.bridgemonitor.fragmetshow.fragmentUnDoneTasksSpecialCheck;

public class allTaskActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alltasks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //底部按钮监听事件
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.mainNavigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private int tag_for_show_kinds = 1;

    //底部按钮监听事件实现
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.all_tasks:
                    //显示fragment，利用类fragmentAllTasks
                    //类fragmentAllTasks中显示页面detail_content_alltask
                    tag_for_show_kinds = 1;
                    FragmentManager fm_alltasks = getSupportFragmentManager();
                    FragmentTransaction MfragmentTransaction1 = fm_alltasks.beginTransaction();
                    fragmentAllTasks fat = new fragmentAllTasks();
                    if(fm_alltasks.findFragmentById(R.id.fragmentForshow)==null){
                        MfragmentTransaction1.add(R.id.fragmentForshow,fat);
                    }else {
                        MfragmentTransaction1.replace(R.id.fragmentForshow,fat);
                    }
                    MfragmentTransaction1.commit();
                    return true;
                case R.id.nodone_tasks:
                    //显示fragment，利用类fragmentUnDoneTasks
                    //类fragmentUnDoneTasks中显示页面detail_content_undonetasks
                    tag_for_show_kinds = 2;
                    FragmentManager fm_nodonetasks = getSupportFragmentManager();
                    FragmentTransaction MfragmentTransaction2 = fm_nodonetasks.beginTransaction();
                    fragmentUnDoneTasks fudt = new fragmentUnDoneTasks();
                    if(fm_nodonetasks.findFragmentById(R.id.fragmentForshow)==null){
                        MfragmentTransaction2.add(R.id.fragmentForshow,fudt);
                    }else {
                        MfragmentTransaction2.replace(R.id.fragmentForshow,fudt);
                    }
                    MfragmentTransaction2.commit();
                    return true;
                case R.id.hasdone_tasks:
                    //显示fragment，利用类fragmentHasDoneTasks
                    //类fragmentHasDoneTasks中显示页面detail_content_hasdonetasks
                    tag_for_show_kinds = 3;
                    FragmentManager fm_hasdonetasks = getSupportFragmentManager();
                    FragmentTransaction MfragmentTransaction3 = fm_hasdonetasks.beginTransaction();
                    fragmentHasDoneTasks fhdt = new fragmentHasDoneTasks();
                    if(fm_hasdonetasks.findFragmentById(R.id.fragmentForshow)==null){
                        MfragmentTransaction3.add(R.id.fragmentForshow,fhdt);
                    }else {
                        MfragmentTransaction3.replace(R.id.fragmentForshow,fhdt);
                    }
                    MfragmentTransaction3.commit();
                    return true;
                case R.id.setting:
                    //显示fragment，利用类fragmentSettings
                    //类fragmentSettings中显示页面detail_content_settings
                    FragmentManager fm_settings = getSupportFragmentManager();
                    FragmentTransaction MfragmentTransaction4 = fm_settings.beginTransaction();
                    fragmentSettings fsetting = new fragmentSettings();
                    if(fm_settings.findFragmentById(R.id.fragmentForshow)==null){
                        MfragmentTransaction4.add(R.id.fragmentForshow,fsetting);
                    }else {
                        MfragmentTransaction4.replace(R.id.fragmentForshow,fsetting);
                    }
                    MfragmentTransaction4.commit();
                    return true;
            }
            return false;
        }

    };

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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //侧滑按钮监听事件实现
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.dailycheck) {
            DailyCheck();
        } else if (id == R.id.oftencheck) {
            OftenCheck();
        } else if (id == R.id.periodiccheck) {
            PeriodicCheck();
        } else if (id == R.id.specialcheck) {
            SpecialCheck();
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void DailyCheck(){
        switch (tag_for_show_kinds){
            //全部任务日常巡检
            case 1:
                FragmentManager fm_alltasks_daily = getSupportFragmentManager();
                FragmentTransaction MfragmentTransaction1 = fm_alltasks_daily.beginTransaction();
                fragmentAllTaskDailyCheck fatdc = new fragmentAllTaskDailyCheck();
                if(fm_alltasks_daily.findFragmentById(R.id.fragmentForshow)==null){
                    MfragmentTransaction1.add(R.id.fragmentForshow,fatdc);
                }else {
                    MfragmentTransaction1.replace(R.id.fragmentForshow,fatdc);
                }
                MfragmentTransaction1.commit();
                break;

            //未完成任务日常巡检
            case 2:
                FragmentManager fm_undonetasks_daily = getSupportFragmentManager();
                FragmentTransaction MfragmentTransaction2 = fm_undonetasks_daily.beginTransaction();
                fragmentUnDoneTasksDailyCheck fudtdc = new fragmentUnDoneTasksDailyCheck();
                if(fm_undonetasks_daily.findFragmentById(R.id.fragmentForshow)==null){
                    MfragmentTransaction2.add(R.id.fragmentForshow,fudtdc);
                }else {
                    MfragmentTransaction2.replace(R.id.fragmentForshow,fudtdc);
                }
                MfragmentTransaction2.commit();
                break;

            //已完成任务日常检查
            case 3:
                FragmentManager fm_hasdonetasks_daily = getSupportFragmentManager();
                FragmentTransaction MfragmentTransaction3 = fm_hasdonetasks_daily.beginTransaction();
                fragmentHasDoneTasksDailyCheck fhdtdc = new fragmentHasDoneTasksDailyCheck();
                if(fm_hasdonetasks_daily.findFragmentById(R.id.fragmentForshow)==null){
                    MfragmentTransaction3.add(R.id.fragmentForshow,fhdtdc);
                }else {
                    MfragmentTransaction3.replace(R.id.fragmentForshow,fhdtdc);
                }
                MfragmentTransaction3.commit();
                break;
        }
    }

    public void OftenCheck(){
        switch (tag_for_show_kinds){
            //全部任务经常检查
            case 1:
                FragmentManager fm_alltasks_often = getSupportFragmentManager();
                FragmentTransaction MfragmentTransaction1 = fm_alltasks_often.beginTransaction();
                fragmentAllTaskOftenCheck fatoc = new fragmentAllTaskOftenCheck();
                if(fm_alltasks_often.findFragmentById(R.id.fragmentForshow)==null){
                    MfragmentTransaction1.add(R.id.fragmentForshow,fatoc);
                }else {
                    MfragmentTransaction1.replace(R.id.fragmentForshow,fatoc);
                }
                MfragmentTransaction1.commit();
                break;

            //未完成任务经常检查
            case 2:
                FragmentManager fm_undonetasks_often = getSupportFragmentManager();
                FragmentTransaction MfragmentTransaction2 = fm_undonetasks_often.beginTransaction();
                fragmentUnDoneTasksOftenCheck fudtoc = new fragmentUnDoneTasksOftenCheck();
                if(fm_undonetasks_often.findFragmentById(R.id.fragmentForshow)==null){
                    MfragmentTransaction2.add(R.id.fragmentForshow,fudtoc);
                }else {
                    MfragmentTransaction2.replace(R.id.fragmentForshow,fudtoc);
                }
                MfragmentTransaction2.commit();
                break;

            //已完成任务经常检查
            case 3:
                FragmentManager fm_hasdonetasks_often = getSupportFragmentManager();
                FragmentTransaction MfragmentTransaction3 = fm_hasdonetasks_often.beginTransaction();
                fragmentHasDoneTasksOftenCheck fhdtoc = new fragmentHasDoneTasksOftenCheck();
                if(fm_hasdonetasks_often.findFragmentById(R.id.fragmentForshow)==null){
                    MfragmentTransaction3.add(R.id.fragmentForshow,fhdtoc);
                }else {
                    MfragmentTransaction3.replace(R.id.fragmentForshow,fhdtoc);
                }
                MfragmentTransaction3.commit();
                break;
        }

    }

    public void PeriodicCheck(){
        switch (tag_for_show_kinds){
            //全部任务定期检查
            case 1:
                FragmentManager fm_alltasks_period = getSupportFragmentManager();
                FragmentTransaction MfragmentTransaction1 = fm_alltasks_period.beginTransaction();
                fragmentAllTaskPeriodcCheck fatpc = new fragmentAllTaskPeriodcCheck();
                if(fm_alltasks_period.findFragmentById(R.id.fragmentForshow)==null){
                    MfragmentTransaction1.add(R.id.fragmentForshow,fatpc);
                }else {
                    MfragmentTransaction1.replace(R.id.fragmentForshow,fatpc);
                }
                MfragmentTransaction1.commit();
                break;

            //未完成任务定期检查
            case 2:
                FragmentManager fm_undonetasks_period = getSupportFragmentManager();
                FragmentTransaction MfragmentTransaction2 = fm_undonetasks_period.beginTransaction();
                fragmentUnDoneTasksPeriodcCheck fudtpc = new fragmentUnDoneTasksPeriodcCheck();
                if(fm_undonetasks_period.findFragmentById(R.id.fragmentForshow)==null){
                    MfragmentTransaction2.add(R.id.fragmentForshow,fudtpc);
                }else {
                    MfragmentTransaction2.replace(R.id.fragmentForshow,fudtpc);
                }
                MfragmentTransaction2.commit();
                break;

            //已完成任务定期检查
            case 3:
                FragmentManager fm_hasdonetasks_period = getSupportFragmentManager();
                FragmentTransaction MfragmentTransaction3 = fm_hasdonetasks_period.beginTransaction();
                fragmentHasDoneTasksPeriodcCheck fhdtpc = new fragmentHasDoneTasksPeriodcCheck();
                if(fm_hasdonetasks_period.findFragmentById(R.id.fragmentForshow)==null){
                    MfragmentTransaction3.add(R.id.fragmentForshow,fhdtpc);
                }else {
                    MfragmentTransaction3.replace(R.id.fragmentForshow,fhdtpc);
                }
                MfragmentTransaction3.commit();
                break;
        }

    }

    public void SpecialCheck(){
        switch (tag_for_show_kinds){
            //全部任务专门检查
            case 1:
                FragmentManager fm_alltasks_special = getSupportFragmentManager();
                FragmentTransaction MfragmentTransaction1 = fm_alltasks_special.beginTransaction();
                fragmentAllTaskSpecialCheck fatsc = new fragmentAllTaskSpecialCheck();
                if(fm_alltasks_special.findFragmentById(R.id.fragmentForshow)==null){
                    MfragmentTransaction1.add(R.id.fragmentForshow,fatsc);
                }else {
                    MfragmentTransaction1.replace(R.id.fragmentForshow,fatsc);
                }
                MfragmentTransaction1.commit();
                break;

            //未完成任务专门检查
            case 2:
                FragmentManager fm_undonetasks_special = getSupportFragmentManager();
                FragmentTransaction MfragmentTransaction2 = fm_undonetasks_special.beginTransaction();
                fragmentUnDoneTasksSpecialCheck fudtsc = new fragmentUnDoneTasksSpecialCheck();
                if(fm_undonetasks_special.findFragmentById(R.id.fragmentForshow)==null){
                    MfragmentTransaction2.add(R.id.fragmentForshow,fudtsc);
                }else {
                    MfragmentTransaction2.replace(R.id.fragmentForshow,fudtsc);
                }
                MfragmentTransaction2.commit();
                break;

            //已完成任务专门检查
            case 3:
                FragmentManager fm_hasdonetasks_special = getSupportFragmentManager();
                FragmentTransaction MfragmentTransaction3 = fm_hasdonetasks_special.beginTransaction();
                fragmentHasDoneTasksSpecialCheck fhdtsc = new fragmentHasDoneTasksSpecialCheck();
                if(fm_hasdonetasks_special.findFragmentById(R.id.fragmentForshow)==null){
                    MfragmentTransaction3.add(R.id.fragmentForshow,fhdtsc);
                }else {
                    MfragmentTransaction3.replace(R.id.fragmentForshow,fhdtsc);
                }
                MfragmentTransaction3.commit();
                break;
        }

    }


}

