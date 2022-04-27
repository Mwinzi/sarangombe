package com.mwinzi.sarangombe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupFin extends AppCompatActivity {

    Button next4;
    Button next5;

    //Get Data Variables
    TextInputLayout phoneNo;
    TextInputLayout passwords;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    String name, id, county, sub, ward, stage, memberId, sacco, chair, chairNo, license, plate, model, color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup_fin);


        next4 = findViewById(R.id.next4);
        next5 = findViewById(R.id.next5);

        //Hooks for getting data
        phoneNo = findViewById(R.id.signup_phone);
        passwords = findViewById(R.id.signup_password);

        next4.setOnClickListener(view -> {

            next5.setEnabled(true);

            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("riders");

            //get all values passed from previous screen using Intent
            name = getIntent().getStringExtra("name");
            id = getIntent().getStringExtra("id");
            county = getIntent().getStringExtra("county");
            sub = getIntent().getStringExtra("sub-county");
            ward = getIntent().getStringExtra("ward");
            stage = getIntent().getStringExtra("stage");
            memberId = getIntent().getStringExtra("membership id");
            sacco = getIntent().getStringExtra("sacco");
            chair = getIntent().getStringExtra("stage chairman");
            chairNo = getIntent().getStringExtra("chairman phone");
            license = getIntent().getStringExtra("license");
            plate = getIntent().getStringExtra("plate");
            model = getIntent().getStringExtra("model");
            color = getIntent().getStringExtra("color");

            String phone = phoneNo.getEditText().getText().toString();
            String pass = passwords.getEditText().getText().toString();

            RiderHelperClass helperClass = new RiderHelperClass(name, id, county, sub, ward, stage, memberId, sacco, chair, chairNo, license, plate, model, color, phone, pass);
            reference.child(id).setValue(helperClass);


            next4.setText(" ");

        });

        next5.setOnClickListener(view -> sendData());

    }

    public void sendData() {

        String phone = phoneNo.getEditText().getText().toString();

        String text = "Name: " + name + "\nID No: " + id + "County: " + county + "\nSub-County: " + sub + "Ward: " + ward +
                "\nStage: " + stage + "Membership Id: " + memberId + "\nSacco: " + sacco + "Stage Chairman: " + chair +
                "\nChairman phone: " + chairNo + "License Number: " + license + "\nBike Number Plate: " + plate +
                "Bike Model: " + model + "\nBike color: " + color + "Phone Number: " + phone;

        Intent intent = new Intent(getApplicationContext(), QrGenerator.class);

        intent.putExtra("text", text);

        startActivity(intent);


    }



}