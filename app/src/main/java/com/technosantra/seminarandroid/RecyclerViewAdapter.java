package com.technosantra.seminarandroid;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M. Nashrulloh on 05/04/19.
 * at PT. Ansvia
 * contact us blankcd3@gmail.com or mohammad.nashrulloh@ansvia.com
 */
class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder>{
    List<String> mData = new ArrayList<>();

    public RecyclerViewAdapter(List<String> data) {
        mData.addAll(data);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.txtData.setText(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder{
    TextView txtData;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        txtData = itemView.findViewById(R.id.txtData);
    }
}