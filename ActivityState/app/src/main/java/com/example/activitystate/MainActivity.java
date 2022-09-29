package com.example.activitystate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items = new ArrayList<String>();
    TextView textView;
    Button addTaskButton;

    void initializeTasks() {
        items.add("Get Milk");
        items.add("Attend Training");
    }

    void updateUI() {
        textView.setText(getStringFromArrayList(items));
    }

    String getStringFromArrayList(ArrayList<String> items) {
        StringBuilder strBuilder = new StringBuilder();
        for( String item : items) {
            strBuilder.append(item);
            strBuilder.append("\n");
        }

        return strBuilder.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "onCreate");

        if(savedInstanceState == null) {
            initializeTasks();
        } else {
            items = savedInstanceState.getStringArrayList("ITEMS");
        }

        textView = findViewById(R.id.textView);

        addTaskButton = findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = "New Task";
                items.add(item);
                updateUI();
            }
        });

        updateUI();

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("MainActivity", "onSaveInstanceState");
        outState.putStringArrayList("ITEMS", items);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity", "onDestroy");
    }
}