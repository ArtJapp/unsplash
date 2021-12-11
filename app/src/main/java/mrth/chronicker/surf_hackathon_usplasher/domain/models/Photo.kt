package mrth.chronicker.surf_hackathon_usplasher.domain.models

data class Photo(
    val id: String,
    val description: String,
    val width: Int,
    val height: Int,
    val urls: PhotoUrls
)