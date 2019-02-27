package com.example.valer.gen4;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private static SquareAPI squareAPI;

    @Override
    public void onCreate() {
        super.onCreate();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        squareAPI = retrofit.create(SquareAPI.class);
    }

    public static SquareAPI getApi() {
        return squareAPI;
    }
}
