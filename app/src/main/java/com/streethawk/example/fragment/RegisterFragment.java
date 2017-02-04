package com.streethawk.example.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.streethawk.example.R;
import com.streethawk.example.activity.MainActivity;
import com.streethawk.example.databinding.FragmentRegisterBinding;
import com.streethawk.example.util.Util;

/**
 * Created by ercanpinar on 03/02/2017.
 */

public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding fragmentRegisterBinding;

    public RegisterFragment() {
    }

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

        fragmentRegisterBinding.buttonShowAllRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(new UserListFragment());
            }
        });

        return fragmentRegisterBinding.getRoot();
    }

    private void saveNewPerson() {



    }

}
