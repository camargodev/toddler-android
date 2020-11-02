package com.ihc.toddler.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.ihc.toddler.R;
import com.ihc.toddler.adapter.DrawerItemCustomAdapter;
import com.ihc.toddler.entity.NavigationDrawerLine;
import com.ihc.toddler.fragment.DisplayActivitiesFragment;
import com.ihc.toddler.fragment.DisplayAwardsFragment;
import com.ihc.toddler.manager.AwardManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private String[] navigationDrawerItemTitles;
    private DrawerLayout drawerLayout;
    private ListView navigationDrawerListView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private static final int ACTIVITIES = 0, AWARDS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapLayout();
        setupNavigationDrawer(buildNavigationDrawerLineArray());
    }

    @Override
    protected void onResume() {
        super.onResume();
        AwardManager.getInstance().notifyAward(this);
        selectItem(0);
    }

    private void mapLayout() {
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationDrawerListView = findViewById(R.id.left_drawer);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);

        navigationDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
    }

    private void setupNavigationDrawer(NavigationDrawerLine[] lines) {
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.navigation_drawer_first_item, R.layout.navigation_drawer_commom_item, lines);
        navigationDrawerListView.setAdapter(adapter);
        navigationDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        actionBarDrawerToggle.syncState();
    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case ACTIVITIES:
                fragment = new DisplayActivitiesFragment(); break;
            case AWARDS:
                fragment = new DisplayAwardsFragment(); break;
            default: break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            navigationDrawerListView.setItemChecked(position, true);
            navigationDrawerListView.setSelection(position);
            setTitle(navigationDrawerItemTitles[position]);
            drawerLayout.closeDrawer(navigationDrawerListView);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    private NavigationDrawerLine[] buildNavigationDrawerLineArray() {
        List<NavigationDrawerLine> lines = new ArrayList<>();
        lines.add(new NavigationDrawerLine(R.drawable.book, navigationDrawerItemTitles[ACTIVITIES]));
        lines.add(new NavigationDrawerLine(R.drawable.homework, navigationDrawerItemTitles[AWARDS]));

        NavigationDrawerLine[] array = new NavigationDrawerLine[lines.size()];
        lines.toArray(array);
        return array;
    }
}
