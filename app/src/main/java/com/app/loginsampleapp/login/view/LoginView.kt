package com.app.loginsampleapp.login.view


interface LoginView {

    fun navigateToDashboard(username : String)

    fun usernameError()

    fun passwordError()

    fun showProgressBar()

    fun dismissProgressBar()

    fun loginFail()
}