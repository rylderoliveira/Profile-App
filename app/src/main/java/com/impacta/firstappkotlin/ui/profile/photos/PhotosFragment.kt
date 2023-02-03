package com.impacta.firstappkotlin.ui.profile.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.impacta.firstappkotlin.databinding.FragmentPhotosBinding
import com.impacta.firstappkotlin.ui.profile.Photo
import java.util.Random

class PhotosFragment : Fragment() {

    private lateinit var binding: FragmentPhotosBinding
    private val adapter = PhotoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPhotosBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initListeners()
    }

    private fun initListeners() {
        binding.floatingActionButtonPhotos.setOnClickListener {
            val urlList = listOf(
                "https://i.pinimg.com/236x/8b/ee/9a/8bee9a0f5485ac940546c6009bfb679e.jpg",
                "https://i.pinimg.com/236x/fe/96/88/fe968866d54d5ca867a613c2ddb2b3a4--soccer-memes-funny-photoshop.jpg",
                "https://pbs.twimg.com/profile_images/1337764119596896256/oBLxrSLC_400x400.jpg",
                "https://pbs.twimg.com/media/Epy6Tq0XEAE9Q-X.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRt-TrMyumPcB56kArfbfJ7Zy-sokjqB8rF9Hnpir3fTDvDeKLgqIgM69f1obJJw_EQXew&usqp=CAU",
            )
            val index = Random().nextInt(5)
            val photo = Photo(
                image = urlList[index],
                description = "Imagem Adiciona"
            )
            adapter.photos.add(0, photo)
            adapter.notifyItemInserted(0)
            binding.recyclerViewPhotos.scrollToPosition(0)
        }
    }

    private fun initRecyclerView() {
        binding.recyclerViewPhotos.layoutManager =
            GridLayoutManager(this.context, 3, GridLayoutManager.VERTICAL, false)
        binding.recyclerViewPhotos.adapter = adapter
    }
}