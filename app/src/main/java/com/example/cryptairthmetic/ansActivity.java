package com.example.cryptairthmetic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.MessageFormat;

public class ansActivity extends AppCompatActivity {

    TextView ans , totalWay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ans);
        ans = findViewById(R.id.ansText);
        totalWay = findViewById(R.id.TotalWay);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        String a = intent.getStringExtra("way");
        totalWay.setText(MessageFormat.format("{0}{1}", getString(R.string.ways), a));
        ans.setText(str);
    }
}