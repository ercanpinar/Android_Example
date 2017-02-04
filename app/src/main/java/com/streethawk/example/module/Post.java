package com.streethawk.example.module;

import java.io.Serializable;

/**
 * Created by ercanpinar on 03/02/2017.
 */

public class Post implements Serializable {

    private String title;
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
