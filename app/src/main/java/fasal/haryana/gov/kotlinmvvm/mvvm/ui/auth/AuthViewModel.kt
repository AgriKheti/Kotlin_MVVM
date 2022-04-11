package fasal.haryana.gov.kotlinmvvm.mvvm.ui.auth

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.repositories.UserRepository
import fasal.haryana.gov.kotlinmvvm.mvvm.utils.Coroutines
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.snackbar

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

    }

    fun onSignUpbtn(view: View){
        Intent(view.context,SignUpActivity::class.java).also{
            view.context.startActivity(it)
        }
    }
    /*sending otp for login*/
    fun onSendOtp(view: View){

        if (email.isNullOrEmpty()){
            view.snackbar("Enter User Id")
            return
        }
        authListner?.onStarted()
        // this is a bad practices we are creating a other class instanc in Viewmodel class
        // we should avoid it
        // it is tight coupling


        /*calling it from coroutines*/

        Coroutines.main {
            val response = UserRepository().sendOtp(email!!)
            if (response.isSuccessful){
                authListner?.onSuccess(response)
            }
        }

//        val loginResponse = UserRepository().sendOtp(email!!)
//        authListner?.onSuccess(loginResponse)

    }
}