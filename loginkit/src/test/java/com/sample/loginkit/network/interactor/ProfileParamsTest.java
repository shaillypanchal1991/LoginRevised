package com.sample.loginkit.network.interactor;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProfileParamsTest {
String token="sdfsdf";
    @Test
    public void createInstance() {

        ProfileInteractor.createInstance(token);
        assertNotNull("Access token cannot be null",token);


    }
}