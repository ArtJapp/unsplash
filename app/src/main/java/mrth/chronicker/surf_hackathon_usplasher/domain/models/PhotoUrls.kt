package mrth.chronicker.surf_hackathon_usplasher.domain.models

data class PhotoUrls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String
) {

    companion object {
        val empty = PhotoUrls("", "", "", "", "")
    }
}