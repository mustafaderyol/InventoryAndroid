package com.mustafaderyol.inventory;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mustafaderyol.inventory.database.LoginPersonalDBHelper;
import com.mustafaderyol.inventory.entity.Personal;
import com.mustafaderyol.inventory.util.Global;
import com.mustafaderyol.inventory.util.LoginItem;
import com.mustafaderyol.inventory.util.NetworkUtil;

import java.io.UnsupportedEncodingException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class LoginActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private Context context;
    private View coordinatorLayoutView;

    private UserLoginTask mAuthTask = null;
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    private Boolean successBool;
    private Response<Personal> response2;

    private LoginPersonalDBHelper loginPersonalDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        coordinatorLayoutView = findViewById(R.id.snackbarPosition);

        loginPersonalDBHelper = new LoginPersonalDBHelper(this);

        toolbar =(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        context = getApplicationContext();

        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);

        if(NetworkUtil.getConnectivityStatusString(getApplicationContext())==0){

            Snackbar.make(coordinatorLayoutView,"Internet Bağlantısı Yok.",Snackbar.LENGTH_LONG).show();
        }
        else
        {
            Cursor rs = loginPersonalDBHelper.getData(1);
            if ( rs.getCount() > 0)
            {
                attemptLogin();
            }
        }


        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(NetworkUtil.getConnectivityStatusString(getApplicationContext())==0)
                {
                    Snackbar.make(coordinatorLayoutView,"Internet Bağlantısı Yok.",Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    attemptLogin();

                      //Intent i = new Intent(getApplication(),Dashboard.class);
                      //startActivity(i);
                }

            }
        });

    }

    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        mEmailView.setError(null);
        mPasswordView.setError(null);

        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }


        if (cancel) {
            Cursor rs = loginPersonalDBHelper.getData(1);
            if ( rs.getCount() > 0)
            {

                showProgress(true);
                email = rs.getString(rs.getColumnIndex(LoginPersonalDBHelper.CONTACTS_COLUMN_EMAIL));
                password = rs.getString(rs.getColumnIndex(LoginPersonalDBHelper.CONTACTS_COLUMN_PASSWORD));
                mAuthTask = new UserLoginTask(email, password);
                mAuthTask.execute((Void) null);
            }
            else
            {
                focusView.requestFocus();
            }
        } else {
            showProgress(true);
            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 0;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private String mEmail;
        private String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            successBool = false;
            String email = mEmail,password = mPassword;

            Cursor rs = loginPersonalDBHelper.getData(1);
            if ( rs.getCount() <= 0)
            {
                loginPersonalDBHelper.insertLoginPersonal(1,email,password);
            }

            LoginItem loginItem = new LoginItem(mEmail, mPassword);

            Call<Personal> call = Global.service.getUser(loginItem);

            call.enqueue(new Callback<Personal>() {
                @Override
                public void onResponse(Response<Personal> response, Retrofit retrofit) {
                    try
                    {
                        if(response.body()== null)
                        {
                            Snackbar.make(coordinatorLayoutView,"Kullanıcı Adı veya Parola Hatalı",Snackbar.LENGTH_LONG).show();
                            loginPersonalDBHelper.deleteLoginPersonal(1);
                            successBool = false;
                        }
                        else
                        {
                            response2 = response;
                            Global.PERSONAL = response.body();
                            Global.EMAIL = Global.PERSONAL.getEmail();
                            Global.PASSWORD = Global.PERSONAL.getPassword();
                            String text = Global.EMAIL+":"+Global.PASSWORD;
                            String base64 =  Base64.encodeToString(text.getBytes(), Base64.NO_WRAP);

                            Global.BASIC_AUTH = "Basic "+base64;

                            loginPersonalDBHelper.updateLoginPersonal(1,Global.EMAIL,Global.PASSWORD);
                            successBool = true;

                            Intent i = new Intent(getApplication(),Dashboard.class);
                            startActivity(i);

                            //Snackbar.make(coordinatorLayoutView,Global.PERSONAL.getFirstname()+" "+Global.PERSONAL.getLastname(),Snackbar.LENGTH_LONG).show();
                        }
                    }
                    catch (Exception e)
                    {
                        mPasswordView.setError(getString(R.string.error_incorrect_password));
                        mPasswordView.requestFocus();
                        successBool = false;
                        loginPersonalDBHelper.deleteLoginPersonal(1);
                        Snackbar.make(coordinatorLayoutView,"Kullanıcı Adı veya Parola Hatalı",Snackbar.LENGTH_LONG).show();
                    }


                }

                @Override
                public void onFailure(Throwable t) {
                    mPasswordView.setError(getString(R.string.error_incorrect_password));
                    mPasswordView.requestFocus();
                    Snackbar.make(coordinatorLayoutView,"İşlem Gerçekleştirilemedi.",Snackbar.LENGTH_LONG).show();
                    loginPersonalDBHelper.deleteLoginPersonal(1);
                    successBool = false;

                }
            });

            return successBool;
        }

        @Override
        protected void onPostExecute(Boolean success) {
            mAuthTask = null;
            showProgress(false);

        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }
}

