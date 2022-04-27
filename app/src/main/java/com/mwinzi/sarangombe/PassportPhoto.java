package com.mwinzi.sarangombe;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PassportPhoto extends AppCompatActivity {

    Button button;
    ImageView imageView;
    int SELECT_IMAGE_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passport_photo);

        button = findViewById(R.id.btn_pick);
        imageView = findViewById(R.id.pickedImage);

        button.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent,"Title"), SELECT_IMAGE_CODE);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1) {
            Uri uri = data.getData();
            imageView.setImageURI(uri);
            button.setText("Done");

        }

    }

    public void callDash3 (View view) {
        startActivity(new Intent(this, Dashboard.class));
        finish();
    }

}