package com.example.persistanceessentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void write(View view) {
        FileOutputStream fileOut = null;
        //create a file
        try {
            String message = "Hello World!!";
            fileOut = openFileOutput("test.txt", MODE_PRIVATE);
            fileOut.write(message.getBytes());
            fileOut.flush();
            fileOut.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeSharedPreference(View view) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("showImages", true);
        editor.putInt("level", 10);
        editor.commit();

    }

    public void readSharedPreference(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean i = prefs.getBoolean("showImages", true);
        int j = prefs.getInt("level", 0);


        Log.i("MainActivity", i + " " + j);
    }
}