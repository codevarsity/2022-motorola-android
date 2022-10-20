package com.example.serviceessentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ImageReceiver receiver = new ImageReceiver();

    class ImageReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String fileName = intent.getStringExtra("IMAGE_NAME");
            try {
                FileInputStream fin = openFileInput(fileName);
                Bitmap image = BitmapFactory.decodeStream(fin);
                imageView.setImageBitmap(image);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.serviceessentials.IMAGE");

        //register the broadcast receiver with the Android System
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
    }

    public void download(View view) {
        Intent intent = new Intent(this, ImageDownloaderService.class);

        //intent.putExtra("LINK", "https://seeklogo.com/images/A/android-logo-8F906C4135-seeklogo.com.png");
        intent.putExtra("LINK", "https://chandra.harvard.edu/photo/2009/galactic/galactic.jpg");
        startService(intent);
    }
}