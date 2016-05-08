/**
 * Created by thanhle on 5/8/16.
 */
package com.example.thanhle.googlemapv2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> shoppingList = null;
    ArrayAdapter<String> adapter = null;
    ListView lv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_main);

        Button advanceToMaps = (Button) findViewById(R.id.next_maps);
        advanceToMaps.setOnClickListener((view) -> {
            Button advanceToschedule = (Button) findViewById(R.id.next_schedule);
            advanceToschedule.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(main.this, maps.class);
                    startActivity(intent);
                }

            });

        Button advanceToschedule = (Button) findViewById(R.id.next_schedule);
        advanceToschedule.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View view){
                Intent intent = new Intent(main.this, Schedule.class);
                startActivity(intent);
            }

        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        shoppingList = new ArrayList<>();
        Collections.addAll(shoppingList, "Schedule", "Map");
        shoppingList.addAll(Arrays.asList("Calendar"));
        //  shoppingList.add("Sunscreen");
        //  shoppingList.add("Toothpase");
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, shoppingList);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}