package com.example.imagedownloader;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private String imageLink = "https://seeklogo.com/images/A/android-logo-8F906C4135-seeklogo.com.png";
    ImageView imageView;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        handler = new Handler(getMainLooper());
    }



    private Bitmap getImage() {

        try {
            URL url = new URL(imageLink);
            URLConnection connection = url.openConnection();
            InputStream inStr = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inStr);
            return bitmap;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void download(View view) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Bitmap image = getImage();
                if(image != null) {
                    Log.i("MainActivity", "Image download complete");

                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageBitmap(image);
                        }
                    };
                    handler.post(runnable);

                }
            }
        };

       ExecutorService service = Executors.newFixedThreadPool(10);
       service.execute(runnable);
   }
}