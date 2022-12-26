package com.gabrielgrs2.feature.cardlist

import com.gabrielgrs2.feature.cardlist.data.dataModule
import com.gabrielgrs2.feature.cardlist.domain.domainModule
import com.gabrielgrs2.feature.cardlist.presentation.presentationModule

val featureCardModules = listOf(
    presentationModule,
    domainModule,
    dataModule
)
