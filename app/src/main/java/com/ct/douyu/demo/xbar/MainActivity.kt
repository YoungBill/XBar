package com.ct.douyu.demo.xbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
Created by taochen on 2022/7/18.
Email: 935612713@qq.com.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_status_bar.setOnClickListener {
            StatusBarActivity.start(this)
        }

        bt_navigation_bar.setOnClickListener {
            NavigationBarActivity.start(this)
        }
    }
}