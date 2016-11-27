package com.example.danielyosef.androidapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Calc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clac);
        String title = "Sum Of Two Numbers";
        setTitle(title);
    }

    public void Sum(View view) {
        Intent intent = new Intent(this, Sum.class);
        EditText firstNum = (EditText) findViewById(R.id.first_num);
        EditText secNum = (EditText) findViewById(R.id.second_num);
        String first = firstNum.getText().toString();
        String sec = secNum.getText().toString();
        intent.putExtra("FIRST_NUMBER",  String.valueOf(first));
        intent.putExtra("SEC_NUMBER", String.valueOf(sec));
        startActivity(intent);
    }

}