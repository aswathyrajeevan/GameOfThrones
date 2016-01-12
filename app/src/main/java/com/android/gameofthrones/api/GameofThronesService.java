package com.android.gameofthrones.api;

import com.android.gameofthrones.models.EpisodeDetails;
import com.android.gameofthrones.models.Episode;
import com.android.gameofthrones.models.GameOfThrones;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aswathyragesh on 1/11/16.
 */
public interface GameofThronesService {

    @GET("/")
    Call<GameOfThrones> getEpisodes(@Query("t") String query, @Query("Season") String season);

    @GET("/")
    Call<EpisodeDetails> getEpisodeDetails(@Query("i") String imdbId,
                                           @Query("plot") String plot,
                                           @Query("r") String response);
}
