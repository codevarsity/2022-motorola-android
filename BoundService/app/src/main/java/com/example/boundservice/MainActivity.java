package com.example.boundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    IStringConcat serviceInterface;
    StringConcatConnection connection;
    class StringConcatConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            serviceInterface = IStringConcat.Stub.asInterface(iBinder);
            Toast.makeText(MainActivity.this, "Service Connected", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            serviceInterface = null;
        }
    }


    public void connect(View view) {
        connection = new StringConcatConnection();
        Intent intent = new Intent(this, StringConcatImpl.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    public void concat(View view) {
        String str1 = "Hello";
        String str2 = "World";
        ArrayList<String> strings = new ArrayList<>();
        strings.add(str1);
        strings.add(str2);

        try {
            String result = serviceInterface.concat(strings);
            Toast.makeText(this, result , Toast.LENGTH_LONG).show();

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}