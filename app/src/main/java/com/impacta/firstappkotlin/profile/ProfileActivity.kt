package com.impacta.firstappkotlin.profile

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.impacta.firstappkotlin.R
import com.impacta.firstappkotlin.profile.curiosities.CuriositiesFragment
import com.impacta.firstappkotlin.profile.photos.PhotosFragment

class ProfileActivity : AppCompatActivity() {

    private val cardViewPhotos: CardView by lazy {
        findViewById(R.id.card_view_profile_photos)
    }
    private val cardViewCuriosities: CardView by lazy {
        findViewById(R.id.card_view_profile_curiosities)
    }
    private val cardViewContainer: CardView by lazy {
        findViewById(R.id.card_view_profile_fragment_container)
    }
    private val fragmentContainerView: FragmentContainerView by lazy {
        findViewById(R.id.fragment_container_view_profile)
    }
    private val textViewInfos: TextView by lazy {
        findViewById(R.id.text_view_profile_infos)
    }
    private lateinit var user: User

    private val photosFragment: Fragment = PhotosFragment()
    private val curiositiesFragment: Fragment = CuriositiesFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initListeners()
        initInfos()
    }

    private fun initInfos() {
        user = getUser()
        val infos = "${user.name}\n${user.age} anos\n${user.city}"
        textViewInfos.text = infos
    }

    private fun initListeners() {
        cardViewPhotos.setOnClickListener {
            inflateFragment(photosFragment)
        }
        cardViewCuriosities.setOnClickListener {
            inflateFragment(curiositiesFragment)
        }
    }

    private fun inflateFragment(fragment: Fragment) {
        cardViewContainer.visibility = View.VISIBLE
        supportFragmentManager.beginTransaction().apply {
            replace(fragmentContainerView.id, fragment)
            commit()
        }
    }
}