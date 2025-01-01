package com.example.unwindappwork

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LanguagesAdapter(
    val languages: Array<String>,
    var selectedPosition: Int = -1
) : RecyclerView.Adapter<LanguagesAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val language = view.findViewById<TextView>(R.id.tvLanguage)
        val radioButton = view.findViewById<RadioButton>(R.id.rbLanguage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.languages_single_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return languages.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val languages = languages[position]
        holder.language.text = languages
        holder.radioButton.isChecked = position == selectedPosition

        holder.radioButton.setOnClickListener {
            selectedPosition = position
            notifyDataSetChanged()
        }
    }
}