package com.example.valer.gen4.Models;


import com.google.gson.annotations.SerializedName;

public class ContributorsModel {

    @SerializedName("login")
    private final String contributorLogin;

    @SerializedName("avatar_url")
    private final String avatarUrl;


    public ContributorsModel(String contributorLogin, String avatarUrl) {
        this.contributorLogin = contributorLogin;
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getContributorLogin() {
        return contributorLogin;
    }
}
