package pe.edu.hiresync_mobileapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PostulationClient {
    private const val API_BASE_URL = "http://deploymoviles1-001-site1.btempurl.com/api/v1/recruitment/processes/"

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