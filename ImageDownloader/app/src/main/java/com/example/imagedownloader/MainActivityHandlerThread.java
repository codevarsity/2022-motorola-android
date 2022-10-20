package com.example.imagedownloader;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivityHandlerThread extends AppCompatActivity {

    private String imageLink = "https://seeklogo.com/images/A/android-logo-8F906C4135-seeklogo.com.png";
    class ImageDownloaderThread extends HandlerThread {
        Handler handler;

        @Override
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            handler = new Handler(getLooper())  {
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    String link = msg.getData().getString("LINK");
                    if(link != null) {
                        Bitmap image = getImage(link);
                        if(image != null) {
                            Log.i("ImageDownloaderThread", "Image Downloaded Successfully");
                        }
                    }
                }
            };
        }

        private Bitmap getImage(String imageLink) {
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

        public ImageDownloaderThread(String name) {
            super(name);
        }
    }

    ImageDownloaderThread downloaderThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_handler_thread);

        downloaderThread = new ImageDownloaderThread("ImageDownloaderThread");
        downloaderThread.start();
    }

    public void download(View view) {
        Message message = downloaderThread.handler.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putString("LINK", imageLink);
        message.setData(bundle);
        downloaderThread.handler.sendMessage(message);

    }
}