package com.example.danielyosef.androidapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myList = (ListView)findViewById(R.id.myList);

        final ArrayList<Screen> IntentArray = new ArrayList<Screen>();

        IntentArray.add(new Screen("calc",new Intent(getApplicationContext(),Calc.class)));
        IntentArray.add(new Screen("constrain1",new Intent(getApplicationContext(),Constrain1.class)));
        IntentArray.add(new Screen("constrain2",new Intent(getApplicationContext(),Constrain2.class)));
        IntentArray.add(new Screen("constrain3",new Intent(getApplicationContext(),Constrain3.class)));


        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,IntentArray);

        myList.setAdapter(ad);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                startActivity(IntentArray.get(position).getI());
            }

        });

    }

}

class Screen {

    String s;
    Intent i;

    public Screen(String s, Intent i) {
        this.s = s;
        this.i = i;
    }

    public Intent getI() {
        return i;
    }

    public void setI(Intent i) {
        this.i = i;
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
