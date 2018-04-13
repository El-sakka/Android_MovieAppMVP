package www.sakkawy.com.movieappmvp.Presenter;

import java.util.List;

import www.sakkawy.com.movieappmvp.Model.Movie;
import www.sakkawy.com.movieappmvp.Model.Result;
import www.sakkawy.com.movieappmvp.MovieUtils.MovieClient;
import www.sakkawy.com.movieappmvp.View.IMovieView;

public class PresenterMovieImp implements IPresenter{

    IMovieView mIMovieView;
    MovieClient mMovieClient;

    public PresenterMovieImp(IMovieView mIMovieView) {
        this.mIMovieView = mIMovieView;
        mMovieClient = new MovieClient(this);
    }

    @Override
    public void onGetData() {
        mMovieClient.initRetrofitCall();
    }

    @Override
    public void onSuccess(String message, List<Result> mMovieList) {
        mIMovieView.onGetDataSuccess(message,mMovieList);
    }

    @Override
    public void onFailed(String message) {
        mIMovieView.onGetDataFailed(message);
    }
}
