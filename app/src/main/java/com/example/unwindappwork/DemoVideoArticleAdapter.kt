package com.example.unwindappwork

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DemoVideoArticleAdapter: RecyclerView.Adapter<DemoVideoArticleAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val questionTitle = view.findViewById<TextView>(R.id.issueTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.issuse_single_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        // return the number of issues dynamically fetched from server
        return 4
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // set the question title here
        holder.questionTitle.text = "Pay Bills"
    }


}