package fasal.haryana.gov.kotlinmvvm.mvvm.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.google.gson.JsonObject
import fasal.haryana.gov.kotlinmvvm.R
import fasal.haryana.gov.kotlinmvvm.databinding.ActivityLoginBinding
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.hide
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.show
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.showtoast
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity(),AuthListner {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)

        val binding :ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewmodel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.viewmodel=viewmodel
        viewmodel.authListner=this

    }

    override fun onStarted() {
        progress_bar.show()

    }
    override fun onSuccess(loginResponse: JsonObject,key:String) {
        progress_bar.hide()

        if (loginResponse!= null && key.equals("otp")){
            showtoast(loginResponse.toString())
            edit_text_password.visibility= View.VISIBLE
            button_sign_in.visibility=View.VISIBLE
        }else if (key.equals("login")){

            Intent(this,SignUpActivity::class.java).also {
                startActivity(it)
            }
        }
//        root_layout.snackbar("Login Success")
//        progress_bar.hide()
    }
    override fun onFailure(message: String) {
        showtoast(message)
        progress_bar.hide()
    }
}