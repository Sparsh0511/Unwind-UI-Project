package com.example.unwindappwork.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unwindappwork.DemoVideoArticleAdapter
import com.example.unwindappwork.R
import com.example.unwindappwork.VideosAdapter

class DemoVideos: Fragment() {
    lateinit var videosRecyclerView: RecyclerView
    lateinit var questionRecyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.demo_videos, container, false)
        videosRecyclerView = view.findViewById(R.id.videosRecyclerView)
        questionRecyclerView = view.findViewById(R.id.issue_article_recycler_view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        videosRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val videoAdapter = VideosAdapter()
        videosRecyclerView.adapter = videoAdapter

        questionRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val issueAdapter = DemoVideoArticleAdapter()
        questionRecyclerView.adapter = issueAdapter

    }
}