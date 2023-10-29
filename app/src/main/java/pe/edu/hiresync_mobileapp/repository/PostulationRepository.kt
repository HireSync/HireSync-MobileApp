package pe.edu.hiresync_mobileapp.repository

import pe.edu.hiresync_mobileapp.data.model.Postulation
import pe.edu.hiresync_mobileapp.data.model.PostulationResponse
import pe.edu.hiresync_mobileapp.data.remote.PostulationClient
import pe.edu.hiresync_mobileapp.data.remote.PostulationService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import pe.edu.hiresync_mobileapp.utils.Result

class PostulationRepository(
    private val postulationService: PostulationService = PostulationClient.getPostulationService(),

    ){
    fun getByAll(callback: (Result<List<Postulation>>)->Unit ){
        val getAll = postulationService.getAll()

        getAll.enqueue(object : Callback<PostulationResponse> {
            override fun onResponse(call: Call<PostulationResponse>, response: Response<PostulationResponse>) {
                if (response.isSuccessful) {
                    callback(Result.Success(data = response.body()!!.postulations))
                }
            }

            override fun onFailure(call: Call<PostulationResponse>, t: Throwable) {
                callback(Result.Error(t.localizedMessage))
            }

        })
    }

}
