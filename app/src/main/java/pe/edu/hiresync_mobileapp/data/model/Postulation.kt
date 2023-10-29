package pe.edu.hiresync_mobileapp.data.model

import com.google.gson.annotations.SerializedName

data class PostulationResponse(
    @SerializedName("results")
    val postulations: List<Postulation>
)

data class Postulation(
    val id: Int,
    val name: String,
    val position: String,
    val description: String,
    val applicationDate: String,
    val location: String,
    val salary: String,
    val contractType: String,
    val requirements: String,
    val contact: Contact,
    var isApplied: Boolean = false
)

data class Contact(
    val email: String,
    val phone: String
)


