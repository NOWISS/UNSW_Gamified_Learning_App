package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Idea for this class taken from:
// Title: How to Make a News App | REST API | Android Project
// Author: Coding with Evan
// Date: 1/8/2021
// Availability: https://www.youtube.com/watch?v=Csx7ve8DF_U

public class RequestManager {

     private static Retrofit retrofit = null;

     public static ApiInterface getApiInterface(){

         if(retrofit == null){
             retrofit = new Retrofit.Builder()
                     .baseUrl(ApiInterface.base_url)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
         }
        return retrofit.create(ApiInterface.class);
     }
}
