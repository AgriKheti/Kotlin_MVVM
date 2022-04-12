package fasal.haryana.gov.kotlinmvvm.mvvm.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonObject
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.db.entities.User
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses.AuthResponse
import retrofit2.Call
import retrofit2.Response

interface AuthListner {

    fun onStarted()
    fun onSuccess(loginResponse: JsonObject,key:String)
    fun onFailure(message:String)
}