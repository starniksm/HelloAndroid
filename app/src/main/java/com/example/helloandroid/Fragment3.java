package com.example.helloandroid;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.helloandroid.databinding.Fragment3Binding;

import java.util.ArrayList;


public class Fragment3 extends Fragment implements SelectedItem{
    private final ArrayList<Shoes> shoes = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Fragment3Binding binding = Fragment3Binding.inflate(getLayoutInflater());
        createData();
        AdapterRecyclerView adapter = new AdapterRecyclerView(getContext(), shoes, this);
        binding.recyclerView.setAdapter(adapter);
        return binding.getRoot();
    }

    public void createData(){
        for (int i = 1; i <= 200; ++i)
            shoes.add(new Shoes("Обувь " + i));
    }

    @Override
    public void onItemClicked(Shoes shoes) {
        Toast.makeText(getContext(), shoes.toString(), Toast.LENGTH_SHORT).show();
        Log.i("shoesOnClick", shoes.toString());
    }

}