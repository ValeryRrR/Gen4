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
                .baseUrl("https://api.github.com/") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        squareAPI = retrofit.create(SquareAPI.class); //Создаем объект, при помощи которого будем выполнять запросы
    }

    public static SquareAPI getApi() {
        return squareAPI;
    }
}
