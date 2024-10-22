package com.example.individual_14_modulo_5

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.individual_14_modulo_5.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        loginViewModel.loginResult.observe(this, Observer { result ->
            if (result) {
                Toast.makeText(this, "Login exitoso", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Datos inválidos", Toast.LENGTH_SHORT).show()
            }
        })

        // Manejar el botón de login
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val rememberMe = binding.cbRememberMe.isChecked

            loginViewModel.login(email, password, rememberMe)
        }
    }
}
