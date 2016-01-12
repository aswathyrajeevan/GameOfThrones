package com.android.gameofthrones.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.gameofthrones.adapters.EpisodeListAdapter;
import com.android.gameofthrones.R;
import com.android.gameofthrones.api.NetworkManager;
import com.android.gameofthrones.models.Episode;
import com.android.gameofthrones.models.GameOfThrones;

import java.util.ArrayList;

public class EpisodeListActivity extends AppCompatActivity {


    private NetworkManager mNetworkManager;
    private ArrayList<Episode> mEpisodes;

    private ListView mEpisodesListView;
    private EpisodeListAdapter mEpisodeListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.episode_list);

        mEpisodesListView = (ListView) findViewById(R.id.episode_list);
        mEpisodeListAdapter = new EpisodeListAdapter();
        mEpisodesListView.setAdapter(mEpisodeListAdapter);
        mNetworkManager = NetworkManager.getInstance();

        mEpisodesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(EpisodeListActivity.this, EpisodeDetailsActivity.class);
                intent.putExtra("imdbID", mEpisodes.get(position).getImdbID());
                startActivity(intent);
            }
        });

        fetchEpisodes();

    }

    private void fetchEpisodes() {
        mNetworkManager.getEpisodes(new NetworkManager.ApiResultListener() {
            @Override
            public void onComplete(Object result) {
                GameOfThrones gameOfThrones = (GameOfThrones) result;
                mEpisodes =  gameOfThrones.getmEpisodes();
                mEpisodeListAdapter.setmEpisodes(mEpisodes);
                mEpisodeListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError() {
                Toast.makeText(EpisodeListActivity.this, "Oops, something went wrong!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_episode_list, menu);
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
