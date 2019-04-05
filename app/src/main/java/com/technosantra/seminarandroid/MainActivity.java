package com.technosantra.seminarandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycles", "onCreate");

        Button btnRequest = findViewById(R.id.btnRequest);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("user", "Username");
                intent.putExtra("age", "Age");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycles", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycles", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycles", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycles", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycles", "onDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == REQUEST_CODE){
                String username = data.getStringExtra("user");
                String age = data.getExtras().getString("age");
                Toast.makeText(this, "Username is :"+username+" Age is : "+age, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
