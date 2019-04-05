package com.technosantra.seminarandroid;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        CheckBox chkStatus = findViewById(R.id.chkStatus);
        chkStatus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean isCheck = isChecked;
                Toast.makeText(ButtonActivity.this, "Status is : "+isCheck, Toast.LENGTH_SHORT).show();
            }
        });

        RadioGroup rgStatus = findViewById(R.id.rgStatus);
        rgStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rdAvailable:
                        Toast.makeText(ButtonActivity.this, "Status is : Available", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdNotAvailable:
                        Toast.makeText(ButtonActivity.this, "Status is : Not Available", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        Switch switchStatus = findViewById(R.id.switchStatus);
        switchStatus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ButtonActivity.this, "Status is : "+isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ButtonActivity.this, "Status is : "+isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton fabStatus = findViewById(R.id.fabStatus);
        fabStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "Floationg Action Button is : Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
