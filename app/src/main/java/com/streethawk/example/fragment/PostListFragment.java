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
import com.streethawk.example.adapter.PostArrayAdapter;
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

public class PostListFragment extends Fragment implements ResponseListener {
    /**
     * ******** Declare Used Variables ********
     */
    private FragmentPostListBinding fragmentPostListBinding;
    private Activity mActivity;
    private ServiceManager mServiceManager;

    /**
     * ******** CustomFragment Constructor ********
     */
    public PostListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mActivity = (MainActivity) getActivity();

        fragmentPostListBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_post_list, container, false);


        if (!Util.internetConnectionCheck(mActivity))
            Util.messageShow(mActivity, getString(R.string.message_internet_connection), Style.INFO);

        /****** GetPostList ServiceCall ******/
        mServiceManager = new ServiceManager(mActivity, this);
        try {
            mServiceManager.postListRequest();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fragmentPostListBinding.getRoot();
    }

    /**
     * ********* ReturnResponse ********
     *
     * @param response BaseResponse -> PostListResponse
     */
    @Override
    public void returnResponse(BaseResponse response) {
        if (response != null) {
            PostListResponse postListResponse = (PostListResponse) response;

            PostArrayAdapter postArrayAdapter = new PostArrayAdapter(mActivity, postListResponse.getPostList());
            fragmentPostListBinding.listViewPostList.setAdapter(postArrayAdapter);


        } else {
            Util.messageShow(mActivity, getString(R.string.error_general), Style.ALERT);
        }
    }
}
