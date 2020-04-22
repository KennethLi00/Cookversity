package com.example.cookversity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class NutritionWeb extends AppCompatActivity {
    private WebView webView;
    private TextView webTitle;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_web);

//      https://zocada.com/using-intents-extras-pass-data-activities-android-beginners-guide/
//      Used website to retrieve data from previous intent
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");

        webView = findViewById(R.id.wvPage);
        webTitle = findViewById(R.id.tvWebTitle);
        back = findViewById(R.id.ivBack);

        webView.loadUrl(url);
        webTitle.setText(title);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
