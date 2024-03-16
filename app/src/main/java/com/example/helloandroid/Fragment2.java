package com.example.helloandroid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.helloandroid.databinding.Fragment2Binding;

import java.util.ArrayList;


public class Fragment2 extends Fragment {

    private ArrayList<Clothes> clothes = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Fragment2Binding binding = Fragment2Binding.inflate(getLayoutInflater());
        createData();;
        AdapterListView adapterListView = new AdapterListView(getContext(), R.layout.item, clothes);
        binding.listView1.setAdapter(adapterListView);
        binding.listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), clothes.get(position).toString(),
                        Toast.LENGTH_SHORT).show();
                Log.i("clothOnClick", clothes.get(position).toString());
            }
        });
        return binding.getRoot();
    }

    public void createData(){
        for (int i = 1; i <= 200; ++i)
            clothes.add(new Clothes("Верхняя одежда " + i));
    }
}