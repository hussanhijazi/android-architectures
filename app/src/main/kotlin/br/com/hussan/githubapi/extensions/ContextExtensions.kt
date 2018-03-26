package br.com.hussan.githubapi.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Point
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.util.TypedValue
import android.view.View

val ConnectivityManager.isConnected: Boolean
    get() = activeNetworkInfo?.isConnected ?: false

fun NetworkInfo.isMobile() = type.run { this == ConnectivityManager.TYPE_MOBILE }
fun NetworkInfo.isWifi() = type.run { this == ConnectivityManager.TYPE_WIFI || this == ConnectivityManager.TYPE_WIMAX }


fun Context.checkSelfPermissionCompat(permission: String): Boolean =
        ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED

fun Intent.clearTop(): Intent {
    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    return this
}

fun Intent.clearTask(): Intent {
    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    return this
}

val Activity.windowSize: Point
    get() {
        val display = windowManager.defaultDisplay
        return Point().apply { display.getSize(this) }
    }

fun Number.dp(context: Context): Float =
        context.resources.displayMetrics
                .let { TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), it) }

fun Context.showError(str: String, length: Int = Snackbar.LENGTH_LONG, action: String? = null, callback: View.OnClickListener? = null, view: View)
{
    view.let{
        val snack = Snackbar.make(it, str, length)

        callback?.let {
            snack.setAction(action, callback)
        }

        snack.show()
    }

}

fun Context.color(resColor: Int): Int {
    return ContextCompat.getColor(this, resColor)
}