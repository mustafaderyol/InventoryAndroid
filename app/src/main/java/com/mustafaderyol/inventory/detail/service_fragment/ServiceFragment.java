package com.mustafaderyol.inventory.detail.service_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.mustafaderyol.inventory.R;
import com.mustafaderyol.inventory.detail.service_fragment.ServiceFragmentExpandableListViewBaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by MstfDryl on 10.12.2015.
 */

public class ServiceFragment extends Fragment {

    ServiceFragmentExpandableListViewBaseAdapter serviceFragmentExpandableListViewBaseAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

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
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("20.05.1994");
        listDataHeader.add("20.05.2004");
        listDataHeader.add("20.05.2014");
        listDataHeader.add("20.05.2015");

        // Adding child data
        List<String> a1 = new ArrayList<String>();
        a1.add("Toner Arıza");
        a1.add("Mustafa Deryol");

        List<String> a2 = new ArrayList<String>();
        a2.add("Kablo Arıza");
        a2.add("Mustafa Deryol");

        List<String> a3 = new ArrayList<String>();
        a3.add("Toner Arıza");
        a3.add("Mustafa Deryol");

        List<String> a4 = new ArrayList<String>();
        a4.add("Toner Arıza");
        a4.add("Mustafa Deryol");

        listDataChild.put(listDataHeader.get(0), a1); // Header, Child data
        listDataChild.put(listDataHeader.get(1), a2);
        listDataChild.put(listDataHeader.get(2), a3);
        listDataChild.put(listDataHeader.get(3), a4);
    }
}