package com.streethawk.example.service.response;

import com.streethawk.example.module.Post;

import java.util.ArrayList;

/**
 * Created by ercanpinar on 04/02/2017.
 */

/**
 * ******** PostListResponse extends with BaseResponse ********
 */

public class PostListResponse extends BaseResponse {

    /**
     * ******** Declare Used Variables ********
     */
    private ArrayList<Post> postList;

    public PostListResponse(ArrayList<Post> postList) {
        this.postList = postList;
    }

    public ArrayList<Post> getPostList() {
        return postList;
    }

    public void setPostList(ArrayList<Post> postList) {
        this.postList = postList;
    }
}
