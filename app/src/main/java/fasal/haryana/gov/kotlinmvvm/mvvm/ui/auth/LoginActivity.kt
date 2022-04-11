package fasal.haryana.gov.kotlinmvvm.mvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import fasal.haryana.gov.kotlinmvvm.R
import fasal.haryana.gov.kotlinmvvm.databinding.ActivityLoginBinding
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.hide
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.show
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.showtoast
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.snackbar
import kotlinx.android.synthetic.main.activity_login.*

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
        showtoast("Login Started")
    }
    override fun onSuccess() {
        root_layout.snackbar("Login Success")
//        progress_bar.hide()
    }
    override fun onFailure(message: String) {
        showtoast(message)
    }
}