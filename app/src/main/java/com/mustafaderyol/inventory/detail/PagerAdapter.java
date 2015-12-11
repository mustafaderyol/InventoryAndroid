package com.mustafaderyol.inventory.detail;

/**
 * Created by MstfDryl on 11.12.2015.
 */

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.mustafaderyol.inventory.detail.general_fragment.GeneralFragment;
import com.mustafaderyol.inventory.detail.movement_fragment.MovementFragment;
import com.mustafaderyol.inventory.detail.relationship_fragment.RelationshipFragment;
import com.mustafaderyol.inventory.detail.service_fragment.ServiceFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                GeneralFragment tab1 = new GeneralFragment();
                return tab1;
            case 1:
                RelationshipFragment tab2 = new RelationshipFragment();
                return tab2;
            case 2:
                MovementFragment tab3 = new MovementFragment();
                return tab3;
            case 3:
                ServiceFragment tab4 = new ServiceFragment();
                return tab4;
            default:
                GeneralFragment tab5 = new GeneralFragment();
                return tab5;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}