package org.hueanalysis.moviediary;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.net.URL;
import java.net.URLConnection;

public class MovieApiTask extends AsyncTask<Void, Void, JSONObject> {


    // https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc

    @Override
    protected JSONObject doInBackground(Void... voids) {
        String urlstr  = "";
        URLConnection urlConnection = null;
        BufferedReader bufferedReader = null;

        try{
            URL url = new URL(urlstr);

        }catch(Exception e){
            Log.e("App", "MovieApiTask ", e);
        }

       // return new JSONObject(stringBuffer.toString());
        return null ;
    }
}
