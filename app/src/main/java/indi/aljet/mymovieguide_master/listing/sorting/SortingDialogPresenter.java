package indi.aljet.mymovieguide_master.listing.sorting;

/**
 * Created by PC-LJL on 2018/4/11.
 */

public interface SortingDialogPresenter {

    void setLastSavedOption();

    void onPopularMoviesSelected();

    void onHighestRatedMoviesSelected();

    void onFavoritesSelected();

    void setView(SortingDialogView view);

    void destroy();
}
