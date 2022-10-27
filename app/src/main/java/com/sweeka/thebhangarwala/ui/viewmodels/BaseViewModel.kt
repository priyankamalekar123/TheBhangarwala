package com.sweeka.thebhangarwala.ui.viewmodels

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel

open class BaseViewModel(application: Application): AndroidViewModel(Application()) {

    lateinit var context:Application

    init {
        context = application
    }

    fun showToast(showMsg:String){
        Toast.makeText(context,showMsg,Toast.LENGTH_SHORT).show()
    }
}



