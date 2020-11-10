package com.example.reto2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.reto2.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView titleTV;
    private TextView usernameTV;
    private EditText usernameET;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTV = findViewById(R.id.titleTV);
        usernameTV = findViewById(R.id.usernameTV);
        usernameET = findViewById(R.id.usernameET);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.loginBtn:
                Intent i = new Intent(this, MyPokemonActivity.class);
                startActivity(i);
                break;
        }
    }
}