package com.streethawk.example.service;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.streethawk.example.R;
import com.streethawk.example.service.listener.JsonObjectReturnListener;
import com.streethawk.example.service.listener.ResponseListener;
import com.streethawk.example.service.response.NewPostResponse;
import com.streethawk.example.service.response.PostListResponse;
import com.streethawk.example.util.Util;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * Created by ercanpinar on 03/02/2017.
 */

public class ServiceManager implements JsonObjectReturnListener{

    private Activity mActivity;
    private RequestTypeEnum requestTypeEnum;
    private ProgressDialog mProgress;
    private ResponseListener responseListener;


    public ServiceManager(Activity activity, ResponseListener listener){
        this.mActivity = activity;
        this.responseListener = listener;

    }

    /**
     * Requests
     * */
    public void sendNewPostRequest(Map<String, String> paramMap) throws Exception {

        requestTypeEnum = RequestTypeEnum.NEWPOST;

        createRequest(Constant.SERVICE_NEW_POST_URL, Request.Method.POST,paramMap);

    }
    public void userListRequest() throws Exception {

        requestTypeEnum = RequestTypeEnum.POSTLIST;

        createRequest(Constant.SERVICE_POST_LIST_URL, Request.Method.GET,null);

    }


    /**
     * Create Request
     * */
    private CustomRequest jsObjRequest;
    private RequestQueue requestQueue;

    private void createRequest(String URL, final int reqType, Map<String, String> params) {

        if(!Util.internetConnectionCheck(mActivity)) {
            Util.messageShow(mActivity, mActivity.getString(R.string.error_internet_connection), Style.ALERT);
            return;
        }

        progresShow();


        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mActivity);
        }

        jsObjRequest = new CustomRequest(reqType, URL, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                progressDissmis();

                callBackJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDissmis();
                Toast.makeText(mActivity,mActivity.getString(R.string.error_general),Toast.LENGTH_SHORT).show();
            }
        })
        {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }

        };


//        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(
//                45000,
//                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        requestQueue.add(jsObjRequest);
    }

    /**
     * Response - Callback
     * */
    @Override
    public void callBackJson(JSONObject jsonObject) {

        progressDissmis();

        if(jsonObject == null){
            Util.messageShow(mActivity, mActivity.getString(R.string.error_general), Style.ALERT);
            return;
        }

        switch (requestTypeEnum) {
            case NEWPOST:
                registerResponse(jsonObject);
                break;
            case POSTLIST:
                userListResponse(jsonObject);
                break;
        }

    }
    /**
     * Responses
     * */
    private void registerResponse(JSONObject jsonObject) {
        Gson mGson = new Gson();
        NewPostResponse newPostResponse = new NewPostResponse();
        newPostResponse = mGson.fromJson(jsonObject.toString(),NewPostResponse.class);

        responseListener.returnResponse(newPostResponse);
    }
    private void userListResponse(JSONObject jsonObject) {
        Gson mGson = new Gson();
        PostListResponse postListResponse = new PostListResponse();
        postListResponse = mGson.fromJson(jsonObject.toString(),PostListResponse.class);

        responseListener.returnResponse(postListResponse);
    }


    /**
     * Progress
     * */
    public void progresShow() {
        if (mProgress == null) {
            mProgress = Util.createProgressDialog(mActivity);
            mProgress.show();
        } else {
            if(!mProgress.isShowing()){
                mProgress.show();
            }
        }
    }
    public void progressDissmis(){
        if (mProgress != null)
        {
            mProgress.dismiss();
        }
    }

}

