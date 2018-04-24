package indi.aljet.mymovieguide_master.details;

import java.util.List;

import indi.aljet.mymovieguide_master.Review;
import indi.aljet.mymovieguide_master.Video;
import io.reactivex.Observable;

/**
 * Created by PC-LJL on 2018/4/10.
 */

public interface MovieDetailsInteractor {
    Observable<List<Video>> getTrailers(String id);

    Observable<List<Review>> getReviews(String id);
}
