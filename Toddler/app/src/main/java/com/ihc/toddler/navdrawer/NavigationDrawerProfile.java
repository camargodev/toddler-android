package com.ihc.toddler.navdrawer;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NavigationDrawerProfile implements NavigationDrawerGenericItem {

    private int icon;
    private String name;

    public NavigationDrawerProfile(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    @Override
    public void populateScreenViews(List<View> views) {
        if (views.size() != 2) {
            Log.e("NavigationDrawerLine", "Should have two views: icon and name");
            return;
        }
        ((TextView) views.get(1)).setText("Oi, " + name);
    }
}