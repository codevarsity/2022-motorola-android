package com.example.unittestessentials;


interface NetworkUtils {
    boolean callLoginAPI(String username, String password);
}

class NetworkUtilsImpl implements NetworkUtils {

    @Override
    public boolean callLoginAPI(String username, String password) {
        //talk to the login web service
        return true;
    }
}

public class LoginUtil {

    NetworkUtils networkUtils;

    LoginUtil(NetworkUtils networkUtils) {
        this.networkUtils = networkUtils;
    }

    boolean login(String username, String password) {
        return networkUtils.callLoginAPI(username, password);
    }
}
