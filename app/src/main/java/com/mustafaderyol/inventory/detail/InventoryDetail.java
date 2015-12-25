package com.mustafaderyol.inventory.detail;

import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import com.mustafaderyol.inventory.R;
import com.mustafaderyol.inventory.util.Global;

public class InventoryDetail extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_detail);

        toolbar =(Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitle("DETAYLAR");
        setSupportActionBar(toolbar);

        String subTitle = Global.INVENTORY.getCategory().getName()+" - "+String.valueOf(Global.INVENTORY.getId()+120000);
        toolbar.setSubtitle(subTitle);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setHomeButtonEnabled(true);
        mActionBar.setDisplayHomeAsUpEnabled(true);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_action_action_assignment));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_action_action_swap_horiz_beyaz));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_action_image_healing_beyaz));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_action_communication_contacts_beyaz));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());int i = tab.getPosition();
                if(i==0)
                {
                    toolbar.setTitle("Detaylar");
                    tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_action_assignment);
                    tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_action_swap_horiz_beyaz);
                    tabLayout.getTabAt(2).setIcon(R.drawable.ic_action_communication_contacts_beyaz);
                    tabLayout.getTabAt(3).setIcon(R.drawable.ic_action_image_healing_beyaz);
                }
                else if(i==1)
                {
                    toolbar.setTitle("Envanter İlişki");
                    tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_action_assignment_beyaz);
                    tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_action_swap_horiz);
                    tabLayout.getTabAt(2).setIcon(R.drawable.ic_action_communication_contacts_beyaz);
                    tabLayout.getTabAt(3).setIcon(R.drawable.ic_action_image_healing_beyaz);
                }
                else if(i==2)
                {
                    toolbar.setTitle("Hareket Geçmişi");
                    tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_action_assignment_beyaz);
                    tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_action_swap_horiz_beyaz);
                    tabLayout.getTabAt(2).setIcon(R.drawable.ic_action_communication_contacts);
                    tabLayout.getTabAt(3).setIcon(R.drawable.ic_action_image_healing_beyaz);
                }
                else if(i==3)
                {
                    toolbar.setTitle("Servis Geçmişi");
                    tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_action_assignment_beyaz);
                    tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_action_swap_horiz_beyaz);
                    tabLayout.getTabAt(2).setIcon(R.drawable.ic_action_communication_contacts_beyaz);
                    tabLayout.getTabAt(3).setIcon(R.drawable.ic_action_image_healing);
                }
                else
                {
                    toolbar.setTitle("Detaylar");
                    tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_action_assignment_beyaz);
                    tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_action_swap_horiz_beyaz);
                    tabLayout.getTabAt(2).setIcon(R.drawable.ic_action_image_healing_beyaz);
                    tabLayout.getTabAt(3).setIcon(R.drawable.ic_action_communication_contacts_beyaz);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}
