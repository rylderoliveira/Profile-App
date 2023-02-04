package com.impacta.firstappkotlin.ui.profile.dogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.impacta.firstappkotlin.core.DogService
import com.impacta.firstappkotlin.core.RetrofitDog
import com.impacta.firstappkotlin.databinding.FragmentDogsBinding
import com.impacta.firstappkotlin.model.Dog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DogsFragment : Fragment() {

    private lateinit var binding: FragmentDogsBinding
    private val adapter = DogAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDogsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initListeners()

    }

    private fun initListeners() {
        binding.buttonDogsSearch.setOnClickListener {
            val id = binding.editTextDogsRace.text.toString()
            val limit = binding.editTextDogsQuantity.text.toString().toInt()
            getCats(id, limit)
        }
    }

    private fun initRecyclerView() {
        binding.recyclerViewDogs.layoutManager =
            GridLayoutManager(this.context, 2, GridLayoutManager.VERTICAL, false)
        binding.recyclerViewDogs.adapter = adapter
    }

    private fun getRandomCats() {
        GlobalScope.launch(Dispatchers.Main) {
            runCatching {
                val retrofit = RetrofitDog.instance.create(DogService::class.java)
                val response = retrofit.getRandomDogs()
                if (response.isSuccessful) {
                    showDogs(response.body())
                } else {
                    showError()
                }
            }
        }
    }

    private fun getCats(id: String, limit: Int) {
        GlobalScope.launch(Dispatchers.Main) {
            runCatching {
                val retrofit = RetrofitDog.instance.create(DogService::class.java)
                val response = retrofit.getDogs(id, limit)
                if (response.isSuccessful) {
                    showDogs(response.body())
                } else {
                    showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(this.context, "Erro ao realizar requisição", Toast.LENGTH_LONG).show()
    }

    private fun showDogs(dogs: List<Dog>?) {
        adapter.items = dogs ?: emptyList()
        adapter.notifyDataSetChanged()
    }
}