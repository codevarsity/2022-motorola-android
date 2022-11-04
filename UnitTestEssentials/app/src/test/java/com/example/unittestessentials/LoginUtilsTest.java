package com.example.unittestessentials;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

class NetworkUtilMock implements NetworkUtils{
    @Override
    public boolean callLoginAPI(String username, String password) {
        if (username.equalsIgnoreCase("amit") &&
                password.equalsIgnoreCase("1234")) {
            return true;
        }
        return false;
    }
}


public class LoginUtilsTest {

    LoginUtil loginUtil;

    @Before
    public void setUp() throws Exception {
        NetworkUtils nUtils = new NetworkUtilMock();
        loginUtil = new LoginUtil(nUtils);
    }

    @Test
    public void login_EmptyString_ReturnsFalse() {
        assertFalse(loginUtil.login("", ""));
    }

    @Test
    public void login_IncorrectCredentials_ReturnsFalse() {
        assertFalse(loginUtil.login("a", "1"));
    }

    @Test
    public void login_CorrectCredentials_ReturnsTrue() {
        assertTrue(loginUtil.login("amit", "1234"));
    }
}
