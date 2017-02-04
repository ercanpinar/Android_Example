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
import com.streethawk.example.databinding.FragmentPostListBinding;
import com.streethawk.example.service.ServiceManager;
import com.streethawk.example.service.listener.ResponseListener;
import com.streethawk.example.service.response.BaseResponse;
import com.streethawk.example.service.response.PostListResponse;
import com.streethawk.example.util.Util;

import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * Created by ercanpinar on 03/02/2017.
 */

public class PostListFragment extends Fragment implements ResponseListener{

    private FragmentPostListBinding fragmentPostListBinding;

    private Activity mActivity;
    private ServiceManager mServiceManager;


    public PostListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mActivity = (MainActivity)getActivity();

        fragmentPostListBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_post_list, container, false);


        if(!Util.internetConnectionCheck(mActivity))
            Util.messageShow(mActivity,getString(R.string.message_internet_connection), Style.INFO);


        mServiceManager =  new ServiceManager(mActivity,this);
        try {
            mServiceManager.userListRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fragmentPostListBinding.getRoot();
    }

    @Override
    public void returnResponse(BaseResponse response) {
        if(response !=null){
            PostListResponse postListResponse = (PostListResponse) response;



        }else{
            Util.messageShow(mActivity,getString(R.string.error_general), Style.ALERT);
        }
    }
}
