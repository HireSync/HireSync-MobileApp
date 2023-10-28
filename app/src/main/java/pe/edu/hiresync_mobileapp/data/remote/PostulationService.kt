package pe.edu.hiresync_mobileapp.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface PostulationService {
    @GET(" ")
    fun getAll(): Call<PostulationResponse>
}