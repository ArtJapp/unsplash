package mrth.chronicker.surf_hackathon_usplasher.ui

import mrth.chronicker.surf_hackathon_usplasher.data.api.PhotoApi
import mrth.chronicker.surf_hackathon_usplasher.data.entity.PhotoResponse
import mrth.chronicker.surf_hackathon_usplasher.data.interceptor.UsplashAuthInterceptor
import mrth.chronicker.surf_hackathon_usplasher.data.repository.PhotoRepository
import mrth.chronicker.surf_hackathon_usplasher.ui.views.editorial.EditorialPicturesViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

@JvmField
val uiModule = module {

    viewModel { EditorialPicturesViewModel(get()) }
}