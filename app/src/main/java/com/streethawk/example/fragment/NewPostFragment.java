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

import com.streethawk.example.databinding.FragmentNewPostBinding;
import com.streethawk.example.service.ServiceManager;
import com.streethawk.example.service.listener.ResponseListener;
import com.streethawk.example.service.response.BaseResponse;
import com.streethawk.example.util.Util;

import java.util.HashMap;
import java.util.Map;

import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * Created by ercanpinar on 03/02/2017.
 */

/**
 * **** NewPost Create and Send Page ****
 */

public class NewPostFragment extends Fragment implements ResponseListener {

    /**
     * ******** Declare Used Variables ********
     */
    private FragmentNewPostBinding fragmentNewPostBinding;
    private Activity mActivity;
    private ServiceManager mServiceManager;


    /**
     * ******** CustomFragment Constructor ********
     */
    public NewPostFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mActivity = (MainActivity) getActivity();

        fragmentNewPostBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_new_post, container, false);

        if (!Util.internetConnectionCheck(mActivity))
            Util.messageShow(mActivity, getString(R.string.message_internet_connection), Style.INFO);

        mServiceManager = new ServiceManager(mActivity, this);


        fragmentNewPostBinding.buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fragmentNewPostBinding.formEditTextTitle.testValidity() && fragmentNewPostBinding.formEditTextBody.testValidity())
                    sendNewPost();
            }
        });

        fragmentNewPostBinding.buttonShowAllRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).replaceFragment(new PostListFragment());
            }
        });

        return fragmentNewPostBinding.getRoot();
    }

    /**
     * ********* SendNewPost  *********
     */
    private void sendNewPost() {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("title", fragmentNewPostBinding.formEditTextTitle.getText().toString());
        paramMap.put("body", fragmentNewPostBinding.formEditTextBody.getText().toString());
        try {
            mServiceManager.sendNewPostRequest(paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * ********* ReturnResponse ********
     *
     * @param response BaseResponse -> NewPostResponse
     */
    @Override
    public void returnResponse(BaseResponse response) {
        if (response != null) {
            //NewPostResponse registerResponse = (NewPostResponse) response;
            Util.messageShow(mActivity, getString(R.string.new_post_success), Style.CONFIRM);
        } else {
            Util.messageShow(mActivity, getString(R.string.error_general), Style.ALERT);
        }
    }
}
