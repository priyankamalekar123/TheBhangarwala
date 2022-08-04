package com.sweeka.thebhangarwala.ui.Activity

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.sweeka.thebhangarwala.PreferenceManager
import com.sweeka.thebhangarwala.R
//import com.sweeka.thebhangarwala.SelectTheRoleActivity

class AppIntroActivity : AppCompatActivity() {

    lateinit var prefManager: PreferenceManager
    lateinit var btnskip:Button
    lateinit var btnNext:Button
    lateinit var layout:ArrayList<Int>
    lateinit var dotText:ArrayList<TextView>
    lateinit var viewPager: ViewPager
    lateinit var myViewpagerAdapetr: MyViewpagerAdapeter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         supportActionBar!!.setIcon(R.mipmap.ic_launcher_foreground)
        supportActionBar!!.setDisplayShowTitleEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        setContentView(R.layout.activity_app_intro)

        // Checking for first time launch - before calling setContentView()
        prefManager = PreferenceManager(this)
        if(!prefManager.isFirstTimeLaunch()){
            launchHomeScreen()
            finish()
        }


        viewPager = findViewById(R.id.viewpager)
        btnskip = findViewById(R.id.btn_skip)
        btnNext = findViewById(R.id.btn_next)

        layout = arrayListOf(R.layout.layout_slide1, R.layout.layout_slide2, R.layout.layout_slide3)
        dotText = arrayListOf(findViewById(R.id.indicator1),findViewById(R.id.indicator2),findViewById(
            R.id.indicator3))

        myViewpagerAdapetr = MyViewpagerAdapeter()
        viewPager.adapter = myViewpagerAdapetr
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener)

        btnskip.setOnClickListener {

            launchHomeScreen()

        }

        btnNext.setOnClickListener {
            var currentItem = getItem()
            var layoutsize = layout.size

            if ((currentItem+1) < layoutsize){
                viewPager.currentItem = currentItem+1
            }
            else{
                launchHomeScreen()
            }
        }
    }
    //  viewpager change listener
    var viewPagerPageChangeListener: OnPageChangeListener = object : OnPageChangeListener {
        @RequiresApi(Build.VERSION_CODES.M)
        override fun onPageSelected(position: Int) {

            if (position == layout.size - 1){
                btnskip.setVisibility(View.GONE)
                btnNext.text = "GOT IT"
            } else{
                // still pages are left
                btnNext.text = "NEXT"
                btnskip.setVisibility(View.VISIBLE)
            }

//            //change the dot color
            for (i in dotText){
               if (dotText[position] == i){
                   dotText[position].setTextColor(getColor(R.color.limegreen))
               }
                else{
                    i.setTextColor(getColor(R.color.limegreen1))
               }
            }

        }

        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {

        }
        override fun onPageScrollStateChanged(arg0: Int) {}
    }

  inner class MyViewpagerAdapeter: PagerAdapter(){

      private var layoutInflater: LayoutInflater? = null

      override fun instantiateItem(container: ViewGroup, position: Int): Any {

          layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

          val view: View = layoutInflater!!.inflate(layout.get(position), container, false)
          container.addView(view)

          return view

      }
      override fun getCount(): Int {
         return layout.size
      }

      override fun isViewFromObject(view: View, `object`: Any): Boolean {
         return view == `object`
      }

      override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
          val view = `object` as View
          container.removeView(view)
      }

  }

    fun launchHomeScreen(){
        prefManager.setFirstTimeLaunch(false)
       var i = Intent(this, SelectTheRoleActivity::class.java)
        startActivity(i)
        finish()
    }

    fun getItem():Int{
         return viewPager.currentItem

    }
 }