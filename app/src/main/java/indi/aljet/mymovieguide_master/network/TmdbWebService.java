package indi.aljet.mymovieguide_master.network;

import indi.aljet.mymovieguide_master.MoviesWraper;
import indi.aljet.mymovieguide_master.ReviewsWrapper;
import indi.aljet.mymovieguide_master.VideoWrapper;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by PC-LJL on 2018/4/11.
 */

public interface TmdbWebService {

    @GET("3/discover/movie?language=en&sort_by=popularity.desc")
    Observable<MoviesWraper> popularMovies();


    @GET("3/discover/movie?vote_count.gte=500&language=en&sort_by=vote_average.desc")
    Observable<MoviesWraper> highestRatedMovies();


    @GET("3/movie/{movieId}/videos")
    Observable<VideoWrapper> trailers(@Path("movieId") String movieId);

    @GET("3/movie/{movieId}/reviews")
    Observable<ReviewsWrapper> reviews(@Path("movieId") String movieId);



}
