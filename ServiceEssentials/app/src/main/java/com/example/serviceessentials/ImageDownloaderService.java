package com.example.serviceessentials;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class ImageDownloaderService extends IntentService {

    public ImageDownloaderService() {
        super("ImageDownloaderService");
    }

    Bitmap getImage(String imageLink) {
        try {
            URL url = new URL(imageLink);
            URLConnection connection = url.openConnection();
            InputStream inStr = connection.getInputStream();
            Bitmap image = BitmapFactory.decodeStream(inStr);
            return image;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void writeImageToFile(Bitmap image) {
        String fileName = "downloadedImage";
        try {
            FileOutputStream fout = openFileOutput(fileName, MODE_PRIVATE);
            image.compress(Bitmap.CompressFormat.JPEG, 90, fout);
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String link = intent.getStringExtra("LINK");
            Bitmap image = getImage(link);
            if(image != null) {
                Log.i("ImageDownloaderService", "onHandleIntent: Image Downloaded Successfully");
                writeImageToFile(image);
                Intent serviceIntent = new Intent("com.example.serviceessentials.IMAGE");
                serviceIntent.putExtra("IMAGE_NAME", "downloadedImage");
                sendBroadcast(serviceIntent);


            }


        }
    }


}