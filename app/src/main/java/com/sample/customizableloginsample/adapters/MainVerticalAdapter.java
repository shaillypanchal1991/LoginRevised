package com.sample.customizableloginsample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sample.customizableloginsample.R;
import com.sample.customizableloginsample.models.Sport;

import java.util.ArrayList;

/* Dummy data vertical recyclerview for Home Fragment */
public class MainVerticalAdapter extends RecyclerView.Adapter<MainVerticalAdapter.MyViewHolder> {

    private float rowwidth;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout rootLayout;
        public ImageView thumbnail;


        public MyViewHolder(View view) {
            super(view);
            rootLayout = view.findViewById(R.id.rootLinearLayout);
            thumbnail = view.findViewById(R.id.imgbanner);


        }
    }




    public MainVerticalAdapter(float getwidthonepercent) {

        rowwidth = getwidthonepercent;


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 0) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.mainrecycler_row1, parent, false);

            return new MyViewHolder(itemView);
        } else if (viewType == 1) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.mainrecycler_row2, parent, false);

            return new MyViewHolder(itemView);
        }
        else if(viewType==2){
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.mainrecycler_row3, parent, false);

            return new MyViewHolder(itemView);
        }



        else {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.mainrecycler_row1, parent, false);

            return new MyViewHolder(itemView);
        }

    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        }
        return 0;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {



        if (holder.thumbnail != null) {
            holder.thumbnail.getLayoutParams().height = (int) rowwidth;
        }

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
