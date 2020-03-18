package com.app.idnbin.Profile.Settings.Security;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app.idnbin.R;

public class ActiveSessionsActivity extends AppCompatActivity {

    RecyclerView Rvactivesessions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_sessions);

        Rvactivesessions = findViewById(R.id.Rvactivesessions);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(ActiveSessionsActivity.this);
        Rvactivesessions.setLayoutManager(layoutManager);
        ActiveAdapter activeAdapter = new ActiveAdapter(ActiveSessionsActivity.this);
        Rvactivesessions.setAdapter(activeAdapter);
    }
}
