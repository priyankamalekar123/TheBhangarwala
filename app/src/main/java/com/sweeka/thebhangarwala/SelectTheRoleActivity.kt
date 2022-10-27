package com.sweeka.thebhangarwala

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SelectTheRoleActivity : AppCompatActivity() {

    lateinit var user:ImageView
    lateinit var admin:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_the_role2)

        user = findViewById(R.id.user)
        admin = findViewById(R.id.admin)

        user.setOnClickListener {
            var i  = Intent(this,MainActivity::class.java)
            startActivity(i)
        }

        admin.setOnClickListener {
            var i = Intent(this,VendorLoginActivity::class.java)
            startActivity(i)
        }
    }
}