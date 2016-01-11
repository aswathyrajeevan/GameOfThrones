package com.android.gameofthrones.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aswathyragesh on 1/10/16.
 */
public class Episode {

    @SerializedName("Title")
    private String title;
    @SerializedName("Released")
    private String released;
    @SerializedName("Episode")
    private int episode;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    @SerializedName("imdbRating")
    private String imdbRating;
    @SerializedName("imdbID")
    private String imdbID;

}
