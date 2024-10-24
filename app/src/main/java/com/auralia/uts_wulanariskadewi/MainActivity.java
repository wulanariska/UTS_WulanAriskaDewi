package com.auralia.uts_wulanariskadewi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Declaration of UI components
    private TextView Hasil;
    private EditText Masukan;
    private Button Eksekusi;

    // Declaration and initialization of SharedPreferences
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing UI components
        Masukan = findViewById(R.id.input);
        Hasil = findViewById(R.id.output);
        Eksekusi = findViewById(R.id.save);

        // Creating a new SharedPreferences file
        preferences = getSharedPreferences("BelajarSharedPreferences", Context.MODE_PRIVATE);

        Eksekusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
                Toast.makeText(getApplicationContext(), "Data Tersimpan", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getData() {
        // Get input from the user
        String getKonten = Masukan.getText().toString();

        // Configuring SharedPreferences
        editor = preferences.edit();

        // Putting data into SharedPreferences
        editor.putString("data_saya", getKonten);
        editor.apply();

        // Displaying output
        Hasil.setText("Output Data: " + preferences.getString("data_saya", null));
    }
}