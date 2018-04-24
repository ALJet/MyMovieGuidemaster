package indi.aljet.mymovieguide_master.listing;

import android.content.Context;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import indi.aljet.mymovieguide_master.Movie;
import indi.aljet.mymovieguide_master.R;

/**
 * Created by PC-LJL on 2018/4/12.
 */

public class MoviesListingAdapter extends
        RecyclerView.Adapter<MoviesListingAdapter.ViewHolder> {

    private List<Movie> movies;
    private Context context;
    private MoviesListingView view;

    public MoviesListingAdapter(List<Movie> movies, MoviesListingView view) {
        this.movies = movies;
        this.view = view;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.movie_grid_item,parent,
                        false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(holder);
        holder.movie = movies.get(position);
        holder.name.setText(holder.movie.getTitle());

    }


    private void setBackgroundColor(Palette palette,
                                    ViewHolder holder){
        holder.titleBackground.setBackgroundColor(palette
        .getVibrantColor(context.getResources()
        .getColor(R.color.black_translucent_60)));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{



        @BindView(R.id.movie_poster)
        ImageView poster;
        @BindView(R.id.title_background)
        View titleBackground;
        @BindView(R.id.movie_name)
        TextView name;

        public Movie movie;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }


        @Override
        public void onClick(View v) {
            view.onMovieClicked(movie);
        }
    }
}
