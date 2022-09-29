package com.example.applicationbasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent = new Intent(this, FileDownloaderService.class);
//        startService(intent);

//        FileDownloaderService service = new FileDownloaderService();
//        service.onCreate();


    }

    public void makePhoneCall(View view) {
        //implict intent
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);

    }

    public void launchMain(View view) {
        //explicit intent
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void takePhoto(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }
}