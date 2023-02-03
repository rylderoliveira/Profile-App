package com.impacta.firstappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.impacta.firstappkotlin.profile.ProfileActivity

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
                val intent: Intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 1000)
    }
}