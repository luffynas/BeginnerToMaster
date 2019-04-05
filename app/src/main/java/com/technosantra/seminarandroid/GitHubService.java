package com.technosantra.seminarandroid;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by M. Nashrulloh on 06/04/19.
 * at PT. Ansvia
 * contact us blankcd3@gmail.com or mohammad.nashrulloh@ansvia.com
 */
public interface GitHubService {

    @GET("users/{user}")
    Call<User> getUser(@Path("user") String user);
}
