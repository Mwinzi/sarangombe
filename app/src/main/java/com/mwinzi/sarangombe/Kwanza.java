package com.mwinzi.sarangombe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Kwanza extends AppCompatActivity {

    private static final int SPLASH_TIMER = 5000;

    ImageView backgroundImage;
    TextView poweredByLine;

    Animation levitateAnim, sideAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_kwanza);

        backgroundImage = findViewById(R.id.logo);
        poweredByLine = findViewById(R.id.powered_by_line);

        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        levitateAnim = AnimationUtils.loadAnimation(this, R.anim.levitate_anim);

        backgroundImage.setAnimation(sideAnim);
        poweredByLine.setAnimation(levitateAnim);

        new Handler().postDelayed(() -> {

            Intent intent = new Intent(getApplicationContext(), Dashboard.class);
            startActivity(intent);
            finish();
        },SPLASH_TIMER);

    }
}