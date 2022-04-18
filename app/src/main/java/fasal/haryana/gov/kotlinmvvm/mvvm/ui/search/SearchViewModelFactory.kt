package fasal.haryana.gov.kotlinmvvm.mvvm.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.auth.AuthViewModel
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.repositories.UserRepository


class SearchViewModelFactory (private val repository: UserRepository): ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchViewModel(repository) as T
//        that will give us the Authviewmodel with required constructor
    }

}