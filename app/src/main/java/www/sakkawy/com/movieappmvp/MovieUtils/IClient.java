package www.sakkawy.com.movieappmvp.MovieUtils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import www.sakkawy.com.movieappmvp.Model.Movie;

public interface IClient {
    @GET("top_rated")
    Call<Movie> fetchDataTopRated(@Query("api_key") String apiKey);

}
