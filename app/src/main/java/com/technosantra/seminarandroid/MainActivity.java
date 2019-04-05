package com.technosantra.seminarandroid;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.Preference;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycles", "onCreate");

        final SharedPreferences sharedPref = getSharedPreferences("seminar", Context.MODE_PRIVATE);

        final EditText txtUsername = findViewById(R.id.txtUsername);
        final TextInputEditText txtAddress = findViewById(R.id.txtAddress);

        Button btnRequest = findViewById(R.id.btnSave);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("username", txtUsername.getText().toString());
                editor.putString("address", txtAddress.getText().toString());
                editor.apply();

                txtUsername.setText("");
                txtAddress.setText("");
            }
        });

        Button btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = sharedPref.getString("username", "");
                String address = sharedPref.getString("address", "");
                Toast.makeText(MainActivity.this, "Username is : "+username+" Address is : "+address, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
