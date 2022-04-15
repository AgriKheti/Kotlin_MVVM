package fasal.haryana.gov.kotlinmvvm.mvvm.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.JsonObject
import fasal.haryana.gov.kotlinmvvm.R
import fasal.haryana.gov.kotlinmvvm.databinding.ActivityLoginBinding
import fasal.haryana.gov.kotlinmvvm.mvvm.mynotesApp.notesUi.HomeActivity
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.db.entities.AppDatabase
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.MyApis
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses.AuthResponse
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.repositories.UserRepository
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.main.MainActivity
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.hide
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.show
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.message
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),AuthListner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
        val api=MyApis()
        val db=AppDatabase(this)
        val repository=UserRepository(api,db)
        val factory = AuthViewModelFactory(repository)
        //in order to pass the constructor param in AuthViewModel we will be using ViewModel factory
//        now we have the view model from our factory
        val binding :ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewmodel = ViewModelProvider(this,factory).get(AuthViewModel::class.java)
        binding.viewmodel=viewmodel
        viewmodel.authListner=this


        viewmodel.getLoggedInUser().observe(this, Observer {
            it?.let {
//                Inte
                message("${it.Name.toString()} is Logged In Successfully")
                Intent(this,MainActivity::class.java).also {
                    startActivity(it)
                }
            }
        })

    }
    override fun onStarted() {
        progress_bar.show()
    }
    override fun onSuccess(loginResponse: JsonObject,key:String) {
        progress_bar.hide()
        if (loginResponse!= null && key.equals("otp")){
            message(loginResponse.toString())

            edit_text_password.visibility= View.VISIBLE
            button_sign_in.visibility=View.VISIBLE
        }else if (key.equals("login")){
            Intent(this,SignUpActivity::class.java).also {
                startActivity(it)
            }
        }
    }
    override fun onFailure(message: String) {
        message(message)
        progress_bar.hide()
    }
    override fun onLoginSuccess(response: AuthResponse) {
        progress_bar.hide()
        root_layout.snackbar("${response.Name.toString()} is logged Successfully"  )
            message("Login Successful done") }
}