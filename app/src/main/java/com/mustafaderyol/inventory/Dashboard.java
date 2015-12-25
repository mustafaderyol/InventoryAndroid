package com.mustafaderyol.inventory;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.mustafaderyol.inventory.detail.InventoryDetail;
import com.mustafaderyol.inventory.entity.Inventory;
import com.mustafaderyol.inventory.entity.InventoryRelationship;
import com.mustafaderyol.inventory.util.Global;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by MstfDryl on 10.12.2015.
 */
public class Dashboard extends AppCompatActivity {

    private ImageButton btn;
    private Toolbar toolbar;
    private View dashboard_layout;
    private TextView personalTextView;
    private URL url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        dashboard_layout = findViewById(R.id.dashboard_layout);

        toolbar =(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setHomeButtonEnabled(true);
        mActionBar.setDisplayHomeAsUpEnabled(true);

        personalTextView = (TextView) findViewById(R.id.dashboard_personal_tv);
        personalTextView.setText(Global.PERSONAL.getFirstname()+" "+Global.PERSONAL.getLastname());

        btn = (ImageButton) findViewById(R.id.imageButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                final String result = intent.getStringExtra("SCAN_RESULT");
                try
                {
                    Long id = Long.parseLong(result)-Long.parseLong("120000");

                    Snackbar.make(dashboard_layout,"Sonuç: "+result,Snackbar.LENGTH_LONG).show();


                    Call<Inventory> call = Global.service.getInventory(id);
                    call.enqueue(new Callback<Inventory>() {
                        @Override
                        public void onResponse(Response<Inventory> response, Retrofit retrofit) {

                            Global.INVENTORY = response.body();

                            Call<List<InventoryRelationship>> call = Global.service.getInventoryRelationship(Global.INVENTORY.getId());
                            call.enqueue(new Callback<List<InventoryRelationship>>() {
                                @Override
                                public void onResponse(Response<List<InventoryRelationship>> response2, Retrofit retrofit) {


                                    Global.INVENTORTYRELATIONSHIPLIST = response2.body();

                                    Intent i = new Intent(getApplication(), InventoryDetail.class);
                                    startActivity(i);
                                }

                                @Override
                                public void onFailure(Throwable t) {
                                }
                            });



                        }

                        @Override
                        public void onFailure(Throwable t) {
                            Snackbar.make(dashboard_layout,"Sonuç: "+result,Snackbar.LENGTH_INDEFINITE).show();
                        }
                    });

                }
                catch (Exception e)
                {
                    try
                    {
                        url = new URL(result);

                        Snackbar snackbar = Snackbar
                                .make(dashboard_layout, result, Snackbar.LENGTH_INDEFINITE)
                                .setAction("Git", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url.toString()));
                                        startActivity(i);
                                    }
                                });

                        snackbar.setActionTextColor(Color.WHITE);

                        View sbView = snackbar.getView();
                        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                        textView.setTextColor(Color.RED);
                        snackbar.show();
                    }catch(IOException d)
                    {
                        Snackbar.make(dashboard_layout,result,Snackbar.LENGTH_LONG).show();
                    }

                }

            } else if (resultCode == RESULT_CANCELED) {
                Snackbar.make(dashboard_layout,"Tarama İptal Edildi.",Snackbar.LENGTH_LONG).show();
            }

        }

    }

}
