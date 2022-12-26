package com.gabrielgrs2.feature.cardlist.data

import com.gabrielgrs2.feature.cardlist.data.datasource.api.service.CardRetrofitService
import com.gabrielgrs2.feature.cardlist.data.repository.CardRepositoryImpl
import com.gabrielgrs2.feature.cardlist.domain.repository.CardRepository
import org.koin.dsl.module
import retrofit2.Retrofit

internal val dataModule = module {

    single<CardRepository> { CardRepositoryImpl(get()) }

    single { get<Retrofit>().create(CardRetrofitService::class.java) }

}
