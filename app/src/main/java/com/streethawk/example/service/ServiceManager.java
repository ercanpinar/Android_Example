package com.streethawk.example.service;

/**
 * Created by ercanpinar on 03/02/2017.
 */

public class ServiceManager {


//    Util.internetConnectionCheck(getContext());


    /*public static final String SERVICE_URL="http://sandbox.000.com";

    public static final String SERVICE_LOGIN_URL="/000/login";


    enum RequestType{
        SERVICE_LOGIN_URL
    }
    private Activity mActivity;
    private RequestType requestTypeEnum;
    private ProgressDialog mProgress;
    private ResponseReturnListener listener;

    private DBHelper myDb;

    public ServiceManager(Activity activity, ResponseReturnListener litnr){
        this.mActivity = activity;
        this.listener = litnr;
        myDb = new DBHelper(activity);
    }


    public void login(Map<String, String> paramMap) throws Exception {

        requestTypeEnum = RequestType.SERVICE_LOGIN_URL;

        createRequest(SERVICE_URL+SERVICE_LOGIN_URL,Request.Method.POST,paramMap, HEADER_TYPE.TOKEN_OR_REGISTER,true);

    }

    public enum HEADER_TYPE{
        TOKEN_OR_REGISTER,
        NORMAL
    }

    private CustomRequest jsObjRequest;
    private RequestQueue requestQueue;
    private void createRequest(String URL, final int reqType, Map<String, String> params, final HEADER_TYPE headerType,boolean isProgressDialogShow) {

        if(!((MainActivity)mActivity).internetConnectionCheck()){
            ((MainActivity)mActivity).showMessage(mActivity.getString(R.string.internet_connection_error));
            return;
        }

        if(isProgressDialogShow)
            progresShow();

        Util.trustEveryone();

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

                String json = null;

                NetworkResponse response = error.networkResponse;
                if(response != null && response.data != null){
//                    switch(response.statusCode){
//                        case 400:
//                            json = new String(response.data);
//                            json = trimMessage(json, "errorMessage");
//                            if(json != null) displayMessage(json);
//
//                            break;
//
//                    }

                }

            }
        })
        {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                if(headerType == HEADER_TYPE.TOKEN_OR_REGISTER){
                    //params.put("Content-Type", "application/json");
                }else{
                    //params.put("Content-Type", "application/json");
                    params.put("appAuthToken",  myDb.getLoginValue().getToken());
                }

                return params;
            }

        };
        jsObjRequest.setRetryPolicy(new DefaultRetryPolicy(
                45000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(jsObjRequest);
    }

    //=========================
    @Override
    public void callBackJson(JSONObject jsonObject) {
    }

*//*
    private void loginResponse(JSONObject jsonObject) {
        Gson mGson = new Gson();
        LoginResponse loginResponse = new LoginResponse();

//
        if(jsonObject.toString().contains("errorCode") && jsonObject.toString().contains("errorMessage")) {

            try {
                loginResponse.setErrorCode(jsonObject.getString("errorCode"));
                loginResponse.setErrorMessage(jsonObject.getString("errorMessage"));
            } catch (JSONException e) {
                e.printStackTrace();
                loginResponse.setErrorCode("-1");
                loginResponse.setErrorMessage(mActivity.getResources().getString(R.string.please_try_again_later));
            }
        }else{
            loginResponse = mGson.fromJson(jsonObject.toString(),LoginResponse.class);
        }
        listener.returnResponse(loginResponse,Util.ResponseTypeEnum.LOGIN);
    }
*//*



    private void courierAssignResponse(JSONObject jsonObject) {
        Gson mGson = new Gson();
        CourierAssignResponse courierAssignResponse = new CourierAssignResponse();
        //
        if(jsonObject.toString().contains("errorCode") && jsonObject.toString().contains("errorMessage")) {

            try {
                courierAssignResponse.setErrorCode(jsonObject.getString("errorCode"));
                courierAssignResponse.setErrorMessage(jsonObject.getString("errorMessage"));
            } catch (JSONException e) {
                e.printStackTrace();
                courierAssignResponse.setErrorCode("-1");
                courierAssignResponse.setErrorMessage(mActivity.getResources().getString(R.string.please_try_again_later));
            }
        }else{
            courierAssignResponse = mGson.fromJson(jsonObject.toString(),CourierAssignResponse.class);

        }
//

        Log.i("--courierAssignResponse ",jsonObject.toString());


        listener.returnResponse(courierAssignResponse,Util.ResponseTypeEnum.COURIERASSIGN);
    }


    //=====progressdialog
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
    //==================*/
}

