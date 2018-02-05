package com.example.josimuddin.recyclview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v7.recyclerview.R.styleable.RecyclerView;

/**
 * Created by JosimUddin on 20/10/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<DataModel> dataSet;

    public CustomAdapter(ArrayList<DataModel>data){
        this.dataSet = data;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardslayout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        view.setOnClickListener(MainActivity.myOnClickListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TextView textViewName = holder.textViewName, textViewVersion=holder.textViewVersion;
        ImageView imageViewIcon= holder.imageViewIcon;

        textViewName.setText(dataSet.get(position).getName());
        textViewVersion.setText(dataSet.get(position).getVersion());
        imageViewIcon.setImageResource(dataSet.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewVersion;
        ImageView imageViewIcon;
        public MyViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewVersion = itemView.findViewById(R.id.android_version);
            imageViewIcon = itemView.findViewById(R.id.image_view);
        }
    }

}
