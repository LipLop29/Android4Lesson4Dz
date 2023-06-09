package com.example.android4lesson4dz.data.remote.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("key", "AIzaSyD_Ue90fikmR65RnjTsGfrXR-uzXGtjUl4").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}