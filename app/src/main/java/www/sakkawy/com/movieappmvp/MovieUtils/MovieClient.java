package www.sakkawy.com.movieappmvp.MovieUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import www.sakkawy.com.movieappmvp.Model.Movie;
import www.sakkawy.com.movieappmvp.Model.Result;
import www.sakkawy.com.movieappmvp.Presenter.PresenterMovieImp;

public class MovieClient {
    public final static String API_KEY ="3c15dbf274c6641b91228b202383fdc9";
    public final static String BASE_URL="http://api.themoviedb.org/3/movie/";

    public static Retrofit retrofit = null;
    public List<Result> mResultList;
    public PresenterMovieImp mPresenterMovieImp;
    IClient iClient;

    public MovieClient(PresenterMovieImp mPresenterMovieImp) {
        this.mPresenterMovieImp = mPresenterMovieImp;
        mResultList = new ArrayList<>();
    }

    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

    public void initRetrofitCall(){
        iClient = getClient().create(IClient.class);
        Call<Movie> call = iClient.fetchDataTopRated(API_KEY);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                mResultList = response.body().getResults();
                mPresenterMovieImp.onSuccess("List size "+mResultList.size(),mResultList);
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                mPresenterMovieImp.onFailed("Failed");
            }
        });
    }
}
