package fasal.haryana.gov.kotlinmvvm.mvvm.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.gson.JsonObject
import fasal.haryana.gov.kotlinmvvm.R
import fasal.haryana.gov.kotlinmvvm.databinding.ActivityLoginBinding
import fasal.haryana.gov.kotlinmvvm.databinding.ActivitySignUpBinding
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses.AuthResponse
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.message
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SignUpActivity : AppCompatActivity(),AuthListner,KodeinAware {

    override val kodein by kodein()

    val factory: AuthViewModelFactory by instance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivitySignUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        val viewmodel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)

    }

    override fun onStarted() {


    }

    override fun onSuccess(loginResponse: JsonObject, key: String) {
    }

    override fun onFailure(message: String) {
        message(message)
    }

    override fun onLoginSuccess(response: AuthResponse) {
    }
}