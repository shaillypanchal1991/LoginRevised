package com.sample.loginkit.init;

import android.content.Context;

import com.sample.loginkit.utils.StringConstants;

import org.junit.Test;

import static org.junit.Assert.*;

public class RootControllerTest {
    Context context;

    @Test
    public void loadLoginKit() {
        int retryCount = 0;
        String defaulDdomainURL = "https://usermgt-staging.shared-svc.bellmedia.ca";

        RootLoginController rootLoginController = RootLoginController.init();

        rootLoginController.loadLoginKit(context, rootLoginController);


        assertNotNull("Domain URL cannot be null", rootLoginController.customConfiguration.getDomainURL());

        assertEquals("Default Domain url should be", rootLoginController.customConfiguration.getDomainURL(), defaulDdomainURL);

    }


}