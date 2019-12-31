package com.app.loginsampleapp.dashboard.presenter

import com.app.loginsampleapp.dashboard.view.DashboardView

class DashboardPresenter (val dashboardView : DashboardView){

    private lateinit var loggedInUsername : String


    fun getLoggedInUsername(loggedInUser: String){
        loggedInUsername = loggedInUser
        dashboardView.showUsername(loggedInUsername)
    }
}