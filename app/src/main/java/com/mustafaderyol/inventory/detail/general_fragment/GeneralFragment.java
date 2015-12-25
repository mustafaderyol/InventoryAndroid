package com.mustafaderyol.inventory.detail.general_fragment;

/**
 * Created by MstfDryl on 10.12.2015.
 */

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.mustafaderyol.inventory.R;
import com.mustafaderyol.inventory.entity.InventoryDetailCommonParameter;
import com.mustafaderyol.inventory.entity.InventoryDetailParameter;
import com.mustafaderyol.inventory.entity.MovementHistory;
import com.mustafaderyol.inventory.util.Global;

import java.util.ArrayList;
import java.util.List;

public class GeneralFragment extends Fragment {
    private ArrayList list;
    private ListView liste;
    private GeneralFragmentListViewBaseAdapter generalFragmentListViewBaseAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.general_fragment, container, false);


        final ArrayList<GeneralFragmentItem> items = new ArrayList<GeneralFragmentItem>();
        MovementHistory movementHistory = Global.INVENTORY.getMovementHistory().get(Global.INVENTORY.getMovementHistory().size()-1);

        items.add(new GeneralFragmentItem("Personel",movementHistory.getPersonal().getFirstname()+" "+movementHistory.getPersonal().getLastname()));
        items.add(new GeneralFragmentItem("Birim",movementHistory.getUnit().getName()));
        items.add(new GeneralFragmentItem("Lokasyon",movementHistory.getLocation().getName()));
        items.add(new GeneralFragmentItem("Lokasyon Detay",movementHistory.getLocationdetail()));
        items.add(new GeneralFragmentItem("Not",Global.INVENTORY.getNote()));

        for (int i=0;i< Global.INVENTORY.getInventoryDetailParameter().size();i++)
        {
            InventoryDetailParameter inventoryDetailParameter = Global.INVENTORY.getInventoryDetailParameter().get(i);
            if (inventoryDetailParameter.getAnswerparameter() == null)
                items.add(new GeneralFragmentItem(inventoryDetailParameter.getParameter().getName(),inventoryDetailParameter.getText()));
            else
                items.add(new GeneralFragmentItem(inventoryDetailParameter.getParameter().getName(),inventoryDetailParameter.getAnswerparameter().getName()));
        }


        for (int i=0;i< Global.INVENTORY.getInventoryDetailCommonParameter().size();i++)
        {
            InventoryDetailCommonParameter inventoryDetailCommonParameter = Global.INVENTORY.getInventoryDetailCommonParameter().get(i);
            items.add(new GeneralFragmentItem(inventoryDetailCommonParameter.getCommonparameter().getName(),inventoryDetailCommonParameter.getUndercommonparameter().getName()));
        }

        liste=(ListView) view.findViewById(R.id.general_fragment_listview);
        generalFragmentListViewBaseAdapter = new GeneralFragmentListViewBaseAdapter(getActivity(), items);
        liste.setAdapter(generalFragmentListViewBaseAdapter);

        return view;
    }
}