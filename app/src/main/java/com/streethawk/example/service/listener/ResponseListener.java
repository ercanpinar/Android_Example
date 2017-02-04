package com.streethawk.example.service.listener;

import com.streethawk.example.service.response.BaseResponse;

/**
 * Created by ercanpinar on 04/02/2017.
 */

public interface ResponseListener {
    void returnResponse(BaseResponse response);
}
