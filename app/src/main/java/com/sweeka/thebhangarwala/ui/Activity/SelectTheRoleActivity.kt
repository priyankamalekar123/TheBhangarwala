package com.sweeka.thebhangarwala.ui.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import com.sweeka.thebhangarwala.R
//import com.sweeka.thebhangarwala.VendorLoginActivity

class SelectTheRoleActivity : BaseActivity() {

    lateinit var user:LinearLayout
    lateinit var admin:LinearLayout
    lateinit var vendor:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_the_role2)

        user = findViewById(R.id.user)
        vendor = findViewById(R.id.vendor)
        admin = findViewById(R.id.admin)

        user.setOnClickListener {
            var i  = Intent(this,MainActivity::class.java)
            startActivity(i)
        }

        vendor.setOnClickListener {
            var i = Intent(this, VendorLoginActivity::class.java)
            startActivity(i)
        }

        admin.setOnClickListener {
            var i = Intent(this,AdminLoginActivity::class.java)
            startActivity(i)
        }
    }
}