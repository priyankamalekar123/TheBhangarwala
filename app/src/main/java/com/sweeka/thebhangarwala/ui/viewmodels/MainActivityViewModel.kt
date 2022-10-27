package com.sweeka.thebhangarwala.ui.viewmodels

import android.app.Application
import androidx.lifecycle.LiveData
import com.sweeka.thebhangarwala.db.AsyncDbCrud
import com.sweeka.thebhangarwala.db.DataModels.Product

class MainActivityViewModel(application: Application):BaseViewModel(application) {

    var asyncDbCurd = AsyncDbCrud(application)

    fun getAllAddedItem(): LiveData<List<Product>> {
        return asyncDbCurd.getAllAddedItems()
    }
}