package com.sample.loginkit.network.interactor;

import com.sample.loginkit.utils.StringConstants;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProfileLoginParamsTest {
    String granttype="password";
    String username="protik";
    String password="poc";
    String profileid="2673bjhhsd";
    int profilepin=888;

    @Test
    public void createInstance() {

        ProfileLoginInteractor.createInstance(granttype,username,password,profileid,profilepin);

        assertEquals("Grant type should be password", StringConstants.PASSWORD,granttype);
        assertNotNull("Username cannot be null",username);
        assertNotNull("Password cannot be null",password);
        assertNotNull("Profile ID  cannot be null",profileid);
        assertTrue("Profile pin should be of 4 digits", profilepin>999 && profilepin < 10000);


    }
}