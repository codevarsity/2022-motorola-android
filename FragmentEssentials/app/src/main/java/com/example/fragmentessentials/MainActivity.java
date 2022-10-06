package com.example.fragmentessentials;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button addFragmentButton;
    Button removeFragmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragmentButton = findViewById(R.id.addFragmentButton);
        addFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFirstFragment();
            }
        });

        removeFragmentButton = findViewById(R.id.removeFragmentButton);
        removeFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeFirstFragment();
            }
        });
    }

    private void removeFirstFragment() {
        //get access to the first fragment
        FirstFragment ff = (FirstFragment)  getSupportFragmentManager().findFragmentByTag("FF");
        if( ff != null ) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.remove(ff);
            transaction.commit();
        }
    }


    private void loadFirstFragment() {
       Fragment ff = FirstFragment.newFragment("This is a message from activity");

        /* add the fragment to activity */
        //create fragment transaction object using fragmentmanager
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //add the fragment to transaction
        transaction.add(R.id.mainLayout, ff, "FF");
        //commit the transaction
        transaction.commit();
    }
}