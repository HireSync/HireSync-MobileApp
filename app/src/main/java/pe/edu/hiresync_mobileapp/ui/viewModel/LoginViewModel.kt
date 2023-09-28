package pe.edu.hiresync_mobileapp.ui.viewModel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class LoginViewModel : ViewModel(){
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password
    private val _newpassword = MutableLiveData<String>()
    val newpassword: LiveData<String> = _newpassword

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name


    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable: LiveData<Boolean> = _loginEnable

    private val _signupEnable = MutableLiveData<Boolean>()
    val signupEnable: LiveData<Boolean> = _signupEnable


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    fun onLoginChanged(email: String, password: String ){
        _email.value= email
        _password.value=password
        _loginEnable.value= isValidEmail(email) && isValidPassword(password)

    }



    fun onSignUpChanged( name:String,newpassword:String ){
        _name.value=name
        _newpassword.value=newpassword
        _signupEnable.value= isValidNewPassword(newpassword)

    }

    private fun isValidPassword(password: String):Boolean = password.length > 6

    private fun isValidNewPassword(newpassword: String):Boolean = newpassword.length > 25

    private fun isValidEmail(email:String):Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()






}