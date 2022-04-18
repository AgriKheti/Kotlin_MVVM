package fasal.haryana.gov.kotlinmvvm.mvvm.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.gson.JsonObject
import fasal.haryana.gov.kotlinmvvm.R
import fasal.haryana.gov.kotlinmvvm.databinding.ActivityLoginBinding
import fasal.haryana.gov.kotlinmvvm.mvvm.mynotesApp.notesUi.HomeActivity
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses.AuthResponse
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.home.MyHomeActivity
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.hide
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.message
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.show
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.snackbar
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(),KodeinAware {

    override val kodein by kodein()

    val factory: AuthViewModelFactory by instance()
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewmodel :AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)

        //in order to pass the constructor param in AuthViewModel we will be using ViewModel factory
//        now we have the view model from our factory
        binding  =DataBindingUtil.setContentView(this, R.layout.activity_login)
         viewmodel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)


        viewmodel.getLoggedInUser().observe(this, Observer {
            it?.let {
//                Inte
                message("${it.Name.toString()} is Logged In Successfully")
                Intent(this, MyHomeActivity::class.java).also {
                    startActivity(it)
                }
            }
        })


        binding.buttonSendOtp.setOnClickListener {
            sendotp()
        }

        button_sign_in.setOnClickListener {

            signincall()

    }





        text_view_sign_up.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun signincall() {
            val userid = binding.editTextUserid.text.toString().trim()
            val otp = binding.editTextOtp.text.toString().trim()

            if (otp.isEmpty()){
                message("Enter Otp")
            }else {
                lifecycleScope.launch {
                    val authResponse=viewmodel.onSubmitotp(userid,otp)
                    message("${authResponse.Name} is Logged in Successfully")
                    viewmodel.saveLoggedinUser(authResponse)
                }
                val intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)
            }

    }

    private fun sendotp() {

        val userid = binding.editTextUserid.text.toString().trim()

        if (userid.isNullOrEmpty()) {
            message("Enter User ID")
        } else lifecycleScope.launch {
            val response = viewmodel.onSendOtp(userid)
            message(response.toString())
            edit_text_otp.visibility = View.VISIBLE
            button_sign_in.visibility = View.VISIBLE

        }

//    override fun onStarted() {
//        progress_bar.show()
//    }

//    override fun onSuccess(loginResponse: JsonObject, key: String) {
//        progress_bar.hide()
//        if (key.equals("otp")) {
//            message(loginResponse.toString())
//
//            edit_text_otp.visibility = View.VISIBLE
//            button_sign_in.visibility = View.VISIBLE
//        } else if (key.equals("login")) {
//            Intent(this, SignUpActivity::class.java).also {
//                startActivity(it)
//            }
//        }
//    }


    }
}