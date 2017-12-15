package br.com.hussan.githubapi.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

inline fun <reified T : Activity> Context.myStartActivity(goTo: Class<T>, bundle: Bundle){

    val intent = Intent(this, goTo)

    with(intent){
        putExtras(bundle)
    }

    startActivity(intent)
}