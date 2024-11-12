package com.example.tgsretrofit.adapter.com.example.tgsretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tgsretrofit.databinding.ItemTrackBinding
import com.example.tgsretrofit.model.Track

class TrackAdapter(private val tracks: List<Track>) : RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {
    inner class TrackViewHolder(val binding: ItemTrackBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val binding = ItemTrackBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrackViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val track = tracks[position]

        with(holder.binding) {
            trackTitle.text = track.title
            artistName.text = track.artist.name
            Glide.with(holder.itemView)
                .load(track.album.coverUrl)
                .into(albumCover)
        }
    }

    override fun getItemCount(): Int = tracks.size
}