package pe.edu.hiresync_mobileapp.data.remote

import pe.edu.hiresync_mobileapp.data.model.UserRequest
import pe.edu.hiresync_mobileapp.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("users")
    fun register(@Body userRequest: UserRequest): Call<UserResponse>
}