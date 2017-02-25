package com.ercanpinar.news.service;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by ercanpinar on 04/02/2017.
 */

/**
 * ******** CustomArrayRequest extends with Request (JSONArray) ********
 */
public class CustomArrayRequest extends Request<JSONArray> {
    /**
     * ******** Declare Used Variables ********
     */
    private Response.Listener<JSONArray> listener;
    private Map<String, String> params;

    /**
     * ******** CustomArrayRequest Constructor ********
     *
     * @param url             Service URL
     * @param method          RequestType - POST - GET
     * @param params          Request parameters
     * @param reponseListener Response Listener
     * @param errorListener   Error Listener
     */
    public CustomArrayRequest(int method, String url, Map<String, String> params,
                              Response.Listener<JSONArray> reponseListener, Response.ErrorListener errorListener) {
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
    protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(new JSONArray(jsonString),
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
     * @param response JSONArrayResponse
     */
    @Override
    protected void deliverResponse(JSONArray response) {
        listener.onResponse(response);
    }
}

