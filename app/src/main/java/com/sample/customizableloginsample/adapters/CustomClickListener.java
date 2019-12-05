package com.sample.customizableloginsample.adapters;


import com.sample.loginkit.models.Profile;


/* Gives callback when a particular profile is clicked in the Profiles View */

public interface CustomClickListener {
    void cardClicked(Profile f);
}