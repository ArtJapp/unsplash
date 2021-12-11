package mrth.chronicker.surf_hackathon_usplasher.domain

import mrth.chronicker.surf_hackathon_usplasher.data.repository.PhotoRepository

class UsplashInteractor(
    val repository: PhotoRepository
) {

    suspend fun getImages() = repository.getImages()
}