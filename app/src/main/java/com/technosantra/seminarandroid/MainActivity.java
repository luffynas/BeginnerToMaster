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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycles", "onCreate");

        Button btnLinearLayout = findViewById(R.id.btnLinearLayout);
        Button btnRelativeLayout = findViewById(R.id.btnRelativeLayout);
        Button btnConstraintLayout = findViewById(R.id.btnConstraintLayout );

        btnLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LinearLayoutActivity.class));
            }
        });

        btnLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RelativeLayoutActivity.class));
            }
        });

        btnLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ConstraintLayoutActivity.class));
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
}
