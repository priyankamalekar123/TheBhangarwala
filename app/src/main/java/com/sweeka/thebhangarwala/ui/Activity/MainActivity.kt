package com.sweeka.thebhangarwala.ui.Activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sweeka.thebhangarwala.R
import com.sweeka.thebhangarwala.ui.fragment.CitiesFragment
import com.sweeka.thebhangarwala.ui.fragment.HistoryFragment
import com.sweeka.thebhangarwala.ui.fragment.HomeFragment

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var textCartItemCount:TextView
    var mCartItemCount = 10
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
        //creating request parameters
        val params = HashMap<String, String>()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
         menuInflater.inflate(R.menu.appbarmenu,menu)

        val menuItem = menu.findItem(R.id.cart)

        val actionView = MenuItemCompat.getActionView(menuItem)

//        textCartItemCount = actionView.findViewById<View>(R.id.cart_badge) as TextView

//        setupBadge()

//        actionView.setOnClickListener { onOptionsItemSelected(menuItem) }
        return true
    }

    private fun setupBadge() {
        if (textCartItemCount != null) {
            if (mCartItemCount == 0) {
                if (textCartItemCount.visibility != View.GONE) {
                    textCartItemCount.visibility = View.GONE
                }
            } else {
//                val sc = Selected()
                val getdetails: ArrayList<HashMap<String, String>>
                var qnty = 0
//                getdetails = sc.getGetDetails()
//                for (i in getdetails.indices) {
//                    val data1 = getdetails[i]
//                    qnty = qnty + data1["q1"]!!.toInt()
//                }
                textCartItemCount.text = qnty.toString()
                if (textCartItemCount.visibility != View.VISIBLE) {
                    textCartItemCount.visibility = View.VISIBLE
                }
            }
        }
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