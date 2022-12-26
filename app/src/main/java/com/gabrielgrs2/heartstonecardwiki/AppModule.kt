package com.gabrielgrs2.heartstonecardwiki

import com.gabrielgrs2.base.data.retrofit.ApiResultAdapterFactory
import com.gabrielgrs2.heartstonecardwiki.data.api.AuthenticationInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

val appModule = module {

    single { AuthenticationInterceptor(BuildConfig.API_TOKEN) }

    single {
        HttpLoggingInterceptor { message ->
            Timber.d("Http: $message")
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        OkHttpClient.Builder()
            .connectTimeout(2, TimeUnit.MINUTES)
            .readTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES)
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<AuthenticationInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(ApiResultAdapterFactory())
            .build()
    }
}
