package com.example.helloandroid;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.helloandroid.databinding.FragmentSecondBinding;


public class SecondFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSecondBinding binding = FragmentSecondBinding.inflate(getLayoutInflater());
        binding.buttonUndo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Fragment fragment = new MainFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();


                Bundle result = new Bundle();
                result.putString("secondFragment", binding.editText2.getText().toString());
                getParentFragmentManager().setFragmentResult("dataFromSecondFragment", result);


                transaction.replace(R.id.main_container, fragment);
                transaction.commit();
            }
        });
        return  binding.getRoot();
    }

}