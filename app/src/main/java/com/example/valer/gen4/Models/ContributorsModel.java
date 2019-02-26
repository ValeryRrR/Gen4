package com.example.valer.gen4.Models;


import com.google.gson.annotations.SerializedName;

public class ContributorsModel {

    @SerializedName("login")
    private final String contributorLogin;

    public ContributorsModel(String contributorLogin) {
        this.contributorLogin = contributorLogin;
    }

    public String getContributorLogin() {
        return contributorLogin;
    }
}
