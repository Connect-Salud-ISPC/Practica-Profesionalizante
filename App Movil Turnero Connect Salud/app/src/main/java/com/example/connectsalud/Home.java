package com.example.connectsalud;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.content.Context;

public class Home extends AppCompatActivity {

    private long pacienteId;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
        pacienteId = sharedPreferences.getLong("PACIENTE_ID", -1);
    }

    public void launchProfile(View view) {
        Intent intent = new Intent(this, Profile.class);
        intent.putExtra("PACIENTE_ID", pacienteId);
        startActivity(intent);
    }

    public void launchReserve(View view) {
        Intent intent = new Intent(this, Reserve.class);
        startActivity(intent);
    }