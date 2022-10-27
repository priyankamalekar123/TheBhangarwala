package com.sweeka.thebhangarwala.ui.Activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.sweeka.thebhangarwala.R
import com.sweeka.thebhangarwala.ui.fragment.CitiesFragment
import com.sweeka.thebhangarwala.ui.fragment.HistoryFragment
import com.sweeka.thebhangarwala.ui.fragment.HomeFragment
import com.sweeka.thebhangarwala.ui.viewmodels.MainActivityViewModel

class MainActivity : BaseActivity() {
    lateinit var bottomNavigation: MeowBottomNavigation
    var textCartItemCount:TextView? = null
    lateinit var mainActivityVM: MainActivityViewModel
    var addedItems = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityVM = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        bottomNavigation = findViewById(R.id.bottom_navigation)

        setCurrentFragment(HomeFragment())
        bottomNavigation.show(1,true)

        bottomNavigation.add(MeowBottomNavigation.Model(1,R.drawable.home_icon))
        bottomNavigation.add(MeowBottomNavigation.Model(2,R.drawable.ic_transection))
        bottomNavigation.add(MeowBottomNavigation.Model(3,R.drawable.ic_map))

        bottomNavigation.setOnShowListener {

        }
        bottomNavigation.setOnClickMenuListener {
            when (it.id){
                1 -> setCurrentFragment(HomeFragment())
                2 -> setCurrentFragment(HistoryFragment())
                3 -> setCurrentFragment(CitiesFragment())
            }
        }


        //getSupportActionBar().setIcon(R.drawable.ic_cart);
        var locationManager:LocationManager = getSystemService(LOCATION_SERVICE) as LocationManager

        //For location permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1000)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), 2000)
        }

        initObserver()

    }

    private fun initObserver() {
        mainActivityVM.getAllAddedItem().observe(this, Observer{
            addedItems = it.size
            setupBadge()

        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

         menuInflater.inflate(R.menu.appbarmenu,menu)
         val menuItem = menu.findItem(R.id.cart)
         val actionView = MenuItemCompat.getActionView(menuItem)

            textCartItemCount = actionView.findViewById<View>(R.id.cart_badge) as TextView


        actionView.setOnClickListener { onOptionsItemSelected(menuItem) }
        return true
    }
    private fun setupBadge() {
        if (textCartItemCount != null){
            if (addedItems == 0){
                textCartItemCount!!.visibility = View.GONE
            }
            else{
                textCartItemCount!!.visibility = View.VISIBLE
                textCartItemCount!!.text = addedItems.toString()
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