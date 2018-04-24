package indi.aljet.mymovieguide_master.details;

import java.util.List;

import indi.aljet.mymovieguide_master.Review;
import indi.aljet.mymovieguide_master.ReviewsWrapper;
import indi.aljet.mymovieguide_master.Video;
import indi.aljet.mymovieguide_master.VideoWrapper;
import indi.aljet.mymovieguide_master.network.TmdbWebService;
import io.reactivex.Observable;

/**
 * Created by PC-LJL on 2018/4/10.
 */

public class MovieDetailsInteractorImpl implements MovieDetailsInteractor {

    private TmdbWebService tmdbWebService;

    public MovieDetailsInteractorImpl
            (TmdbWebService tmdbWebService) {
        this.tmdbWebService = tmdbWebService;
    }

    @Override
    public Observable<List<Video>> getTrailers(String id) {
        return tmdbWebService.trailers(id)
                .map(VideoWrapper
                :: getVideos);
    }


    @Override
    public Observable<List<Review>> getReviews(String id) {
        return tmdbWebService.reviews(id)
                .map(ReviewsWrapper :: getReviews);
    }
}
