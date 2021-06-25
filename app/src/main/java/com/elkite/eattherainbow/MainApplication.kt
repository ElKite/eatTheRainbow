package com.elkite.eattherainbow

import android.app.Application
import com.elkite.eattherainbow.managers.database.DatabaseInstances
import timber.log.Timber

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        DatabaseInstances.initDatabases(applicationContext)
    }
}