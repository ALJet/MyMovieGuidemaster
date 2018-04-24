package indi.aljet.mymovieguide_master.listing;

import java.util.List;

import indi.aljet.mymovieguide_master.Movie;

/**
 * Created by PC-LJL on 2018/4/12.
 */

public interface MoviesListingView {

    void showMovies(List<Movie> movies);

    void loadingStarted();

    void loadingFailed(String errorMessage);

    void onMovieClicked(Movie movie);

}
