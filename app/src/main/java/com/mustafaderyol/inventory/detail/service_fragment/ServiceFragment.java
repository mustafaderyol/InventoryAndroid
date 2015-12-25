package com.mustafaderyol.inventory.detail.service_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.mustafaderyol.inventory.R;
import com.mustafaderyol.inventory.detail.service_fragment.ServiceFragmentExpandableListViewBaseAdapter;
import com.mustafaderyol.inventory.entity.Services;
import com.mustafaderyol.inventory.util.Global;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by MstfDryl on 10.12.2015.
 */

public class ServiceFragment extends Fragment {

    ServiceFragmentExpandableListViewBaseAdapter serviceFragmentExpandableListViewBaseAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, Services> listDataChild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.service_fragment, container, false);

        expListView = (ExpandableListView) view.findViewById(R.id.service_fragment_expandableListView);

        prepareListData();

        serviceFragmentExpandableListViewBaseAdapter = new ServiceFragmentExpandableListViewBaseAdapter(getContext(), listDataHeader, listDataChild);

        expListView.setAdapter(serviceFragmentExpandableListViewBaseAdapter);
        return view;
    }


    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, Services>();

        for (int i = 0; i < Global.INVENTORTYSERVICESLIST.size(); i++)
        {
            Services services = Global.INVENTORTYSERVICESLIST.get(i);
            String longV = services.getGoDate().toString();
            long millisecond = Long.parseLong(longV);
            String dateString= DateFormat.format("dd.MM.yyyy H:mm:ss", new Date(millisecond)).toString();
            if (services.getComeDate() != null)
            {
                longV = services.getComeDate().toString();
                millisecond = Long.parseLong(longV);
                dateString += DateFormat.format(" - dd.MM.yyyy H:mm:ss", new Date(millisecond)).toString();
            }
            listDataHeader.add(dateString);
            listDataChild.put(listDataHeader.get(i), services);
        }
    }
}