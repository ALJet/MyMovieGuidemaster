package indi.aljet.mymovieguide_master.favorites;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import indi.aljet.mymovieguide_master.Movie;

/**
 * Created by PC-LJL on 2018/4/11.
 */

public class FavoritesInteractorImpl implements
        FavoritesInteractor {

    private FavoritesStore favoritesStore;

    public FavoritesInteractorImpl(FavoritesStore favoritesStore) {
        this.favoritesStore = favoritesStore;
    }

    @Override
    public void setFavorite(Movie movie) {
        favoritesStore.setFavorite(movie);
    }

    @Override
    public boolean isFavorite(String id) {
        return favoritesStore.isFavorite(id);
    }

    @Override
    public List<Movie> getFavorites() {
        try {
            return favoritesStore.getFavcorites();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>(0);
        }
    }

    @Override
    public void unFavorite(String id) {
        favoritesStore.unfavorite(id);
    }
}
