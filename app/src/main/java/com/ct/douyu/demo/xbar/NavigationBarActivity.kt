package com.ct.douyu.demo.xbar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ct.douyu.xbar.setNavigationBarLightMode
import com.ct.douyu.xbar.setStatusBarLightMode
import com.ct.douyu.xbar.transparentNavigationBar
import com.ct.douyu.xbar.transparentStatusBar
import kotlinx.android.synthetic.main.activity_navigation_bar.*

/**
Created by taochen on 2022/7/18.
Email: 935612713@qq.com.
 */
class NavigationBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_bar)

        transparentNavigationBar(false)

        transparentStatusBar(true)

        bt_navigation_bar.setOnClickListener {
            setStatusBarLightMode(false)
        }

        bt_status_bar.setOnClickListener {
            setNavigationBarLightMode(true)
        }
    }

    companion object {

        fun start(context: Context) {
            context.startActivity(Intent(context, NavigationBarActivity::class.java))
        }
    }
}