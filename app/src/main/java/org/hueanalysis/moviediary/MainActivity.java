package org.hueanalysis.moviediary;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import org.hueanalysis.moviediary.MovieRetrofitClient;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "----------------------";

    private RecyclerView contactsRecView;

    private Retrofit movieRetrofit ;
    private MovieApiService movieApiService;
    private Call<Object> movieCallMovieList;

    //private MovieRetrofitClient mRtfCient ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsRecView = findViewById(R.id.contactsRecView);

        ArrayList<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact("Margot Robbie", "marog@gmail.com", "https://thumbor.forbes.com/thumbor/fit-in/416x416/filters%3Aformat%28jpg%29/https%3A%2F%2Fspecials-images.forbesimg.com%2Fimageserve%2F585404d54bbe6f1f20e92308%2F0x0.jpg%3Fbackground%3D000000%26cropX1%3D0%26cropX2%3D744%26cropY1%3D58%26cropY2%3D802" ) );
        contacts.add(new Contact("Cillian Mruphy", "Chillian@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg/440px-Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg" ) );
        contacts.add(new Contact("Saoirse Ronan", "saoirse@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/f/f5/Saoirse_Ronan_in_2018.png" ) );

        contacts.add(new Contact("Emma Watson", "emma@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/0/0a/Emma_Watson_interview_in_2017.jpg" ) );
        contacts.add(new Contact("Margot Robbie", "marog@gmail.com", "https://thumbor.forbes.com/thumbor/fit-in/416x416/filters%3Aformat%28jpg%29/https%3A%2F%2Fspecials-images.forbesimg.com%2Fimageserve%2F585404d54bbe6f1f20e92308%2F0x0.jpg%3Fbackground%3D000000%26cropX1%3D0%26cropX2%3D744%26cropY1%3D58%26cropY2%3D802" ) );
        contacts.add(new Contact("Cillian Mruphy", "Chillian@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg/440px-Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg" ) );

        contacts.add(new Contact("Saoirse Ronan", "saoirse@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/f/f5/Saoirse_Ronan_in_2018.png" ) );
        contacts.add(new Contact("Emma Watson", "emma@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/0/0a/Emma_Watson_interview_in_2017.jpg" ) );
        contacts.add(new Contact("Margot Robbie", "marog@gmail.com", "https://thumbor.forbes.com/thumbor/fit-in/416x416/filters%3Aformat%28jpg%29/https%3A%2F%2Fspecials-images.forbesimg.com%2Fimageserve%2F585404d54bbe6f1f20e92308%2F0x0.jpg%3Fbackground%3D000000%26cropX1%3D0%26cropX2%3D744%26cropY1%3D58%26cropY2%3D802" ) );

        contacts.add(new Contact("Cillian Mruphy", "Chillian@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg/440px-Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg" ) );
        contacts.add(new Contact("Saoirse Ronan", "saoirse@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/f/f5/Saoirse_Ronan_in_2018.png" ) );
        contacts.add(new Contact("Emma Watson", "emma@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/0/0a/Emma_Watson_interview_in_2017.jpg" ) );

        contacts.add(new Contact("Cillian Mruphy", "Chillian@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg/440px-Cillian_Murphy_Press_Conference_The_Party_Berlinale_2017_02cr.jpg" ) );
        contacts.add(new Contact("Saoirse Ronan", "saoirse@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/f/f5/Saoirse_Ronan_in_2018.png" ) );
        contacts.add(new Contact("Emma Watson", "emma@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/0/0a/Emma_Watson_interview_in_2017.jpg" ) );




        ContactsRecViewAdapter adapter = new ContactsRecViewAdapter(this);
        adapter.setContacts(contacts);

        contactsRecView.setAdapter(adapter);
        //contactsRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        contactsRecView.setLayoutManager(new GridLayoutManager(this, 1));


        setRetrofitInit();
        callRecentMovieList();

//        Call<Object> mRecentMovieList = MovieRetrofitClient.getApiService().getRecentMovieList();
//        Call<Object> mRecentMovieList = MovieRetrofitClient.getApiService().getTest();
//
//        try {
//            System.out.println(mRecentMovieList.execute().body());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }




    private  void setRetrofitInit(){
        String url = "https://api.themoviedb.org/3/";
        String urlstr  = getResources().getString(R.string.movie_base_url);
        movieRetrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        movieApiService = movieRetrofit.create(MovieApiService.class);
    }


    private void callRecentMovieList() {
        final String TAG = "<<<<<<<>>>>>>>>>";

        Call<Object> movieCallMovieList = movieApiService.getRecentMovieList();
        movieCallMovieList.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()){
                    Object movielist = response.body();
                    Log.d(TAG, movielist.toString());
                }else{
                    Log.d(TAG, "Status code : " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d(TAG, "Fail msg : "+ t.getMessage() );
            }
        });

    }
}

