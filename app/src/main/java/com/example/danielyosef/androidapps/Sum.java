package com.example.danielyosef.androidapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Sum extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);
        String title = "Two Numbers Sum";
        setTitle(title);

        Intent intent = getIntent();
        int first ;
        int sec ;
        int sum;
        first = Integer.parseInt(intent.getStringExtra("FIRST_NUMBER"));
        sec = Integer.parseInt(intent.getStringExtra("SEC_NUMBER"));
        sum =first+sec;
        Toast.makeText(getApplicationContext(), "sum is = " + (first+sec),Toast.LENGTH_LONG).show();
        TextView textView = (TextView)findViewById(R.id.txtSum);
        textView.setText(String.valueOf(sum));
    }
}