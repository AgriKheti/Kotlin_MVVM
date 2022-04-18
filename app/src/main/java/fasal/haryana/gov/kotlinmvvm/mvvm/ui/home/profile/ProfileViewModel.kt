package fasal.haryana.gov.kotlinmvvm.mvvm.ui.home.profile

import androidx.lifecycle.ViewModel
import fasal.haryana.gov.kotlinmvvm.mvvm.ui.data.repositories.UserRepository

class ProfileViewModel(userRepository: UserRepository) : ViewModel() {

    val user = userRepository.getUser()

}