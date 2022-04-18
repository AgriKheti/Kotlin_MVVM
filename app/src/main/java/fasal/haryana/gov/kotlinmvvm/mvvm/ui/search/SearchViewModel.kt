package fasal.haryana.gov.kotlinmvvm.mvvm.ui.search

import androidx.lifecycle.ViewModel
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchViewModel(private val userRepository: UserRepository):ViewModel() {

    suspend fun searchSample(samleno:String,token:String) = withContext(Dispatchers.IO){userRepository.searchSample(samleno,token)}
    fun getLoggedInUser()=userRepository.getUser()

}