package com.ihc.toddler.adapter;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ihc.toddler.R;
import com.ihc.toddler.navdrawer.NavigationDrawerGenericItem;
import com.ihc.toddler.navdrawer.NavigationDrawerLine;

import java.util.Arrays;

public class DrawerItemCustomAdapter extends ArrayAdapter<NavigationDrawerGenericItem> {

    private Context context;
    private int firstLayoutResourceId, layoutResourceId;
    private NavigationDrawerGenericItem[] navigationDrawerLines;

    private static final int PROFILE = 0;

    public DrawerItemCustomAdapter(Context context, int firstLayoutResourceId, int layoutResourceId, NavigationDrawerGenericItem[] navigationDrawerLines) {
        super(context, layoutResourceId, navigationDrawerLines);
        this.context = context;
        this.firstLayoutResourceId = firstLayoutResourceId;
        this.layoutResourceId = layoutResourceId;
        this.navigationDrawerLines = navigationDrawerLines;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        NavigationDrawerGenericItem navigationDrawerItem = navigationDrawerLines[position];
        View listViewItem;

        if (position == PROFILE) {
            listViewItem = inflater.inflate(firstLayoutResourceId, parent, false);

            ImageView imageViewIcon = listViewItem.findViewById(R.id.nav_drawer_profile_pic);
            TextView textViewName = listViewItem.findViewById(R.id.nav_drawer_profile_name);

            navigationDrawerItem.populateScreenViews(Arrays.asList(imageViewIcon, textViewName));
        } else {
            listViewItem = inflater.inflate(layoutResourceId, parent, false);

            ImageView imageViewIcon = listViewItem.findViewById(R.id.nav_drawer_item_logo);
            TextView textViewName = listViewItem.findViewById(R.id.nav_drawer_item_name);

            navigationDrawerItem.populateScreenViews(Arrays.asList(imageViewIcon, textViewName));
        }

        return listViewItem;
    }

}
