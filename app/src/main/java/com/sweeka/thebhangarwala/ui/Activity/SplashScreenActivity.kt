package com.sweeka.thebhangarwala.ui.Activity

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.sweeka.thebhangarwala.R
import com.sweeka.thebhangarwala.ui.Activity.AppIntroActivity

class SplashScreenActivity : AppCompatActivity() {

    lateinit var image: ImageView
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        requestedOrientation =ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        handler = Handler()
        handler.postDelayed({

            val intent = Intent(this, AppIntroActivity::class.java)
            startActivity(intent)
            finish()
        }, 1800)
    }
}