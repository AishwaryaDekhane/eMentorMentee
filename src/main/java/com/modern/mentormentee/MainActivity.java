package com.modern.mentormentee;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.modern.fragment.AdminFragment;
import com.modern.model.Student;
import com.modern.model.Teacher;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String LoginType = "";
    TextView navHeaderName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
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

        navHeaderName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.nav_header_name);
        // get the Intent that started this Activity
        Intent intent = getIntent();
        // get the Bundle that stores the data of this Activity
        Bundle bundle = intent.getExtras();
        // getting data from bundle
        LoginType = bundle.getString("LoginType");
        if (LoginType.equals("Admin")) {
            navigationView.getMenu().setGroupVisible(R.id.menu_admin, true);
            navHeaderName.setText("Admin");
        } else if (LoginType.equals("Teacher")) {
            navigationView.getMenu().setGroupVisible(R.id.menu_teacher, true);
            Teacher teacher = (Teacher) intent.getSerializableExtra("Teacher");
            navHeaderName.setText(teacher.get_TEACHER_FNAME() + " " + teacher.get_TEACHER_LNAME());
        } else if (LoginType.equals("Student")) {
            navigationView.getMenu().setGroupVisible(R.id.menu_student, true);
            Student student = (Student) intent.getSerializableExtra("Student");
            navHeaderName.setText(student.get_STUDENT_FNAME() + " " + student.get_STUDENT_LNAME());
        }
        // show screen as per logintype
        displaySelectedScreen();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
        }
    }


    private void displaySelectedScreen() {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (LoginType) {
            case "Admin":
                fragment = new AdminFragment();
                break;
            case "Teacher":
                //fragment = new Menu2();
                break;
            case "Student":
                //fragment = new Menu3();
                break;
            default:
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_student_logout || id == R.id.nav_admin_logout || id == R.id.nav_teacher_logout) {
            finish();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        } /*else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
