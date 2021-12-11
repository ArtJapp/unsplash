package mrth.chronicker.surf_hackathon_usplasher.data.api

import mrth.chronicker.surf_hackathon_usplasher.data.constants.UnsplashUrls.EDITORIAL_PHOTOS
import mrth.chronicker.surf_hackathon_usplasher.data.entity.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Query

private const val EDITORIAL_PAGE_SIZE = 20

interface PhotoApi {

    @GET(EDITORIAL_PHOTOS)
    suspend fun getEditorialPhotos(
        @Query("per_page") pageSize: Int = EDITORIAL_PAGE_SIZE
    ): List<PhotoResponse>
}

