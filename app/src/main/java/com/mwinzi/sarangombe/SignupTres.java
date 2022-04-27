package com.mwinzi.sarangombe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class SignupTres extends AppCompatActivity {

    Button next3;

    TextInputLayout license;
    TextInputLayout plate;
    TextInputLayout model;
    TextInputLayout color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup_tres);

        next3 = findViewById(R.id.next3);

        license = findViewById(R.id.signup_license);
        plate = findViewById(R.id.signup_plate);
        model = findViewById(R.id.signup_model);
        color = findViewById(R.id.signup_color);

    }

    public void callNext3(View view) {

        if (!validateLicense() | !validatePlate() | !validateModel() | !validateColor()) {
            return;
        }

        String _license = license.getEditText().getText().toString();
        String _plate = plate.getEditText().getText().toString();
        String _model = model.getEditText().getText().toString();
        String _color = color.getEditText().getText().toString();

        //get all values passed from previous screen using Intent
        String _name = getIntent().getStringExtra("name");
        String _id = getIntent().getStringExtra("id");
        String _county = getIntent().getStringExtra("county");
        String _subCounty = getIntent().getStringExtra("sub-county");
        String _ward = getIntent().getStringExtra("ward");
        String _stage = getIntent().getStringExtra("stage");
        String _memberId = getIntent().getStringExtra("membership id");
        String _sacco = getIntent().getStringExtra("sacco");
        String _stageChair = getIntent().getStringExtra("stage chairman");
        String _chairNo = getIntent().getStringExtra("chairman phone");

        Intent intent = new Intent(getApplicationContext(), SignupFin.class);

        //pass all fields to the next activity
        intent.putExtra("name", _name);
        intent.putExtra("id", _id);
        intent.putExtra("county", _county);
        intent.putExtra("sub-county", _subCounty);
        intent.putExtra("ward", _ward);
        intent.putExtra("stage", _stage);
        intent.putExtra("membership id", _memberId);
        intent.putExtra("sacco", _sacco);
        intent.putExtra("stage chairman", _stageChair);
        intent.putExtra("chairman phone", _chairNo);
        intent.putExtra("license", _license);
        intent.putExtra("plate", _plate);
        intent.putExtra("bike model", _model);
        intent.putExtra("color", _color);

        //Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.next3), "transition_next");

        ActivityOptions options = null;
        options = ActivityOptions.makeSceneTransitionAnimation(SignupTres.this, pairs);
        startActivity(intent, options.toBundle());
        finish();

    }

    private boolean validateLicense() {

        String val = license.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            license.setError("please enter rider's license number");
            return false;
        } else {
            license.setError(null);
            license.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validatePlate() {

        String val = plate.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            plate.setError("please enter rider's number plate");
            return false;
        } else {
            plate.setError(null);
            plate.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateModel() {

        String val = model.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            model.setError("please enter rider's bike model");
            return false;
        } else {
            model.setError(null);
            model.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateColor() {

        String val = color.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            color.setError("please enter rider's bike color");
            return false;
        } else {
            color.setError(null);
            color.setErrorEnabled(false);
            return true;
        }

    }

}