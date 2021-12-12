package mrth.chronicker.surf_hackathon_usplasher.data.interceptor

import mrth.chronicker.surf_hackathon_usplasher.data.constants.SensitiveData.apiVersion
import mrth.chronicker.surf_hackathon_usplasher.data.constants.SensitiveData.usplashApiToken
import okhttp3.Interceptor
import okhttp3.Response

private const val AuthorizationKey = "Authorization"
private const val AcceptVersionKey = "Accept-Version"

object UsplashAuthInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val updatedRequest = chain.request().newBuilder()
            .addHeader(AuthorizationKey, usplashApiToken)
            .addHeader(AcceptVersionKey, apiVersion)
            .build()
        return chain.proceed(updatedRequest)
    }
}