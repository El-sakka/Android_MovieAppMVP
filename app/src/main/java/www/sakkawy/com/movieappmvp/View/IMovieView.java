package www.sakkawy.com.movieappmvp.View;

import java.util.List;

import www.sakkawy.com.movieappmvp.Model.Movie;
import www.sakkawy.com.movieappmvp.Model.Result;

public interface IMovieView {

    public void onGetDataSuccess(String messaga, List<Result> mMovieList);
    public void onGetDataFailed(String messaga);
}
