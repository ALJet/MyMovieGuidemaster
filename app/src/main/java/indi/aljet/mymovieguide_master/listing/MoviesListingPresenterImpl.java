package indi.aljet.mymovieguide_master.listing;

import java.util.List;

import indi.aljet.mymovieguide_master.Movie;
import indi.aljet.mymovieguide_master.util.RxUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by PC-LJL on 2018/4/12.
 */

public class MoviesListingPresenterImpl
        implements MoviesListingPresenter {
    private MoviesListingView view;
    private MoviesListingInteractor moviesListingInteractor;
    private Disposable fetchSubscription;


    public MoviesListingPresenterImpl
            (MoviesListingInteractor moviesListingInteractor) {
        this.moviesListingInteractor =
                moviesListingInteractor;
    }



    @Override
    public void displayMovies() {
        showLoading();
        fetchSubscription = moviesListingInteractor
                .fetchMovies().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( this :: onMovieFetchSuccess,
                        this :: onMovieFetchFailed);

    }

    @Override
    public void setView(MoviesListingView view) {
        this.view = view;
        RxUtils.unsubscribe(fetchSubscription);
    }

    @Override
    public void destroy() {
        view = null;
        RxUtils.unsubscribe(fetchSubscription);
    }


    private void showLoading(){
        if(isViewAttached()){
            view.loadingStarted();
        }
    }

    private void onMovieFetchSuccess(List<Movie> movies) {
        if (isViewAttached()) {
            view.showMovies(movies);
        }
    }

    private void onMovieFetchFailed(Throwable e) {
        view.loadingFailed(e.getMessage());
    }

    private boolean isViewAttached(){
        return view != null;
    }
}
