package com.app.idnbin.Profile.Settings.Security;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.idnbin.LoginRegister.VerifyPhoneActivity;
import com.app.idnbin.R;
import com.app.idnbin.util.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AuthenticationActivity extends BaseActivity {

    @BindView(R.id.TvPhoneNumber) TextView TvPhoneNumber;
    @BindView(R.id.rlayuout1) RelativeLayout rlayuout1;
    @BindView(R.id.rlayuout2) RelativeLayout rlayuout2;
    @BindView(R.id.et_phone) EditText et_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.TvPhoneNumber,R.id.BtnNext})
    public void authClick(View view){
        switch (view.getId()){
            case R.id.TvPhoneNumber:
                rlayuout1.setVisibility(View.GONE);
                rlayuout2.setVisibility(View.VISIBLE);
                break;
            case R.id.BtnNext:
                String mobile_no = et_phone.getText().toString();
                if (mobile_no.isEmpty() || mobile_no.length() < 10) {
                    et_phone.setError("Enter Valid Mobile Number");
                    et_phone.requestFocus();
                    return;
                }
                sendDataToClass(mobile_no,"+91", CodeActivity.class);
                break;
        }
    }
}
