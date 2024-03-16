package com.example.helloandroid;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Shoes> items;
    private SelectedItem selectedItem;

    AdapterRecyclerView(Context context, List<Shoes> items, SelectedItem selectedItem) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
        this.selectedItem = selectedItem;
    }

    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                             int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterRecyclerView.ViewHolder holder, int position) {
        Shoes item = items.get(position);
        holder.textView.setText(item.getName());
        holder.imageView.setImageResource(R.drawable.shoes);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItem.onItemClicked(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        final ImageView imageView;

        ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textViewItemName);
            imageView = view.findViewById(R.id.imageViewItemImage);
        }
    }
}
