package indi.aljet.mymovieguide_master.listing;

import dagger.Subcomponent;
import indi.aljet.mymovieguide_master.listing.sorting.SortingDialogFragment;
import indi.aljet.mymovieguide_master.listing.sorting.SortingModule;

/**
 * Created by PC-LJL on 2018/4/12.
 */

@ListingScope
@Subcomponent(modules = {ListingModule.class,
        SortingModule.class})
public interface ListingComponent {

    MoviesListingFragment inject(MoviesListingFragment fragment);

    SortingDialogFragment inject(SortingDialogFragment fragment);


}
