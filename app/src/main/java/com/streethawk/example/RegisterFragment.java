package com.streethawk.example;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.streethawk.example.databinding.FragmentRegisterBinding;

/**
 * Created by ercanpinar on 03/02/2017.
 */

public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding fragmentRegisterBinding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentRegisterBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_register, container, false);


        return fragmentRegisterBinding.getRoot();
    }
}
