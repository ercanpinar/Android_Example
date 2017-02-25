package com.ercanpinar.news.fragment;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ercanpinar.news.R;
import com.ercanpinar.news.activity.MainActivity;
import com.ercanpinar.news.adapter.PostArrayAdapter;
import com.ercanpinar.news.databinding.FragmentPostListBinding;
import com.ercanpinar.news.service.ServiceManager;
import com.ercanpinar.news.service.listener.ResponseListener;
import com.ercanpinar.news.service.response.BaseResponse;
import com.ercanpinar.news.service.response.PostListResponse;
import com.ercanpinar.news.util.Util;

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
