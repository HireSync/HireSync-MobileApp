package pe.edu.hiresync_mobileapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val API_BASE_URL = "https://electric-difficult-liquid.glitch.me/"


    private var userService: UserService? = null
    fun getUserService(): UserService {
        if (userService == null) {
            val retrofit = Retrofit
                .Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            userService = retrofit.create(UserService:: class.java)
        }
        return userService as UserService
    }

}