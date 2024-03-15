package com.example.helloandroid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helloandroid.databinding.FragmentExternalBinding;



public class ExternalFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentExternalBinding binding = FragmentExternalBinding.inflate(getLayoutInflater());
        Fragment internalFragment = new InternalFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.internalFragment, internalFragment).commit();
        getChildFragmentManager().setFragmentResultListener("dataFromFragment2",
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
                getChildFragmentManager().setFragmentResult("dataFromFragment1", result);
            }
        });
        return binding.getRoot();
    }
}