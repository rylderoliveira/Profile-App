package com.impacta.firstappkotlin.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.impacta.firstappkotlin.R
import com.impacta.firstappkotlin.isSigned
import com.impacta.firstappkotlin.ui.login.LoginActivity
import com.impacta.firstappkotlin.ui.profile.ProfileActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val handler = Handler()
        handler.postDelayed({
            if(isSigned) {
                val intent: Intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent: Intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 1000)
    }
}