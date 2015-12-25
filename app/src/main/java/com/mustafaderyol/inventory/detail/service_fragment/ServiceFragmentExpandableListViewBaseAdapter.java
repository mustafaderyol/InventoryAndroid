package com.mustafaderyol.inventory.detail.service_fragment;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.mustafaderyol.inventory.R;
import com.mustafaderyol.inventory.entity.Services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by MstfDryl on 12.12.2015.
 */
public class ServiceFragmentExpandableListViewBaseAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<String> _listDataHeader;
    private HashMap<String, Services> _listDataChild;

    public ServiceFragmentExpandableListViewBaseAdapter(Context context, List<String> listDataHeader, HashMap<String, Services> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition));
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        Services childText = (Services) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.service_fragment_child_list_item, null);
        }

        TextView ctarih = (TextView) convertView.findViewById(R.id.services_fragment_child_list_item_tv_ctarih);
        TextView cnote = (TextView) convertView.findViewById(R.id.services_fragment_child_list_item_tv_cnot);
        TextView gtarih = (TextView) convertView.findViewById(R.id.services_fragment_child_list_item_tv_gtarih);
        TextView gnote = (TextView) convertView.findViewById(R.id.services_fragment_child_list_item_tv_gnot);
        TextView personal = (TextView) convertView.findViewById(R.id.services_fragment_child_list_item_tv_personal);
        TextView unit = (TextView) convertView.findViewById(R.id.services_fragment_child_list_item_tv_birim);
        TextView location = (TextView) convertView.findViewById(R.id.services_fragment_child_list_item_tv_lokasyon);
        TextView locationDetail = (TextView) convertView.findViewById(R.id.services_fragment_child_list_item_tv_lokasyon_detay);

        personal.setText(childText.getMovementhistory().getPersonal().getFirstname()+" "+childText.getMovementhistory().getPersonal().getLastname());
        unit.setText(childText.getMovementhistory().getUnit().getName());
        location.setText(childText.getMovementhistory().getLocation().getName());
        locationDetail.setText(childText.getMovementhistory().getLocationdetail());

        String longV = childText.getGoDate().toString();
        long millisecond = Long.parseLong(longV);
        String dateString= DateFormat.format("dd.MM.yyyy H:mm:ss", new Date(millisecond)).toString();
        ctarih.setText(dateString);
        cnote.setText(childText.getGoNote());

        longV = childText.getComeDate().toString();
        millisecond = Long.parseLong(longV);
        dateString= DateFormat.format("dd.MM.yyyy H:mm:ss", new Date(millisecond)).toString();
        gtarih.setText(dateString);
        gnote.setText(childText.getComeNote());
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.service_fragment_group_list_item, null);
        }

        TextView lblListHeader = (TextView) convertView.findViewById(R.id.service_fragment_group_list_item_group_name);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
