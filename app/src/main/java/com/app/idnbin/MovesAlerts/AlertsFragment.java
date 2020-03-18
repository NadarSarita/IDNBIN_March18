package com.app.idnbin.MovesAlerts;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.app.idnbin.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static com.facebook.FacebookSdk.getApplicationContext;

public class AlertsFragment extends DialogFragment {
    FloatingActionButton floating_action_button;
    RecyclerView recyclerview_alerts;
    AlertAdapter alertAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alerts, container, false);

        floating_action_button = view.findViewById(R.id.floating_action_button);
        recyclerview_alerts =view.findViewById(R.id.recyclerview_alerts);

        floating_action_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
                View dialogView = inflater.inflate(R.layout.alert_dialogbox, null);
                dialogBuilder.setView(dialogView);


                Button btnSave = dialogView.findViewById(R.id.btnSave);
                Button btnCancel = dialogView.findViewById(R.id.btnCancel);
                EditText editAsset = dialogView.findViewById(R.id.tv_asset);
                EditText editValue = dialogView.findViewById(R.id.tv_value);
                AlertDialog alertDialog = dialogBuilder.create();
                String asset = editAsset.getText().toString();
                String value = editValue.getText().toString();
                editValue.getText().toString();
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ArrayList<String> alertList = new ArrayList<>();
                        alertList.add(asset);
                        alertList.add(value);

                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerview_alerts.setLayoutManager(mLayoutManager);
                        alertAdapter = new AlertAdapter(getContext(),alertList);
                        recyclerview_alerts.setAdapter(alertAdapter);

                        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                        alert.setTitle("Set Alerts");
                        alert.setMessage("Notify me when Ripple Price reaches 0.2354789");
                        alert.setPositiveButton("OK",null);
                        alert.show();
                        alertDialog.dismiss();



                    }
                });


                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });

        return view;

    }


}



