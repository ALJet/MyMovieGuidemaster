package indi.aljet.mymovieguide_master.favorites;

import java.util.List;

import indi.aljet.mymovieguide_master.Movie;

/**
 * Created by PC-LJL on 2018/4/11.
 */

public interface FavoritesInteractor {
    void setFavorite(Movie movie);
    boolean isFavorite(String id);
    List<Movie> getFavorites();
    void unFavorite(String id);
}
