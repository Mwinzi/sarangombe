package com.mwinzi.sarangombe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QrGenerator extends AppCompatActivity {

    TextView tvCode;
    Button btGenerate;
    Button fin;
    ImageView ivOutput;

    String details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_generator);

        tvCode = findViewById(R.id.tv_code);
        btGenerate = findViewById(R.id.bt_generate);
        ivOutput = findViewById(R.id.iv_output);
        details = getIntent().getStringExtra("text");

        tvCode.setText(details);

        btGenerate.setOnClickListener(view -> {

            fin.setEnabled(true);
            String sText = tvCode.getText().toString().trim();

            MultiFormatWriter writer = new MultiFormatWriter();

            try {
                BitMatrix matrix = writer.encode(sText, BarcodeFormat.QR_CODE, 400, 400);

                BarcodeEncoder encoder = new BarcodeEncoder();

                Bitmap bitmap = encoder.createBitmap(matrix);

                ivOutput.setImageBitmap(bitmap);
                btGenerate.setText(" ");

                InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(tvCode.getApplicationWindowToken(), 0);

            } catch (WriterException e) {
                e.printStackTrace();
            }


        });

    }

    public void callDash (View view) {
        startActivity(new Intent(this, Dashboard.class));
        finish();
    }

}