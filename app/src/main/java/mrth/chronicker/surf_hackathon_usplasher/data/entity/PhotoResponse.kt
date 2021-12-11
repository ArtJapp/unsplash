package mrth.chronicker.surf_hackathon_usplasher.data.entity

import com.google.gson.annotations.SerializedName
import mrth.chronicker.surf_hackathon_usplasher.data.Transformable
import mrth.chronicker.surf_hackathon_usplasher.domain.models.Photo
import mrth.chronicker.surf_hackathon_usplasher.domain.models.PhotoUrls

data class PhotoResponse(
    @SerializedName("id") val id: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("width") val width: Int?,
    @SerializedName("height") val height: Int?,
    @SerializedName("urls") val urls: PhotoUrlsObj?
) : Transformable<Photo> {

    override fun transform(): Photo {
        return Photo(
            id = id.orEmpty(),
            description = description.orEmpty(),
            width = width ?: 0,
            height = height ?: 0,
            urls = urls?.transform() ?: PhotoUrls.empty,
        )
    }
}