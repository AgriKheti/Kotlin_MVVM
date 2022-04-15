package fasal.haryana.gov.kotlinmvvm.mvvm.ui.auth

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import fasal.haryana.gov.kotlinmvvm.mvvm.mynotesApp.notesUi.HomeActivity
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.repositories.UserRepository
import fasal.haryana.gov.kotlinmvvm.mvvm.utils.ApiException
import fasal.haryana.gov.kotlinmvvm.mvvm.utils.Coroutines
import fasal.haryana.gov.kotlinmvvm.mvvm.utils.NoInternetException
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.hide
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.message
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.snackbar
import kotlinx.android.synthetic.main.activity_login.view.*

//this is called constructor injection , atleast once we need to create the instance that we will do in LoginActivity
/*we will be using dependency injection as passing classes in constructor to avoid tight coupled*/
class AuthViewModel(private  val userRepository: UserRepository) : ViewModel() {

    var email: String? = null
    var otp: String? = null
    var authListner: AuthListner? = null


//    to check the details of logged in user
    fun getLoggedInUser()=userRepository.getUser()  // now this will called in activity
    fun onSubmitOtpBtn(view: View) {
        authListner?.onStarted()
        if (email.isNullOrEmpty() || otp.isNullOrEmpty()) {
            authListner?.onFailure("All fileds are required ")
            /*show message*/
            return
        }
        /*hit submit otp from here*/
//            success
        Coroutines.main {
            try {
                val loginresponse = userRepository.submitOtp(email!!, otp!!)
                loginresponse.let {
                    authListner?.onLoginSuccess(it)

                    userRepository.saveUser(loginresponse)//user details saved in database
                    return@main
                }

                authListner?.onFailure(loginresponse.toString())
                /*if it is null */

            } catch (e: ApiException) {
                authListner?.onFailure(e.message!!)
            }catch (e:NoInternetException){
                authListner?.onFailure(e.message!!)
            }
//            val response = UserRepository().submitOtp(email!!, otp!!)
//            authListner?.onLoginSuccess(response)
        }

    }

    fun onSignUpbtn(view: View) {
        Intent(view.context, SignUpActivity::class.java).also {
            view.context.startActivity(it)

        }
    }
    // this is a bad practices we are creating a other class instance in Viewmodel class
    // we should avoid it
    // it is tight coupling
    /*calling it from coroutines*/
    /*sending otp for login*/
    fun onSendOtp(view: View) {

        if (email.isNullOrEmpty()) {
            view.snackbar("Enter User Id")
            return
        }
        authListner?.onStarted()
            Coroutines.main {
                try {
                    val response = userRepository.sendOtp(email!!)
                    authListner?.onSuccess(response, "otp")
                }catch (e:NoInternetException){
                    authListner?.onFailure(e.message!!)
                }
            }

    }

    fun ToNotesscreen(view: View) {
        Intent(view.context, HomeActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

//        val loginResponse = UserRepository().sendOtp(email!!)
//        authListner?.onSuccess(loginResponse)

}
