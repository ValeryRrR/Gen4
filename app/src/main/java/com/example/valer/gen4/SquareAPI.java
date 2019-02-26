package com.example.valer.gen4;

import com.example.valer.gen4.Models.CommitModel;
import com.example.valer.gen4.Models.ContributorsModel;
import com.example.valer.gen4.Models.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface SquareAPI {
    @GET("users/square/repos")
    Call<List<PostModel>> getRepos();
    //https://api.github.com/users/square/repos

    @GET("repos/square/{repoName}/commits")
    Call<List<CommitModel>> getCommits(@Path("repoName") String repoName);

    @GET("repos/square/{repoName}/contributors")
    Call<List<ContributorsModel>> getContributors(@Path("repoName") String repoName);
}
