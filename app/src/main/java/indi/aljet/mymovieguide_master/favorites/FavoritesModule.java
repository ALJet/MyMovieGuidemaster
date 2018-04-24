package indi.aljet.mymovieguide_master.favorites;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import indi.aljet.mymovieguide_master.AppModule;

/**
 * Created by PC-LJL on 2018/4/11.
 */

@Module(includes = AppModule.class)
public class FavoritesModule {
    @Provides
    @Singleton
    FavoritesInteractor provideFavouritesInteractor(FavoritesStore store){
        return new FavoritesInteractorImpl(store);
    }
}
