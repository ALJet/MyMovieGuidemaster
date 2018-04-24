package indi.aljet.mymovieguide_master.listing;

/**
 * Created by PC-LJL on 2018/4/12.
 */

public interface MoviesListingPresenter {
    void displayMovies();

    void setView(MoviesListingView view);

    void destroy();
}
