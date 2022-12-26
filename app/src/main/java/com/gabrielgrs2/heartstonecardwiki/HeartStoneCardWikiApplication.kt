package com.gabrielgrs2.heartstonecardwiki

import android.app.Application
import com.gabrielgrs2.base.baseModule
import com.gabrielgrs2.feature.cardlist.featureCardModules
import com.google.android.material.color.DynamicColors
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import timber.log.Timber

class HeartStoneCardWikiApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
        initTimber()
        initDynamicColorScheme()
    }

    private fun initDynamicColorScheme() {
        // Apply dynamic colors to all Activities, Fragments, Views
        // (Material 3 library helper class)
        DynamicColors.applyToActivitiesIfAvailable(this)
    }

    private fun initKoin() {
        GlobalContext.startKoin {
            androidLogger()
            androidContext(this@HeartStoneCardWikiApplication)

            modules(appModule)
            modules(baseModule)
            modules(featureCardModules)
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}