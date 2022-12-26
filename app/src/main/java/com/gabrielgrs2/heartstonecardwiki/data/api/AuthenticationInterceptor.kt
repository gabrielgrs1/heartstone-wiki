package com.gabrielgrs2.heartstonecardwiki.data.api

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.request().let {
        val newRequest = it.newBuilder()
            .header("X-RapidAPI-Key", apiKey)
            .header("X-RapidAPI-Host", "omgvamp-hearthstone-v1.p.rapidapi.com")
            .url(it.url)
            .build()

        chain.proceed(newRequest)
    }
}
