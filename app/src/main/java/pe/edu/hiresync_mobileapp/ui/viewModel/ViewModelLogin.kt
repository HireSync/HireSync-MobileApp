package pe.edu.hiresync_mobileapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.hiresync_mobileapp.data.model.UserRequest
import pe.edu.hiresync_mobileapp.data.model.UserResponse
import pe.edu.hiresync_mobileapp.repository.UserRepository
import pe.edu.hiresync_mobileapp.utils.Result

class ViewModelLogin(private val userRepository: UserRepository = UserRepository()) : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _loggedInUser = MutableLiveData<UserResponse?>()
    val loggedInUser: LiveData<UserResponse?> get() = _loggedInUser
    
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> get() = _name

    private val _phone = MutableLiveData<String>()
    val phone: LiveData<String> get() = _phone


    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> get() = _isLoggedIn

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
    }

    fun login() {
        val email = _email.value
        val password = _password.value
        userRepository.login(email!!, password!!){result->
            if (result is Result.Success) {
                val users = result.data
                if(!users.isNullOrEmpty()){
                    _isLoggedIn.value = true
                    val loggedInUser = users[0]
                    _loggedInUser.value = loggedInUser
                }
            }
        }
    }

    fun editProfile(updatedProfile: UserRequest) {
        val userId = _loggedInUser.value?.id
        if (userId != null) {
            userRepository.editProfile(userId, updatedProfile) { result ->
                if (result is Result.Success) {
                }
            }
        }
    }

}
