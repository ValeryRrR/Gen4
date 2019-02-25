package com.example.valer.gen4.Models;

import com.google.gson.annotations.SerializedName;

public class Commit {

    @SerializedName("message")
    private final String commit;

    public Commit(String commit) {
        this.commit = commit;
    }

    public String getCommit() {
        return commit;
    }
}
