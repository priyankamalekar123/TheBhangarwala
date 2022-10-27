package com.sweeka.thebhangarwala.ui.viewmodels

import android.app.Application
import android.content.Intent
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sweeka.thebhangarwala.db.AsyncDbCrud
import com.sweeka.thebhangarwala.db.DataModels.Product
import com.sweeka.thebhangarwala.ui.Activity.GoToCartActivity
import com.sweeka.thebhangarwala.ui.interfaces.gotoNext

class SingleProductViewModel(application: Application):BaseViewModel(application) {
    var quantityOfItems = MutableLiveData<Int>(0)
    var asyncDbCrud=AsyncDbCrud(application)
    var product1 = ObservableField<Product>()
    var item_present = MutableLiveData<Boolean>(false)
    var quantityOfItem:Int = 0
    var quantityOfItemPresentInDb = MutableLiveData<Int>(0)


    fun getItem(item:String):LiveData<Product>{
        return asyncDbCrud.getSelectedItem(item)
    }

    fun plusBtnClick(){
        quantityOfItem = quantityOfItem + 1
        quantityOfItems.value = quantityOfItem

    }
    fun minusBtnClick(){
        if(quantityOfItem == 0){
            quantityOfItems.value = 0
        }
        else{
            quantityOfItem = quantityOfItem - 1
            quantityOfItems.value = quantityOfItem
        }
    }

    fun addToCart(){
        var total_Amount = product1.get()!!.price.toLong() * quantityOfItem
        if (item_present.value == true){
            if (quantityOfItem == quantityOfItemPresentInDb.value){
                showToast("your order of ${product1.get()!!.item_name} ${quantityOfItem} ${product1.get()!!.unit} already added to card")
            }
            else if(quantityOfItem == 0){
                asyncDbCrud.updateSell(quantityOfItem,total_Amount,product1.get()!!.item_name,product1.get()!!.isPresent)
                showToast("Item deleted from your data")
            }
            else{
                asyncDbCrud.updateSell(quantityOfItem,total_Amount , product1.get()!!.item_name,product1.get()!!.isPresent)
                showToast("your order update successfully")
            }
        }
        else{
            if (quantityOfItem == 0){
                showToast("please select no of kg amount to sell")
            }
            else{
                  asyncDbCrud.updateSell(quantityOfItem,total_Amount,product1.get()!!.item_name,true)
                  showToast("added your data to card")
            }
        }
    }
//
//    fun gotoNextAct(gotoNext: gotoNext){
//       gotoNext.gotoNextActivity()
//    }

}