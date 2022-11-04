package com.example.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.List;

public class StringConcatImpl extends Service {
    public StringConcatImpl() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return new IStringConcat.Stub() {

           @Override
           public String concat(List<String> items) throws RemoteException {
               StringBuilder builder = new StringBuilder();
               for(String item : items) {
                   builder.append(item);
               }
               return builder.toString();
           }
       };
    }
}