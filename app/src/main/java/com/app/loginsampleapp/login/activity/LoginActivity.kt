package com.app.loginsampleapp.login.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.loginsampleapp.R
import com.app.loginsampleapp.dashboard.activity.DashboardActivity
import com.app.loginsampleapp.login.presenter.LoginPresenter
import com.app.loginsampleapp.login.view.LoginView
import com.app.loginsampleapp.utils.Constants
import kotlinx.android.synthetic.main.activity_login.*
import android.view.*
import android.widget.Toast
import com.app.loginsampleapp.login.validator.LoginValidator

class LoginActivity : AppCompatActivity(), LoginView {

    val loginPresenter = LoginPresenter(this, LoginValidator())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnSubmit.setOnClickListener {

            loginPresenter.validateLogin(edtUsername.text.toString(),edtPassword.text.toString())
        }

    }

    override fun navigateToDashboard(loginUsername : String) {
        startActivity(Intent(this,DashboardActivity::class.java)
            .putExtra(Constants.BUNDLE_USERNAME,loginUsername))
    }

    override fun usernameError() {

        Toast.makeText(this,R.string.username_error,Toast.LENGTH_SHORT).show()
    }

    override fun passwordError() {
        Toast.makeText(this,R.string.password_error,Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun dismissProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun loginFail() {
        Toast.makeText(this,R.string.login_failed,Toast.LENGTH_SHORT).show()
    }

}