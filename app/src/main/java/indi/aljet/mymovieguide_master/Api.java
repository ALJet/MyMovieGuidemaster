package indi.aljet.mymovieguide_master;

/**
 * Created by PC-LJL on 2018/4/4.
 */

public class Api {

    public static final String BASE_POSTER_PATH
            = "http://image.tmdb.org/t/p/w342";
    public static final String BASR_BACKDROP_PATH
            = "http://image.tmdb.org/t/p/w780";
    static final String YOUTUBE_VIDEO_URL
            = "http://www.youtube.com/watch?v=%1$s";
    static final String YOUTUBE_THUMBNAIL_URL
            = "http://img.youtube.com/vi/%1$s/0.jpg";


    public Api() {
    }

    public static String getPosterPath(String posterPath){
        return BASE_POSTER_PATH + posterPath;
    }

    public static String getBackdropPath(String backdropPath){
        return BASR_BACKDROP_PATH + backdropPath;
    }
}
