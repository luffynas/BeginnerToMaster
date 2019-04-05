package com.technosantra.seminarandroid;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycles", "onCreate");

        final DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this);

        final EditText txtNim = findViewById(R.id.txtNim);
        final TextInputEditText txtNama = findViewById(R.id.txtNama);

        Button btnRequest = findViewById(R.id.btnSave);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nim = txtNim.getText().toString();
                String nama = txtNama.getText().toString();

                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setNim(nim);
                mahasiswa.setNama(nama);

                dbHelper.createMahasiswa(mahasiswa);

                txtNim.setText("");
                txtNama.setText("");
            }
        });

        Button btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Mahasiswa> mahasiswaList = dbHelper.getAllMahasiswa();
                for (Mahasiswa mhs : mahasiswaList){
                    Log.d("DATA", "NIM : "+mhs.getNim());
                    Log.d("DATA", "NAMA : "+mhs.getNama());
                    Log.d("DATA", "======================");
                }
            }
        });
    }
}
