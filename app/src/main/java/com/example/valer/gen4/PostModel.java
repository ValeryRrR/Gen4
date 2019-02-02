package com.example.valer.gen4;

import com.google.gson.annotations.SerializedName;

final public class PostModel {

    @SerializedName("name")
    private final String squareName;

    @SerializedName("stargazers_count")
    private final int stargazersCount;

    @SerializedName("forks_count")
    private final int forksCount;


    public PostModel(String squareName, int stargazersCount, int forksCount) {
        this.squareName = squareName;
        this.stargazersCount = stargazersCount;
        this.forksCount = forksCount;
    }


    public String getSquareName() {
        return squareName;
    }

    public int getStargazersCount() {
        return stargazersCount;
    }

    public int getForksCount() {
        return forksCount;
    }
}

