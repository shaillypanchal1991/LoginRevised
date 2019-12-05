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


/*Dummy data  Horizontal Sports RecyclerView for Home Fragment */

public  class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder> {
    private Context context;
    private ArrayList<Sport> _sportsList;
    private float rowwidth;


    public class HorizontalViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView thumbnail;
        public LinearLayout llmain;

        public HorizontalViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.txtName);
            thumbnail = view.findViewById(R.id.imgItem);
            llmain = view.findViewById(R.id.llmain);
        }
    }


    public HorizontalAdapter(Context context, ArrayList<Sport> sportsList, float getwidthonepercent) {
        this.context = context;
        _sportsList=sportsList;
        rowwidth=getwidthonepercent;


    }

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizontal_item, parent, false);

        return new HorizontalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, final int position) {
        final Sport sport = _sportsList.get(position);


        holder.llmain.getLayoutParams().width = (int) rowwidth;

        Glide.with(context)
                .load(sport.getImgURL())

                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return _sportsList.size();
    }
}
