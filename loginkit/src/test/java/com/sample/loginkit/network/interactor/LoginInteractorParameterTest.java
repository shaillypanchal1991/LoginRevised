package com.sample.loginkit.network.interactor;

import com.sample.loginkit.utils.StringConstants;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginInteractorParameterTest {

    @Test
    public void createInstance() {
        String token = "";
        String username = null;
        String password = null;
        String granttype = "";

        LoginInteractor.createInstance(token, granttype, username, password);
        assertNotNull("Username cannot be null",username);
        assertNotNull("Password cannot be null",password);
        assertNotNull("Token cannot be null",token);
        assertEquals("Grant type has to be password", StringConstants.GRANTTYPE,"password");







    }


}