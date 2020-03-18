package com.app.idnbin.Profile.Settings.Security;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.app.idnbin.R;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;

public class PasscodeCheckActivity extends AppCompatActivity {

    @BindView(R.id.editText1)
    TextInputEditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passcode_check);


    }
}
