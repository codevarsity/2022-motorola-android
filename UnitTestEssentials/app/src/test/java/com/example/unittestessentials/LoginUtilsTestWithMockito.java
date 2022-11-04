package com.example.unittestessentials;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginUtilsTestWithMockito {
    LoginUtil loginUtil;

    @Mock
    NetworkUtils networkUtils;

    @Before
    public void setUp() throws Exception {
        when(networkUtils.callLoginAPI("amit", "1234")).thenReturn(true);
        when(networkUtils.callLoginAPI("", "")).thenReturn(false);
        when(networkUtils.callLoginAPI("a", "1")).thenReturn(false);

        loginUtil = new LoginUtil(networkUtils);
    }

    @Test
    public void login_EmptyString_ReturnsFalse() {
        assertFalse(loginUtil.login("", ""));
    }

    @Test
    public void login_IncorrectCredentials_ReturnFalse() {
        assertFalse(loginUtil.login("a", "1"));
    }

    @Test
    public void login_CorrectCredentials_ReturnTrue() {
        assertTrue(loginUtil.login("amit", "1234"));
    }


}
