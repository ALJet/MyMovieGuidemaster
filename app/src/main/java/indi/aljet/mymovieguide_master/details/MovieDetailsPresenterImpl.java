package indi.aljet.mymovieguide_master.details;

import java.util.List;

import indi.aljet.mymovieguide_master.Movie;
import indi.aljet.mymovieguide_master.Review;
import indi.aljet.mymovieguide_master.Video;
import indi.aljet.mymovieguide_master.favorites.FavoritesInteractor;
import indi.aljet.mymovieguide_master.util.RxUtils;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by PC-LJL on 2018/4/11.
 */

public class MovieDetailsPresenterImpl
        implements MovieDetailsPresenter {

    private MovieDetailsView view;
    private MovieDetailsInteractor movieDetailsInteractor;
    private FavoritesInteractor favoritesInteractor;
    private Disposable trailerSubscription;
    private Disposable reviewSubscription;

    public MovieDetailsPresenterImpl(MovieDetailsInteractor movieDetailsInteractor,
                                     FavoritesInteractor favoritesInteractor) {
        this.movieDetailsInteractor = movieDetailsInteractor;
        this.favoritesInteractor = favoritesInteractor;
    }


    @Override
    public void setView(MovieDetailsView view) {
        this.view = view;
    }

    @Override
    public void destroy() {
        view = null;
        RxUtils.unsubscribe(trailerSubscription
        ,reviewSubscription);
    }

    @Override
    public void showDetails(Movie movie) {
        if(isViewAttached()){
            view.showDetails(movie);
        }
    }

    private boolean isViewAttached(){
        return view != null;
    }

    @Override
    public void showTrailers(Movie movie) {
        trailerSubscription = movieDetailsInteractor
                .getTrailers(movie.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this :: onGetTrailersSuccess ,
                        t -> onGetTrailersFailure());
    }

    private void onGetTrailersSuccess(List<Video> videos){
        if(isViewAttached()){
            view.showTrailers(videos);
        }
    }


    private void onGetTrailersFailure(){}


    @Override
    public void showReviews(Movie movie) {
        reviewSubscription = movieDetailsInteractor
                .getReviews(movie.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this :: onGetReviewsSuccess,
                        t -> onGetReviewsFailure());
    }


    private void onGetReviewsSuccess(List<Review> reviews){
        if(isViewAttached()){
            view.showReviews(reviews);
        }
    }

    private void onGetReviewsFailure(){}


    @Override
    public void showFavoriteButton(Movie movie) {
        boolean isFavorite = favoritesInteractor
                .isFavorite(movie.getId());
        if(isViewAttached()){
            if(isFavorite){
                view.showFavorited();
            }else{
                view.showUnFavorited();
            }
        }
    }


    @Override
    public void onFavoriteClick(Movie movie) {
        if(isViewAttached()){
            boolean isFavorite = favoritesInteractor
                    .isFavorite(movie.getId());
            if(isFavorite){
                favoritesInteractor.unFavorite(movie
                .getId());
                view.showUnFavorited();
            }else{
                favoritesInteractor.setFavorite(movie);
                view.showFavorited();
            }
        }
    }

}
