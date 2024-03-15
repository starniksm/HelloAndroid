package com.example.helloandroid;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.helloandroid.databinding.Fragment1Binding;


public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Fragment1Binding binding = Fragment1Binding.inflate(getLayoutInflater());
        getParentFragmentManager().setFragmentResultListener("dataFromFragment2",
                this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                binding.textFromF2.setText(result.getString("Fragment2"));
            }
        });
        binding.buttonToFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                result.putString("Fragment1", binding.editText1.getText().toString());
                getParentFragmentManager().setFragmentResult("dataFromFragment1", result);
            }
        });
        return binding.getRoot();
    }
}