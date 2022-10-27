package com.sweeka.thebhangarwala

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomnav)

        setCurrentFragment(HomeFragment())

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> setCurrentFragment(HomeFragment())
                R.id.history -> setCurrentFragment(HistoryFragment())
                R.id.cities -> setCurrentFragment(CitiesFragment())
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
         menuInflater.inflate(R.menu.appbarmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.cart ->{
                var i = Intent(this,CartActivity::class.java)
                startActivity(i)
            }

            R.id.user ->{
                var builder = AlertDialog.Builder(this)
                builder.setTitle("Logout")
                builder.setMessage("are you want to loguot")
                builder.setPositiveButton("Yes"){ it ,which->
                    Toast.makeText(this,"you are loged out",Toast.LENGTH_SHORT).show()
                }
                builder.setNegativeButton("No"){it,which->
                    Toast.makeText(this,"you are not loged out",Toast.LENGTH_SHORT).show()
                }
                val alertDialog = builder.create()
                alertDialog.show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun setCurrentFragment(fm:Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.framelayout,fm)
        transaction.commit()
    }


}