package com.app.idnbin.Profile.Settings.Security;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.idnbin.R;

public class SecurityActivity extends AppCompatActivity implements View.OnClickListener {

    TextView TvAuthentication, TvPasscode, TvActivesessions, TvChangePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);

        TvAuthentication = findViewById(R.id.TvAuthentication);
        TvPasscode = findViewById(R.id.TvPasscode);
        TvActivesessions = findViewById(R.id.TvActivesessions);
        TvChangePassword = findViewById(R.id.TvChangePassword);

        TvAuthentication.setOnClickListener(this);
        TvPasscode.setOnClickListener(this);
        TvActivesessions.setOnClickListener(this);
        TvChangePassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.TvAuthentication:
                Intent intent = new Intent(this, AuthenticationActivity.class);
                startActivity(intent);
                break;
            case R.id.TvPasscode:
                Intent intentPasscode = new Intent(this, PasscodeActivity.class);
                startActivity(intentPasscode);
                break;
            case R.id.TvActivesessions:
                Intent intentActive = new Intent(this, ActiveSessionsActivity.class);
                startActivity(intentActive);
                break;
            case R.id.TvChangePassword:
                Intent intentChangePass = new Intent(this, ChangePasswordActivity.class);
                startActivity(intentChangePass);
                break;
        }
    }
}
