package com.example.valer.gen4;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface SquareAPI {
    @GET("users/square/repos")
    Call<List<PostModel>> getData();
    //https://api.github.com/users/square/repos
}
