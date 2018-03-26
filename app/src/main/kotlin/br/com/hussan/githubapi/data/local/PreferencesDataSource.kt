package br.com.hussan.githubapi.data.local

import android.content.Context
import android.content.SharedPreferences



interface PreferencesDataSource {
    fun storeUser(user: String)
    fun getUser(): String?
    fun clearUserInformations()
}

class PreferencesRepository(val context: Context) : PreferencesDataSource {

    companion object {
        const val USER_KEY = "USER_KEY"
    }

    val sharedPreferences: SharedPreferences = context.getSharedPreferences("br.com.hussan.githubapi", Context.MODE_PRIVATE)

    override fun storeUser(user: String) {
        sharedPreferences.edit().putString(USER_KEY, user).apply()
    }

    override fun getUser(): String? {
        return sharedPreferences.getString(USER_KEY, null)
    }

    override fun clearUserInformations() {
        sharedPreferences.edit()
                .remove(USER_KEY)
                .apply()
    }
}