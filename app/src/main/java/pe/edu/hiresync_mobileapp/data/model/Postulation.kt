package pe.edu.hiresync_mobileapp.data.model


data class PostulationResponse(val postulations: List<Postulation>)

data class Postulation(
    val id: Int,
    val name: String,
    val description: String,
    val startingDate: String,
    val endingDate: String,
    val status: Boolean
)

