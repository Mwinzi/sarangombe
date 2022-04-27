package com.mwinzi.sarangombe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void sign (View view) {
        startActivity(new Intent(this, SignupOne.class));
    }

    public void precise (View view) {
        startActivity(new Intent(this, RidePrecise.class));
    }

    public void report (View view) {
        startActivity(new Intent(this, Report.class));
    }



}