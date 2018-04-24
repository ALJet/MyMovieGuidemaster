package indi.aljet.mymovieguide_master.listing;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import indi.aljet.mymovieguide_master.Constants;
import indi.aljet.mymovieguide_master.Movie;
import indi.aljet.mymovieguide_master.R;
import indi.aljet.mymovieguide_master.details.MovieDetailsActivity;
import indi.aljet.mymovieguide_master.details.MovieDetailsFragment;

/**
 * Created by PC-LJL on 2018/4/12.
 */

public class MoviesListingActivity extends
        AppCompatActivity implements MoviesListingFragment.Callback {

    public static final String DETAILS_FRAGMENT = "DetailsFragment";
    private boolean twoPaneMode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        if(findViewById(R.id.movie_details_container) != null){
            twoPaneMode = true;
            if(savedInstanceState == null){
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.movie_details_container,
                                new MovieDetailsFragment())
                        .commit();
            }
        }else{
            twoPaneMode = false;
        }
    }


    private void setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(R.string
            .movie_guide);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,
                menu);
        return true;
    }

    @Override
    public void onMoviesLoaded(Movie movie) {
        if(twoPaneMode){
            loadMovieFragment(movie);
        }else{

        }
    }

    @Override
    public void onMovieClicked(Movie movie) {
        if(twoPaneMode){
            loadMovieFragment(movie);
        }else{
            startMovieActivity(movie);
        }
    }


    private void startMovieActivity(Movie movie){
        Intent intent = new Intent(this,
                MovieDetailsActivity.class);
        Bundle extras = new Bundle();
        extras.putParcelable(Constants.MOVIE
        ,movie);
        intent.putExtras(extras);
        startActivity(intent);
    }



    private void loadMovieFragment(Movie movie){
        MovieDetailsFragment movieDetailsFragment =
                MovieDetailsFragment.getInstance(movie);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.movie_details_container,
                        movieDetailsFragment,
                        DETAILS_FRAGMENT).commit();
    }
}
