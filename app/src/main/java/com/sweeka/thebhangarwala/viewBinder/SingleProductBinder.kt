package com.sweeka.thebhangarwala.viewBinder

import androidx.lifecycle.MutableLiveData

class SingleProductBinder{

    var item_name = MutableLiveData<String>()
    var amount_per_kg = MutableLiveData<String>()
    var quantity_of_item = MutableLiveData<String>()
    var total_amount =MutableLiveData<String>()
    var isItemPresent = MutableLiveData<Boolean>()

}