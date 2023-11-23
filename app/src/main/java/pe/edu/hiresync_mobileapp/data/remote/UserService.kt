package pe.edu.hiresync_mobileapp.data.remote

import pe.edu.hiresync_mobileapp.data.model.UserRequest
import pe.edu.hiresync_mobileapp.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService {

    @POST("users")
    fun register(@Body userRequest: UserRequest): Call<UserResponse>

    @GET("users")
    fun login(@Query("email") email: String, @Query("password")lastName: String): Call<List<UserResponse>>

    @PUT("users/{userId}")
    fun updateUser(
        @Path("userId") userId: Int,
        @Body updatedUser: UserRequest
    ): Call<UserResponse>

}
