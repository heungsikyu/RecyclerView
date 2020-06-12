package org.hueanalysis.moviediary.api;

import android.app.Application;

import com.google.gson.Gson;

import org.hueanalysis.moviediary.api.common.ApiManager;


public class APIApplication extends Application {

    private Gson gson;
    private ApiManager apiManager;

    private static class Singleton {
        private static final APIApplication instance = new APIApplication();
    }

    public static APIApplication getInstance(){ return Singleton.instance; }

    public Gson gson(){
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    public ApiManager getApiManager() {
        if (apiManager == null){
            apiManager = new ApiManager();
        }
        return apiManager;
    }
}
