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

public class SignupOne extends AppCompatActivity {

    Button next;


    TextInputLayout name;
    TextInputLayout id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup_one);

        next = findViewById(R.id.next);

        name = findViewById(R.id.signup_name);
        id = findViewById(R.id.signup_id);

    }

    public void callNext(View view) {

        if (!validateName() | !validateId()) {
            return;
        }

        String _name = name.getEditText().getText().toString();
        String _id = id.getEditText().getText().toString();

        Intent intent = new Intent(getApplicationContext(), SignupTwo.class);

        //pass all fields to the next activity
        intent.putExtra("name", _name);
        intent.putExtra("id", _id);

        //Add Transition
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.next), "transition_next");

        ActivityOptions options = null;
        options = ActivityOptions.makeSceneTransitionAnimation(SignupOne.this, pairs);
        startActivity(intent, options.toBundle());
        finish();

    }

    private boolean validateName() {

        String val = name.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            name.setError("please enter your names");
            return false;
        } else if (val.length() > 20) {
            name.setError("Names are too long");
            return false;
        } else if (val.length() < 3) {
            name.setError("Name is too short");
            return false;
        } else {
            name.setError(null);
            name.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateId() {

        String val = id.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            id.setError("please enter national id number");
            return false;
        } else if (val.length() > 8) {
            id.setError("Registration number is too long");
            return false;
        } else if (val.length() < 8) {
            id.setError("Registration number is too short");
            return false;
        } else {
            id.setError(null);
            id.setErrorEnabled(false);
            return true;
        }

    }

}