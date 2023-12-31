package pe.edu.hiresync_mobileapp.data.remote

import pe.edu.hiresync_mobileapp.data.model.PostulationResponse
import retrofit2.Call
import retrofit2.http.GET

interface PostulationService {
    @GET("all-recruitments")
    fun getAll(): Call<PostulationResponse>

}