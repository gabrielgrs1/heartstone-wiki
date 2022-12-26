package com.gabrielgrs2.base

import com.gabrielgrs2.base.nav.NavManager
import org.koin.dsl.module

val baseModule = module {

    single { NavManager() }
}
