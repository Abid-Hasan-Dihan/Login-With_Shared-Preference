package com.example.loginwithsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText phone;
    TextInputEditText pin;
    Button LoginBtn;
    TextView SignUpBackTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        phone = findViewById(R.id.LoginPhoneNumberId);
        pin = findViewById(R.id.LoginPinId);
        LoginBtn = findViewById(R.id.LoginButtonId);

        //memory Type. we can store data in static form. Temporary Data store
        final SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);

        //Checking phone and pin which we already store in shared preference is it matching or not
        final String type = sharedPreferences.getString("Phone","");
        if (type.isEmpty()){
            Toast.makeText(LoginActivity.this, "Please Login", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(LoginActivity.this,LogoutActivity.class);
            startActivity(intent);
        }

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Store value by calling commit using Shared Preference and start new activity
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Phone",phone.getText().toString());
                editor.putString("Pin",pin.getText().toString());
                editor.commit();

                Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this,LogoutActivity.class);
                startActivity(intent);
            }
        });
    }
}