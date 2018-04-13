package www.sakkawy.com.movieappmvp.Presenter;

import java.util.List;

import www.sakkawy.com.movieappmvp.Model.Movie;
import www.sakkawy.com.movieappmvp.Model.Result;

public interface IPresenter {
    public void onGetData();
    public void onSuccess(String message, List<Result>mMovieList);
    public void onFailed(String message);
}
