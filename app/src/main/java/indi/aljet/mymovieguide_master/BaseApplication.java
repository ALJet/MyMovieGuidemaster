package indi.aljet.mymovieguide_master;

import android.app.Application;
import android.os.StrictMode;

import indi.aljet.mymovieguide_master.details.DetailsComponent;
import indi.aljet.mymovieguide_master.details.DetailsModult;
import indi.aljet.mymovieguide_master.favorites.FavoritesModule;
import indi.aljet.mymovieguide_master.listing.ListingComponent;
import indi.aljet.mymovieguide_master.listing.ListingModule;
import indi.aljet.mymovieguide_master.network.NetworkModule;

/**
 * Created by PC-LJL on 2018/4/10.
 */

public class BaseApplication extends Application {

    private AppComponent appComponent;
    private DetailsComponent detailsComponent;
    private ListingComponent listingComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        StrictMode.enableDefaults();
        appComponent = createAppComponent();
    }

    private AppComponent createAppComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .favoritesModule(new FavoritesModule())
                .build();
    }


    public DetailsComponent createDetailsComponent(){
        detailsComponent = appComponent.plus(new
                DetailsModult());
        return detailsComponent;
    }


    public void releaseDetailsComponent(){
        detailsComponent = null;
    }


    public ListingComponent createListingComponent(){
        listingComponent = appComponent.plus(new
                ListingModule());
        return listingComponent;
    }


    public void releaseListingComponent(){
        listingComponent = null;
    }

    public ListingComponent getListingComponent(){
        return listingComponent;
    }
}
