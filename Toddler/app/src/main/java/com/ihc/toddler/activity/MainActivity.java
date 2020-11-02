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
import com.ihc.toddler.fragment.DisplayContentFragment;
import com.ihc.toddler.fragment.DisplayExerciseFragment;
import com.ihc.toddler.navdrawer.NavigationDrawerGenericItem;
import com.ihc.toddler.navdrawer.NavigationDrawerLine;
import com.ihc.toddler.fragment.DisplayActivitiesFragment;
import com.ihc.toddler.fragment.DisplayAwardsFragment;
import com.ihc.toddler.manager.AwardManager;
import com.ihc.toddler.navdrawer.NavigationDrawerProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private String[] navigationDrawerItemTitles;
    private DrawerLayout drawerLayout;
    private ListView navigationDrawerListView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private static final int PROFILE = 0, CONTENTS = 1, EXERCISES = 2, AWARDS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapLayout();
        setupNavigationDrawer(buildNavigationDrawerLineArray());
        selectItem(CONTENTS);
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

    private void setupNavigationDrawer(NavigationDrawerGenericItem[] lines) {
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
                if (position == PROFILE) return;
                selectItem(position);
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        actionBarDrawerToggle.syncState();
    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case CONTENTS:
                fragment = new DisplayContentFragment(); break;
            case EXERCISES:
                fragment = new DisplayExerciseFragment(); break;
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

    private NavigationDrawerGenericItem[] buildNavigationDrawerLineArray() {
        List<NavigationDrawerGenericItem> lines = new ArrayList<>();
        lines.add(new NavigationDrawerProfile(R.drawable.unselected_button, navigationDrawerItemTitles[PROFILE]));
        lines.add(new NavigationDrawerLine(R.drawable.book, navigationDrawerItemTitles[CONTENTS]));
        lines.add(new NavigationDrawerLine(R.drawable.homework, navigationDrawerItemTitles[EXERCISES]));
        lines.add(new NavigationDrawerLine(R.drawable.gold_achieved, navigationDrawerItemTitles[AWARDS]));

        NavigationDrawerGenericItem[] array = new NavigationDrawerGenericItem[lines.size()];
        lines.toArray(array);
        return array;
    }
}
