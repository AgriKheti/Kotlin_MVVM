package fasal.haryana.gov.kotlinmvvm.mvvm.ui.auth

import androidx.lifecycle.LiveData
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.db.entities.User

interface AuthListner {

    fun onStarted()
    fun onSuccess(loginResponse: LiveData<User>)
    fun onFailure(message:String)
}