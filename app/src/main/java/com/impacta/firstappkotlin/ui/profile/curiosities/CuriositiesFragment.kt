package com.impacta.firstappkotlin.ui.profile.curiosities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.impacta.firstappkotlin.R

class CuriositiesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = CuriosityAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_curiosities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        initRecyclerView()
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recycler_view_curiosity)
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }
}