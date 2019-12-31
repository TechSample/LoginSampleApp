package com.app.loginsampleapp.login.validator

class LoginValidator {

    fun validateLoginInput(username: String, password: String, loginListener: LoginListener){

        when {

            username.isEmpty() -> loginListener.invalidUsername()
            password.isEmpty() -> loginListener.invalidPassword()
            else -> loginListener.onValidLoginDetails(username,password)

        }
    }

    interface LoginListener {

        fun invalidUsername()
        fun invalidPassword()
        fun onValidLoginDetails(username: String,password: String)
    }
}