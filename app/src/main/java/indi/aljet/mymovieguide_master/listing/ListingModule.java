package indi.aljet.mymovieguide_master.listing;

import dagger.Module;
import dagger.Provides;
import indi.aljet.mymovieguide_master.favorites.FavoritesInteractor;
import indi.aljet.mymovieguide_master.listing.sorting.SortingDialogInteractor;
import indi.aljet.mymovieguide_master.listing.sorting.SortingOptionStore;
import indi.aljet.mymovieguide_master.network.TmdbWebService;

/**
 * Created by PC-LJL on 2018/4/12.
 */

@Module
public class ListingModule {

    @Provides
    MoviesListingInteractor provideMovieListingInteractor
            (FavoritesInteractor favoritesInteractor,
             TmdbWebService tmdbWebService,
             SortingOptionStore sortingOptionStore){
        return new MoviesListingInteractorImpl(favoritesInteractor,
                tmdbWebService,sortingOptionStore);
    }


    @Provides
    MoviesListingPresenter provideMovieListingPresenter
            (MoviesListingInteractor interactor){
                return new MoviesListingPresenterImpl(interactor);
    }

}
