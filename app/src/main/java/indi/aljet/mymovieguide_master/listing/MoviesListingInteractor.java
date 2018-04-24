package indi.aljet.mymovieguide_master.listing;

import java.util.List;

import indi.aljet.mymovieguide_master.Movie;
import io.reactivex.Observable;

/**
 * Created by PC-LJL on 2018/4/12.
 */

public interface MoviesListingInteractor {

    Observable<List<Movie>> fetchMovies();
}
