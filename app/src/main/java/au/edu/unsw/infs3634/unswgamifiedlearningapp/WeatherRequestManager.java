package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherRequestManager {

     private static Retrofit retrofit = null;

     public static WeatherApiInterface getApiInterface(){

         if(retrofit == null){
             retrofit = new Retrofit.Builder()
                     .baseUrl(WeatherApiInterface.base_url)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
         }
        return retrofit.create(WeatherApiInterface.class);
     }
}
