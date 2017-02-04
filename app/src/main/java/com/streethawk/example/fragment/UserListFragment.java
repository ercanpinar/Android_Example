package com.streethawk.example.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.streethawk.example.R;
import com.streethawk.example.activity.MainActivity;
import com.streethawk.example.databinding.FragmentListBinding;
import com.streethawk.example.service.ServiceManager;
import com.streethawk.example.util.Util;

import java.util.List;

import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * Created by ercanpinar on 03/02/2017.
 */

public class UserListFragment extends Fragment {

    private FragmentListBinding fragmentListBinding;

    private Activity mActivity;
    private ServiceManager mServiceManager;


    public UserListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mActivity = (MainActivity)getActivity();

        fragmentListBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_list, container, false);


        if(!Util.internetConnectionCheck(mActivity))
            Util.messageShow(mActivity,getString(R.string.error_internet_connection), Style.ALERT);


        return fragmentListBinding.getRoot();
    }
}
