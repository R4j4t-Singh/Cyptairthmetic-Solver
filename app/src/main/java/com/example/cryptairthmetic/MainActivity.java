package com.example.cryptairthmetic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    cryptairthmetic_addition add;
    Cryptairthmetic_divison div;
    Cryptarithmetic_subs subs;
    Cryptarithmetic_multi mul;
    EditText str1, str2, str3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = new cryptairthmetic_addition();
        div = new Cryptairthmetic_divison();
        subs = new Cryptarithmetic_subs();
        mul = new Cryptarithmetic_multi();
        str1 = findViewById(R.id.String1);
        str2 = findViewById(R.id.String2);
        str3 = findViewById(R.id.String3);

    }

    public void addition(View view) {

        String s1 = Objects.requireNonNull(str1.getText().toString().trim());
        String s2 = Objects.requireNonNull(str2.getText().toString().trim());
        String s3 = Objects.requireNonNull(str3.getText().toString().trim());
        hide(view);
        if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
            showInfo();
        } else {

            String s = add.solver(s1, s2, s3);
            String c = String.valueOf(add.ans);
            Intent intent = new Intent(this, ansActivity.class);
            intent.putExtra("message_key", s);
            intent.putExtra("way", c);
            startActivity(intent);
        }

    }

    public void divison(View view) {

        String s1 = Objects.requireNonNull(str1.getText().toString().trim());
        String s2 = Objects.requireNonNull(str2.getText().toString().trim());
        String s3 = Objects.requireNonNull(str3.getText().toString().trim());
        hide(view);
        if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
            showInfo();
        } else {
            String s = div.solver(s1, s2, s3);
            String c = String.valueOf(div.ans);
            Intent intent = new Intent(this, ansActivity.class);
            intent.putExtra("message_key", s);
            intent.putExtra("way", c);
            startActivity(intent);
        }
    }

    public void subtraction(View view) {

        String s1 = Objects.requireNonNull(str1.getText().toString().trim());
        String s2 = Objects.requireNonNull(str2.getText().toString().trim());
        String s3 = Objects.requireNonNull(str3.getText().toString().trim());
        hide(view);

        if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
            showInfo();
        } else {
            String s = subs.solver(s1, s2, s3);
            String c = String.valueOf(subs.ans);
            Intent intent = new Intent(this, ansActivity.class);
            intent.putExtra("message_key", s);
            intent.putExtra("way", c);
            startActivity(intent);
        }
    }

    public void multiplication(View view) {
        String s1 = Objects.requireNonNull(str1.getText().toString().trim());
        String s2 = Objects.requireNonNull(str2.getText().toString().trim());
        String s3 = Objects.requireNonNull(str3.getText().toString().trim());
        hide(view);

        if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
            showInfo();
        } else {

            String s = mul.solver(s1, s2, s3);
            String c = String.valueOf(mul.ans);
            Intent intent = new Intent(this, ansActivity.class);
            intent.putExtra("message_key", s);
            intent.putExtra("way", c);
            startActivity(intent);
        }
    }

    public void hide(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void showInfo() {

        Snackbar.make(str1, R.string.app_info, Snackbar.LENGTH_LONG)
                .show();
    }
}