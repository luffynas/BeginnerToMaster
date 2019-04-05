package com.technosantra.seminarandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String user = getIntent().getStringExtra("user");
        String age = getIntent().getStringExtra("age");

        //Ubah Data, dan kirimkan
        final String username = user+" Aga";
        final String ages = "Umur 12";

        Button btnSendBack = findViewById(R.id.btnSendBack);
        btnSendBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Kirim data ke MainActivity.java
                Intent intent = new Intent();
                intent.putExtra("user", username);
                intent.putExtra("age", ages);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
