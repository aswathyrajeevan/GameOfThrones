package com.android.gameofthrones.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.gameofthrones.R;
import com.android.gameofthrones.models.Episode;

import java.util.ArrayList;

/**
 * Created by aswathyragesh on 1/10/16.
 */
public class EpisodeListAdapter extends BaseAdapter {

    private ArrayList<Episode> mEpisodes;

    public EpisodeListAdapter() {

    }

    @Override
    public int getCount() {
        return mEpisodes == null ? 0 : mEpisodes.size();
    }

    @Override
    public Object getItem(int position) {
        return mEpisodes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mEpisodes.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.episode_list_item, parent, false);
        }
        TextView episodeTitle = (TextView) convertView.findViewById(R.id.episode_title);

        Episode episode = (Episode) getItem(position);
        episodeTitle.setText(episode.getTitle());

        return convertView;
    }

    public ArrayList<Episode> getmEpisodes() {
        return mEpisodes;
    }

    public void setmEpisodes(ArrayList<Episode> mEpisodes) {
        this.mEpisodes = mEpisodes;
    }
}


