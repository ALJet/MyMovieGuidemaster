package indi.aljet.mymovieguide_master.details;

import indi.aljet.mymovieguide_master.Movie;

/**
 * Created by PC-LJL on 2018/4/11.
 */

public interface MovieDetailsPresenter {

    void showDetails(Movie movie);

    void showTrailers(Movie movie);

    void showReviews(Movie movie);

    void showFavoriteButton(Movie movie);

    void onFavoriteClick(Movie movie);

    void setView(MovieDetailsView view);

    void destroy();

}
