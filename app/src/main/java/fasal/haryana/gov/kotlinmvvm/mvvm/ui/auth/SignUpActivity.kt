package fasal.haryana.gov.kotlinmvvm.mvvm.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.gson.JsonObject
import fasal.haryana.gov.kotlinmvvm.R
import fasal.haryana.gov.kotlinmvvm.databinding.ActivityLoginBinding
import fasal.haryana.gov.kotlinmvvm.databinding.ActivitySignUpBinding
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.network.responses.AuthResponse
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.main.MainActivity
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.message
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SignUpActivity : AppCompatActivity(),KodeinAware {

    override val kodein by kodein()

    val factory: AuthViewModelFactory by instance()

    private lateinit var viewModel: AuthViewModel
    private lateinit var binding: ActivitySignUpBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)



        button_sign_up.setOnClickListener {
            val name = edit_text_name.text.toString().trim()
            val email = edit_text_email.text.toString().trim()
            val password = edit_text_password.text.toString().trim()
            val confpassword = edit_text_password_confirm.text.toString().trim()

            if (name.isEmpty()){
                message("Enter Name")

            }else if (email.isEmpty()){
                message("Enter Email")
            }else if (password.isEmpty()){
                message("Enter Password")
            }else if (confpassword.isEmpty()){
                message("Enter Confirm password")
            }else if (password!=confpassword){
                message("Password Mismatch")
            }
            else {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                message("Sign up success")
            }
        }



    }

}