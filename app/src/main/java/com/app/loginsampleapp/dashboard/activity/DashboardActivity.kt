package com.app.loginsampleapp.dashboard.activity

import android.os.Bundle
import android.provider.SyncStateContract
import androidx.appcompat.app.AppCompatActivity
import com.app.loginsampleapp.R
import com.app.loginsampleapp.dashboard.presenter.DashboardPresenter
import com.app.loginsampleapp.dashboard.view.DashboardView
import com.app.loginsampleapp.utils.Constants
import kotlinx.android.synthetic.main.activity_dashboard.*


class DashboardActivity : AppCompatActivity(), DashboardView{

    val dashboardPresenter = DashboardPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        if(intent.getStringExtra(Constants.BUNDLE_USERNAME) != null){
            dashboardPresenter.getLoggedInUsername(intent.getStringExtra(Constants.BUNDLE_USERNAME))
        }

    }

    override fun showUsername(username : String) {
        val welcomeHint = String.format(resources.getString(R.string.welcome_user),username)
        txtWelcomeUser.text = welcomeHint
    }

}