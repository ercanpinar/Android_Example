package com.ercanpinar.news.service.listener;

import com.ercanpinar.news.service.response.BaseResponse;

/**
 * Created by ercanpinar on 04/02/2017.
 */

public interface ResponseListener {
    void returnResponse(BaseResponse response);
}
