package com.app.idnbin.Profile.Settings.Security;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.idnbin.R;

public class AuthenticationActivity extends AppCompatActivity {

    TextView TvPhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        TvPhoneNumber = findViewById(R.id.TvPhoneNumber);

        TvPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthenticationActivity.this, PhoneNumberActivity.class);
                startActivity(intent);
            }
        });
    }
}
