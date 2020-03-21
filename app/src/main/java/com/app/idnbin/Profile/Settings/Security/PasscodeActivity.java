package com.app.idnbin.Profile.Settings.Security;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.app.idnbin.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PasscodeActivity extends AppCompatActivity {

    @BindView(R.id.SPasscode) Switch SPasscode;
    @BindView(R.id.btn_set_pass) Button btn_set_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passcode);
        ButterKnife.bind(this);

        SPasscode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(PasscodeActivity.this, ""+isChecked, Toast.LENGTH_SHORT).show();
                startActivityForResult(new Intent(PasscodeActivity.this,PasscodeCheckActivity.class),1);
            }
        });
    }

    @OnClick({R.id.btn_set_pass})
    public void setPass(){
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(PasscodeActivity.this,PasscodeCheckActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1)
        {
            if(!data.getStringExtra("strValue").equalsIgnoreCase("Exit"))
            {
                SPasscode.setChecked(true);
                btn_set_pass.setText("Change passcode");
            }
            Toast.makeText(this, ""+data.getStringExtra("strValue"), Toast.LENGTH_SHORT).show();
        }
    }
}
