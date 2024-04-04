package com.ristlitelink.ristlitelink

import  android.app.Application
import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDex
import com.rcontracts.myrcontracts.Utils.SharedPManger
import com.rcontracts.myrcontracts.classes.UtilityApp
import com.ristlitelink.ristlitelink.Utils.LocaleUtils
import com.ristlitelink.ristlitelink.classes.Constants
import java.util.*


class RootApplication : Application() {
    var sharedPManger: SharedPManger? = null

    companion object {
        @get:Synchronized
        var instance: RootApplication? = null
            private set

        //        private const val ONESIGNAL_APP_ID = "06c038db-2891-4e93-b03f-ac3a308efc8e"

        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        sharedPManger = SharedPManger(this)

        var appLanguage = UtilityApp.getLanguage()
        if (appLanguage == null) {
            appLanguage = Constants.English
        }
        UtilityApp.setLanguage(appLanguage)
        LocaleUtils.setLocale(Locale(appLanguage))
        LocaleUtils.updateConfig(instance, instance!!.resources.configuration)
      //  AndroidNetworking.initialize(applicationContext)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleUtils.updateConfig(instance, newConfig)
    }


}

