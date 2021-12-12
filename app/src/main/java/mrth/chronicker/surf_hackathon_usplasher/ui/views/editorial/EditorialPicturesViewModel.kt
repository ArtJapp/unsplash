package mrth.chronicker.surf_hackathon_usplasher.ui.views.editorial

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import mrth.chronicker.surf_hackathon_usplasher.domain.UsplashInteractor
import mrth.chronicker.surf_hackathon_usplasher.domain.models.Photo


class EditorialPicturesViewModel(
    private val usplashInteractor: UsplashInteractor,
) : ViewModel() {

    private var loadEditorialPhotosJob: Job? = null
    val widgetStateFlow = MutableStateFlow<EditorialPicturesState>(EditorialPicturesState.Loading)

    init {
        loadImages()
    }

    fun loadImages() {
        subscribe(usplashInteractor::getImages)
            .onEach {
                updateState(photos = it)
            }
            .catch { handleError(it) }
            .launchIn(viewModelScope)
    }

    private suspend fun updateState(photos: List<Photo>) {
        val state = widgetStateFlow.value
        val updatedState = if (state is EditorialPicturesState.Loaded) {
            state.copy(items = state.items + photos)
        } else {
            EditorialPicturesState.Loaded(photos)
        }
        widgetStateFlow.emit(updatedState)
    }

    private suspend fun handleError(error: Throwable) {
        val state = widgetStateFlow.value
        val errorMessage = error.message ?: "Error occurred"
        val updatedState = if (state is EditorialPicturesState.Error) {
            state.copy(message = errorMessage)
        } else {
            EditorialPicturesState.Error(errorMessage, state)
        }
        widgetStateFlow.emit(updatedState)
    }

    private fun <T : Any> subscribe(action: suspend () -> T): Flow<T> = flow { emit(action()) }

}

sealed interface EditorialPicturesState {

    data class Loaded(val items: List<Photo>) : EditorialPicturesState
    object Loading : EditorialPicturesState
    data class Error(val message: String, val previousState: EditorialPicturesState) :
        EditorialPicturesState
}