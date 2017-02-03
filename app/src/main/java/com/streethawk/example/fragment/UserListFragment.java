package com.streethawk.example.fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.streethawk.example.R;
import com.streethawk.example.databinding.FragmentListBinding;

/**
 * Created by ercanpinar on 03/02/2017.
 */

public class UserListFragment extends Fragment {

    private FragmentListBinding fragmentListBinding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentListBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_list, container, false);


        
        return fragmentListBinding.getRoot();
    }
}
