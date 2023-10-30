package pe.edu.hiresync_mobileapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PostulationClient {
    private const val API_BASE_URL = "https://electric-difficult-liquid.glitch.me/"


    private var postulationService: PostulationService? = null

    fun getPostulationService(): PostulationService{
        if(postulationService == null){
            val retrofit = Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            postulationService = retrofit.create(PostulationService::class.java)
        }
        return postulationService as PostulationService
    }
}