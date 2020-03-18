package com.app.idnbin.Assets.Digital;


import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;

import com.app.idnbin.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DigitalSymbolFragment extends Fragment {
    LinearLayout LLdigitalsymbol;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_digital_symbol, container, false);

        LLdigitalsymbol = v.findViewById(R.id.LLdigitalsymbol);

        LLdigitalsymbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog optiondialog = new AlertDialog.Builder(getContext()).create();
                optiondialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                optiondialog.setView(getLayoutInflater().inflate(R.layout.layout_option_dialog, null));
                optiondialog.show();
            }

        });

        return v;
    }

}
