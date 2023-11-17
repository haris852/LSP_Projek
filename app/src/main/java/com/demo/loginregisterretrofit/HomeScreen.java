package com.demo.loginregisterretrofit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.demo.loginregisterretrofit.Forms.LoginActivity;
import com.demo.loginregisterretrofit.Forms.UpdateActivity;

import static com.demo.loginregisterretrofit.Forms.LoginActivity.ALAMAT;
import static com.demo.loginregisterretrofit.Forms.LoginActivity.EMAIL;

import static com.demo.loginregisterretrofit.Forms.LoginActivity.NAMA;
import static com.demo.loginregisterretrofit.Forms.LoginActivity.NOTELP;
import static com.demo.loginregisterretrofit.Forms.LoginActivity.SHARED_PREFERENCES_NAME;
import static com.demo.loginregisterretrofit.Forms.LoginActivity.TANGGALLAHIR;
import static com.demo.loginregisterretrofit.Forms.LoginActivity.TEMPATLAHIR;
import static com.demo.loginregisterretrofit.Forms.LoginActivity.USERNAME;
import static com.demo.loginregisterretrofit.Forms.LoginActivity.USER_ID;

public class HomeScreen extends AppCompatActivity {
    Button logout, edit;
    TextView text_userid, text_email, text_username, text_nama, text_alamat, text_tempatlahir, text_tgllahir, text_notelp;
    String str_email, str_username, str_nama, str_userid, str_passowrd , str_alamat, str_tempatlahir, str_tgllahir, str_notelp;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        str_userid = sharedPreferences.getString(USER_ID, "");
        str_username = sharedPreferences.getString(USERNAME, "");
        str_nama = sharedPreferences.getString(NAMA, "");
        str_email = sharedPreferences.getString(EMAIL, "");
        str_alamat = sharedPreferences.getString(ALAMAT, "");
        str_tempatlahir = sharedPreferences.getString(TEMPATLAHIR, "");
        str_tgllahir = sharedPreferences.getString(TANGGALLAHIR, "");
        str_notelp = sharedPreferences.getString(NOTELP, "");

        text_userid = (TextView) findViewById(R.id.user_id);
        text_email = (TextView) findViewById(R.id.user_email);
        text_username = (TextView) findViewById(R.id.user_username);
        text_nama = (TextView) findViewById(R.id.user_nama);
        text_alamat = (TextView) findViewById(R.id.user_alamat);
        text_tempatlahir = (TextView) findViewById(R.id.user_tempatlahir);
        text_tgllahir = (TextView) findViewById(R.id.user_tgllahir);
        text_notelp = (TextView) findViewById(R.id.user_notelp);
        logout = findViewById(R.id.logout_btn);
//        edit = findViewById(R.id.edit);

        text_userid.setText("UserId : " + str_userid);
        text_email.setText("Email : " + str_email);
        text_username.setText("Username : " + str_username);
        text_nama.setText("Nama :  " + str_nama);
        text_alamat.setText("Alamat :  " + str_alamat);
        text_tempatlahir.setText("Tempat Lahir :  " + str_tempatlahir);
        text_tgllahir.setText("Tanggal Lahir :  " + str_tgllahir);
        text_notelp.setText("No Telp:  " + str_notelp);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
//        edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), UpdateActivity.class);
//                startActivity(intent);
//            }
//        });

    }

    private void logout() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(R.string.confirmation);
        dialog.setMessage(R.string.logout_confirmation_text);
        dialog.setNegativeButton(R.string.CANCEL, null);
        dialog.setPositiveButton(R.string.YES, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SessionOut();
            }
        });
        dialog.setCancelable(false);
        dialog.show();

    }

    private void SessionOut() {
        SharedPreferences sharedpreferences = getApplicationContext().getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.apply();
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        finish();
        startActivity(intent);
    }


}
