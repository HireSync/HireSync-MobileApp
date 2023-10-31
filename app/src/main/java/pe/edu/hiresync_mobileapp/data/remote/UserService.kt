package pe.edu.hiresync_mobileapp.data.remote

import pe.edu.hiresync_mobileapp.data.model.UserRequest
import pe.edu.hiresync_mobileapp.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserService {

    @POST("users")
    fun register(@Body userRequest: UserRequest): Call<UserResponse>

    @GET("users")
    fun login(@Query("email") email: String, @Query("lastName")lastName: String): Call<List<UserResponse>>
}