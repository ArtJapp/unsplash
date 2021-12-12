package mrth.chronicker.surf_hackathon_usplasher.data.api

import mrth.chronicker.surf_hackathon_usplasher.data.constants.UnsplashUrls.EDITORIAL_PHOTOS
import mrth.chronicker.surf_hackathon_usplasher.data.entity.PhotoResponse
import retrofit2.http.GET

interface PhotoApi {

    @GET(EDITORIAL_PHOTOS)
    suspend fun getEditorialPhotos(): List<PhotoResponse>
}

