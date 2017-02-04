package com.streethawk.example.service.response;

import com.streethawk.example.module.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ercanpinar on 04/02/2017.
 */

public class PostListResponse extends BaseResponse{
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
