package pe.edu.hiresync_mobileapp.data.model

import com.google.gson.annotations.SerializedName

data class PostulationResponse(
    val postulations: List<Postulation>
)

data class Postulation(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("created_date")
    val createdDate: String
)



