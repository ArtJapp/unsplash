package mrth.chronicker.surf_hackathon_usplasher.data.repository

import mrth.chronicker.surf_hackathon_usplasher.data.api.PhotoApi
import mrth.chronicker.surf_hackathon_usplasher.domain.models.Photo

class PhotoRepository(
    val api: PhotoApi
) {

    suspend fun getImages(): List<Photo> =
        api.getEditorialPhotos().map { it.transform() }
}