package com.technosantra.seminarandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class TextActivity extends AppCompatActivity {
    private static final String[] COUNTRIES = new String[] {
            "D.I.Yogyakarta", "Solo", "Klaten", "Wonosobo", "Semarang"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        AutoCompleteTextView txtAutoComplete = findViewById(R.id.txtAutoComplete);
        txtAutoComplete.setThreshold(1);
        txtAutoComplete.setAdapter(adapter);

    }

}
