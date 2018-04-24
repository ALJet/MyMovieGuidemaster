package indi.aljet.mymovieguide_master.listing;

import java.util.List;

import indi.aljet.mymovieguide_master.Movie;
import indi.aljet.mymovieguide_master.MoviesWraper;
import indi.aljet.mymovieguide_master.favorites.FavoritesInteractor;
import indi.aljet.mymovieguide_master.listing.sorting.SortType;
import indi.aljet.mymovieguide_master.listing.sorting.SortingOptionStore;
import indi.aljet.mymovieguide_master.network.TmdbWebService;
import io.reactivex.Observable;

/**
 * Created by PC-LJL on 2018/4/12.
 */

public class MoviesListingInteractorImpl implements MoviesListingInteractor {

    private FavoritesInteractor favoritesInteractor;
    private TmdbWebService tmdbWebService;
    private SortingOptionStore sortingOptionStore;

    public MoviesListingInteractorImpl(FavoritesInteractor favoritesInteractor,
                                       TmdbWebService tmdbWebService,
                                       SortingOptionStore sortingOptionStore) {
        this.favoritesInteractor = favoritesInteractor;
        this.tmdbWebService = tmdbWebService;
        this.sortingOptionStore = sortingOptionStore;
    }


    @Override
    public Observable<List<Movie>> fetchMovies() {
        int selectedOption = sortingOptionStore
                .getSelectedOption();
        if(selectedOption == SortType.MOST_POPULAR
                .getValue()){
            return tmdbWebService.popularMovies()
                    .map(MoviesWraper :: getMovieList);
        }else if(selectedOption == SortType
                .HIGHEST_RATED.getValue()){
            return tmdbWebService.highestRatedMovies()
                    .map(MoviesWraper :: getMovieList);
        }else{
            return Observable.just(favoritesInteractor
            .getFavorites());
        }
    }
}
