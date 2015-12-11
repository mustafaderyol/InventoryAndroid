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

import java.util.ArrayList;
import java.util.List;

public class GeneralFragment extends Fragment {
    private ArrayList list;
    private ListView liste;
    private GeneralFragmentListViewBaseAdapter generalFragmentListViewBaseAdapter;
    private FloatingActionButton floatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.general_fragment, container, false);


        final ArrayList<GeneralFragmentItem> items = new ArrayList<GeneralFragmentItem>();
        items.add(new GeneralFragmentItem("Marka","PackardBell"));
        items.add(new GeneralFragmentItem("Model","TK85"));

        liste=(ListView) view.findViewById(R.id.general_fragment_listview);
        generalFragmentListViewBaseAdapter = new GeneralFragmentListViewBaseAdapter(getActivity(), items);
        liste.setAdapter(generalFragmentListViewBaseAdapter);

        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.general_fragment_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Detayları Düzenle",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}