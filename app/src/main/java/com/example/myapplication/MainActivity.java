package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;
    TextView btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);

        btnLogin.setOnClickListener(v -> {

            String user = etUsername.getText().toString().trim().toLowerCase();
            String pass = etPassword.getText().toString().trim();

            SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            String registeredUser = sharedPreferences.getString("username", "").trim().toLowerCase();
            String registeredPass = sharedPreferences.getString("password", "").trim();
            String registeredName = sharedPreferences.getString("name", "Jaspreet Singh");

            if ((user.equals("jaspreet") && pass.equals("1")) ||
                (!registeredUser.isEmpty() && user.equals(registeredUser) && pass.equals(registeredPass))) {
                
                String displayName = user.equals("manpreet||admin") ? "jaspreet singh Singh" : registeredName;
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainUiActivity.class);
                intent.putExtra("USER_NAME", displayName);
                startActivity(intent);
                finish();
            } else {
                String debugMsg = "Entered: '" + user + "' | '" + pass + "'\nRegistered: '" + registeredUser + "'";
                Toast.makeText(this, debugMsg, Toast.LENGTH_LONG).show();
            }

        });

        btnSignup.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SignupActivity.class);
            startActivity(intent);
        });
    }
}