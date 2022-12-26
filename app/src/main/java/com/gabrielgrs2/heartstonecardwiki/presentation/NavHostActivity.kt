package com.gabrielgrs2.heartstonecardwiki.presentation

import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.gabrielgrs2.base.nav.NavManager
import com.gabrielgrs2.base.presentation.activity.BaseActivity
import com.gabrielgrs2.base.presentation.ext.navigateSafe
import com.gabrielgrs2.heartstonecardwiki.R
import com.gabrielgrs2.heartstonecardwiki.databinding.ActivityNavHostBinding
import org.koin.android.ext.android.inject

class NavHostActivity : BaseActivity(R.layout.activity_nav_host) {

    private val navManager: NavManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initNavManager()
    }

    private fun initNavManager() {
        navManager.setOnNavEvent {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment)
            val currentFragment = navHostFragment?.childFragmentManager?.fragments?.get(0)

            currentFragment?.navigateSafe(it)
        }
    }
}
