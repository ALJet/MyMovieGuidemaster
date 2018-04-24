package indi.aljet.mymovieguide_master;

import com.squareup.moshi.Json;

import java.util.List;

/**
 * Created by PC-LJL on 2018/4/10.
 */

public class MoviesWraper {

    @Json(name = "results")
    private List<Movie> movies;

    public List<Movie> getMovieList(){
        return movies;
    }


    public void setMovieList(List<Movie> moviesList){
        this.movies = moviesList;
    }



}
