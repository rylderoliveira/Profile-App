package com.impacta.firstappkotlin.ui.profile

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.impacta.firstappkotlin.R
import com.impacta.firstappkotlin.ui.profile.curiosities.CuriositiesFragment
import com.impacta.firstappkotlin.ui.profile.photos.PhotosFragment

class ProfileActivity : AppCompatActivity() {

    private val cardViewContainer: CardView by lazy {
        findViewById(R.id.card_view_profile_fragment_container)
    }
    private val fragmentContainerView: FragmentContainerView by lazy {
        findViewById(R.id.fragment_container_view_profile)
    }
    private val textViewInfos: TextView by lazy {
        findViewById(R.id.text_view_profile_infos)
    }
    private val bottomNavigationView: BottomNavigationView by lazy {
        findViewById(R.id.bottom_navigation_view_profile)
    }
    private lateinit var user: User

    private val photosFragment: Fragment = PhotosFragment()
    private val curiositiesFragment: Fragment = CuriositiesFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initListeners()
        initInfos()
        bottomNavigationView.selectedItemId = R.id.item_menu_photo
    }

    private fun initInfos() {
        user = getUser()
        val infos = "${user.name}\n${user.age} anos\n${user.city}"
        textViewInfos.text = infos
    }

    private fun initListeners() {
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item_menu_photo -> inflateFragment(photosFragment)
                R.id.item_menu_curiosity -> inflateFragment(curiositiesFragment)
                else -> false
            }
        }
    }

    private fun inflateFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().apply {
            replace(fragmentContainerView.id, fragment)
            commit()
        }
        return true
    }
}
