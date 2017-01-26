package com.pj.lmb.lmbapplication;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;

/**
 * Created by yoshizawa on 2017/01/26.
 */

public class ScheduleAdapter extends RealmBaseAdapter<Schedule> implements ListAdapter {

    private static class ViewHolder {
        TextView title;
        TextView date;
    }

    public ScheduleAdapter(Context context, RealmResults<Schedule> realmResults) {
        super(context, realmResults);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_2, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.date = (TextView) convertView.findViewById(android.R.id.text1);
            viewHolder.title = (TextView)convertView.findViewById(android.R.id.text2);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Schedule schedule = getItem(position);
        viewHolder.date.setText(schedule.getDate());
        viewHolder.title.setText(schedule.getTitle());

        return convertView;
    }
}
