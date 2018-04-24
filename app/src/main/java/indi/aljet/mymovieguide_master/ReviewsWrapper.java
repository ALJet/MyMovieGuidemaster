package indi.aljet.mymovieguide_master;

import com.squareup.moshi.Json;

import java.util.List;

/**
 * Created by PC-LJL on 2018/4/10.
 */

public class ReviewsWrapper {

    @Json(name = "results")
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}
