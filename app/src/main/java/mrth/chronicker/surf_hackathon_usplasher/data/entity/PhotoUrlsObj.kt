package mrth.chronicker.surf_hackathon_usplasher.data.entity

import com.google.gson.annotations.SerializedName
import mrth.chronicker.surf_hackathon_usplasher.data.Transformable
import mrth.chronicker.surf_hackathon_usplasher.domain.models.PhotoUrls

data class PhotoUrlsObj(
    @SerializedName("raw") val raw: String?,
    @SerializedName("full") val full: String?,
    @SerializedName("regular") val regular: String?,
    @SerializedName("small") val small: String?,
    @SerializedName("thumb") val thumb: String?
) : Transformable<PhotoUrls> {

    override fun transform(): PhotoUrls {
        return PhotoUrls(
            raw = raw.orEmpty(),
            full = full.orEmpty(),
            regular = regular.orEmpty(),
            small = small.orEmpty(),
            thumb = thumb.orEmpty()
        )
    }
}