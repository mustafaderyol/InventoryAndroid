package com.mustafaderyol.inventory.detail.relationship_fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.mustafaderyol.inventory.R;
import com.mustafaderyol.inventory.entity.InventoryRelationship;
import com.mustafaderyol.inventory.util.Global;

/**
 * Created by MstfDryl on 10.12.2015.
 */

public class RelationshipFragment extends Fragment {
    private ListView listView;
    private FloatingActionButton floatingActionButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.relationship_fragment, container, false);

        listView =(ListView) view.findViewById(R.id.relationship_fragment_listview);
        int size = Global.INVENTORTYRELATIONSHIPLIST.size();
        String[] relationships = new String[size];
        for (int i=0; i< Global.INVENTORTYRELATIONSHIPLIST.size();i++)
        {
            String relation =  String.valueOf(Global.INVENTORTYRELATIONSHIPLIST.get(i).getInventory2().getId()+120000)+" - "+Global.INVENTORTYRELATIONSHIPLIST.get(i).getInventory2().getCategory().getName();
            relationships[i] = relation;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, android.R.id.text1,relationships);
        listView.setAdapter(adapter);

        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.relationship_fragment_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Hareket Geçmişi",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}