package com.mustafaderyol.inventory.detail.movement_fragment;

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

import java.util.ArrayList;

/**
 * Created by MstfDryl on 10.12.2015.
 */

public class MovementFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.movement_fragment, container, false);


        return view;
    }
}