package mrth.chronicker.surf_hackathon_usplasher.data

import mrth.chronicker.surf_hackathon_usplasher.data.api.PhotoApi
import mrth.chronicker.surf_hackathon_usplasher.data.entity.PhotoResponse
import mrth.chronicker.surf_hackathon_usplasher.data.interceptor.UsplashAuthInterceptor
import mrth.chronicker.surf_hackathon_usplasher.data.repository.PhotoRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@JvmField
val networkModule = module {
    single {
        OkHttpClient().newBuilder()
            .addInterceptor(UsplashAuthInterceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }
    single {
        get<Retrofit>().create(PhotoApi::class.java)
    }
    single {
        PhotoRepository(get<PhotoApi>())
    }
}