package com.example.danielyosef.androidapps;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SharedPreferences ani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView myList = (ListView) findViewById(R.id.myList);

        Screen[] array = new Screen[]{
                new Screen("calc", Calc.class),
                new Screen("constrain1", Constrain1.class),
                new Screen("constrain2", Constrain2.class),
                new Screen("constrain3", Constrain3.class),
                new Screen("mybirthday", MyBirthdays.class)
        };

        ArrayAdapter<Screen> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);

        myList.setAdapter(ad);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Screen clicked = (Screen) myList.getItemAtPosition(position);
                if (clicked.c == null) {
                    Toast.makeText(getBaseContext(), "Activity missing", Toast.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(getBaseContext(), clicked.c);
                    startActivity(i);
                }
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int selectedID = item.getItemId();
        if (selectedID == R.id.Settings) {
            Intent i = new Intent(MainActivity.this, Settings.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    public void PicAnimation() {

        ani = this.getSharedPreferences("com.example.danielyosef.androidapps", Context.MODE_PRIVATE);
        String Title = ani.getString("animation Type", "");
        if (Title.equals("slide")) {
            overridePendingTransition(R.animator.slide_up_animation, R.animator.slide_down_animation);
        } else if (Title.equals("zoom")) {
            overridePendingTransition(R.animator.zoom_in_activity, R.animator.zoom_out_activity);
        } else if (Title.equals("fade")) {
            overridePendingTransition(R.animator.fade_in_animation, R.animator.fade_out_animation);
        } else {
            return;
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
}