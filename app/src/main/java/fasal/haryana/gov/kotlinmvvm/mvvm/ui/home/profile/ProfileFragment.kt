package fasal.haryana.gov.kotlinmvvm.mvvm.ui.home.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import fasal.haryana.gov.kotlinmvvm.R
import fasal.haryana.gov.kotlinmvvm.databinding.ProfileFragmentBinding
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import org.kodein.di.android.x.kodein

class ProfileFragment : Fragment(),KodeinAware {

    override val kodein by kodein()

    private lateinit var viewModel: ProfileViewModel
    private val factory :ProfileViewModelFactory by instance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding :ProfileFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.profile_fragment,
        container,false)
        viewModel = ViewModelProvider(this,factory).get(ProfileViewModel::class.java)
        binding.viewmodel=viewModel
        binding.lifecycleOwner=this
        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        viewModel = ViewModelProvider(this,).get(ProfileViewModel::class.java)
//        super.onActivityCreated(savedInstanceState)
//
//    }



}