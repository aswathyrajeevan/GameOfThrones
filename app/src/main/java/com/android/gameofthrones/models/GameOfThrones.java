package com.android.gameofthrones.models;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by aswathyragesh on 1/11/16.
 */
public class GameOfThrones {

    @SerializedName("Title")
    private String title;
    @SerializedName("Season")
    private int season;
    @SerializedName("Episodes")
    private ArrayList<Episode> episode;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public ArrayList<Episode> getmEpisodes() {
        return episode;
    }

    public void setmEpisodes(ArrayList<Episode> episode) {
        this.episode = episode;
    }

}
