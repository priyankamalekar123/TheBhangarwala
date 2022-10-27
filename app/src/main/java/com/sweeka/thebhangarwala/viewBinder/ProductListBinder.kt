package com.sweeka.thebhangarwala.viewBinder

import androidx.lifecycle.MutableLiveData

class ProductListBinder {
    var ItemPresentCount = MutableLiveData<String>("")

    var type = MutableLiveData<String>()
    var category = MutableLiveData<String>()
    var image = MutableLiveData<String>()
    var item_name = MutableLiveData<String>()
    var price =MutableLiveData<String>()
    var unit = MutableLiveData<String>()
    var quantity = MutableLiveData<Int>()
    var totalAmount = MutableLiveData<Long>()
    var isPresent =MutableLiveData<Boolean>()
}