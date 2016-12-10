package com.example.danielyosef.androidapps;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

import static com.example.danielyosef.androidapps.R.id.myList;

public class Settings extends AppCompatActivity {

    TextView animationTextView;
    SharedPreferences ani;
    String ThisAnimation;
    ArrayList<String> array;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        animationTextView = (TextView) findViewById(R.id.animationTypeTextView);
        ani = this.getSharedPreferences("com.example.danielyosef.androidapps", Context.MODE_PRIVATE);
        animationTextView.setText(ani.getString("animation Type",""));
        ListView myList = (ListView)findViewById(R.id.ListAnimation);

        array = new ArrayList<>();
                array.add("fade");
                array.add("zoom");
                array.add("slide");

        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,array);

        myList.setAdapter(ad);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ThisAnimation = array.get(position);
                animationTextView.setText(ThisAnimation);
                ani.edit().putString("animation Type", ThisAnimation).apply();
            }

        });
    }

}
