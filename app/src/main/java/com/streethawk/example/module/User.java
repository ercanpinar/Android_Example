package com.streethawk.example.module;

import java.io.Serializable;

/**
 * Created by ercanpinar on 03/02/2017.
 */

public class User implements Serializable {

    private String fullname;
    private String email;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
