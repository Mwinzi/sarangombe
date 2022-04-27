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

public class SignupTwo extends AppCompatActivity {

    Button next2;

    TextInputLayout county;
    TextInputLayout subCounty;
    TextInputLayout ward;
    TextInputLayout stage;
    TextInputLayout memberId;
    TextInputLayout sacco;
    TextInputLayout stageChair;
    TextInputLayout chairNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup_two);

        next2 = findViewById(R.id.next2);

        county = findViewById(R.id.signup_county);
        subCounty = findViewById(R.id.signup_sub);
        ward = findViewById(R.id.signup_ward);
        stage = findViewById(R.id.signup_stage);
        memberId = findViewById(R.id.signup_memberId);
        sacco = findViewById(R.id.signup_sacco);
        stageChair = findViewById(R.id.signup_chair);
        chairNo = findViewById(R.id.signup_chair_no);

    }

    public void callNextPili(View view) {

        if (!validateCounty() | !validateSubCounty() | !validateWard() | !validateStage() | !validateMemberId() | !validateSacco() | !validateStageChair() | !validateChairPhone()) {
            return;
        }

        String _county = county.getEditText().getText().toString();
        String _subCounty = subCounty.getEditText().getText().toString();
        String _ward = ward.getEditText().getText().toString();
        String _stage = stage.getEditText().getText().toString();
        String _memberId = memberId.getEditText().getText().toString();
        String _sacco = sacco.getEditText().getText().toString();
        String _stageChair = stageChair.getEditText().getText().toString();
        String _chairNo = chairNo.getEditText().getText().toString();

        //get all values passed from previous screen using Intent
        String _name = getIntent().getStringExtra("name");
        String _id = getIntent().getStringExtra("id");

        Intent intent = new Intent(getApplicationContext(), SignupTres.class);

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

        //Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.next2), "transition_next");

        ActivityOptions options = null;
        options = ActivityOptions.makeSceneTransitionAnimation(SignupTwo.this, pairs);
        startActivity(intent, options.toBundle());
        finish();

    }

    private boolean validateCounty() {

        String val = county.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            county.setError("please enter rider's county");
            return false;
        } else {
            county.setError(null);
            county.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateSubCounty() {

        String val = subCounty.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            subCounty.setError("please enter rider's sub county");
            return false;
        } else {
            subCounty.setError(null);
            subCounty.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateWard() {

        String val = ward.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            ward.setError("please enter rider's ward");
            return false;
        } else {
            ward.setError(null);
            ward.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateStage() {

        String val = stage.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            stage.setError("please enter rider's stage");
            return false;
        } else {
            stage.setError(null);
            stage.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateMemberId() {

        String val = memberId.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            memberId.setError("please enter rider's memberId");
            return false;
        } else {
            memberId.setError(null);
            memberId.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateSacco() {

        String val = sacco.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            sacco.setError("please enter rider's sacco");
            return false;
        } else {
            sacco.setError(null);
            sacco.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateStageChair() {

        String val = stageChair.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            stageChair.setError("please enter rider's stage chairman");
            return false;
        } else {
            stageChair.setError(null);
            stageChair.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateChairPhone() {

        String val = chairNo.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            chairNo.setError("please enter rider's memberId");
            return false;
        } else {
            chairNo.setError(null);
            chairNo.setErrorEnabled(false);
            return true;
        }

    }

}