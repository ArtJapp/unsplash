package mrth.chronicker.surf_hackathon_usplasher.domain

import mrth.chronicker.surf_hackathon_usplasher.data.repository.PhotoRepository
import mrth.chronicker.surf_hackathon_usplasher.domain.models.Photo

class UsplashInteractor(
    private val repository: PhotoRepository
) {

    suspend fun getImages(): List<Photo> {
        return repository.getImages()
    }
}