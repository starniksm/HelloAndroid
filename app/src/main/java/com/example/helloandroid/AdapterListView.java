package com.example.helloandroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class AdapterListView extends ArrayAdapter<Clothes> {
    private final LayoutInflater inflater;
    private int layout;
    private final List<Clothes> items;
    public AdapterListView(Context context, int resource, List<Clothes> items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = inflater.inflate(R.layout.item,
                 parent, false);
        TextView textView = view.findViewById(R.id.textViewItemName);
        Clothes cloth = items.get(position);
        textView.setText(cloth.getName());
        ImageView imageView = view.findViewById(R.id.imageViewItemImage);
        imageView.setImageResource(R.drawable.cloth);
        return view;
    }

}
