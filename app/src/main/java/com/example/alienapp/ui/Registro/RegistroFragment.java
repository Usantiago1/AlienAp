package com.example.alienapp.ui.Registro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.alienapp.databinding.FragmentLoginBinding;
import com.example.alienapp.databinding.FragmentRegistroBinding;

public class RegistroFragment extends Fragment {
    private FragmentRegistroBinding binding;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RegistroViewModel registroViewModel =
                new ViewModelProvider(this).get(RegistroViewModel.class);
        binding = FragmentRegistroBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final TextView ApellidoPaterno = binding.ApellidoPaterno;
        registroViewModel.getText().observe(getViewLifecycleOwner(), ApellidoPaterno::setText);

        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}
