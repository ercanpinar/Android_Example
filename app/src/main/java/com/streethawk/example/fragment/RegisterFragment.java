package com.streethawk.example.fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.streethawk.example.R;
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

        fragmentRegisterBinding.buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragmentRegisterBinding.formEditTextName.testValidity() && fragmentRegisterBinding.formEditTextEmail.testValidity())
                    saveNewPerson();
            }
        });

        return fragmentRegisterBinding.getRoot();
    }

    private void saveNewPerson() {



    }
}
