package indi.aljet.mymovieguide_master.details;

import java.util.List;

import indi.aljet.mymovieguide_master.Movie;
import indi.aljet.mymovieguide_master.Review;
import indi.aljet.mymovieguide_master.Video;

/**
 * Created by PC-LJL on 2018/4/10.
 */

public interface MovieDetailsView {

    void showDetails(Movie movie);
    void showTrailers(List<Video> trailers);
    void showReviews(List<Review> reviews);
    void showFavorited();
    void showUnFavorited();


}
