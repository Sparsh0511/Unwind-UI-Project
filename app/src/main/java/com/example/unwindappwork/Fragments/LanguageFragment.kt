package com.example.unwindappwork.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unwindappwork.LanguagesAdapter
import com.example.unwindappwork.R

class LanguageFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.languages, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.languagesRecyclerView)
        val array = resources.getStringArray(R.array.languages)

        val languageAdapter = LanguagesAdapter(
            array
        )

        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = languageAdapter

    }
}