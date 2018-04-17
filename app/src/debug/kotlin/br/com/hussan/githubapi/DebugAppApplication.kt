package br.com.hussan.githubapi

import android.util.Log
import com.facebook.stetho.Stetho

class DebugAppApplication: AppApplication() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}
