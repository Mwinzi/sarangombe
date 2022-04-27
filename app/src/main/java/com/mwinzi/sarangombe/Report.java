package com.mwinzi.sarangombe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

    }

    public void callReport2 (View view) {
        startActivity(new Intent(this, ReportSuccess.class));
        finish();
    }

}