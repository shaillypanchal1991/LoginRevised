package com.sample.customizableloginsample.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sample.customizableloginsample.R;
import com.sample.customizableloginsample.storage.DataStore;
import com.sample.customizableloginsample.views.SplashActivity;
import com.sample.loginkit.network.apiUtils.DataRepository;


public class SettingsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        TextView txtLogOut= view.findViewById(R.id.txtlogout);
        txtLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataStore.getInstance().clearUserSessionDetails();
                Intent intent= new Intent(getActivity(), SplashActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }


}
