package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiInterface {
    String base_url = "https://www.tianqiapi.com/api/";

    @GET("top-headlines")
    Call<WeatherResponse> getWea(
            @Query("version") String country
    );

}
