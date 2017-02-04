package com.streethawk.example.service;

import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.streethawk.example.R;
import com.streethawk.example.module.Post;
import com.streethawk.example.service.listener.JsonReturnListener;
import com.streethawk.example.service.listener.ResponseListener;
import com.streethawk.example.service.response.NewPostResponse;
import com.streethawk.example.service.response.PostListResponse;
import com.streethawk.example.util.Util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * Created by ercanpinar on 03/02/2017.
 */

public class ServiceManager implements JsonReturnListener {

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

        createRequest(Constant.SERVICE_POST_LIST_URL, Request.Method.GET,null,false);

    }


    /**
     * Create Request
     * */
    private CustomRequest jsonObjectRequest;
    private CustomArrayRequest jsonArrayRequest;
    private RequestQueue requestQueue;

    private void createRequest(String URL, final int reqType, Map<String, String> params){
        createRequest(URL,reqType, params,true);
    }

    private void createRequest(String URL, final int reqType, Map<String, String> params, boolean isRequestJsonObject) {

        if(!Util.internetConnectionCheck(mActivity)) {
            Util.messageShow(mActivity, mActivity.getString(R.string.error_internet_connection), Style.ALERT);
            return;
        }

        progresShow();


        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mActivity);
        }

        if(isRequestJsonObject){
            jsonObjectRequest = new CustomRequest(reqType, URL, params, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    progressDissmis();

                    callBackJsonObject(response);
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

            requestQueue.add(jsonObjectRequest);
        }else{
            jsonArrayRequest = new CustomArrayRequest(reqType, URL, params, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    progressDissmis();

                   callBackJsonArray(response);
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
            requestQueue.add(jsonArrayRequest);
        }

    }

    /**
     * Response - Callback
     * */
    @Override
    public void callBackJsonObject(JSONObject jsonObject) {

        progressDissmis();

        if(jsonObject == null){
            Util.messageShow(mActivity, mActivity.getString(R.string.error_general), Style.ALERT);
            return;
        }

        switch (requestTypeEnum) {
            case NEWPOST:
                registerResponse(jsonObject);
                break;
            default:
                registerResponse(jsonObject);
                break;
        }

    }


    @Override
    public void callBackJsonArray(JSONArray jsonArray) {
        progressDissmis();

        if(jsonArray == null){
            Util.messageShow(mActivity, mActivity.getString(R.string.error_general), Style.ALERT);
            return;
        }

        switch (requestTypeEnum) {
            case POSTLIST:
                userListResponse(jsonArray);
                break;
            default:
                userListResponse(jsonArray);
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
    private void userListResponse(JSONArray jsonArray) {

        Gson gson = new Gson();
        String jsonOutput = jsonArray.toString();
        Type listType = new TypeToken<ArrayList<Post>>(){}.getType();
        ArrayList<Post> posts = (ArrayList<Post>) gson.fromJson(jsonOutput, listType);

        responseListener.returnResponse(new PostListResponse(posts));
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

