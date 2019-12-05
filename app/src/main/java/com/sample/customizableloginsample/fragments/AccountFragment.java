package com.sample.customizableloginsample.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sample.customizableloginsample.R;
import com.sample.customizableloginsample.adapters.ProfileRecyclerViewAdapter;
import com.sample.customizableloginsample.storage.DataStore;
import com.sample.customizableloginsample.utils.GridItemSpacingDecorator;
import com.sample.loginkit.models.Profile;

import com.sample.loginkit.network.apiUtils.DataRepository;


import java.util.List;

/* Showing profiles of the users in account fragment */

public class AccountFragment extends Fragment implements ProfileRecyclerViewAdapter.profileClickListener {
    List<Profile> profiles;
    RecyclerView _profileRecyclerview;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);
        profiles = DataStore.getInstance().get_profileList();
        _profileRecyclerview = (RecyclerView) view.findViewById(R.id.profileRecyclerView);


        _profileRecyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        _profileRecyclerview.addItemDecoration(new GridItemSpacingDecorator(2, dpToPx(10), true));
        _profileRecyclerview.setItemAnimator(new DefaultItemAnimator());


        populateData(profiles);


        return view;
    }

    private void populateData(List<Profile> profiles) {

        if (profiles.size() > 0) {
            ProfileRecyclerViewAdapter profileRecyclerViewAdapter = new ProfileRecyclerViewAdapter(profiles, this);

            _profileRecyclerview.setAdapter(profileRecyclerViewAdapter);
        }


    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));

    }


    @Override
    public void onProfileClicked(Profile profile) {

    }


}
