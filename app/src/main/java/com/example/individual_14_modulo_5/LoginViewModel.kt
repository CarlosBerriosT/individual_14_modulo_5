package com.example.individual_14_modulo_5

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> get() = _loginResult


    fun login(email: String, password: String, rememberMe: Boolean) {

        if (isValidEmail(email) && isValidPassword(password)) {
            _loginResult.value = true
        } else {
            _loginResult.value = false
        }


    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }
}
