package com.example.pratik.dashboard;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.ProgrammingViewHolder>{
    private String[] data;
    public ProgrammingAdapter(String[] data)
    {        this.data = data; }
    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_layout_textmessage,parent,false);
        return new ProgrammingViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder programmingViewHolder, int position) {
        String title = data[position];
        programmingViewHolder.txtview.setText(title);
    }
    @Override
    public int getItemCount() {        return data.length;    }
    public class ProgrammingViewHolder extends RecyclerView.ViewHolder {
        TextView txtview;
        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);
            txtview = itemView.findViewById(R.id.textName);
        }
    }
}
