package com.technosantra.seminarandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitOnlyActivity extends AppCompatActivity {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_only);

        GitHubService service = retrofit.create(GitHubService.class);
        Call<User> fetch = service.getUser("luffynas");
        fetch.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User response1 = response.body();
                Log.d("RETROFIT", response1.getName());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("RETROFIT", t.getMessage());
            }
        });
    }
}
