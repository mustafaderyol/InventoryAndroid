package com.mustafaderyol.inventory.profile;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.mustafaderyol.inventory.R;
import com.mustafaderyol.inventory.entity.Personal;
import com.mustafaderyol.inventory.util.Global;

import java.util.Date;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by MstfDryl on 27.12.2015.
 */
public class Profile extends AppCompatActivity {

    private Toolbar toolbar;
    private View profile_layout;
    private EditText profile_layout_ad,profile_layout_soyad;
    private RadioButton profile_layout_man,profile_layout_woman;
    private Button profile_layout_save_button;
    private Personal personal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        profile_layout = findViewById(R.id.profile_layout);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitle("Profil");
        setSupportActionBar(toolbar);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setHomeButtonEnabled(true);
        mActionBar.setDisplayHomeAsUpEnabled(true);

        profile_layout_ad = (EditText) findViewById(R.id.profile_layout_ad);
        profile_layout_ad.setText(Global.PERSONAL.getFirstname());

        profile_layout_soyad = (EditText) findViewById(R.id.profile_layout_soyad);
        profile_layout_soyad.setText(Global.PERSONAL.getLastname());

        profile_layout_man = (RadioButton) findViewById(R.id.profile_layout_man);
        profile_layout_woman = (RadioButton) findViewById(R.id.profile_layout_woman);
        if(Global.PERSONAL.getSex())
        {
            profile_layout_man.setChecked(true);
        }
        else
        {
            profile_layout_woman.setChecked(true);
        }

        profile_layout_save_button = (Button) findViewById(R.id.profile_layout_save_button);
        profile_layout_save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personal = Global.PERSONAL;
                String profile_layout_adString,profile_layout_soyadString;
                Boolean profile_layout_manBoolean;
                profile_layout_adString = profile_layout_ad.getText().toString();
                profile_layout_soyadString = profile_layout_soyad.getText().toString();
                profile_layout_manBoolean = profile_layout_man.isChecked();
                if(profile_layout_adString.length()>0 && profile_layout_soyadString.length()>0)
                {
                    Date date = new Date();

                    personal.setCreateDate(date.getTime());
                    personal.setFirstname(profile_layout_adString);
                    personal.setLastname(profile_layout_soyadString);
                    personal.setSex(profile_layout_manBoolean);
                    Call<Personal> call = Global.service.updatePersonal(personal,Global.BASIC_AUTH);
                    call.enqueue(new Callback<Personal>() {
                        @Override
                        public void onResponse(Response<Personal> response, Retrofit retrofit) {

                            Global.PERSONAL = response.body();
                            personal = response.body();

                            Toast.makeText(getApplication(), "İşlem Başarılı.", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            Toast.makeText(getApplication(), "İşlem Başarısız. Lütfen internet bağlantınızı kontrol ediniz.", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else
                {
                    Toast.makeText(getApplication(),"Boş Alan Bırakmayınız.",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
