package com.example.activitybasics;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button backButton;
    TextView userMessageTextView;

    EditText secondEditText;
    Button sendToMainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String message = "";
        //get access to the launching intent
        if (getIntent().getExtras() != null) {
            message = getIntent().getExtras().getString("MESSAGE");
            Log.i("SecondActivity", message);
        }

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        userMessageTextView = findViewById(R.id.userMessageTextView);
        userMessageTextView.setText(message);

        secondEditText = findViewById(R.id.secondEditText);
        sendToMainButton = findViewById(R.id.sendDataToMainButton);
        sendToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userMessage = secondEditText.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("MESSAGE_FROM_SECOND", userMessage);

                //send the intent to the parent
                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });
    }
}