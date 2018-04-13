package www.sakkawy.com.movieappmvp.Adaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import www.sakkawy.com.movieappmvp.Model.Result;
import www.sakkawy.com.movieappmvp.R;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.myViewHolder> {

    public List<Result> mResultList;
    public Context mContext;

    public MovieAdapter(List<Result> mResultList, Context mContext) {
        this.mResultList = mResultList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.movie_layout,parent,false);
        return new myViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.mMovieName.setText(mResultList.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return (mResultList.size() !=0) ? mResultList.size() : 0 ;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView mMovieName;
        public myViewHolder(View itemView) {
            super(itemView);
            mMovieName = itemView.findViewById(R.id.tv_movie_name);
        }
    }
}
