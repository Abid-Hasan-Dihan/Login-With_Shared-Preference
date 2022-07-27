package com.example.loginwithsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LogoutActivity extends AppCompatActivity {

    Button LogOutButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        LogOutButton = findViewById(R.id.LogoutButtonId);

        //memory Type. we can store data in static form. Temporary Data store
        final SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);

        LogOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();

                Toast.makeText(LogoutActivity.this, "Logout successfully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(LogoutActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }
}