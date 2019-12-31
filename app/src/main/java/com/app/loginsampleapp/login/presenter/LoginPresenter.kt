package com.app.loginsampleapp.login.presenter

import com.app.loginsampleapp.login.repository.LoginRepository
import com.app.loginsampleapp.login.validator.LoginValidator
import com.app.loginsampleapp.login.view.LoginView
import com.app.loginsampleapp.utils.Constants
import com.app.loginsampleapp.login.model.User



class LoginPresenter(private val loginView : LoginView,loginVal : LoginValidator): LoginValidator.LoginListener{

    private val loginRepository = LoginRepository()
    private val loginValidator = loginVal

    override fun invalidUsername() {

        loginView.usernameError()
        loginView.dismissProgressBar()
    }

    override fun invalidPassword() {

        loginView.passwordError()
        loginView.dismissProgressBar()
    }

    override fun onValidLoginDetails(username: String, password: String) {

        validateLoginWithRepository(username,password)
    }

    fun validateLogin(username : String, password: String){
        loginView.showProgressBar()
        loginValidator.validateLoginInput(username,password, this)
    }

    private fun validateLoginWithRepository(username : String, password : String){

        val responseCode = loginRepository.validateCredentials(User(username, password))
        if (responseCode == Constants.RESPONSE_SUCCESS) {
            loginView.dismissProgressBar()
            loginView.navigateToDashboard(username)
        } else {
            loginView.dismissProgressBar()
            loginView.loginFail()
        }

    }


}