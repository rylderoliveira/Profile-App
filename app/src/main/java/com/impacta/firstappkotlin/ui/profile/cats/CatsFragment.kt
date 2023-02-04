package com.impacta.firstappkotlin.ui.profile.cats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.impacta.firstappkotlin.core.CatService
import com.impacta.firstappkotlin.core.RetrofitCat
import com.impacta.firstappkotlin.databinding.FragmentCatsBinding
import com.impacta.firstappkotlin.model.Cat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CatsFragment : Fragment() {

    private lateinit var binding: FragmentCatsBinding
    private val adapter = CatAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCatsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        GlobalScope.launch(Dispatchers.Main) {
           runCatching {
                val retrofit = RetrofitCat.instance.create(CatService::class.java)
                val response = retrofit.getRandomCats()
                if (response.isSuccessful) {
                    showCats(response.body())
                } else {
                    showError()
                }
            }
        }
    }

    private fun initRecyclerView() {
        binding.recyclerViewCats.layoutManager =
            GridLayoutManager(this.context, 2, GridLayoutManager.VERTICAL, false)
        binding.recyclerViewCats.adapter = adapter
    }

    private fun showError() {
        Toast.makeText(this.context, "Erro ao realizar requisição", Toast.LENGTH_LONG).show()
    }

    private fun showCats(cats: List<Cat>?) {
        adapter.items = cats ?: listOf()
        adapter.notifyItemRangeInserted(0, cats?.size ?: 0)
    }
}