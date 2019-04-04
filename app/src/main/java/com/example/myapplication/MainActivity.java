package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private int Counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        final TextView et_ToGo = (TextView) findViewById(R.id.et_ToGo);
        final ImageButton ib_increment = (ImageButton) findViewById(R.id.ib_increment);
        final TextView tv_status = (TextView) findViewById(R.id.tv_status);

        ib_increment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // interacting with the Progressbar
                progressBar.onSaveInstanceState();
                Counter = Counter + 1;
                progressBar.setProgress(Counter);
                progressBar.setMax(10);

                //Calculating the percentage of hydration
                Integer percentage;
                percentage = (Counter * 10);
                tv_status.setText(Integer.toString(percentage) + "%");
                percentage++;

                //Changing the value of daily drank cups
                et_ToGo.setText(Integer.toString(Counter));

                if (Counter >= 11) {
                    Toast toast = Toast.makeText(getApplicationContext(), "You're overdoing it now, stop it!!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL, -400, -400);
                    toast.show();
                }
            }
        });
    }
}