package fasal.haryana.gov.kotlinmvvm.mvvm.ui.auth

import com.google.gson.JsonObject
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses.AuthResponse

interface AuthListner {

    fun onStarted()
    fun onSuccess(loginResponse: JsonObject,key:String)
    fun onFailure(message:String)
    fun onLoginSuccess(response: AuthResponse)
}