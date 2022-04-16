package fasal.haryana.gov.kotlinmvvm.mvvm.ui.home.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.repositories.UserRepository

@Suppress("UNCHECKED_CAST")
class ProfileViewModelFactory (private val repository: UserRepository):ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModelFactory(repository) as T
//        that will give us the Authviewmodel with required constructor
    }

}
