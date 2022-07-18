package com.ct.douyu.xbar

import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentActivity

/**
 * Created by taochen on 2022/7/18.
 * Email: 935612713@qq.com.
 */
@RequiresApi(Build.VERSION_CODES.KITKAT)
fun FragmentActivity.transparentStatusBar(statusBarLight: Boolean) {
    when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q -> {
            window.isStatusBarContrastEnforced = false
        }
    }
    when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> {
            window.statusBarColor = Color.TRANSPARENT
        }
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT -> {
            if (window.attributes.flags and WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS == 0)
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
    }
    setStatusBarLightMode(statusBarLight)
}

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun FragmentActivity.transparentNavigationBar(navigationBarLight: Boolean) {
    when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q -> {
            window.isNavigationBarContrastEnforced = false
        }
    }
    when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> {
            window.navigationBarColor = Color.TRANSPARENT
        }
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT -> {
            if (window.attributes.flags and WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION == 0)
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }
    }
    setNavigationBarLightMode(navigationBarLight)
}

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun FragmentActivity.setStatusBarLightMode(statusBarLight: Boolean) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
        return
    }
    window?.decorView?.systemUiVisibility = systemUiFlagWithStatusBar(statusBarLight)
}

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun FragmentActivity.setNavigationBarLightMode(navigationBarLight: Boolean) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
        return
    }
    window?.decorView?.systemUiVisibility = systemUiFlagWithNavigationBar(navigationBarLight)
}

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
private fun systemUiFlagWithStatusBar(statusBarLight: Boolean): Int {
    var flag = (View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
    when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.M -> {
            if (statusBarLight) {
                flag = flag or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
    }
    return flag
}

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
private fun systemUiFlagWithNavigationBar(navigationBarLight: Boolean): Int {
    var flag = (View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
    when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> {
            if (navigationBarLight) {
                flag = flag or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            }
        }
    }
    return flag
}