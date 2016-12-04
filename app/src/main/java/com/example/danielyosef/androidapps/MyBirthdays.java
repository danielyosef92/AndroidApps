package com.example.danielyosef.androidapps;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.danielyosef.androidapps.Database.DbopenHelper;

public class MyBirthdays extends AppCompatActivity {

    EditText Name, Bday, Comment;
    Context context;
    DbopenHelper dbopenhelper;
    SQLiteDatabase sqliteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_birthdays);

        Name = (EditText) findViewById(R.id.editTxtName);
        Bday = (EditText) findViewById(R.id.editTxtDate);
        Comment = (EditText) findViewById(R.id.editTxtComment);
    }



    public void addBirthDay (View view){

        String name = Name.getText().toString();
        String bday = Bday.getText().toString();
        String comment = Comment.getText().toString();
        dbopenhelper = new DbopenHelper(context);
        sqliteDatabase = dbopenhelper.getWritableDatabase();
        dbopenhelper.addInformations(name,bday,comment,sqliteDatabase);
        Toast.makeText(getBaseContext(), "Data saved", Toast.LENGTH_LONG).show();
        dbopenhelper.close();
    }




}
