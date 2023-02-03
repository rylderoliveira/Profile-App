package com.impacta.firstappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.impacta.firstappkotlin.profile.ProfileActivity

class MainActivity : AppCompatActivity() {

    private val textViewTitle: TextView by lazy {
        findViewById(R.id.text_view_main_title)
    }
    private val editTextEmail: EditText by lazy {
        findViewById(R.id.edit_text_main_email)
    }
    private val editTextPassword: EditText by lazy {
        findViewById(R.id.edit_text_main_password)
    }
    private val buttonLogin: Button by lazy {
        findViewById(R.id.button_main_login)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonLogin.setOnClickListener {
            validateInfo()
        }
    }

    private fun validateInfo() {
        if (validateEmailAt() &&
            validatePassworLength() &&
            validatePasswordNumberAndChar() &&
            validatePasswordUpperCase()) {
            navigateToProfile()
        } else {
            Toast.makeText(this, "Ops, algo deu errado\nTente novamente", Toast.LENGTH_LONG).show()
        }
    }

    private fun navigateToProfile() {
        isSigned = true
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun validatePasswordUpperCase() : Boolean {
        val password = editTextPassword.text.toString()
        val verifyList = mutableListOf<Boolean>()
        password.forEach {
            if (it.isUpperCase()) {
                verifyList.add(true)
            } else {
                verifyList.add(false)
            }
        }
        return verifyList.contains(false)
    }

    private fun validatePasswordNumberAndChar() : Boolean {
        val password = editTextPassword.text.toString()
        var hasNumber = false
        var hasLetter = false
        if (password.contains("[0-9]".toRegex())) {
            hasNumber = true
        }
        if (password.contains("[a-z|A-Z]".toRegex())) {
            hasLetter = true
        }
        return hasNumber && hasLetter
    }

    private fun validatePassworLength() : Boolean {
        val password = editTextPassword.text.toString()
        return password.length > 4
    }

    private fun validateEmailAt() : Boolean {
        val email = editTextEmail.text.toString()
        return email.contains("@")
    }
}
