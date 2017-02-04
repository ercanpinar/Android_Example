package com.streethawk.example.fragment;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.streethawk.example.R;
import com.streethawk.example.activity.MainActivity;
import com.streethawk.example.databinding.FragmentRegisterBinding;
import com.streethawk.example.service.listener.ResponseListener;
import com.streethawk.example.service.response.BaseResponse;
import com.streethawk.example.util.Util;

import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * Created by ercanpinar on 03/02/2017.
 */

public class RegisterFragment extends Fragment implements ResponseListener{

    private FragmentRegisterBinding fragmentRegisterBinding;
    private Activity mActivity;

    public RegisterFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mActivity = (MainActivity)getActivity();

        fragmentRegisterBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_register, container, false);

        if(!Util.internetConnectionCheck(mActivity))
            Util.messageShow(mActivity,getString(R.string.error_internet_connection), Style.ALERT);

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

    @Override
    public void returnResponse(BaseResponse response) {
        if(response !=null){

        }else{
            Util.messageShow(mActivity,getString(R.string.error_general), Style.ALERT);
        }
    }
}
