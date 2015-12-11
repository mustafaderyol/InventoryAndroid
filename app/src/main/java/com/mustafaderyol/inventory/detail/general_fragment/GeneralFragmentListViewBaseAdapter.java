package com.mustafaderyol.inventory.detail.general_fragment;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mustafaderyol.inventory.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MstfDryl on 11.12.2015.
 */
public class GeneralFragmentListViewBaseAdapter extends BaseAdapter {
    private LayoutInflater inf;
    private List<GeneralFragmentItem> items;
    private Context content;
    private Activity activity;


    public GeneralFragmentListViewBaseAdapter(Context content, ArrayList<GeneralFragmentItem> items) {
        this.items = items;
        this.content = content;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=View.inflate(content, R.layout.general_fragment_listview_item,null);

        TextView parameter = (TextView) convertView.findViewById(R.id.general_fragment_listview_item_textview1);
        TextView value = (TextView) convertView.findViewById(R.id.general_fragment_listview_item_textview2);

        GeneralFragmentItem item = items.get(position);

        parameter.setText(item.getParameter()+" :");
        value.setText(item.getValue());

        return convertView;
    }
}
