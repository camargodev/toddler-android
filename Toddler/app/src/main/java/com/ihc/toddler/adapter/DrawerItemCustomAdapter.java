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
import com.ihc.toddler.entity.NavigationDrawerLine;

public class DrawerItemCustomAdapter extends ArrayAdapter<NavigationDrawerLine> {

    private Context context;
    private int firstLayoutResourceId, layoutResourceId;
    private NavigationDrawerLine[] navigationDrawerLines;

    public DrawerItemCustomAdapter(Context context, int layoutResourceId, NavigationDrawerLine[] navigationDrawerLines) {
       this(context, layoutResourceId, layoutResourceId, navigationDrawerLines);
    }

    public DrawerItemCustomAdapter(Context context, int firstLayoutResourceId, int layoutResourceId, NavigationDrawerLine[] navigationDrawerLines) {
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
        View listViewItem = inflater.inflate(layoutResourceId, parent, false);

        if (position == 0)
            listViewItem = inflater.inflate(firstLayoutResourceId, parent, false);

        ImageView imageViewIcon = listViewItem.findViewById(R.id.nav_drawer_item_logo);
        TextView textViewName = listViewItem.findViewById(R.id.nav_drawer_item_name);

        NavigationDrawerLine folder = navigationDrawerLines[position];

        imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);

        return listViewItem;
    }

}
