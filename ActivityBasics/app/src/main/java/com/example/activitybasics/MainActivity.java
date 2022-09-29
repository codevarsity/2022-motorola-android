package com.example.activitybasics;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;


class MyObject implements Serializable {

}
public class MainActivity extends AppCompatActivity {

    Button launchSecondButton;
    EditText messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("MainActivity", "onCreate");
        launchSecondButton = findViewById(R.id.button);
        launchSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userMessage = messageEditText.getText().toString();
                Log.i("MainActivity", userMessage);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                //total size of items added to the intent should exceed 1 MB
                intent.putExtra("MESSAGE", userMessage);

                startActivityForResult(intent, 101);
            }
        });

        messageEditText = findViewById(R.id.messageEditText);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity", "onDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( requestCode == 101 && resultCode == RESULT_OK && data != null) {
            String message = data.getExtras().getString("MESSAGE_FROM_SECOND");
            Log.i("MainActivity", message);
        }
    }
}