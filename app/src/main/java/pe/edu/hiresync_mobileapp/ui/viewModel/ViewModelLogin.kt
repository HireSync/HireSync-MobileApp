package pe.edu.hiresync_mobileapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.hiresync_mobileapp.repository.UserRepository
import pe.edu.hiresync_mobileapp.utils.Result

class ViewModelLogin(private val userRepository: UserRepository = UserRepository()) : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _lastName = MutableLiveData<String>()
    val lastName: LiveData<String> = _lastName

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> get() = _isLoggedIn

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChanged(email: String, lastName: String) {
        _email.value = email
        _lastName.value = lastName
    }

    fun login() {
        val email = _email.value
        val lastName = _lastName.value
        userRepository.login(email!!, lastName!!){result->
            if (result is Result.Success) {
                val users = result.data
                if(!users.isNullOrEmpty()){
                    _isLoggedIn.value = true
                }
            }
        }
    }

}
