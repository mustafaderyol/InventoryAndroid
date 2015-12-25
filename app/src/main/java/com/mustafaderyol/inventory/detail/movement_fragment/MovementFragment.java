package com.mustafaderyol.inventory.detail.movement_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.mustafaderyol.inventory.R;
import com.mustafaderyol.inventory.entity.MovementHistory;
import com.mustafaderyol.inventory.util.Global;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by MstfDryl on 10.12.2015.
 */

public class MovementFragment extends Fragment {

    MovementFragmentExpandableListViewBaseAdapter movementFragmentExpandableListViewBaseAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, MovementHistory> listDataChild;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.movement_fragment, container, false);

        expListView = (ExpandableListView) view.findViewById(R.id.movement_fragment_expandableListView);

        prepareListData();

        movementFragmentExpandableListViewBaseAdapter = new MovementFragmentExpandableListViewBaseAdapter(getContext(), listDataHeader, listDataChild);

        expListView.setAdapter(movementFragmentExpandableListViewBaseAdapter);

        return view;
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, MovementHistory>();

        for (int i = 0; i < Global.INVENTORY.getMovementHistory().size(); i++)
        {
            MovementHistory movementHistory = Global.INVENTORY.getMovementHistory().get(i);
            String longV = movementHistory.getCreatedDate().toString();
            long millisecond = Long.parseLong(longV);
            String dateString= DateFormat.format("dd.MM.yyyy H:mm:ss", new Date(millisecond)).toString();
            listDataHeader.add(dateString);
            listDataChild.put(listDataHeader.get(i), movementHistory);
        }

    }
}