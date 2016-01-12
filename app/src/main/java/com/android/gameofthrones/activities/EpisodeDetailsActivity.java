package com.android.gameofthrones.activities;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.gameofthrones.R;
import com.android.gameofthrones.api.NetworkManager;
import com.android.gameofthrones.models.EpisodeDetails;

public class EpisodeDetailsActivity extends AppCompatActivity {

    private String mImdbID;
    private TextView mYearTV;
    private TextView mRatedTV;
    private TextView mRleasedTV;
    private TextView mSeasonTV;
    private TextView mEpisodeTV;
    private TextView mRunTimeTV;
    private NetworkManager mNetworkManager;

    EpisodeDetails mEpisodeDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mImdbID = extras.getString("imdbID");
        }

        setContentView(R.layout.episode_details);
        mNetworkManager = NetworkManager.getInstance();


        initViews();

        fetchepisodeDetails();

    }

    private void fetchepisodeDetails() {

        mNetworkManager.getEpisodeDetails(new NetworkManager.ApiResultListener() {
            @Override
            public void onComplete(Object result) {
                mEpisodeDetails = (EpisodeDetails) result;
                setUpViews(mEpisodeDetails);

            }

            @Override
            public void onError() {
                Toast.makeText(EpisodeDetailsActivity.this, "Oops, something went wrong!!", Toast.LENGTH_SHORT).show();
            }
        }, mImdbID);
    }


    private void initViews() {
        mYearTV = (TextView) findViewById(R.id.year_text);
        mRatedTV = (TextView) findViewById(R.id.rated_text);
        mRleasedTV = (TextView) findViewById(R.id.released_text);
        mSeasonTV = (TextView) findViewById(R.id.season_text);
        mEpisodeTV = (TextView) findViewById(R.id.episode_text);
        mRunTimeTV = (TextView) findViewById(R.id.runtime_text);
    }

    private void setUpViews(EpisodeDetails episodeDetails) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(episodeDetails.getTitle());
        actionBar.show();
        
        mYearTV.setText(Integer.toString(episodeDetails.getYear()));
        mRatedTV.setText(episodeDetails.getRated());
        mRleasedTV.setText(episodeDetails.getReleased());
        mSeasonTV.setText(Integer.toString(episodeDetails.getSeason()));
        mEpisodeTV.setText(Integer.toString(episodeDetails.getEpisode()));
        mRunTimeTV.setText(episodeDetails.getRunTime());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gtepisode_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
