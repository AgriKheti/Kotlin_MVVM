package fasal.haryana.gov.kotlinmvvm.mvvm.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel :ViewModel() {

    var email :String?=null
    var password :String?=null
    var authListner:AuthListner? =null

    fun onLoginClickBtn(view:View){
        authListner?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListner?.onFailure("All fileds are required ")
            /*show message*/
            return
        }
//            success
            authListner?.onSuccess()





    }
}