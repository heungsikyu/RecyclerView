package org.hueanalysis.moviediary;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieRetrofitClient {

    //private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String BASE_URL = "https:/reqres.in/";

    public static MovieApiService getApiService(){
        return getInstance().create(MovieApiService.class);
    }

    private static Retrofit getInstance() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
