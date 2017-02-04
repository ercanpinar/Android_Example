package com.streethawk.example.service.listener;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by ercanpinar on 03/02/2017.
 */

public interface JsonReturnListener {
    void callBackJsonObject(JSONObject jsonObject);
    void callBackJsonArray(JSONArray jsonArray);
}
