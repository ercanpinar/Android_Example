package com.streethawk.example.service;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by ercanpinar on 04/02/2017.
 */

/**
 * ******** CustomObjectRequest extends with Request (JSONObject) ********
 */

public class CustomObjectRequest extends Request<JSONObject> {

    /**
     * ******** Declare Used Variables ********
     */
    private Response.Listener<JSONObject> listener;
    private Map<String, String> params;


    /**
     * ******** CustomObjectRequest Constructor ********
     *
     * @param url             Service URL
     * @param method          RequestType - POST - GET
     * @param params          Request parameters
     * @param reponseListener Response Listener
     * @param errorListener   Error Listener
     */

    public CustomObjectRequest(int method, String url, Map<String, String> params,
                               Response.Listener<JSONObject> reponseListener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = reponseListener;
        this.params = params;
    }


    /**
     * ******** parseNetworkResponse ********
     *
     * @param response NetworkResponse
     */
    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(new JSONObject(jsonString),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }


    /**
     * ******** deliverResponse ********
     *
     * @param response JSONObjectResponse
     */
    @Override
    protected void deliverResponse(JSONObject response) {
        listener.onResponse(response);
    }
}

