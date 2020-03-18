package com.app.idnbin.Portfolio.Closed;


import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;

import com.app.idnbin.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClosedFragment extends Fragment implements View.OnClickListener {

    RelativeLayout layoutclosed;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_closed, container, false);

        layoutclosed = v.findViewById(R.id.layoutclosed);

        layoutclosed.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        AlertDialog balancedialog = new AlertDialog.Builder(getContext()).create();
        balancedialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        balancedialog.setView(getLayoutInflater().inflate(R.layout.layout_result_dialog, null));
        balancedialog.show();
    }
}
