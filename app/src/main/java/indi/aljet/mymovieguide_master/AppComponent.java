package indi.aljet.mymovieguide_master;

import javax.inject.Singleton;

import dagger.Component;
import indi.aljet.mymovieguide_master.details.DetailsComponent;
import indi.aljet.mymovieguide_master.details.DetailsModult;
import indi.aljet.mymovieguide_master.favorites.FavoritesModule;
import indi.aljet.mymovieguide_master.listing.ListingComponent;
import indi.aljet.mymovieguide_master.listing.ListingModule;
import indi.aljet.mymovieguide_master.network.NetworkModule;

/**
 * Created by PC-LJL on 2018/4/10.
 */
@Singleton
@Component(modules = {AppModule.class,
NetworkModule.class,
FavoritesModule.class})
public interface AppComponent {
    DetailsComponent plus(DetailsModult detailsModult);

    ListingComponent plus(ListingModule listingModule);

}
