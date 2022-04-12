package fasal.haryana.gov.kotlinmvvm.mvvm.ui.auth

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.repositories.UserRepository
import fasal.haryana.gov.kotlinmvvm.mvvm.utils.Coroutines
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.snackbar

class AuthViewModel :ViewModel() {

    var email :String?=null
    var otp :String?=null
    var authListner:AuthListner? =null

    fun onSubmitOtpBtn(view:View){
        authListner?.onStarted()
        if (email.isNullOrEmpty() || otp.isNullOrEmpty()){
            authListner?.onFailure("All fileds are required ")
            /*show message*/
            return
        }
        /*hit submit otp from here*/
//            success
        Coroutines.main {
            val response = UserRepository().submitOtp(email!!, otp!!)
            authListner?.onSuccess(response ,"login")
        }

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
            if (response!=null)
                authListner?.onSuccess(response,"otp")

            }
        }

//        val loginResponse = UserRepository().sendOtp(email!!)
//        authListner?.onSuccess(loginResponse)

    }
