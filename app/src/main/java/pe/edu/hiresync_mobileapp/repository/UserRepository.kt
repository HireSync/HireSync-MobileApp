package pe.edu.hiresync_mobileapp.repository

import pe.edu.hiresync_mobileapp.data.model.UserRequest
import  pe.edu.hiresync_mobileapp.utils.Result
import pe.edu.hiresync_mobileapp.data.model.UserResponse
import pe.edu.hiresync_mobileapp.data.remote.ApiClient
import pe.edu.hiresync_mobileapp.data.remote.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(private val userService: UserService = ApiClient.getUserService()) {


    fun register(userRequest: UserRequest, callback: (Result<UserResponse>) -> Unit) {
        val registerCall = userService.register(userRequest)
        registerCall.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val userResponse = response.body()
                    if (userResponse != null) {
                        callback(Result.Success(userResponse))
                    } else {
                        callback(Result.Error("Response body is null"))
                    }
                } else {
                    callback(Result.Error("Registration failed: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                val message = t.message ?: "Unknown error occurred"
                callback(Result.Error(message))
            }
        })
    }







}












