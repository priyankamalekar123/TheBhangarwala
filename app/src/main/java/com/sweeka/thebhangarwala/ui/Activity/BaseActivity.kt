package com.sweeka.thebhangarwala.ui.Activity

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sweeka.thebhangarwala.R
open class BaseActivity : AppCompatActivity() {

    companion object
    {
        lateinit var context: Context
        lateinit var activity: Activity
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}