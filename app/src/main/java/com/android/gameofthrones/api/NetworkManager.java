package com.android.gameofthrones.api;

import com.android.gameofthrones.models.EpisodeDetails;
import com.android.gameofthrones.models.GameOfThrones;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by aswathyragesh on 1/11/16.
 */
public class NetworkManager {
    private static NetworkManager ourInstance = new NetworkManager();

    public static NetworkManager getInstance() {
        return ourInstance;
    }

    private GameofThronesService mGameofThronesService;

    private NetworkManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mGameofThronesService = retrofit.create(GameofThronesService.class);
    }

    public interface ApiResultListener {
        void onComplete(Object result);

        void onError();
    }

    public void getEpisodes(final ApiResultListener listener) {
        Call<GameOfThrones> gameOfThronesCall =
                mGameofThronesService.getEpisodes("Game of Thrones", "1");

        gameOfThronesCall.enqueue(new Callback<GameOfThrones>() {
            @Override
            public void onResponse(Response<GameOfThrones> response) {
                listener.onComplete(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onError();
            }
        });
    }

    public void getEpisodeDetails(final ApiResultListener listener, String imdbID) {
        Call<EpisodeDetails> episodeDetailsCall =
                mGameofThronesService.getEpisodeDetails(imdbID, "short", "json");

        episodeDetailsCall.enqueue(new Callback<EpisodeDetails>() {
            @Override
            public void onResponse(Response<EpisodeDetails> response) {
                listener.onComplete(response);
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onError();
            }
        });
    }

}
