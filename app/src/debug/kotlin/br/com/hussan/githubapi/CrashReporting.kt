package br.com.hussan.githubapi

import android.app.Application

object CrashReporting {

    @JvmStatic
    fun e(@Suppress("UNUSED_PARAMETER") error: Throwable, @Suppress("UNUSED_PARAMETER") tag: String = Application::class.java.`package`.name) { /* Nothing */ }

    @JvmStatic
    fun log(@Suppress("UNUSED_PARAMETER") tag: String, @Suppress("UNUSED_PARAMETER") message: String) { /* Nothing */ }
}
