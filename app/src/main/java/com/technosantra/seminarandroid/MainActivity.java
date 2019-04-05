package com.technosantra.seminarandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycles", "onCreate");

        Button btnText = findViewById(R.id.btnText);
        Button btnButton = findViewById(R.id.btnButton);
        Button btnContainer = findViewById(R.id.btnContainer);

        btnText.setOnClickListener(this);
        btnButton.setOnClickListener(this);
        btnContainer.setOnClickListener(this);
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnText:
                startActivity(new Intent(MainActivity.this, TextActivity.class));
                break;
            case R.id.btnButton:
                startActivity(new Intent(MainActivity.this, ButtonActivity.class));
                break;
            case R.id.btnContainer:
                startActivity(new Intent(MainActivity.this, ContainerActivity.class));
                break;
        }
    }
}
