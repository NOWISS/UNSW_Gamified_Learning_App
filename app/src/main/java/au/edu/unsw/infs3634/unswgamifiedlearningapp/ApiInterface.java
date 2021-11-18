package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// Idea for this class taken from:
// Title: How to Make a News App | REST API | Android Project
// Author: Coding with Evan
// Date: 1/8/2021
// Availability: https://www.youtube.com/watch?v=Csx7ve8DF_U

public interface ApiInterface {
    String base_url = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<NewsResponse> getNews(
            @Query("country") String country,
            @Query("pagesize") int pagesize,
            @Query("apikey") String key
    );
    @GET("top-headlines")
    Call<NewsResponse> getCategory(
            @Query("country") String country,
            @Query("category") String category,
            @Query("pagesize") int pagesize,
            @Query("apikey") String key
    );
    @GET("top-headlines")
    Call<NewsResponse> getQ(
            //@Query("country") String country,
            @Query("q") String query,
            @Query("pagesize") int pagesize,
            @Query("apikey") String key
    );
}
