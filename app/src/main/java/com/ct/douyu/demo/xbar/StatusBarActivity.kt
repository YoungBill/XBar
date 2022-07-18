package com.ct.douyu.demo.xbar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ct.douyu.xbar.navigationBarTransparent
import com.ct.douyu.xbar.statusBarTransparent

/**
Created by taochen on 2022/7/18.
Email: 935612713@qq.com.
 */
class StatusBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status_bar)

        statusBarTransparent(true)

        navigationBarTransparent(false)
    }

    companion object {

        fun start(context: Context) {
            context.startActivity(Intent(context, StatusBarActivity::class.java))
        }
    }
}