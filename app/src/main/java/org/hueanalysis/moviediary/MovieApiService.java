package org.hueanalysis.moviediary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApiService {

    @GET("discover/movie?primary_release_date.gte=2019-09-15&primary_release_date.lte=2020-10-22&api_key=4994de80a80b502369c0d4e331185b0c")
    Call<Object>getRecentMovieList();

    @GET("api/users/2")
    Call<Object> getTest();
}
