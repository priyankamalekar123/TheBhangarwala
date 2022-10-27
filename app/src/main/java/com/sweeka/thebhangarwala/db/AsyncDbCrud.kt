package com.sweeka.thebhangarwala.db

import android.app.Application
import android.os.Handler
import androidx.lifecycle.LiveData
import com.sweeka.thebhangarwala.api.api_models.Bottles
import com.sweeka.thebhangarwala.db.DataModels.Product

class AsyncDbCrud(application: Application) {

var db:AppDatabase = AppDatabase.getDatabase(application)
    var  product_data = arrayListOf<Product>()
    var data =  ArrayList<Product>()

    fun insertProduct(data:Bottles){
      Thread{
            for ( i in data){
                var product = Product(0,i.categories,i.iid,i.image,i.item_name,i.price,i.unit)
                db.productDao().addProduct(product)
            }
      }.start()
    }

    fun insertProductFromApp(product: Product){
        Thread{
                db.productDao().addProduct(product)
        }.start()
    }

    fun deleteProduct(){
       Thread {
          db.productDao().deleteAll()
       }.start()
    }

    fun getProduct(type:String): ArrayList<Product> {

            product_data = db.productDao().getProduct(type) as ArrayList<Product>
        return product_data
    }

    fun getProduct1(type: String){
        db.productDao().getProduct(type)
    }


    fun updateSell(quantity:Int,totalAmount:Long,itemName:String,isPresent:Boolean){
        Thread{
            db.productDao().updateSell(quantity,totalAmount,itemName,isPresent)
        }.start()

    }


    fun getAllAddedItems():LiveData<List<Product>>{
        return db.productDao().getAddedProduct()
    }

    fun getSelectedItem(itemName:String):LiveData<Product>{
        return db.productDao().getSelectedItem(itemName)
    }


}