package com.streethawk.example.service.listener;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by ercanpinar on 03/02/2017.
 */

/**
 * ****** JsonReturnListener *******
 */
public interface JsonReturnListener {

    /********
     * JsonReturn -> JSONObject
     ********/
    void callBackJsonObject(JSONObject jsonObject);

    /********
     * JsonReturn -> JSONArray
     ********/
    void callBackJsonArray(JSONArray jsonArray);
}
