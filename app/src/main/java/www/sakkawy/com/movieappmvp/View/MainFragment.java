package www.sakkawy.com.movieappmvp.View;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import www.sakkawy.com.movieappmvp.Adaper.MovieAdapter;
import www.sakkawy.com.movieappmvp.Model.Result;
import www.sakkawy.com.movieappmvp.Presenter.PresenterMovieImp;
import www.sakkawy.com.movieappmvp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements IMovieView{

    private static final String TAG = MainFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private MovieAdapter mAdapter;
    private PresenterMovieImp mPresenterMovieImp;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // init presenter and call onGetData to call the service
        mPresenterMovieImp = new PresenterMovieImp(MainFragment.this);
        mPresenterMovieImp.onGetData();

        mRecyclerView = getActivity().findViewById(R.id.rv_movieList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    public void onGetDataSuccess(String messaga, List<Result> mMovieList) {
        mAdapter = new MovieAdapter(mMovieList,getContext());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onGetDataFailed(String messaga) {
        Log.d(TAG, "onGetDataFailed: "+messaga);
    }
}
