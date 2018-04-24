package indi.aljet.mymovieguide_master.details;

import dagger.Module;
import dagger.Provides;
import indi.aljet.mymovieguide_master.favorites.FavoritesInteractor;
import indi.aljet.mymovieguide_master.network.TmdbWebService;

/**
 * Created by PC-LJL on 2018/4/11.
 */

@Module
public class DetailsModult {

    @Provides
    @DetailsScope
    MovieDetailsInteractor provideInteractor(TmdbWebService tmdbWebService){
        return new MovieDetailsInteractorImpl(tmdbWebService);
    }


    @Provides
    @DetailsScope
    MovieDetailsPresenter providePresenter(MovieDetailsInteractor detailsInteractor,
                                           FavoritesInteractor favoritesInteractor){
        return new MovieDetailsPresenterImpl(detailsInteractor,
                favoritesInteractor);
    }

}
