package com.example.danielyosef.androidapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView myList = (ListView)findViewById(R.id.myList);

        Screen[] array = new Screen[] {
                new Screen("calc", Calc.class),
                new Screen("constrain1", Constrain1.class),
                new Screen("constrain2", Constrain2.class),
                new Screen("constrain3", Constrain3.class),
                new Screen("mybirthday", MyBirthdays.class)
        };

        ArrayAdapter<Screen> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,array);

        myList.setAdapter(ad);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Screen clicked = (Screen) myList.getItemAtPosition(position);
                if(clicked.c == null){
                    Toast.makeText(getBaseContext(), "Activity missing", Toast.LENGTH_LONG).show();
                }else {
                    Intent i = new Intent(getBaseContext(), clicked.c);
                    startActivity(i);
                }
            }

        });

    }

}

class Screen {

    String s;
    Class c;

    public Screen(String s, Class i) {
        this.s = s;
        this.c = i;
    }

    public Class getI() {
        return c;
    }

    public void setI(Class i) {
        this.c = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }


}