package com.sweeka.thebhangarwala.ui.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sweeka.thebhangarwala.R
class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}