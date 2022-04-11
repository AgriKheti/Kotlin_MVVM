package fasal.haryana.gov.kotlinmvvm.mvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import fasal.haryana.gov.kotlinmvvm.R
import fasal.haryana.gov.kotlinmvvm.databinding.ActivityLoginBinding
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.showtoast

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
        showtoast("Login Started")
    }
    override fun onSuccess() {
        showtoast("Login Success")
    }
    override fun onFailure(message: String) {
        showtoast(message)
    }
}