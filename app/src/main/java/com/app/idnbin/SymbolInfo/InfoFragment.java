package com.app.idnbin.SymbolInfo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.app.idnbin.R;

public class InfoFragment extends Fragment {

    public InfoFragment() {
        // Required empty public constructor
    }

    SeekBar SbTrader, SbMinutes, SbHour, SbDay, SbWeek, SbMonth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        SbTrader = view.findViewById(R.id.SbTrader);
        SbMinutes = view.findViewById(R.id.SbMinutes);
        SbHour = view.findViewById(R.id.SbHour);
        SbDay = view.findViewById(R.id.SbDay);
        SbWeek = view.findViewById(R.id.SbWeek);
        SbMonth = view.findViewById(R.id.SbMonth);

        SbTrader.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar));
        SbMinutes.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_back));
        SbHour.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_back));
        SbDay.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_back));
        SbWeek.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_back));
        SbMonth.setProgressDrawable(getResources().getDrawable(R.drawable.progress_bar_back));

        return view;
    }
}
