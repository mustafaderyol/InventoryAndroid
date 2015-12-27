package com.mustafaderyol.inventory.profile;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
public class PasswordChange extends AppCompatActivity {

    private Toolbar toolbar;
    private View passwordchange_layout;
    private Personal personal;
    private String oldPasswordString, newPasswordString, newPasswordRepeatString;
    private EditText oldPassword, newPassword, newPasswordRepeat;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passwordchange_activity);

        passwordchange_layout = findViewById(R.id.passwordchange_layout);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitle("Parola Değiştir");
        setSupportActionBar(toolbar);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setHomeButtonEnabled(true);
        mActionBar.setDisplayHomeAsUpEnabled(true);

        this.personal = Global.PERSONAL;

        oldPassword = (EditText) findViewById(R.id.passwordchange_layout_old_password);
        newPassword = (EditText) findViewById(R.id.passwordchange_layout_new_password);
        newPasswordRepeat = (EditText) findViewById(R.id.passwordchange_layout_new_password_repeat);

        button = (Button) findViewById(R.id.passwordchange_layout_save_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oldPasswordString           = oldPassword.getText().toString() ;
                newPasswordString           = newPassword.getText().toString() ;
                newPasswordRepeatString     = newPasswordRepeat.getText().toString() ;


                if(oldPasswordString.length()>0 && newPasswordString.length()>0 && newPasswordRepeatString.length()>0)
                {
                    if (oldPasswordString.equals(personal.getPassword()))
                    {

                        if (newPasswordString.equals(newPasswordRepeatString))
                        {
                            personal.setPassword(newPasswordString);
                            Date date = new Date();
                            personal.setCreateDate(date.getTime());
                            Call<Personal> call = Global.service.updatePersonal(personal,Global.BASIC_AUTH);
                            call.enqueue(new Callback<Personal>() {
                                @Override
                                public void onResponse(Response<Personal> response, Retrofit retrofit) {

                                    Global.PERSONAL = response.body();
                                    personal = response.body();

                                    Toast.makeText(getApplication(), "İşlem Başarılı.", Toast.LENGTH_LONG).show();
                                    finish();
                                }

                                @Override
                                public void onFailure(Throwable t) {
                                    Toast.makeText(getApplication(), "İşlem Başarısız. Lütfen internet bağlantınızı kontrol ediniz.", Toast.LENGTH_LONG).show();
                                }
                            });

                        }
                        else
                        {
                            Toast.makeText(getApplication(), "Yani Parola ile Yeni Parola (Tekrar) Uyuşmuyor.", Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplication(), "Eski Parola Hatalı.", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplication(), "Alanlar Boş Bırakılamaz.", Toast.LENGTH_LONG).show();
                }
            }

        });

    }
}
