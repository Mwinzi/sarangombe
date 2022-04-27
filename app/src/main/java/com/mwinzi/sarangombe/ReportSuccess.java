package com.mwinzi.sarangombe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ReportSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_success);
    }

    public void callDash2 (View view) {
        startActivity(new Intent(this, Dashboard.class));
        finish();
    }

}