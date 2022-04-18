package fasal.haryana.gov.kotlinmvvm.mvvm.ui.home.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import fasal.haryana.gov.kotlinmvvm.R
import fasal.haryana.gov.kotlinmvvm.databinding.ProfileFragmentBinding
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.repositories.UserRepository
import kotlinx.android.synthetic.main.profile_fragment.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import org.kodein.di.android.x.kodein

class ProfileFragment : Fragment(),KodeinAware {

    override val kodein by kodein()

    private lateinit var viewModel: ProfileViewModel
    private lateinit var binding: ProfileFragmentBinding
    private val factory :ProfileViewModelFactory by instance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         binding  = DataBindingUtil.inflate(inflater, R.layout.profile_fragment,
        container,false)
        viewModel = ViewModelProvider(this,factory).get(ProfileViewModel::class.java)
        binding.lifecycleOwner=this



        viewModel.user.observe(viewLifecycleOwner, Observer { user->
           user?.let {
               edit_text_name.setText(it.Name.toString())
               edit_text_mobile.setText(it.MobileNumber.toString())
           }
       })





        return binding.root

    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        viewModel = ViewModelProvider(this,).get(ProfileViewModel::class.java)
//        super.onActivityCreated(savedInstanceState)
//
//    }



}