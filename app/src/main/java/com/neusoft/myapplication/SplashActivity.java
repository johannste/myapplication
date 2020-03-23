package com.neusoft.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Formatter;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private int i = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final TextView tv_skip = findViewById(R.id.tv_skip);

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    if (i <= 0) {
                        doFinish(timer);
                    } else {
                        SpannableString count = new SpannableString(new Formatter().format("跳过 %ds", i--).toString());
                        count.setSpan(new ForegroundColorSpan(Color.rgb(247, 57, 63)), 3, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        tv_skip.setText(count);
                    }
                });
            }
        };
        timer.schedule(timerTask, 0, 1000);

        tv_skip.setOnClickListener((view) -> doFinish(timer));
    }

    void doFinish(Timer timer) {
        timer.cancel();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
