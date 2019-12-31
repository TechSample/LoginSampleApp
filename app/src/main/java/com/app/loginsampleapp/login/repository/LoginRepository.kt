package com.app.loginsampleapp.login.repository

import com.app.loginsampleapp.utils.Constants
import com.app.loginsampleapp.login.model.User


class LoginRepository {

    private val repositoryUser = User(Constants.PREDEFINED_USERNAME,Constants.PREDEFINED_PASSWORD) // Predefined User Model Data

    fun validateCredentials(userEntity : User) : Int {

        if(userEntity.userName.equals(repositoryUser.userName)&& userEntity.password.equals(repositoryUser.password)){
            return Constants.RESPONSE_SUCCESS
        }else{
            return Constants.RESPONSE_FAIL
        }
    }
}