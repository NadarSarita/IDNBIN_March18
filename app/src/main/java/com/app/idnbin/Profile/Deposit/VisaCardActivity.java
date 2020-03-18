package com.app.idnbin.Profile.Deposit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.app.idnbin.R;


public class VisaCardActivity extends AppCompatActivity implements View.OnClickListener {
    TextView TvAmt ,TvAmt1,TvAmt2,TvAmt3,TvAmt4,TvAmt5;
    EditText ETAmount;
    Spinner SpAmount_visa;
    Button btn_visa_deposit;
    String spinnertext, first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visa_card);


        TvAmt=findViewById(R.id.TvAmt);
        TvAmt1=findViewById(R.id.TvAmt1);
        TvAmt2=findViewById(R.id.TvAmt2);
        TvAmt3=findViewById(R.id.TvAmt3);
        TvAmt4=findViewById(R.id.TvAmt4);
        TvAmt5=findViewById(R.id.TvAmt5);
        ETAmount=findViewById(R.id.ETAmount);
        SpAmount_visa=findViewById(R.id.SpAmount_visa);
        btn_visa_deposit=findViewById(R.id.btn_visa_deposit);


        TvAmt.setOnClickListener(this);
        TvAmt1.setOnClickListener(this);
        TvAmt2.setOnClickListener(this);
        TvAmt3.setOnClickListener(this);
        TvAmt4.setOnClickListener(this);
        TvAmt5.setOnClickListener(this);
        ETAmount.setOnClickListener(this);
        btn_visa_deposit.setOnClickListener(this);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_text, getResources().getStringArray(R.array.currency));
        adapter.setDropDownViewResource(R.layout.spinner_text);
        SpAmount_visa.setAdapter(adapter);
        SpAmount_visa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                spinnertext = SpAmount_visa.getSelectedItem().toString();
                first = spinnertext.substring(0, spinnertext.length() / 2);

                {
                    switch (position) {
                        case 0: // for item 1
                            TvAmt1.setText(first+"250");
                            TvAmt2.setText(first+"500");
                            TvAmt3.setText(first+"1000");
                            TvAmt4.setText(first+"3000");
                            TvAmt5.setText(first+"5000");
                            btn_visa_deposit.setText("DEPOSIT " +""+first+ "" +ETAmount.getText().toString());
                            break;

                        case 1: // for item 1
                            TvAmt1.setText(first+"250");
                            TvAmt2.setText(first+"500");
                            TvAmt3.setText(first+"1000");
                            TvAmt4.setText(first+"3000");
                            TvAmt5.setText(first+"5000");
                            btn_visa_deposit.setText("DEPOSIT " +""+first+ "" +ETAmount.getText().toString());
                            break;

                        case 2:
                            TvAmt1.setText(first+"250");
                            TvAmt2.setText(first+"500");
                            TvAmt3.setText(first+"1000");
                            TvAmt4.setText(first+"3000");
                            TvAmt5.setText(first+"5000");
                            btn_visa_deposit.setText("DEPOSIT " +""+first+ "" +ETAmount.getText().toString());
                            break;
                        case 3:
                            TvAmt1.setText("250" +first);
                            TvAmt2.setText("500" +first);
                            TvAmt3.setText("1000" +first);
                            TvAmt4.setText("3000" +first);
                            TvAmt5.setText("5000" +first);
                            btn_visa_deposit.setText("DEPOSIT " +ETAmount.getText().toString()+""+first);
                            break;



                    }
                }
                // your code here
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(VisaCardActivity.this, "", Toast.LENGTH_SHORT).show();
                // your code here
            }

        });



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.TvAmt1:
                ETAmount.setText("250");
                btn_visa_deposit.setText("DEPOSIT " +""+first+ "" +ETAmount.getText().toString());
                break;
            case R.id.TvAmt2:
                ETAmount.setText("500");
                btn_visa_deposit.setText("DEPOSIT " +""+first+ "" +ETAmount.getText().toString());
                break;
            case R.id.TvAmt3:
                ETAmount.setText("1000");
                btn_visa_deposit.setText("DEPOSIT " +""+first+ "" +ETAmount.getText().toString());
                break;
            case R.id.TvAmt4:
                ETAmount.setText("3000");
                btn_visa_deposit.setText("DEPOSIT " +""+first+ "" +ETAmount.getText().toString());
                break;
            case R.id.TvAmt5:
                ETAmount.setText("5000");
                btn_visa_deposit.setText("DEPOSIT " +""+first+ "" +ETAmount.getText().toString());
                break;
        }

    }
}
