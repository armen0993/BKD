package com.android.bkd.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.bkd.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
    }
}