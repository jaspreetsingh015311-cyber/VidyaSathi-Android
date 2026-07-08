package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainUiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainui);

        TextView tvUserName = findViewById(R.id.tvUserName);
        String name = getIntent().getStringExtra("USER_NAME");
        if (name != null && !name.isEmpty()) {
            tvUserName.setText(name);
            
        }
    }
}
