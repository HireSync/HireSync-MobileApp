package pe.edu.hiresync_mobileapp.data.remote

import com.google.gson.annotations.SerializedName
import pe.edu.hiresync_mobileapp.data.model.Postulation

data class PostulationResponse(
    @SerializedName("postulations")
    val postulations: List<Postulation>
)
