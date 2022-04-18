package fasal.haryana.gov.kotlinmvvm.mvvm.ui.search

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import fasal.haryana.gov.kotlinmvvm.R
import fasal.haryana.gov.kotlinmvvm.databinding.ActivitySearchBinding
import fasal.haryana.gov.kotlinmvvm.databinding.ActivitySignUpBinding
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.auth.AuthViewModel
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.auth.AuthViewModelFactory
import fasal.haryana.gov.kotlinmvvm.mvvm.viewutil.message
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.include_myaccount_layout.*
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SearchActivity : AppCompatActivity(),KodeinAware {

    override val kodein by kodein()

    val factory: SearchViewModelFactory by instance()
    private lateinit var viewModel: SearchViewModel
    private lateinit var binding: ActivitySearchBinding
    private  var token:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        viewModel = ViewModelProvider(this, factory).get(SearchViewModel::class.java)


         viewModel.getLoggedInUser().observe(this, Observer {
                   token = it.accessToken.toString()
        })

        search_btn_1.setOnClickListener {
            val sampleno = search_et.text.toString().trim()
            if (sampleno.isEmpty()){
                message("Enter Sample No")
            }else {
                binding.progessBar.visibility= View.VISIBLE
               lifecycleScope.launch {

                        val response = viewModel.searchSample(sampleno,"bearer "+token)
                        response.let {
                            if (it.status!!.equals("1")){
                                sample_no_tv.setText(it.landDetail?.sampleno)
                                distname_tv.setText(it.landDetail?.DISNAME)
                                teh_tv.setText(it.landDetail?.TEHNAME)
                                block_tv.setText(it.landDetail?.BLKNAME)
                                village_tv.setText(it.landDetail?.VILNAME)
                                murabba_tv.setText(it.landDetail?.Muraba)
                                khasra_tv.setText(it.landDetail?.Khatoni)
                                khewat_tv.setText(it.landDetail?.Khewat)
                                latitude_et.setText(it.landDetail?.latitude)
                                longitude_et.setText(it.landDetail?.longitude)
                                message(response.message!!)
                            }
                            binding.progessBar.visibility= View.GONE
                        }

                }



            }
        }
    }
}