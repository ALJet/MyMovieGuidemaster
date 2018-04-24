package indi.aljet.mymovieguide_master;

import com.squareup.moshi.Json;

import java.util.List;

/**
 * Created by PC-LJL on 2018/4/10.
 */

public class VideoWrapper {


    @Json(name = "results")
    private List<Video> videos;


    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
