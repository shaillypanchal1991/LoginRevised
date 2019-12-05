package com.sample.loginkit.network.interactor;

import org.junit.Test;

import static org.junit.Assert.*;

public class RefreshTokenParamsTest {
String refreshToken="";
String granttype="refresh_token";



    @Test
    public void createInstance() {
        RefreshTokenInteractor.createInstance(refreshToken,granttype);

        assertNotNull("Refresh token cant be null",refreshToken);
        assertEquals("Grant Type has to be refresh_token","refresh_token",granttype);


    }
}