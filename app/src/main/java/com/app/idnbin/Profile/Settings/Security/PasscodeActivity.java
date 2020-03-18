package com.app.idnbin.Profile.Settings.Security;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.app.idnbin.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PasscodeActivity extends AppCompatActivity {

    @BindView(R.id.SPasscode) Switch SPasscode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passcode);
        ButterKnife.bind(this);

        SPasscode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(PasscodeActivity.this, ""+isChecked, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PasscodeActivity.this,PasscodeCheckActivity.class));
            }
        });
    }

    @OnClick({R.id.btn_set_pass})
    public void setPass(){
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(PasscodeActivity.this,PasscodeCheckActivity.class));
    }
}
