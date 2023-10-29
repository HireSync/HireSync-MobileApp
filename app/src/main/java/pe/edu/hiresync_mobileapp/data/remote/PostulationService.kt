package pe.edu.hiresync_mobileapp.data.remote

import pe.edu.hiresync_mobileapp.data.model.PostulationResponse
import retrofit2.Call
import retrofit2.http.GET

interface PostulationService {
    @GET("phases")
    fun getAll(): Call<PostulationResponse>
}