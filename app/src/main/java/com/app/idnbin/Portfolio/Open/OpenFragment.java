package com.app.idnbin.Portfolio.Open;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.idnbin.R;

public class OpenFragment extends Fragment {
    ImageView IV_settings;
    TextView tv_showmore;
    RelativeLayout relativeLayout_porfolio;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_open, container, false);

        //IV_settings = v.findViewById(R.id.IV_settings);
       // tv_showmore = v.findViewById(R.id.tv_showmore);
        relativeLayout_porfolio = v.findViewById(R.id.relativeLayout_porfolio);
        /*IV_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PortfolioSettingActivity.class));
            }
        });

        tv_showmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (relativeLayout_porfolio.getVisibility() == View.VISIBLE)
                {
                    relativeLayout_porfolio.setVisibility(View.INVISIBLE);
                }
                else
                {
                    relativeLayout_porfolio.setVisibility(View.VISIBLE);
                }

            }
        });*/

        return v;
    }

}
