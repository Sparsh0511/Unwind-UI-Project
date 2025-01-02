package com.example.unwindappwork

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class VideosAdapter: RecyclerView.Adapter<VideosAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val videoThumbnail = view.findViewById<ImageView>(R.id.video_thumbnail)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        // return the number of videos fetched from the server
        return 10;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // load images dynamically
        holder.videoThumbnail.setImageResource(R.drawable.upi)
    }
}